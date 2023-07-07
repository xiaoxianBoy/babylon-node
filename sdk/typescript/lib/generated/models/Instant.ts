/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
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
 * @interface Instant
 */
export interface Instant {
    /**
     * An integer between `0` and `10^14`, marking the unix timestamp in ms.
     * @type {number}
     * @memberof Instant
     */
    unix_timestamp_ms: number;
    /**
     * The RFC 3339 / ISO 8601 string representation of the timestamp. Will always use "Z" denoting UTC and include milliseconds.
     * EG: `2023-01-26T18:30:09.453Z`.
     * @type {string}
     * @memberof Instant
     */
    date_time: string;
}

/**
 * Check if a given object implements the Instant interface.
 */
export function instanceOfInstant(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "unix_timestamp_ms" in value;
    isInstance = isInstance && "date_time" in value;

    return isInstance;
}

export function InstantFromJSON(json: any): Instant {
    return InstantFromJSONTyped(json, false);
}

export function InstantFromJSONTyped(json: any, ignoreDiscriminator: boolean): Instant {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'unix_timestamp_ms': json['unix_timestamp_ms'],
        'date_time': json['date_time'],
    };
}

export function InstantToJSON(value?: Instant | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'unix_timestamp_ms': value.unix_timestamp_ms,
        'date_time': value.date_time,
    };
}

