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
pub struct KeyValueStoreEntrySubstate {
    #[serde(rename = "substate_type")]
    pub substate_type: crate::core_api::generated::models::SubstateType,
    /// The hex-encoded bytes of its key
    #[serde(rename = "key_hex")]
    pub key_hex: String,
    #[serde(rename = "is_deleted")]
    pub is_deleted: bool,
    #[serde(rename = "data_struct", skip_serializing_if = "Option::is_none")]
    pub data_struct: Option<Box<crate::core_api::generated::models::DataStruct>>,
}

impl KeyValueStoreEntrySubstate {
    pub fn new(substate_type: crate::core_api::generated::models::SubstateType, key_hex: String, is_deleted: bool) -> KeyValueStoreEntrySubstate {
        KeyValueStoreEntrySubstate {
            substate_type,
            key_hex,
            is_deleted,
            data_struct: None,
        }
    }
}


