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
/**
 * 
 * @export
 * @interface EcdsaSecp256k1PublicKeyAllOf
 */
export interface EcdsaSecp256k1PublicKeyAllOf {
    /**
     * The hex-encoded compressed ECDSA Secp256k1 public key (33 bytes)
     * @type {string}
     * @memberof EcdsaSecp256k1PublicKeyAllOf
     */
    key_hex: string;
    /**
     * 
     * @type {string}
     * @memberof EcdsaSecp256k1PublicKeyAllOf
     */
    key_type?: EcdsaSecp256k1PublicKeyAllOfKeyTypeEnum;
}


/**
 * @export
 */
export const EcdsaSecp256k1PublicKeyAllOfKeyTypeEnum = {
    EcdsaSecp256k1: 'EcdsaSecp256k1'
} as const;
export type EcdsaSecp256k1PublicKeyAllOfKeyTypeEnum = typeof EcdsaSecp256k1PublicKeyAllOfKeyTypeEnum[keyof typeof EcdsaSecp256k1PublicKeyAllOfKeyTypeEnum];


/**
 * Check if a given object implements the EcdsaSecp256k1PublicKeyAllOf interface.
 */
export function instanceOfEcdsaSecp256k1PublicKeyAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "key_hex" in value;

    return isInstance;
}

export function EcdsaSecp256k1PublicKeyAllOfFromJSON(json: any): EcdsaSecp256k1PublicKeyAllOf {
    return EcdsaSecp256k1PublicKeyAllOfFromJSONTyped(json, false);
}

export function EcdsaSecp256k1PublicKeyAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): EcdsaSecp256k1PublicKeyAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'key_hex': json['key_hex'],
        'key_type': !exists(json, 'key_type') ? undefined : json['key_type'],
    };
}

export function EcdsaSecp256k1PublicKeyAllOfToJSON(value?: EcdsaSecp256k1PublicKeyAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'key_hex': value.key_hex,
        'key_type': value.key_type,
    };
}

