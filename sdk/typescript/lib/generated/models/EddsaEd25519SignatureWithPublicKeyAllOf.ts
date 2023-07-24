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
 * The EdDSA public key and signature
 * @export
 * @interface EddsaEd25519SignatureWithPublicKeyAllOf
 */
export interface EddsaEd25519SignatureWithPublicKeyAllOf {
    /**
     * 
     * @type {EddsaEd25519PublicKey}
     * @memberof EddsaEd25519SignatureWithPublicKeyAllOf
     */
    public_key: EddsaEd25519PublicKey;
    /**
     * 
     * @type {EddsaEd25519Signature}
     * @memberof EddsaEd25519SignatureWithPublicKeyAllOf
     */
    signature: EddsaEd25519Signature;
    /**
     * 
     * @type {string}
     * @memberof EddsaEd25519SignatureWithPublicKeyAllOf
     */
    key_type?: EddsaEd25519SignatureWithPublicKeyAllOfKeyTypeEnum;
}


/**
 * @export
 */
export const EddsaEd25519SignatureWithPublicKeyAllOfKeyTypeEnum = {
    EddsaEd25519: 'EddsaEd25519'
} as const;
export type EddsaEd25519SignatureWithPublicKeyAllOfKeyTypeEnum = typeof EddsaEd25519SignatureWithPublicKeyAllOfKeyTypeEnum[keyof typeof EddsaEd25519SignatureWithPublicKeyAllOfKeyTypeEnum];


/**
 * Check if a given object implements the EddsaEd25519SignatureWithPublicKeyAllOf interface.
 */
export function instanceOfEddsaEd25519SignatureWithPublicKeyAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "public_key" in value;
    isInstance = isInstance && "signature" in value;

    return isInstance;
}

export function EddsaEd25519SignatureWithPublicKeyAllOfFromJSON(json: any): EddsaEd25519SignatureWithPublicKeyAllOf {
    return EddsaEd25519SignatureWithPublicKeyAllOfFromJSONTyped(json, false);
}

export function EddsaEd25519SignatureWithPublicKeyAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): EddsaEd25519SignatureWithPublicKeyAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'public_key': EddsaEd25519PublicKeyFromJSON(json['public_key']),
        'signature': EddsaEd25519SignatureFromJSON(json['signature']),
        'key_type': !exists(json, 'key_type') ? undefined : json['key_type'],
    };
}

export function EddsaEd25519SignatureWithPublicKeyAllOfToJSON(value?: EddsaEd25519SignatureWithPublicKeyAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'public_key': EddsaEd25519PublicKeyToJSON(value.public_key),
        'signature': EddsaEd25519SignatureToJSON(value.signature),
        'key_type': value.key_type,
    };
}

