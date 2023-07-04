use radix_engine::types::*;

use sbor::representations::*;

use crate::core_api::*;

#[tracing::instrument(skip_all)]
pub fn to_hex<T: AsRef<[u8]>>(v: T) -> String {
    hex::encode(v)
}

pub fn from_hex<T: AsRef<[u8]>>(v: T) -> Result<Vec<u8>, ExtractionError> {
    hex::decode(v).map_err(|_| ExtractionError::InvalidHex)
}

pub fn to_api_data_struct_from_scrypto_value(
    context: &MappingContext,
    scrypto_value: &ScryptoValue,
) -> Result<models::DataStruct, MappingError> {
    let scrypto_value = IndexedScryptoValue::from_typed(scrypto_value);
    to_api_data_struct_from_indexed_scrypto_value(context, scrypto_value)
}

pub fn to_api_data_struct_from_scrypto_raw_value(
    context: &MappingContext,
    scrypto_raw_value: &ScryptoRawValue<'_>,
) -> Result<models::DataStruct, MappingError> {
    let scrypto_value =
        IndexedScryptoValue::from_vec(scrypto_encode(scrypto_raw_value).unwrap()).unwrap();
    to_api_data_struct_from_indexed_scrypto_value(context, scrypto_value)
}

pub fn to_api_data_struct_from_bytes(
    context: &MappingContext,
    data: &[u8],
) -> Result<models::DataStruct, MappingError> {
    let scrypto_value =
        IndexedScryptoValue::from_slice(data).map_err(|err| MappingError::ScryptoValueDecode {
            decode_error: err,
            bytes: data.to_vec(),
        })?;
    to_api_data_struct_from_indexed_scrypto_value(context, scrypto_value)
}

pub fn to_api_data_struct_from_indexed_scrypto_value(
    context: &MappingContext,
    scrypto_value: IndexedScryptoValue,
) -> Result<models::DataStruct, MappingError> {
    let entities = extract_entities(context, &scrypto_value)?;
    Ok(models::DataStruct {
        struct_data: Box::new(to_api_sbor_data_from_bytes(
            context,
            scrypto_value.as_slice(),
        )?),
        owned_entities: entities.owned_entities,
        referenced_entities: entities.referenced_entities,
    })
}

struct Entities {
    pub owned_entities: Vec<models::EntityReference>,
    pub referenced_entities: Vec<models::EntityReference>,
}

fn extract_entities(
    context: &MappingContext,
    struct_scrypto_value: &IndexedScryptoValue,
) -> Result<Entities, MappingError> {
    let owned_entities = struct_scrypto_value
        .owned_nodes()
        .iter()
        .map(|node_id| to_api_entity_reference(context, node_id))
        .collect::<Result<Vec<_>, _>>()?;

    let referenced_entities = struct_scrypto_value
        .references()
        .iter()
        .map(|node_id| to_api_entity_reference(context, node_id))
        .collect::<Result<Vec<_>, _>>()?;

    Ok(Entities {
        owned_entities,
        referenced_entities,
    })
}

pub fn to_api_sbor_data_from_encodable(
    context: &MappingContext,
    value: &impl ScryptoEncode,
) -> Result<models::SborData, MappingError> {
    to_api_sbor_data_from_bytes(
        context,
        &scrypto_encode(value).map_err(|err| MappingError::SborEncodeError {
            encode_error: err,
            message: "Could not encode sbor for SBOR data".to_string(),
        })?,
    )
}

pub fn to_api_sbor_data_from_bytes(
    context: &MappingContext,
    scrypto_sbor_bytes: &[u8],
) -> Result<models::SborData, MappingError> {
    Ok(models::SborData {
        hex: {
            if context.sbor_options.include_raw {
                Some(to_hex(scrypto_sbor_bytes))
            } else {
                None
            }
        },
        programmatic_json: {
            if context.sbor_options.include_programmatic_json {
                Some({
                    serde_json::to_value(
                        ScryptoRawPayload::new_from_valid_slice_with_checks(scrypto_sbor_bytes)
                            .ok_or_else(|| MappingError::InvalidSbor {
                                decode_error: "Failed payload prefix check".to_string(),
                                bytes: scrypto_sbor_bytes.to_vec(),
                            })?
                            .serializable(SerializationParameters::Schemaless {
                                mode: SerializationMode::Programmatic,
                                custom_context: ScryptoValueDisplayContext::with_optional_bech32(
                                    Some(&context.bech32_encoder),
                                ),
                            }),
                    )
                    .map_err(|err| MappingError::InvalidSbor {
                        decode_error: format!("Could not encode to JSON: {err}"),
                        bytes: scrypto_sbor_bytes.to_vec(),
                    })?
                })
            } else {
                None
            }
        },
    })
}
