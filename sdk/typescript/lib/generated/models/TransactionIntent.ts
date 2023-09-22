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
import type { TransactionHeader } from './TransactionHeader';
import {
    TransactionHeaderFromJSON,
    TransactionHeaderFromJSONTyped,
    TransactionHeaderToJSON,
} from './TransactionHeader';
import type { TransactionMessage } from './TransactionMessage';
import {
    TransactionMessageFromJSON,
    TransactionMessageFromJSONTyped,
    TransactionMessageToJSON,
} from './TransactionMessage';

/**
 * 
 * @export
 * @interface TransactionIntent
 */
export interface TransactionIntent {
    /**
     * The hex-encoded intent hash for a user transaction, also known as the transaction id.
     * This hash identifies the core content "intent" of the transaction. Each intent can only be committed once.
     * This hash gets signed by any signatories on the transaction, to create the signed intent.
     * @type {string}
     * @memberof TransactionIntent
     */
    hash: string;
    /**
     * The Bech32m-encoded human readable `IntentHash`.
     * @type {string}
     * @memberof TransactionIntent
     */
    hash_bech32m: string;
    /**
     * 
     * @type {TransactionHeader}
     * @memberof TransactionIntent
     */
    header: TransactionHeader;
    /**
     * The decompiled transaction manifest instructions. Only returned if enabled in `TransactionFormatOptions` on your request.
     * @type {string}
     * @memberof TransactionIntent
     */
    instructions?: string;
    /**
     * A map of the hex-encoded blob hash, to hex-encoded blob content. Only returned if enabled in `TransactionFormatOptions` on your request.
     * @type {{ [key: string]: string; }}
     * @memberof TransactionIntent
     */
    blobs_hex?: { [key: string]: string; };
    /**
     * 
     * @type {TransactionMessage}
     * @memberof TransactionIntent
     */
    message?: TransactionMessage;
}

/**
 * Check if a given object implements the TransactionIntent interface.
 */
export function instanceOfTransactionIntent(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "hash" in value;
    isInstance = isInstance && "hash_bech32m" in value;
    isInstance = isInstance && "header" in value;

    return isInstance;
}

export function TransactionIntentFromJSON(json: any): TransactionIntent {
    return TransactionIntentFromJSONTyped(json, false);
}

export function TransactionIntentFromJSONTyped(json: any, ignoreDiscriminator: boolean): TransactionIntent {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'hash': json['hash'],
        'hash_bech32m': json['hash_bech32m'],
        'header': TransactionHeaderFromJSON(json['header']),
        'instructions': !exists(json, 'instructions') ? undefined : json['instructions'],
        'blobs_hex': !exists(json, 'blobs_hex') ? undefined : json['blobs_hex'],
        'message': !exists(json, 'message') ? undefined : TransactionMessageFromJSON(json['message']),
    };
}

export function TransactionIntentToJSON(value?: TransactionIntent | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'hash': value.hash,
        'hash_bech32m': value.hash_bech32m,
        'header': TransactionHeaderToJSON(value.header),
        'instructions': value.instructions,
        'blobs_hex': value.blobs_hex,
        'message': TransactionMessageToJSON(value.message),
    };
}

