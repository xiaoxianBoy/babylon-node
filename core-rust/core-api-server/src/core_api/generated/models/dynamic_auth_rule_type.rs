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
pub enum DynamicAuthRuleType {
    #[serde(rename = "ProofRule")]
    ProofRule,
    #[serde(rename = "AnyOf")]
    AnyOf,
    #[serde(rename = "AllOf")]
    AllOf,

}

impl ToString for DynamicAuthRuleType {
    fn to_string(&self) -> String {
        match self {
            Self::ProofRule => String::from("ProofRule"),
            Self::AnyOf => String::from("AnyOf"),
            Self::AllOf => String::from("AllOf"),
        }
    }
}

impl Default for DynamicAuthRuleType {
    fn default() -> DynamicAuthRuleType {
        Self::ProofRule
    }
}



