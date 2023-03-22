/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct TransactionCallPreviewResponse {
    #[serde(rename = "status")]
    pub status: crate::core_api::generated::models::TransactionStatus,
    #[serde(rename = "output", skip_serializing_if = "Option::is_none")]
    pub output: Option<Box<crate::core_api::generated::models::SborData>>,
    /// Error message (only present if status is Failed or Rejected)
    #[serde(rename = "error_message", skip_serializing_if = "Option::is_none")]
    pub error_message: Option<String>,
}

impl TransactionCallPreviewResponse {
    pub fn new(status: crate::core_api::generated::models::TransactionStatus) -> TransactionCallPreviewResponse {
        TransactionCallPreviewResponse {
            status,
            output: None,
            error_message: None,
        }
    }
}


