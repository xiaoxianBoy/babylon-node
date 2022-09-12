use sbor::decode_any;

use crate::core_api::*;

pub fn to_hex<T: AsRef<[u8]>>(v: T) -> String {
    hex::encode(v)
}

pub fn scrypto_bytes_to_api_sbor_data(
    scrypto_bytes: &[u8],
) -> Result<models::SborData, MappingError> {
    let scrypto_value = decode_any(scrypto_bytes).map_err(|err| MappingError::InvalidSbor {
        decode_error: err,
        bytes: scrypto_bytes.to_vec(),
    })?;
    Ok(models::SborData {
        data_bytes: to_hex(scrypto_bytes),
        data_json: serde_json::to_string(&scrypto_value).expect("JSON serialize error"),
    })
}