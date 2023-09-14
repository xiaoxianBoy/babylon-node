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
import type { AccessControllerFieldStateValue } from './AccessControllerFieldStateValue';
import {
    AccessControllerFieldStateValueFromJSON,
    AccessControllerFieldStateValueFromJSONTyped,
    AccessControllerFieldStateValueToJSON,
} from './AccessControllerFieldStateValue';

/**
 * 
 * @export
 * @interface AccessControllerFieldStateSubstate
 */
export interface AccessControllerFieldStateSubstate {
    /**
     * 
     * @type {string}
     * @memberof AccessControllerFieldStateSubstate
     */
    substate_type: AccessControllerFieldStateSubstateSubstateTypeEnum;
    /**
     * 
     * @type {boolean}
     * @memberof AccessControllerFieldStateSubstate
     */
    is_locked: boolean;
    /**
     * 
     * @type {AccessControllerFieldStateValue}
     * @memberof AccessControllerFieldStateSubstate
     */
    value: AccessControllerFieldStateValue;
}


/**
 * @export
 */
export const AccessControllerFieldStateSubstateSubstateTypeEnum = {
    AccessControllerFieldState: 'AccessControllerFieldState'
} as const;
export type AccessControllerFieldStateSubstateSubstateTypeEnum = typeof AccessControllerFieldStateSubstateSubstateTypeEnum[keyof typeof AccessControllerFieldStateSubstateSubstateTypeEnum];


/**
 * Check if a given object implements the AccessControllerFieldStateSubstate interface.
 */
export function instanceOfAccessControllerFieldStateSubstate(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "substate_type" in value;
    isInstance = isInstance && "is_locked" in value;
    isInstance = isInstance && "value" in value;

    return isInstance;
}

export function AccessControllerFieldStateSubstateFromJSON(json: any): AccessControllerFieldStateSubstate {
    return AccessControllerFieldStateSubstateFromJSONTyped(json, false);
}

export function AccessControllerFieldStateSubstateFromJSONTyped(json: any, ignoreDiscriminator: boolean): AccessControllerFieldStateSubstate {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'substate_type': json['substate_type'],
        'is_locked': json['is_locked'],
        'value': AccessControllerFieldStateValueFromJSON(json['value']),
    };
}

export function AccessControllerFieldStateSubstateToJSON(value?: AccessControllerFieldStateSubstate | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'substate_type': value.substate_type,
        'is_locked': value.is_locked,
        'value': AccessControllerFieldStateValueToJSON(value.value),
    };
}

