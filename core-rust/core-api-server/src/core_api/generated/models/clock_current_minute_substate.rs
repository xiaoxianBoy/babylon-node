/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ClockCurrentMinuteSubstate {
    #[serde(rename = "substate_type")]
    pub substate_type: crate::core_api::generated::models::SubstateType,
    /// An integer between `0` and `10^14`, marking the ledger unix timestamp in ms (rounded down to the current minute)
    #[serde(rename = "timestamp_ms_rounded_down_to_minute")]
    pub timestamp_ms_rounded_down_to_minute: i64,
}

impl ClockCurrentMinuteSubstate {
    pub fn new(substate_type: crate::core_api::generated::models::SubstateType, timestamp_ms_rounded_down_to_minute: i64) -> ClockCurrentMinuteSubstate {
        ClockCurrentMinuteSubstate {
            substate_type,
            timestamp_ms_rounded_down_to_minute,
        }
    }
}

