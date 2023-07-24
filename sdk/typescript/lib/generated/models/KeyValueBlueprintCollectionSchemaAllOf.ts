/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v2\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { TypePointer } from './TypePointer';
import {
    TypePointerFromJSON,
    TypePointerFromJSONTyped,
    TypePointerToJSON,
} from './TypePointer';

/**
 * 
 * @export
 * @interface KeyValueBlueprintCollectionSchemaAllOf
 */
export interface KeyValueBlueprintCollectionSchemaAllOf {
    /**
     * 
     * @type {TypePointer}
     * @memberof KeyValueBlueprintCollectionSchemaAllOf
     */
    key_type_pointer: TypePointer;
    /**
     * 
     * @type {TypePointer}
     * @memberof KeyValueBlueprintCollectionSchemaAllOf
     */
    value_type_pointer: TypePointer;
    /**
     * Whether the entries of the key-value store are allowed to own child nodes.
     * @type {boolean}
     * @memberof KeyValueBlueprintCollectionSchemaAllOf
     */
    can_own: boolean;
    /**
     * 
     * @type {string}
     * @memberof KeyValueBlueprintCollectionSchemaAllOf
     */
    type?: KeyValueBlueprintCollectionSchemaAllOfTypeEnum;
}


/**
 * @export
 */
export const KeyValueBlueprintCollectionSchemaAllOfTypeEnum = {
    KeyValue: 'KeyValue'
} as const;
export type KeyValueBlueprintCollectionSchemaAllOfTypeEnum = typeof KeyValueBlueprintCollectionSchemaAllOfTypeEnum[keyof typeof KeyValueBlueprintCollectionSchemaAllOfTypeEnum];


/**
 * Check if a given object implements the KeyValueBlueprintCollectionSchemaAllOf interface.
 */
export function instanceOfKeyValueBlueprintCollectionSchemaAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "key_type_pointer" in value;
    isInstance = isInstance && "value_type_pointer" in value;
    isInstance = isInstance && "can_own" in value;

    return isInstance;
}

export function KeyValueBlueprintCollectionSchemaAllOfFromJSON(json: any): KeyValueBlueprintCollectionSchemaAllOf {
    return KeyValueBlueprintCollectionSchemaAllOfFromJSONTyped(json, false);
}

export function KeyValueBlueprintCollectionSchemaAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): KeyValueBlueprintCollectionSchemaAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'key_type_pointer': TypePointerFromJSON(json['key_type_pointer']),
        'value_type_pointer': TypePointerFromJSON(json['value_type_pointer']),
        'can_own': json['can_own'],
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function KeyValueBlueprintCollectionSchemaAllOfToJSON(value?: KeyValueBlueprintCollectionSchemaAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'key_type_pointer': TypePointerToJSON(value.key_type_pointer),
        'value_type_pointer': TypePointerToJSON(value.value_type_pointer),
        'can_own': value.can_own,
        'type': value.type,
    };
}

