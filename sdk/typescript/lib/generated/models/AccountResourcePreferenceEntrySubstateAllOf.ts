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
import type { AccountResourcePreferenceEntryValue } from './AccountResourcePreferenceEntryValue';
import {
    AccountResourcePreferenceEntryValueFromJSON,
    AccountResourcePreferenceEntryValueFromJSONTyped,
    AccountResourcePreferenceEntryValueToJSON,
} from './AccountResourcePreferenceEntryValue';
import type { ResourceKey } from './ResourceKey';
import {
    ResourceKeyFromJSON,
    ResourceKeyFromJSONTyped,
    ResourceKeyToJSON,
} from './ResourceKey';

/**
 * 
 * @export
 * @interface AccountResourcePreferenceEntrySubstateAllOf
 */
export interface AccountResourcePreferenceEntrySubstateAllOf {
    /**
     * 
     * @type {ResourceKey}
     * @memberof AccountResourcePreferenceEntrySubstateAllOf
     */
    key: ResourceKey;
    /**
     * 
     * @type {AccountResourcePreferenceEntryValue}
     * @memberof AccountResourcePreferenceEntrySubstateAllOf
     */
    value?: AccountResourcePreferenceEntryValue;
    /**
     * 
     * @type {string}
     * @memberof AccountResourcePreferenceEntrySubstateAllOf
     */
    substate_type?: AccountResourcePreferenceEntrySubstateAllOfSubstateTypeEnum;
}


/**
 * @export
 */
export const AccountResourcePreferenceEntrySubstateAllOfSubstateTypeEnum = {
    AccountResourcePreferenceEntry: 'AccountResourcePreferenceEntry'
} as const;
export type AccountResourcePreferenceEntrySubstateAllOfSubstateTypeEnum = typeof AccountResourcePreferenceEntrySubstateAllOfSubstateTypeEnum[keyof typeof AccountResourcePreferenceEntrySubstateAllOfSubstateTypeEnum];


/**
 * Check if a given object implements the AccountResourcePreferenceEntrySubstateAllOf interface.
 */
export function instanceOfAccountResourcePreferenceEntrySubstateAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "key" in value;

    return isInstance;
}

export function AccountResourcePreferenceEntrySubstateAllOfFromJSON(json: any): AccountResourcePreferenceEntrySubstateAllOf {
    return AccountResourcePreferenceEntrySubstateAllOfFromJSONTyped(json, false);
}

export function AccountResourcePreferenceEntrySubstateAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): AccountResourcePreferenceEntrySubstateAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'key': ResourceKeyFromJSON(json['key']),
        'value': !exists(json, 'value') ? undefined : AccountResourcePreferenceEntryValueFromJSON(json['value']),
        'substate_type': !exists(json, 'substate_type') ? undefined : json['substate_type'],
    };
}

export function AccountResourcePreferenceEntrySubstateAllOfToJSON(value?: AccountResourcePreferenceEntrySubstateAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'key': ResourceKeyToJSON(value.key),
        'value': AccountResourcePreferenceEntryValueToJSON(value.value),
        'substate_type': value.substate_type,
    };
}

