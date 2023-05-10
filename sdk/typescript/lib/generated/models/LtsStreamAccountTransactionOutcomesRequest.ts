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
/**
 * A request to retrieve a sublist of committed transactions from the ledger.
 * @export
 * @interface LtsStreamAccountTransactionOutcomesRequest
 */
export interface LtsStreamAccountTransactionOutcomesRequest {
    /**
     * The logical name of the network
     * @type {string}
     * @memberof LtsStreamAccountTransactionOutcomesRequest
     */
    network: string;
    /**
     * The Bech32m-encoded human readable version of the account's address
     * @type {string}
     * @memberof LtsStreamAccountTransactionOutcomesRequest
     */
    account_address: string;
    /**
     * An integer between `1` and `10^13`, giving the first (resultant) state version to be returned
     * @type {number}
     * @memberof LtsStreamAccountTransactionOutcomesRequest
     */
    from_state_version: number;
    /**
     * The maximum number of transactions that will be returned.
     * @type {number}
     * @memberof LtsStreamAccountTransactionOutcomesRequest
     */
    limit: number;
}

/**
 * Check if a given object implements the LtsStreamAccountTransactionOutcomesRequest interface.
 */
export function instanceOfLtsStreamAccountTransactionOutcomesRequest(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "network" in value;
    isInstance = isInstance && "account_address" in value;
    isInstance = isInstance && "from_state_version" in value;
    isInstance = isInstance && "limit" in value;

    return isInstance;
}

export function LtsStreamAccountTransactionOutcomesRequestFromJSON(json: any): LtsStreamAccountTransactionOutcomesRequest {
    return LtsStreamAccountTransactionOutcomesRequestFromJSONTyped(json, false);
}

export function LtsStreamAccountTransactionOutcomesRequestFromJSONTyped(json: any, ignoreDiscriminator: boolean): LtsStreamAccountTransactionOutcomesRequest {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'network': json['network'],
        'account_address': json['account_address'],
        'from_state_version': json['from_state_version'],
        'limit': json['limit'],
    };
}

export function LtsStreamAccountTransactionOutcomesRequestToJSON(value?: LtsStreamAccountTransactionOutcomesRequest | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'network': value.network,
        'account_address': value.account_address,
        'from_state_version': value.from_state_version,
        'limit': value.limit,
    };
}
