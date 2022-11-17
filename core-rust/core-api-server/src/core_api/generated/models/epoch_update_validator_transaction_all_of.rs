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
pub struct EpochUpdateValidatorTransactionAllOf {
    /// An integer between `0` and `10^10`, marking the new epoch
    #[serde(rename = "epoch")]
    pub epoch: i64,
}

impl EpochUpdateValidatorTransactionAllOf {
    pub fn new(epoch: i64) -> EpochUpdateValidatorTransactionAllOf {
        EpochUpdateValidatorTransactionAllOf {
            epoch,
        }
    }
}

