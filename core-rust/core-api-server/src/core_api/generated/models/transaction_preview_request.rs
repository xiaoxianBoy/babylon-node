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
pub struct TransactionPreviewRequest {
    /// The logical name of the network
    #[serde(rename = "network")]
    pub network: String,
    /// A text-representation of a transaction manifest
    #[serde(rename = "manifest")]
    pub manifest: String,
    /// An array of hex-encoded blob data (optional)
    #[serde(rename = "blobs_hex", skip_serializing_if = "Option::is_none")]
    pub blobs_hex: Option<Vec<String>>,
    /// An integer between `0` and `10^10`, marking the epoch at which the transaction starts being valid
    #[serde(rename = "start_epoch_inclusive")]
    pub start_epoch_inclusive: i64,
    /// An integer between `0` and `10^10`, marking the epoch at which the transaction is no longer valid
    #[serde(rename = "end_epoch_exclusive")]
    pub end_epoch_exclusive: i64,
    #[serde(rename = "notary_public_key", skip_serializing_if = "Option::is_none")]
    pub notary_public_key: Option<Box<crate::core_api::generated::models::PublicKey>>,
    /// Whether the notary should count as a signatory (optional, default false)
    #[serde(rename = "notary_is_signatory", skip_serializing_if = "Option::is_none")]
    pub notary_is_signatory: Option<bool>,
    /// An integer between `0` and `255`, giving the validator tip as a percentage amount. A value of `1` corresponds to 1% of the fee.
    #[serde(rename = "tip_percentage")]
    pub tip_percentage: i32,
    /// An integer between `0` and `2^32 - 1`, chosen to allow a unique intent to be created (to enable submitting an otherwise identical/duplicate intent). 
    #[serde(rename = "nonce")]
    pub nonce: i64,
    /// A list of public keys to be used as transaction signers
    #[serde(rename = "signer_public_keys")]
    pub signer_public_keys: Vec<crate::core_api::generated::models::PublicKey>,
    #[serde(rename = "message", skip_serializing_if = "Option::is_none")]
    pub message: Option<Box<crate::core_api::generated::models::TransactionMessage>>,
    #[serde(rename = "flags")]
    pub flags: Box<crate::core_api::generated::models::TransactionPreviewRequestFlags>,
}

impl TransactionPreviewRequest {
    pub fn new(network: String, manifest: String, start_epoch_inclusive: i64, end_epoch_exclusive: i64, tip_percentage: i32, nonce: i64, signer_public_keys: Vec<crate::core_api::generated::models::PublicKey>, flags: crate::core_api::generated::models::TransactionPreviewRequestFlags) -> TransactionPreviewRequest {
        TransactionPreviewRequest {
            network,
            manifest,
            blobs_hex: None,
            start_epoch_inclusive,
            end_epoch_exclusive,
            notary_public_key: None,
            notary_is_signatory: None,
            tip_percentage,
            nonce,
            signer_public_keys,
            message: None,
            flags: Box::new(flags),
        }
    }
}


