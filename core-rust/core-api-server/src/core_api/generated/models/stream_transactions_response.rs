/*
 * Radix Core API - Babylon (v1.0.0)
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct StreamTransactionsResponse {
    #[serde(rename = "previous_state_identifiers", skip_serializing_if = "Option::is_none")]
    pub previous_state_identifiers: Option<Box<crate::core_api::generated::models::CommittedStateIdentifier>>,
    #[serde(rename = "from_state_version")]
    pub from_state_version: i64,
    /// An integer between `0` and `10000`, giving the total count of transactions in the returned response
    #[serde(rename = "count")]
    pub count: i32,
    #[serde(rename = "max_ledger_state_version")]
    pub max_ledger_state_version: i64,
    /// A committed transactions list starting from the `from_state_version` (inclusive).
    #[serde(rename = "transactions")]
    pub transactions: Vec<crate::core_api::generated::models::CommittedTransaction>,
    /// A ledger proof list starting from `from_state_version` (inclusive) stored by this node.
    #[serde(rename = "proofs", skip_serializing_if = "Option::is_none")]
    pub proofs: Option<Vec<crate::core_api::generated::models::LedgerProof>>,
}

impl StreamTransactionsResponse {
    pub fn new(from_state_version: i64, count: i32, max_ledger_state_version: i64, transactions: Vec<crate::core_api::generated::models::CommittedTransaction>) -> StreamTransactionsResponse {
        StreamTransactionsResponse {
            previous_state_identifiers: None,
            from_state_version,
            count,
            max_ledger_state_version,
            transactions,
            proofs: None,
        }
    }
}


