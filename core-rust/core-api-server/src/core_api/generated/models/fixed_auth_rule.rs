/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "type")]
pub enum FixedAuthRule {
    #[serde(rename="AllOf")]
    AllOfFixedAuthRule {
        #[serde(rename = "auth_rules")]
        auth_rules: Vec<crate::core_api::generated::models::FixedAuthRule>,
    },
    #[serde(rename="AnyOf")]
    AnyOfFixedAuthRule {
        #[serde(rename = "auth_rules")]
        auth_rules: Vec<crate::core_api::generated::models::FixedAuthRule>,
    },
    #[serde(rename="ProofRule")]
    ProofFixedAuthRule {
        #[serde(rename = "proof_rule")]
        proof_rule: Box<crate::core_api::generated::models::FixedProofRule>,
    },
}



