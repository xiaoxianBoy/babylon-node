/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { LocalTypeIndex } from './LocalTypeIndex';
import {
    LocalTypeIndexFromJSON,
    LocalTypeIndexFromJSONTyped,
    LocalTypeIndexToJSON,
} from './LocalTypeIndex';

/**
 * 
 * @export
 * @interface KeyValueStoreEntryStructure
 */
export interface KeyValueStoreEntryStructure {
    /**
     * 
     * @type {string}
     * @memberof KeyValueStoreEntryStructure
     */
    type: KeyValueStoreEntryStructureTypeEnum;
    /**
     * Bech32m-encoded human readable version of the entity's address (ie the entity's node id)
     * @type {string}
     * @memberof KeyValueStoreEntryStructure
     */
    key_value_store_address: string;
    /**
     * The hex-encoded schema hash, capturing the identity of an SBOR schema.
     * @type {string}
     * @memberof KeyValueStoreEntryStructure
     */
    key_schema_hash: string;
    /**
     * 
     * @type {LocalTypeIndex}
     * @memberof KeyValueStoreEntryStructure
     */
    key_local_type_index: LocalTypeIndex;
    /**
     * The hex-encoded schema hash, capturing the identity of an SBOR schema.
     * @type {string}
     * @memberof KeyValueStoreEntryStructure
     */
    value_schema_hash: string;
    /**
     * 
     * @type {LocalTypeIndex}
     * @memberof KeyValueStoreEntryStructure
     */
    value_local_type_index: LocalTypeIndex;
}


/**
 * @export
 */
export const KeyValueStoreEntryStructureTypeEnum = {
    KeyValueStoreEntry: 'KeyValueStoreEntry'
} as const;
export type KeyValueStoreEntryStructureTypeEnum = typeof KeyValueStoreEntryStructureTypeEnum[keyof typeof KeyValueStoreEntryStructureTypeEnum];


/**
 * Check if a given object implements the KeyValueStoreEntryStructure interface.
 */
export function instanceOfKeyValueStoreEntryStructure(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "key_value_store_address" in value;
    isInstance = isInstance && "key_schema_hash" in value;
    isInstance = isInstance && "key_local_type_index" in value;
    isInstance = isInstance && "value_schema_hash" in value;
    isInstance = isInstance && "value_local_type_index" in value;

    return isInstance;
}

export function KeyValueStoreEntryStructureFromJSON(json: any): KeyValueStoreEntryStructure {
    return KeyValueStoreEntryStructureFromJSONTyped(json, false);
}

export function KeyValueStoreEntryStructureFromJSONTyped(json: any, ignoreDiscriminator: boolean): KeyValueStoreEntryStructure {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'key_value_store_address': json['key_value_store_address'],
        'key_schema_hash': json['key_schema_hash'],
        'key_local_type_index': LocalTypeIndexFromJSON(json['key_local_type_index']),
        'value_schema_hash': json['value_schema_hash'],
        'value_local_type_index': LocalTypeIndexFromJSON(json['value_local_type_index']),
    };
}

export function KeyValueStoreEntryStructureToJSON(value?: KeyValueStoreEntryStructure | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'key_value_store_address': value.key_value_store_address,
        'key_schema_hash': value.key_schema_hash,
        'key_local_type_index': LocalTypeIndexToJSON(value.key_local_type_index),
        'value_schema_hash': value.value_schema_hash,
        'value_local_type_index': LocalTypeIndexToJSON(value.value_local_type_index),
    };
}
