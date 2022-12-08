/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct V0StateClockResponse {
    #[serde(rename = "current_minute")]
    pub current_minute: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
}

impl V0StateClockResponse {
    pub fn new(current_minute: crate::core_api::generated::models::Substate) -> V0StateClockResponse {
        V0StateClockResponse {
            current_minute: Option::Some(current_minute),
        }
    }
}


