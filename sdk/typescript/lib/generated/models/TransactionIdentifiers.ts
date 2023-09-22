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
/**
 * 
 * @export
 * @interface TransactionIdentifiers
 */
export interface TransactionIdentifiers {
    /**
     * The hex-encoded intent hash for a user transaction, also known as the transaction id.
     * This hash identifies the core content "intent" of the transaction. Each intent can only be committed once.
     * This hash gets signed by any signatories on the transaction, to create the signed intent.
     * @type {string}
     * @memberof TransactionIdentifiers
     */
    intent_hash: string;
    /**
     * The Bech32m-encoded human readable `IntentHash`.
     * @type {string}
     * @memberof TransactionIdentifiers
     */
    intent_hash_bech32m: string;
    /**
     * The hex-encoded signed intent hash for a user transaction.
     * This hash identifies the transaction intent, plus additional signatures.
     * This hash is signed by the notary, to create the submittable NotarizedTransaction.
     * @type {string}
     * @memberof TransactionIdentifiers
     */
    signed_intent_hash: string;
    /**
     * The Bech32m-encoded human readable `SignedIntentHash`.
     * @type {string}
     * @memberof TransactionIdentifiers
     */
    signed_intent_hash_bech32m: string;
    /**
     * The hex-encoded notarized transaction hash for a user transaction.
     * This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature.
     * @type {string}
     * @memberof TransactionIdentifiers
     */
    payload_hash: string;
    /**
     * The Bech32m-encoded human readable `NotarizedTransactionHash`.
     * @type {string}
     * @memberof TransactionIdentifiers
     */
    payload_hash_bech32m: string;
}

/**
 * Check if a given object implements the TransactionIdentifiers interface.
 */
export function instanceOfTransactionIdentifiers(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "intent_hash" in value;
    isInstance = isInstance && "intent_hash_bech32m" in value;
    isInstance = isInstance && "signed_intent_hash" in value;
    isInstance = isInstance && "signed_intent_hash_bech32m" in value;
    isInstance = isInstance && "payload_hash" in value;
    isInstance = isInstance && "payload_hash_bech32m" in value;

    return isInstance;
}

export function TransactionIdentifiersFromJSON(json: any): TransactionIdentifiers {
    return TransactionIdentifiersFromJSONTyped(json, false);
}

export function TransactionIdentifiersFromJSONTyped(json: any, ignoreDiscriminator: boolean): TransactionIdentifiers {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'intent_hash': json['intent_hash'],
        'intent_hash_bech32m': json['intent_hash_bech32m'],
        'signed_intent_hash': json['signed_intent_hash'],
        'signed_intent_hash_bech32m': json['signed_intent_hash_bech32m'],
        'payload_hash': json['payload_hash'],
        'payload_hash_bech32m': json['payload_hash_bech32m'],
    };
}

export function TransactionIdentifiersToJSON(value?: TransactionIdentifiers | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'intent_hash': value.intent_hash,
        'intent_hash_bech32m': value.intent_hash_bech32m,
        'signed_intent_hash': value.signed_intent_hash,
        'signed_intent_hash_bech32m': value.signed_intent_hash_bech32m,
        'payload_hash': value.payload_hash,
        'payload_hash_bech32m': value.payload_hash_bech32m,
    };
}

