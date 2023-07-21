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
import type { PublicKey } from './PublicKey';
import {
    PublicKeyFromJSON,
    PublicKeyFromJSONTyped,
    PublicKeyToJSON,
} from './PublicKey';
import type { TransactionMessage } from './TransactionMessage';
import {
    TransactionMessageFromJSON,
    TransactionMessageFromJSONTyped,
    TransactionMessageToJSON,
} from './TransactionMessage';
import type { TransactionPreviewRequestFlags } from './TransactionPreviewRequestFlags';
import {
    TransactionPreviewRequestFlagsFromJSON,
    TransactionPreviewRequestFlagsFromJSONTyped,
    TransactionPreviewRequestFlagsToJSON,
} from './TransactionPreviewRequestFlags';

/**
 * 
 * @export
 * @interface TransactionPreviewRequest
 */
export interface TransactionPreviewRequest {
    /**
     * The logical name of the network
     * @type {string}
     * @memberof TransactionPreviewRequest
     */
    network: string;
    /**
     * A text-representation of a transaction manifest
     * @type {string}
     * @memberof TransactionPreviewRequest
     */
    manifest: string;
    /**
     * An array of hex-encoded blob data (optional)
     * @type {Array<string>}
     * @memberof TransactionPreviewRequest
     */
    blobs_hex?: Array<string>;
    /**
     * An integer between `0` and `10^10`, marking the epoch at which the transaction starts being valid
     * @type {number}
     * @memberof TransactionPreviewRequest
     */
    start_epoch_inclusive: number;
    /**
     * An integer between `0` and `10^10`, marking the epoch at which the transaction is no longer valid
     * @type {number}
     * @memberof TransactionPreviewRequest
     */
    end_epoch_exclusive: number;
    /**
     * 
     * @type {PublicKey}
     * @memberof TransactionPreviewRequest
     */
    notary_public_key?: PublicKey;
    /**
     * Whether the notary should count as a signatory (optional, default false)
     * @type {boolean}
     * @memberof TransactionPreviewRequest
     */
    notary_is_signatory?: boolean;
    /**
     * An integer between `0` and `255`, giving the validator tip as a percentage amount. A value of `1` corresponds to 1% of the fee.
     * @type {number}
     * @memberof TransactionPreviewRequest
     */
    tip_percentage: number;
    /**
     * An integer between `0` and `2^32 - 1`, chosen to allow a unique intent to be created (to enable submitting an otherwise identical/duplicate intent).
     * @type {number}
     * @memberof TransactionPreviewRequest
     */
    nonce: number;
    /**
     * A list of public keys to be used as transaction signers
     * @type {Array<PublicKey>}
     * @memberof TransactionPreviewRequest
     */
    signer_public_keys: Array<PublicKey>;
    /**
     * 
     * @type {TransactionMessage}
     * @memberof TransactionPreviewRequest
     */
    message?: TransactionMessage;
    /**
     * 
     * @type {TransactionPreviewRequestFlags}
     * @memberof TransactionPreviewRequest
     */
    flags: TransactionPreviewRequestFlags;
}

/**
 * Check if a given object implements the TransactionPreviewRequest interface.
 */
export function instanceOfTransactionPreviewRequest(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "network" in value;
    isInstance = isInstance && "manifest" in value;
    isInstance = isInstance && "start_epoch_inclusive" in value;
    isInstance = isInstance && "end_epoch_exclusive" in value;
    isInstance = isInstance && "tip_percentage" in value;
    isInstance = isInstance && "nonce" in value;
    isInstance = isInstance && "signer_public_keys" in value;
    isInstance = isInstance && "flags" in value;

    return isInstance;
}

export function TransactionPreviewRequestFromJSON(json: any): TransactionPreviewRequest {
    return TransactionPreviewRequestFromJSONTyped(json, false);
}

export function TransactionPreviewRequestFromJSONTyped(json: any, ignoreDiscriminator: boolean): TransactionPreviewRequest {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'network': json['network'],
        'manifest': json['manifest'],
        'blobs_hex': !exists(json, 'blobs_hex') ? undefined : json['blobs_hex'],
        'start_epoch_inclusive': json['start_epoch_inclusive'],
        'end_epoch_exclusive': json['end_epoch_exclusive'],
        'notary_public_key': !exists(json, 'notary_public_key') ? undefined : PublicKeyFromJSON(json['notary_public_key']),
        'notary_is_signatory': !exists(json, 'notary_is_signatory') ? undefined : json['notary_is_signatory'],
        'tip_percentage': json['tip_percentage'],
        'nonce': json['nonce'],
        'signer_public_keys': ((json['signer_public_keys'] as Array<any>).map(PublicKeyFromJSON)),
        'message': !exists(json, 'message') ? undefined : TransactionMessageFromJSON(json['message']),
        'flags': TransactionPreviewRequestFlagsFromJSON(json['flags']),
    };
}

export function TransactionPreviewRequestToJSON(value?: TransactionPreviewRequest | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'network': value.network,
        'manifest': value.manifest,
        'blobs_hex': value.blobs_hex,
        'start_epoch_inclusive': value.start_epoch_inclusive,
        'end_epoch_exclusive': value.end_epoch_exclusive,
        'notary_public_key': PublicKeyToJSON(value.notary_public_key),
        'notary_is_signatory': value.notary_is_signatory,
        'tip_percentage': value.tip_percentage,
        'nonce': value.nonce,
        'signer_public_keys': ((value.signer_public_keys as Array<any>).map(PublicKeyToJSON)),
        'message': TransactionMessageToJSON(value.message),
        'flags': TransactionPreviewRequestFlagsToJSON(value.flags),
    };
}

