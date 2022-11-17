/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */


/// 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum FixedProofRuleType {
    #[serde(rename = "Require")]
    Require,
    #[serde(rename = "AmountOf")]
    AmountOf,
    #[serde(rename = "AllOf")]
    AllOf,
    #[serde(rename = "AnyOf")]
    AnyOf,
    #[serde(rename = "CountOf")]
    CountOf,

}

impl ToString for FixedProofRuleType {
    fn to_string(&self) -> String {
        match self {
            Self::Require => String::from("Require"),
            Self::AmountOf => String::from("AmountOf"),
            Self::AllOf => String::from("AllOf"),
            Self::AnyOf => String::from("AnyOf"),
            Self::CountOf => String::from("CountOf"),
        }
    }
}

impl Default for FixedProofRuleType {
    fn default() -> FixedProofRuleType {
        Self::Require
    }
}



