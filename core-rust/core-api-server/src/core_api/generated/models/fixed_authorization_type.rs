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
pub enum FixedAuthorizationType {
    #[serde(rename = "Protected")]
    Protected,
    #[serde(rename = "AllowAll")]
    AllowAll,
    #[serde(rename = "DenyAll")]
    DenyAll,

}

impl ToString for FixedAuthorizationType {
    fn to_string(&self) -> String {
        match self {
            Self::Protected => String::from("Protected"),
            Self::AllowAll => String::from("AllowAll"),
            Self::DenyAll => String::from("DenyAll"),
        }
    }
}

impl Default for FixedAuthorizationType {
    fn default() -> FixedAuthorizationType {
        Self::Protected
    }
}



