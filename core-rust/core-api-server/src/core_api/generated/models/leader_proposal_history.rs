/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct LeaderProposalHistory {
    /// The validators which were leaders of the \"gap\" rounds (i.e. since the previous `RoundUpdateValidatorTransaction` - which means that this list will contain exactly `current.round - previous.round - 1` elements). The validators on this list should be penalized during emissions at the end of the epoch.
    #[serde(rename = "gap_round_leaders")]
    pub gap_round_leaders: Vec<crate::core_api::generated::models::ActiveValidatorIndex>,
    #[serde(rename = "current_leader")]
    pub current_leader: Box<crate::core_api::generated::models::ActiveValidatorIndex>,
    /// Whether the concluded round was conducted in a \"fallback\" mode (i.e. indicating a fault of the current leader). When `true`, the `current_leader` should be penalized during emissions in the same way as `gap_round_leaders`. When `false`, the `current_leader` is considered to have made this round's proposal successfully.
    #[serde(rename = "is_fallback")]
    pub is_fallback: bool,
}

impl LeaderProposalHistory {
    pub fn new(gap_round_leaders: Vec<crate::core_api::generated::models::ActiveValidatorIndex>, current_leader: crate::core_api::generated::models::ActiveValidatorIndex, is_fallback: bool) -> LeaderProposalHistory {
        LeaderProposalHistory {
            gap_round_leaders,
            current_leader: Box::new(current_leader),
            is_fallback,
        }
    }
}


