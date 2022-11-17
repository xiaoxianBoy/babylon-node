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
pub enum FixedAuthorization {
    #[serde(rename="AllowAll")]
    AllowAllFixedAuthorization {
    },
    #[serde(rename="DenyAll")]
    DenyAllFixedAuthorization {
    },
    #[serde(rename="Protected")]
    ProtectedFixedAuthorization {
        #[serde(rename = "auth_rule")]
        auth_rule: Box<crate::core_api::generated::models::FixedAuthRule>,
    },
}



