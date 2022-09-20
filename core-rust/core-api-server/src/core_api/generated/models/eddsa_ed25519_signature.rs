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
pub struct EddsaEd25519Signature {
    #[serde(rename = "key_type")]
    pub key_type: crate::core_api::generated::models::PublicKeyType,
    /// A hex-encoded EdDSA Ed25519 signature (64 bytes). This is CONCAT(R, s) where R and s are each 32-bytes in padded big-endian format.
    #[serde(rename = "signature_bytes")]
    pub signature_bytes: String,
}

impl EddsaEd25519Signature {
    pub fn new(key_type: crate::core_api::generated::models::PublicKeyType, signature_bytes: String) -> EddsaEd25519Signature {
        EddsaEd25519Signature {
            key_type,
            signature_bytes,
        }
    }
}

