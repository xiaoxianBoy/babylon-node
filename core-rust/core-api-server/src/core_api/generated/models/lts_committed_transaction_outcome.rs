/*
 * Babylon Core API - RCnet v3
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// LtsCommittedTransactionOutcome : For the given transaction, contains the status, total fee summary and individual entity resource balance changes. The balance changes accounts for the fee payments as well. Current implementation does not take into account recalls, but this will change in a future update. For failed transactions, current implementation does not return any balance changes (not even the fee payments). This will also change in a future update. 



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct LtsCommittedTransactionOutcome {
    #[serde(rename = "state_version")]
    pub state_version: i64,
    /// The hex-encoded transaction accumulator hash. This hash captures the order of all transactions on ledger. This hash is `ACC_{N+1} = combine(ACC_N, LEDGER_HASH_{N}))` (where `combine()` is an arbitrary deterministic function we use). 
    #[serde(rename = "accumulator_hash")]
    pub accumulator_hash: String,
    #[serde(rename = "user_transaction_identifiers", skip_serializing_if = "Option::is_none")]
    pub user_transaction_identifiers: Option<Box<crate::core_api::generated::models::TransactionIdentifiers>>,
    #[serde(rename = "status")]
    pub status: crate::core_api::generated::models::LtsCommittedTransactionStatus,
    /// THE FEE ASSIGNMENT IS NOT CURRENTLY FULLY ACCURATE FOR SOME TRANSACTIONS. THIS WILL BE FIXED AT RCNET-V2. A list of all fungible balance updates which occurred in this transaction, aggregated by the global entity (such as account) which owns the vaults which were updated. 
    #[serde(rename = "fungible_entity_balance_changes")]
    pub fungible_entity_balance_changes: Vec<crate::core_api::generated::models::LtsEntityFungibleBalanceChanges>,
    /// THIS CURRENTLY RETURNS AN EMPTY LIST. THIS FEATURE WILL BE COMING AT RCNET-V2. A list of the resultant balances of any account balances changed in this transaction. Only balances for accounts are returned, not any other kind of entity. 
    #[serde(rename = "resultant_account_fungible_balances")]
    pub resultant_account_fungible_balances: Vec<crate::core_api::generated::models::LtsResultantAccountFungibleBalances>,
    /// The string-encoded decimal representing the total amount of XRD payed as fee (execution, validator tip and royalties). A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. 
    #[serde(rename = "total_fee")]
    pub total_fee: String,
}

impl LtsCommittedTransactionOutcome {
    /// For the given transaction, contains the status, total fee summary and individual entity resource balance changes. The balance changes accounts for the fee payments as well. Current implementation does not take into account recalls, but this will change in a future update. For failed transactions, current implementation does not return any balance changes (not even the fee payments). This will also change in a future update. 
    pub fn new(state_version: i64, accumulator_hash: String, status: crate::core_api::generated::models::LtsCommittedTransactionStatus, fungible_entity_balance_changes: Vec<crate::core_api::generated::models::LtsEntityFungibleBalanceChanges>, resultant_account_fungible_balances: Vec<crate::core_api::generated::models::LtsResultantAccountFungibleBalances>, total_fee: String) -> LtsCommittedTransactionOutcome {
        LtsCommittedTransactionOutcome {
            state_version,
            accumulator_hash,
            user_transaction_identifiers: None,
            status,
            fungible_entity_balance_changes,
            resultant_account_fungible_balances,
            total_fee,
        }
    }
}


