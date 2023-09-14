/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet v3.1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { FungibleResourceManagerFieldDivisibilityValue } from './FungibleResourceManagerFieldDivisibilityValue';
import {
    FungibleResourceManagerFieldDivisibilityValueFromJSON,
    FungibleResourceManagerFieldDivisibilityValueFromJSONTyped,
    FungibleResourceManagerFieldDivisibilityValueToJSON,
} from './FungibleResourceManagerFieldDivisibilityValue';

/**
 * 
 * @export
 * @interface FungibleResourceManagerFieldDivisibilitySubstateAllOf
 */
export interface FungibleResourceManagerFieldDivisibilitySubstateAllOf {
    /**
     * 
     * @type {FungibleResourceManagerFieldDivisibilityValue}
     * @memberof FungibleResourceManagerFieldDivisibilitySubstateAllOf
     */
    value: FungibleResourceManagerFieldDivisibilityValue;
    /**
     * 
     * @type {string}
     * @memberof FungibleResourceManagerFieldDivisibilitySubstateAllOf
     */
    substate_type?: FungibleResourceManagerFieldDivisibilitySubstateAllOfSubstateTypeEnum;
}


/**
 * @export
 */
export const FungibleResourceManagerFieldDivisibilitySubstateAllOfSubstateTypeEnum = {
    FungibleResourceManagerFieldDivisibility: 'FungibleResourceManagerFieldDivisibility'
} as const;
export type FungibleResourceManagerFieldDivisibilitySubstateAllOfSubstateTypeEnum = typeof FungibleResourceManagerFieldDivisibilitySubstateAllOfSubstateTypeEnum[keyof typeof FungibleResourceManagerFieldDivisibilitySubstateAllOfSubstateTypeEnum];


/**
 * Check if a given object implements the FungibleResourceManagerFieldDivisibilitySubstateAllOf interface.
 */
export function instanceOfFungibleResourceManagerFieldDivisibilitySubstateAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "value" in value;

    return isInstance;
}

export function FungibleResourceManagerFieldDivisibilitySubstateAllOfFromJSON(json: any): FungibleResourceManagerFieldDivisibilitySubstateAllOf {
    return FungibleResourceManagerFieldDivisibilitySubstateAllOfFromJSONTyped(json, false);
}

export function FungibleResourceManagerFieldDivisibilitySubstateAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): FungibleResourceManagerFieldDivisibilitySubstateAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'value': FungibleResourceManagerFieldDivisibilityValueFromJSON(json['value']),
        'substate_type': !exists(json, 'substate_type') ? undefined : json['substate_type'],
    };
}

export function FungibleResourceManagerFieldDivisibilitySubstateAllOfToJSON(value?: FungibleResourceManagerFieldDivisibilitySubstateAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'value': FungibleResourceManagerFieldDivisibilityValueToJSON(value.value),
        'substate_type': value.substate_type,
    };
}

