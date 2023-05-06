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
import type { ActiveValidator } from './ActiveValidator';
import {
    ActiveValidatorFromJSON,
    ActiveValidatorFromJSONTyped,
    ActiveValidatorToJSON,
} from './ActiveValidator';

/**
 * 
 * @export
 * @interface ValidatorSetSubstate
 */
export interface ValidatorSetSubstate {
    /**
     * 
     * @type {string}
     * @memberof ValidatorSetSubstate
     */
    substate_type: ValidatorSetSubstateSubstateTypeEnum;
    /**
     * 
     * @type {Array<ActiveValidator>}
     * @memberof ValidatorSetSubstate
     */
    validator_set: Array<ActiveValidator>;
    /**
     * An integer between `0` and `10^10`, marking the epoch the validator set is a part of
     * @type {number}
     * @memberof ValidatorSetSubstate
     */
    epoch: number;
}


/**
 * @export
 */
export const ValidatorSetSubstateSubstateTypeEnum = {
    ValidatorSet: 'ValidatorSet'
} as const;
export type ValidatorSetSubstateSubstateTypeEnum = typeof ValidatorSetSubstateSubstateTypeEnum[keyof typeof ValidatorSetSubstateSubstateTypeEnum];


/**
 * Check if a given object implements the ValidatorSetSubstate interface.
 */
export function instanceOfValidatorSetSubstate(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "substate_type" in value;
    isInstance = isInstance && "validator_set" in value;
    isInstance = isInstance && "epoch" in value;

    return isInstance;
}

export function ValidatorSetSubstateFromJSON(json: any): ValidatorSetSubstate {
    return ValidatorSetSubstateFromJSONTyped(json, false);
}

export function ValidatorSetSubstateFromJSONTyped(json: any, ignoreDiscriminator: boolean): ValidatorSetSubstate {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'substate_type': json['substate_type'],
        'validator_set': ((json['validator_set'] as Array<any>).map(ActiveValidatorFromJSON)),
        'epoch': json['epoch'],
    };
}

export function ValidatorSetSubstateToJSON(value?: ValidatorSetSubstate | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'substate_type': value.substate_type,
        'validator_set': ((value.validator_set as Array<any>).map(ActiveValidatorToJSON)),
        'epoch': value.epoch,
    };
}

