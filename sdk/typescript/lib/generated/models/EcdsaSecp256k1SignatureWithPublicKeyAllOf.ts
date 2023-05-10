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
import type { EcdsaSecp256k1Signature } from './EcdsaSecp256k1Signature';
import {
    EcdsaSecp256k1SignatureFromJSON,
    EcdsaSecp256k1SignatureFromJSONTyped,
    EcdsaSecp256k1SignatureToJSON,
} from './EcdsaSecp256k1Signature';

/**
 * Because ECDSA has recoverable signatures, this only includes a signature
 * @export
 * @interface EcdsaSecp256k1SignatureWithPublicKeyAllOf
 */
export interface EcdsaSecp256k1SignatureWithPublicKeyAllOf {
    /**
     * 
     * @type {EcdsaSecp256k1Signature}
     * @memberof EcdsaSecp256k1SignatureWithPublicKeyAllOf
     */
    recoverable_signature: EcdsaSecp256k1Signature;
    /**
     * 
     * @type {string}
     * @memberof EcdsaSecp256k1SignatureWithPublicKeyAllOf
     */
    key_type?: EcdsaSecp256k1SignatureWithPublicKeyAllOfKeyTypeEnum;
}


/**
 * @export
 */
export const EcdsaSecp256k1SignatureWithPublicKeyAllOfKeyTypeEnum = {
    EcdsaSecp256k1: 'EcdsaSecp256k1'
} as const;
export type EcdsaSecp256k1SignatureWithPublicKeyAllOfKeyTypeEnum = typeof EcdsaSecp256k1SignatureWithPublicKeyAllOfKeyTypeEnum[keyof typeof EcdsaSecp256k1SignatureWithPublicKeyAllOfKeyTypeEnum];


/**
 * Check if a given object implements the EcdsaSecp256k1SignatureWithPublicKeyAllOf interface.
 */
export function instanceOfEcdsaSecp256k1SignatureWithPublicKeyAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "recoverable_signature" in value;

    return isInstance;
}

export function EcdsaSecp256k1SignatureWithPublicKeyAllOfFromJSON(json: any): EcdsaSecp256k1SignatureWithPublicKeyAllOf {
    return EcdsaSecp256k1SignatureWithPublicKeyAllOfFromJSONTyped(json, false);
}

export function EcdsaSecp256k1SignatureWithPublicKeyAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): EcdsaSecp256k1SignatureWithPublicKeyAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'recoverable_signature': EcdsaSecp256k1SignatureFromJSON(json['recoverable_signature']),
        'key_type': !exists(json, 'key_type') ? undefined : json['key_type'],
    };
}

export function EcdsaSecp256k1SignatureWithPublicKeyAllOfToJSON(value?: EcdsaSecp256k1SignatureWithPublicKeyAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'recoverable_signature': EcdsaSecp256k1SignatureToJSON(value.recoverable_signature),
        'key_type': value.key_type,
    };
}
