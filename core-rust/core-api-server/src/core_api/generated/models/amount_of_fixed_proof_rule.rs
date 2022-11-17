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
pub struct AmountOfFixedProofRule {
    #[serde(rename = "type")]
    pub _type: crate::core_api::generated::models::FixedProofRuleType,
    /// The string-encoded decimal representing the amount of resource required to pass the proof rule. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "amount")]
    pub amount: String,
    #[serde(rename = "resource")]
    pub resource: Option<crate::core_api::generated::models::FixedResourceDescriptor>, // Using Option permits Default trait; Will always be Some in normal use
}

impl AmountOfFixedProofRule {
    pub fn new(_type: crate::core_api::generated::models::FixedProofRuleType, amount: String, resource: crate::core_api::generated::models::FixedResourceDescriptor) -> AmountOfFixedProofRule {
        AmountOfFixedProofRule {
            _type,
            amount,
            resource: Option::Some(resource),
        }
    }
}

