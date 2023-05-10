/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet V1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { EddsaEd25519PublicKey } from './EddsaEd25519PublicKey';
import {
    EddsaEd25519PublicKeyFromJSON,
    EddsaEd25519PublicKeyFromJSONTyped,
    EddsaEd25519PublicKeyToJSON,
} from './EddsaEd25519PublicKey';
import type { EddsaEd25519Signature } from './EddsaEd25519Signature';
import {
    EddsaEd25519SignatureFromJSON,
    EddsaEd25519SignatureFromJSONTyped,
    EddsaEd25519SignatureToJSON,
} from './EddsaEd25519Signature';

/**
 * 
 * @export
 * @interface EddsaEd25519SignatureWithPublicKey
 */
export interface EddsaEd25519SignatureWithPublicKey {
    /**
     * 
     * @type {string}
     * @memberof EddsaEd25519SignatureWithPublicKey
     */
    key_type: EddsaEd25519SignatureWithPublicKeyKeyTypeEnum;
    /**
     * 
     * @type {EddsaEd25519PublicKey}
     * @memberof EddsaEd25519SignatureWithPublicKey
     */
    public_key: EddsaEd25519PublicKey;
    /**
     * 
     * @type {EddsaEd25519Signature}
     * @memberof EddsaEd25519SignatureWithPublicKey
     */
    signature: EddsaEd25519Signature;
}


/**
 * @export
 */
export const EddsaEd25519SignatureWithPublicKeyKeyTypeEnum = {
    EddsaEd25519: 'EddsaEd25519'
} as const;
export type EddsaEd25519SignatureWithPublicKeyKeyTypeEnum = typeof EddsaEd25519SignatureWithPublicKeyKeyTypeEnum[keyof typeof EddsaEd25519SignatureWithPublicKeyKeyTypeEnum];


/**
 * Check if a given object implements the EddsaEd25519SignatureWithPublicKey interface.
 */
export function instanceOfEddsaEd25519SignatureWithPublicKey(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "key_type" in value;
    isInstance = isInstance && "public_key" in value;
    isInstance = isInstance && "signature" in value;

    return isInstance;
}

export function EddsaEd25519SignatureWithPublicKeyFromJSON(json: any): EddsaEd25519SignatureWithPublicKey {
    return EddsaEd25519SignatureWithPublicKeyFromJSONTyped(json, false);
}

export function EddsaEd25519SignatureWithPublicKeyFromJSONTyped(json: any, ignoreDiscriminator: boolean): EddsaEd25519SignatureWithPublicKey {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'key_type': json['key_type'],
        'public_key': EddsaEd25519PublicKeyFromJSON(json['public_key']),
        'signature': EddsaEd25519SignatureFromJSON(json['signature']),
    };
}

export function EddsaEd25519SignatureWithPublicKeyToJSON(value?: EddsaEd25519SignatureWithPublicKey | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'key_type': value.key_type,
        'public_key': EddsaEd25519PublicKeyToJSON(value.public_key),
        'signature': EddsaEd25519SignatureToJSON(value.signature),
    };
}
