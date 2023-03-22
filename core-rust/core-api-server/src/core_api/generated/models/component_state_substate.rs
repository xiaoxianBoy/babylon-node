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
pub struct ComponentStateSubstate {
    #[serde(rename = "substate_type")]
    pub substate_type: crate::core_api::generated::models::SubstateType,
    #[serde(rename = "data_struct")]
    pub data_struct: Box<crate::core_api::generated::models::DataStruct>,
}

impl ComponentStateSubstate {
    pub fn new(substate_type: crate::core_api::generated::models::SubstateType, data_struct: crate::core_api::generated::models::DataStruct) -> ComponentStateSubstate {
        ComponentStateSubstate {
            substate_type,
            data_struct: Box::new(data_struct),
        }
    }
}


