use crate::core_api::handlers::to_api_committed_transaction;
use crate::core_api::*;

use state_manager::store::traits::*;

#[tracing::instrument(skip(state), err(Debug))]
pub(crate) async fn handle_transaction_receipt(
    state: State<CoreApiState>,
    Json(request): Json<models::TransactionReceiptRequest>,
) -> Result<Json<models::TransactionReceiptResponse>, ResponseError<()>> {
    assert_matching_network(&request.network, &state.network)?;

    let mapping_context = MappingContext::new(&state.network);

    let intent_hash = extract_intent_hash(request.intent_hash)
        .map_err(|err| err.into_response_error("intent_hash"))?;

    let state_manager = state.state_manager.read();

    let txn_state_version_opt = state_manager
        .store()
        .get_txn_state_version_by_identifier(&intent_hash);

    if let Some(txn_state_version) = txn_state_version_opt {
        let ledger_transaction = state_manager
            .store()
            .get_committed_transaction(txn_state_version)
            .expect("Txn is missing");

        let receipt = state_manager
            .store()
            .get_committed_transaction_receipt(txn_state_version)
            .expect("Txn receipt is missing");

        let identifiers = state_manager
            .store()
            .get_committed_transaction_identifiers(txn_state_version)
            .expect("Txn identifiers are missing");

        Ok(models::TransactionReceiptResponse {
            committed: Box::new(to_api_committed_transaction(
                &mapping_context,
                ledger_transaction,
                receipt,
                identifiers,
            )?),
        })
        .map(Json)
    } else {
        Err(not_found_error(format!(
            "Committed transaction not found with intent hash: {intent_hash}"
        )))
    }
}
