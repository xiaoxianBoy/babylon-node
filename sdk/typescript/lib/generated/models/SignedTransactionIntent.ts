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
import type { SignatureWithPublicKey } from './SignatureWithPublicKey';
import {
    SignatureWithPublicKeyFromJSON,
    SignatureWithPublicKeyFromJSONTyped,
    SignatureWithPublicKeyToJSON,
} from './SignatureWithPublicKey';
import type { TransactionIntent } from './TransactionIntent';
import {
    TransactionIntentFromJSON,
    TransactionIntentFromJSONTyped,
    TransactionIntentToJSON,
} from './TransactionIntent';

/**
 * 
 * @export
 * @interface SignedTransactionIntent
 */
export interface SignedTransactionIntent {
    /**
     * The hex-encoded signed intent hash for a user transaction.
     * This hash identifies the transaction intent, plus additional signatures.
     * This hash is signed by the notary, to create the submittable NotarizedTransaction.
     * @type {string}
     * @memberof SignedTransactionIntent
     */
    hash: string;
    /**
     * The Bech32m-encoded human readable `SignedIntentHash`.
     * @type {string}
     * @memberof SignedTransactionIntent
     */
    hash_bech32m: string;
    /**
     * 
     * @type {TransactionIntent}
     * @memberof SignedTransactionIntent
     */
    intent: TransactionIntent;
    /**
     * 
     * @type {Array<SignatureWithPublicKey>}
     * @memberof SignedTransactionIntent
     */
    intent_signatures: Array<SignatureWithPublicKey>;
}

/**
 * Check if a given object implements the SignedTransactionIntent interface.
 */
export function instanceOfSignedTransactionIntent(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "hash" in value;
    isInstance = isInstance && "hash_bech32m" in value;
    isInstance = isInstance && "intent" in value;
    isInstance = isInstance && "intent_signatures" in value;

    return isInstance;
}

export function SignedTransactionIntentFromJSON(json: any): SignedTransactionIntent {
    return SignedTransactionIntentFromJSONTyped(json, false);
}

export function SignedTransactionIntentFromJSONTyped(json: any, ignoreDiscriminator: boolean): SignedTransactionIntent {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'hash': json['hash'],
        'hash_bech32m': json['hash_bech32m'],
        'intent': TransactionIntentFromJSON(json['intent']),
        'intent_signatures': ((json['intent_signatures'] as Array<any>).map(SignatureWithPublicKeyFromJSON)),
    };
}

export function SignedTransactionIntentToJSON(value?: SignedTransactionIntent | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'hash': value.hash,
        'hash_bech32m': value.hash_bech32m,
        'intent': TransactionIntentToJSON(value.intent),
        'intent_signatures': ((value.intent_signatures as Array<any>).map(SignatureWithPublicKeyToJSON)),
    };
}

