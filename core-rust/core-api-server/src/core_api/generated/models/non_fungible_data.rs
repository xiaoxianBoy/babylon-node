/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// NonFungibleData : Only present if the non fungible isn't deleted



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct NonFungibleData {
    #[serde(rename = "immutable_data")]
    pub immutable_data: Box<crate::core_api::generated::models::DataStruct>,
    #[serde(rename = "mutable_data")]
    pub mutable_data: Box<crate::core_api::generated::models::DataStruct>,
}

impl NonFungibleData {
    /// Only present if the non fungible isn't deleted
    pub fn new(immutable_data: crate::core_api::generated::models::DataStruct, mutable_data: crate::core_api::generated::models::DataStruct) -> NonFungibleData {
        NonFungibleData {
            immutable_data: Box::new(immutable_data),
            mutable_data: Box::new(mutable_data),
        }
    }
}

