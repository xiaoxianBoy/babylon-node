use std::collections::HashMap;

use crate::core_api::*;
use state_manager::jni::state_manager::ActualStateManager;
use state_manager::{
    HasUserPayloadHash, LedgerTransactionOutcome, RejectionReason, UserPayloadHash,
};

use state_manager::mempool::pending_transaction_result_cache::PendingTransactionRecord;
use state_manager::store::traits::*;

#[tracing::instrument(err(Debug), skip(state))]
pub(crate) async fn handle_v0_transaction_status(
    state: Extension<CoreApiState>,
    request: Json<models::V0TransactionStatusRequest>,
) -> Result<Json<models::V0TransactionStatusResponse>, RequestHandlingError> {
    core_api_read_handler(state, request, handle_v0_transaction_status_internal)
}

use models::v0_transaction_payload_status::Status as PayloadStatus;
use models::v0_transaction_status_response::IntentStatus;

fn handle_v0_transaction_status_internal(
    state_manager: &ActualStateManager,
    request: models::V0TransactionStatusRequest,
) -> Result<models::V0TransactionStatusResponse, RequestHandlingError> {
    let intent_hash = extract_intent_hash(request.intent_hash)
        .map_err(|err| err.into_response_error("intent_hash"))?;

    let committed_option = state_manager
        .store
        .get_committed_transaction_by_identifier(&intent_hash);

    let mut known_pending_payloads = state_manager
        .pending_transaction_result_cache
        .peek_all_known_payloads_for_intent(&intent_hash);

    if let Some((stored_transaction, receipt, _)) = committed_option {
        let payload_hash = stored_transaction
            .user()
            .expect("Only user transactions should be able to be looked up by intent hash")
            .user_payload_hash();

        // Remove the committed payload from the rejection list if it's present
        known_pending_payloads.remove(&payload_hash);

        let intent_status = match &receipt.outcome {
            LedgerTransactionOutcome::Success(_) => IntentStatus::CommittedSuccess,
            LedgerTransactionOutcome::Failure(_) => IntentStatus::CommittedFailure,
        };

        let (payload_status, error_message) = match &receipt.outcome {
            LedgerTransactionOutcome::Success(_) => (PayloadStatus::CommittedSuccess, None),
            LedgerTransactionOutcome::Failure(reason) => (
                PayloadStatus::CommittedFailure,
                Some(format!("{:?}", reason)),
            ),
        };

        let committed_payload = models::V0TransactionPayloadStatus {
            payload_hash: to_api_payload_hash(&payload_hash),
            status: payload_status,
            error_message,
        };

        let mut known_payloads = vec![committed_payload];
        known_payloads.append(&mut map_rejected_payloads_due_to_known_commit(
            known_pending_payloads,
        ));

        return Ok(models::V0TransactionStatusResponse {
            intent_status,
            known_payloads,
        });
    }

    let mempool_payloads_hashes = state_manager
        .mempool
        .get_payload_hashes_for_intent(&intent_hash);

    if !mempool_payloads_hashes.is_empty() {
        let mempool_payloads = mempool_payloads_hashes
            .into_iter()
            .map(|payload_hash| models::V0TransactionPayloadStatus {
                payload_hash: to_api_payload_hash(&payload_hash),
                status: PayloadStatus::InMempool,
                error_message: None,
            })
            .collect::<Vec<_>>();

        let mut known_payloads = mempool_payloads;
        known_payloads.append(&mut map_pending_payloads_not_in_mempool(
            known_pending_payloads,
        ));

        return Ok(models::V0TransactionStatusResponse {
            intent_status: models::v0_transaction_status_response::IntentStatus::InMempool,
            known_payloads,
        });
    }

    let known_payloads = map_pending_payloads_not_in_mempool(known_pending_payloads);

    let intent_status = if !known_payloads.is_empty() {
        // NOTE
        // We can't be more accurate at this level about the permanence of rejection.
        // Just because all known payloads are permanent rejections, doesn't mean that there isn't a possible payload
        // for this intent which could be committed. EG all known payloads could just have an invalid notary signature.
        models::v0_transaction_status_response::IntentStatus::Rejected
    } else {
        models::v0_transaction_status_response::IntentStatus::Unknown
    };

    Ok(models::V0TransactionStatusResponse {
        intent_status,
        known_payloads,
    })
}

fn map_rejected_payloads_due_to_known_commit(
    known_rejected_payloads: HashMap<UserPayloadHash, PendingTransactionRecord>,
) -> Vec<models::V0TransactionPayloadStatus> {
    known_rejected_payloads
        .into_iter()
        .map(
            |(payload_hash, transaction_record)| match transaction_record.last_attempt.rejection {
                Some(reason) => models::V0TransactionPayloadStatus {
                    payload_hash: to_api_payload_hash(&payload_hash),
                    status: PayloadStatus::PermanentlyRejected,
                    error_message: Some(reason.to_string()),
                },
                None => models::V0TransactionPayloadStatus {
                    payload_hash: to_api_payload_hash(&payload_hash),
                    status: PayloadStatus::PermanentlyRejected,
                    error_message: Some(RejectionReason::IntentHashCommitted.to_string()),
                },
            },
        )
        .collect::<Vec<_>>()
}

fn map_pending_payloads_not_in_mempool(
    known_rejected_payloads: HashMap<UserPayloadHash, PendingTransactionRecord>,
) -> Vec<models::V0TransactionPayloadStatus> {
    known_rejected_payloads
        .into_iter()
        .filter_map(|(payload_hash, transaction_record)| {
            match &transaction_record.last_attempt.rejection {
                Some(reason) => Some(models::V0TransactionPayloadStatus {
                    payload_hash: to_api_payload_hash(&payload_hash),
                    status: if transaction_record
                        .last_attempt
                        .was_against_committed_state()
                        && reason.is_permanent()
                    {
                        PayloadStatus::PermanentlyRejected
                    } else {
                        PayloadStatus::TransientlyRejected
                    },
                    error_message: Some(reason.to_string()),
                }),
                None => None,
            }
        })
        .collect::<Vec<_>>()
}
