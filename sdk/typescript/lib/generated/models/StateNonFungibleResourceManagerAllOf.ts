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
import type { Substate } from './Substate';
import {
    SubstateFromJSON,
    SubstateFromJSONTyped,
    SubstateToJSON,
} from './Substate';

/**
 * 
 * @export
 * @interface StateNonFungibleResourceManagerAllOf
 */
export interface StateNonFungibleResourceManagerAllOf {
    /**
     * 
     * @type {Substate}
     * @memberof StateNonFungibleResourceManagerAllOf
     */
    id_type: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateNonFungibleResourceManagerAllOf
     */
    total_supply?: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateNonFungibleResourceManagerAllOf
     */
    mutable_fields: Substate;
    /**
     * 
     * @type {string}
     * @memberof StateNonFungibleResourceManagerAllOf
     */
    resource_type?: StateNonFungibleResourceManagerAllOfResourceTypeEnum;
}


/**
 * @export
 */
export const StateNonFungibleResourceManagerAllOfResourceTypeEnum = {
    NonFungible: 'NonFungible'
} as const;
export type StateNonFungibleResourceManagerAllOfResourceTypeEnum = typeof StateNonFungibleResourceManagerAllOfResourceTypeEnum[keyof typeof StateNonFungibleResourceManagerAllOfResourceTypeEnum];


/**
 * Check if a given object implements the StateNonFungibleResourceManagerAllOf interface.
 */
export function instanceOfStateNonFungibleResourceManagerAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "id_type" in value;
    isInstance = isInstance && "mutable_fields" in value;

    return isInstance;
}

export function StateNonFungibleResourceManagerAllOfFromJSON(json: any): StateNonFungibleResourceManagerAllOf {
    return StateNonFungibleResourceManagerAllOfFromJSONTyped(json, false);
}

export function StateNonFungibleResourceManagerAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): StateNonFungibleResourceManagerAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id_type': SubstateFromJSON(json['id_type']),
        'total_supply': !exists(json, 'total_supply') ? undefined : SubstateFromJSON(json['total_supply']),
        'mutable_fields': SubstateFromJSON(json['mutable_fields']),
        'resource_type': !exists(json, 'resource_type') ? undefined : json['resource_type'],
    };
}

export function StateNonFungibleResourceManagerAllOfToJSON(value?: StateNonFungibleResourceManagerAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'id_type': SubstateToJSON(value.id_type),
        'total_supply': SubstateToJSON(value.total_supply),
        'mutable_fields': SubstateToJSON(value.mutable_fields),
        'resource_type': value.resource_type,
    };
}

