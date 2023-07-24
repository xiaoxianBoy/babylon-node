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
import type { RoyaltyAmount } from './RoyaltyAmount';
import {
    RoyaltyAmountFromJSON,
    RoyaltyAmountFromJSONTyped,
    RoyaltyAmountToJSON,
} from './RoyaltyAmount';

/**
 * 
 * @export
 * @interface BlueprintMethodRoyalty
 */
export interface BlueprintMethodRoyalty {
    /**
     * 
     * @type {string}
     * @memberof BlueprintMethodRoyalty
     */
    method_name: string;
    /**
     * 
     * @type {RoyaltyAmount}
     * @memberof BlueprintMethodRoyalty
     */
    royalty_amount?: RoyaltyAmount;
}

/**
 * Check if a given object implements the BlueprintMethodRoyalty interface.
 */
export function instanceOfBlueprintMethodRoyalty(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "method_name" in value;

    return isInstance;
}

export function BlueprintMethodRoyaltyFromJSON(json: any): BlueprintMethodRoyalty {
    return BlueprintMethodRoyaltyFromJSONTyped(json, false);
}

export function BlueprintMethodRoyaltyFromJSONTyped(json: any, ignoreDiscriminator: boolean): BlueprintMethodRoyalty {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'method_name': json['method_name'],
        'royalty_amount': !exists(json, 'royalty_amount') ? undefined : RoyaltyAmountFromJSON(json['royalty_amount']),
    };
}

export function BlueprintMethodRoyaltyToJSON(value?: BlueprintMethodRoyalty | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'method_name': value.method_name,
        'royalty_amount': RoyaltyAmountToJSON(value.royalty_amount),
    };
}

