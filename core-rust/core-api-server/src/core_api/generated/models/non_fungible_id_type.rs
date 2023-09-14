/*
 * Babylon Core API - RCnet v3.1
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
 * 
 * Generated by: https://openapi-generator.tech
 */


/// 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum NonFungibleIdType {
    #[serde(rename = "String")]
    String,
    #[serde(rename = "Integer")]
    Integer,
    #[serde(rename = "Bytes")]
    Bytes,
    #[serde(rename = "RUID")]
    RUID,

}

impl ToString for NonFungibleIdType {
    fn to_string(&self) -> String {
        match self {
            Self::String => String::from("String"),
            Self::Integer => String::from("Integer"),
            Self::Bytes => String::from("Bytes"),
            Self::RUID => String::from("RUID"),
        }
    }
}

impl Default for NonFungibleIdType {
    fn default() -> NonFungibleIdType {
        Self::String
    }
}




