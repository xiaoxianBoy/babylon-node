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
pub struct PackageRoyaltyAccumulatorSubstate {
    #[serde(rename = "substate_type")]
    pub substate_type: crate::core_api::generated::models::SubstateType,
    /// The string-encoded decimal representing the amount of XRD available for claim in the royalty accumulator. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "xrd_amount")]
    pub xrd_amount: String,
}

impl PackageRoyaltyAccumulatorSubstate {
    pub fn new(substate_type: crate::core_api::generated::models::SubstateType, xrd_amount: String) -> PackageRoyaltyAccumulatorSubstate {
        PackageRoyaltyAccumulatorSubstate {
            substate_type,
            xrd_amount,
        }
    }
}


