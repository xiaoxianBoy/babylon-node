/*
 * Babylon Core API - RCnet v3
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct CostingParameters {
    /// The string-encoded decimal representing the XRD price of a single cost unit of transaction execution. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "execution_cost_unit_price")]
    pub execution_cost_unit_price: String,
    /// An integer between `0` and `2^32 - 1`, representing the maximum amount of cost units available for the transaction execution.
    #[serde(rename = "execution_cost_unit_limit")]
    pub execution_cost_unit_limit: i64,
    /// An integer between `0` and `2^32 - 1`, representing the number of execution cost units loaned from system.
    #[serde(rename = "execution_cost_unit_loan")]
    pub execution_cost_unit_loan: i64,
    /// The string-encoded decimal representing the XRD price of a single cost unit of transaction finalization. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "finalization_cost_unit_price")]
    pub finalization_cost_unit_price: String,
    /// An integer between `0` and `2^32 - 1`, representing the maximum amount of cost units available for the transaction finalization.
    #[serde(rename = "finalization_cost_unit_limit")]
    pub finalization_cost_unit_limit: i64,
    /// The string-encoded decimal representing the price of 1 USD, expressed in XRD. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "xrd_usd_price")]
    pub xrd_usd_price: String,
    /// The string-encoded decimal representing the price of 1 byte of storage, expressed in XRD. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "xrd_storage_price")]
    pub xrd_storage_price: String,
    /// An integer between `0` and `255`, giving the validator tip as a percentage amount. A value of `1` corresponds to 1% of the fee.
    #[serde(rename = "tip_percentage")]
    pub tip_percentage: i32,
}

impl CostingParameters {
    pub fn new(execution_cost_unit_price: String, execution_cost_unit_limit: i64, execution_cost_unit_loan: i64, finalization_cost_unit_price: String, finalization_cost_unit_limit: i64, xrd_usd_price: String, xrd_storage_price: String, tip_percentage: i32) -> CostingParameters {
        CostingParameters {
            execution_cost_unit_price,
            execution_cost_unit_limit,
            execution_cost_unit_loan,
            finalization_cost_unit_price,
            finalization_cost_unit_limit,
            xrd_usd_price,
            xrd_storage_price,
            tip_percentage,
        }
    }
}


