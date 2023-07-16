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
 * Requested substate formats to include in the response
 * @export
 * @interface SubstateFormatOptions
 */
export interface SubstateFormatOptions {
    /**
     * Whether to return the raw substate value bytes (default false)
     * @type {boolean}
     * @memberof SubstateFormatOptions
     */
    raw?: boolean;
    /**
     * Whether to return the raw substate value bytes hash (default false)
     * @type {boolean}
     * @memberof SubstateFormatOptions
     */
    hash?: boolean;
    /**
     * Whether to return the typed substate information (default true)
     * @type {boolean}
     * @memberof SubstateFormatOptions
     */
    typed?: boolean;
    /**
     * Whether to return the previous substate value for updates (default false)
     * @type {boolean}
     * @memberof SubstateFormatOptions
     */
    previous?: boolean;
}

/**
 * Check if a given object implements the SubstateFormatOptions interface.
 */
export function instanceOfSubstateFormatOptions(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function SubstateFormatOptionsFromJSON(json: any): SubstateFormatOptions {
    return SubstateFormatOptionsFromJSONTyped(json, false);
}

export function SubstateFormatOptionsFromJSONTyped(json: any, ignoreDiscriminator: boolean): SubstateFormatOptions {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'raw': !exists(json, 'raw') ? undefined : json['raw'],
        'hash': !exists(json, 'hash') ? undefined : json['hash'],
        'typed': !exists(json, 'typed') ? undefined : json['typed'],
        'previous': !exists(json, 'previous') ? undefined : json['previous'],
    };
}

export function SubstateFormatOptionsToJSON(value?: SubstateFormatOptions | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'raw': value.raw,
        'hash': value.hash,
        'typed': value.typed,
        'previous': value.previous,
    };
}
