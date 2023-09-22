/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (v1.0.0)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { ParsedSignedTransactionIntentIdentifiers } from './ParsedSignedTransactionIntentIdentifiers';
import {
    ParsedSignedTransactionIntentIdentifiersFromJSON,
    ParsedSignedTransactionIntentIdentifiersFromJSONTyped,
    ParsedSignedTransactionIntentIdentifiersToJSON,
} from './ParsedSignedTransactionIntentIdentifiers';
import type { SignedTransactionIntent } from './SignedTransactionIntent';
import {
    SignedTransactionIntentFromJSON,
    SignedTransactionIntentFromJSONTyped,
    SignedTransactionIntentToJSON,
} from './SignedTransactionIntent';

/**
 * 
 * @export
 * @interface ParsedSignedTransactionIntentAllOf
 */
export interface ParsedSignedTransactionIntentAllOf {
    /**
     * 
     * @type {SignedTransactionIntent}
     * @memberof ParsedSignedTransactionIntentAllOf
     */
    signed_intent?: SignedTransactionIntent;
    /**
     * 
     * @type {ParsedSignedTransactionIntentIdentifiers}
     * @memberof ParsedSignedTransactionIntentAllOf
     */
    identifiers: ParsedSignedTransactionIntentIdentifiers;
    /**
     * 
     * @type {string}
     * @memberof ParsedSignedTransactionIntentAllOf
     */
    type?: ParsedSignedTransactionIntentAllOfTypeEnum;
}


/**
 * @export
 */
export const ParsedSignedTransactionIntentAllOfTypeEnum = {
    SignedTransactionIntent: 'SignedTransactionIntent'
} as const;
export type ParsedSignedTransactionIntentAllOfTypeEnum = typeof ParsedSignedTransactionIntentAllOfTypeEnum[keyof typeof ParsedSignedTransactionIntentAllOfTypeEnum];


/**
 * Check if a given object implements the ParsedSignedTransactionIntentAllOf interface.
 */
export function instanceOfParsedSignedTransactionIntentAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "identifiers" in value;

    return isInstance;
}

export function ParsedSignedTransactionIntentAllOfFromJSON(json: any): ParsedSignedTransactionIntentAllOf {
    return ParsedSignedTransactionIntentAllOfFromJSONTyped(json, false);
}

export function ParsedSignedTransactionIntentAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): ParsedSignedTransactionIntentAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'signed_intent': !exists(json, 'signed_intent') ? undefined : SignedTransactionIntentFromJSON(json['signed_intent']),
        'identifiers': ParsedSignedTransactionIntentIdentifiersFromJSON(json['identifiers']),
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function ParsedSignedTransactionIntentAllOfToJSON(value?: ParsedSignedTransactionIntentAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'signed_intent': SignedTransactionIntentToJSON(value.signed_intent),
        'identifiers': ParsedSignedTransactionIntentIdentifiersToJSON(value.identifiers),
        'type': value.type,
    };
}

