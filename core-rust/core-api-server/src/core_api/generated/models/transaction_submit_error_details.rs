/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "type")]
pub enum TransactionSubmitErrorDetails {
    #[serde(rename="MempoolFull")]
    TransactionSubmitMempoolFullErrorDetails {
        #[serde(rename = "mempool_capacity")]
        mempool_capacity: i32,
    },
    #[serde(rename="Rejected")]
    TransactionSubmitRejectedErrorDetails {
        /// An explanation of the error
        #[serde(rename = "error_message")]
        error_message: String,
        /// Whether (true) this rejected status has just been calculated fresh, or (false) the status is from the pending transaction result cache. 
        #[serde(rename = "is_fresh")]
        is_fresh: bool,
        /// Whether the rejection of this payload is known to be permanent. 
        #[serde(rename = "is_payload_rejection_permanent")]
        is_payload_rejection_permanent: bool,
        /// Whether the rejection of this intent is known to be permanent - this is a stronger statement than the payload rejection being permanent, as it implies any payloads containing the intent will also be permanently rejected. 
        #[serde(rename = "is_intent_rejection_permanent")]
        is_intent_rejection_permanent: bool,
        /// Whether the cached rejection of this intent is due to the intent already having been committed. If so, see the /transaction/receipt endpoint for further information. 
        #[serde(rename = "is_rejected_because_intent_already_committed")]
        is_rejected_because_intent_already_committed: bool,
        #[serde(rename = "retry_from_timestamp", skip_serializing_if = "Option::is_none")]
        retry_from_timestamp: Option<Box<crate::core_api::generated::models::Instant>>,
        /// An integer between `0` and `10^10`, marking the epoch after which the node will consider recalculating the validity of the transaction. Only present if the rejection is temporary due to a header specifying a \"from epoch\" in the future. 
        #[serde(rename = "retry_from_epoch", skip_serializing_if = "Option::is_none")]
        retry_from_epoch: Option<i64>,
        /// An integer between `0` and `10^10`, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the rejection isn't permanent. 
        #[serde(rename = "invalid_from_epoch", skip_serializing_if = "Option::is_none")]
        invalid_from_epoch: Option<i64>,
    },
}




