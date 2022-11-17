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
pub enum FixedResourceDescriptor {
    #[serde(rename="NonFungible")]
    NonFungibleFixedResourceDescriptor {
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "resource_address")]
        resource_address: String,
        /// The hex-encoded bytes of a non-fungible id
        #[serde(rename = "non_fungible_id_hex")]
        non_fungible_id_hex: String,
    },
    #[serde(rename="Resource")]
    ResourceFixedResourceDescriptor {
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "resource_address")]
        resource_address: String,
    },
}



