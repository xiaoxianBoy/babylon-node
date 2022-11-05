/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// StateUpdates : Transaction state updates (only present if status is Succeeded or Failed)



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct StateUpdates {
    #[serde(rename = "up_substates")]
    pub up_substates: Vec<crate::core_api::generated::models::UpSubstate>,
    #[serde(rename = "down_substates")]
    pub down_substates: Vec<crate::core_api::generated::models::DownSubstate>,
    #[serde(rename = "new_global_entities")]
    pub new_global_entities: Vec<crate::core_api::generated::models::GlobalEntityAssignment>,
}

impl StateUpdates {
    /// Transaction state updates (only present if status is Succeeded or Failed)
    pub fn new(up_substates: Vec<crate::core_api::generated::models::UpSubstate>, down_substates: Vec<crate::core_api::generated::models::DownSubstate>, new_global_entities: Vec<crate::core_api::generated::models::GlobalEntityAssignment>) -> StateUpdates {
        StateUpdates {
            up_substates,
            down_substates,
            new_global_entities,
        }
    }
}


