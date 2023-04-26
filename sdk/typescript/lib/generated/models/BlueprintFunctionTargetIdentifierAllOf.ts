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
 * 
 * @export
 * @interface BlueprintFunctionTargetIdentifierAllOf
 */
export interface BlueprintFunctionTargetIdentifierAllOf {
    /**
     * The Bech32m-encoded human readable version of the package address
     * @type {string}
     * @memberof BlueprintFunctionTargetIdentifierAllOf
     */
    package_address: string;
    /**
     * 
     * @type {string}
     * @memberof BlueprintFunctionTargetIdentifierAllOf
     */
    blueprint_name: string;
    /**
     * 
     * @type {string}
     * @memberof BlueprintFunctionTargetIdentifierAllOf
     */
    function_name: string;
    /**
     * 
     * @type {string}
     * @memberof BlueprintFunctionTargetIdentifierAllOf
     */
    type?: BlueprintFunctionTargetIdentifierAllOfTypeEnum;
}


/**
 * @export
 */
export const BlueprintFunctionTargetIdentifierAllOfTypeEnum = {
    Function: 'Function'
} as const;
export type BlueprintFunctionTargetIdentifierAllOfTypeEnum = typeof BlueprintFunctionTargetIdentifierAllOfTypeEnum[keyof typeof BlueprintFunctionTargetIdentifierAllOfTypeEnum];


/**
 * Check if a given object implements the BlueprintFunctionTargetIdentifierAllOf interface.
 */
export function instanceOfBlueprintFunctionTargetIdentifierAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "package_address" in value;
    isInstance = isInstance && "blueprint_name" in value;
    isInstance = isInstance && "function_name" in value;

    return isInstance;
}

export function BlueprintFunctionTargetIdentifierAllOfFromJSON(json: any): BlueprintFunctionTargetIdentifierAllOf {
    return BlueprintFunctionTargetIdentifierAllOfFromJSONTyped(json, false);
}

export function BlueprintFunctionTargetIdentifierAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): BlueprintFunctionTargetIdentifierAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'package_address': json['package_address'],
        'blueprint_name': json['blueprint_name'],
        'function_name': json['function_name'],
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function BlueprintFunctionTargetIdentifierAllOfToJSON(value?: BlueprintFunctionTargetIdentifierAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'package_address': value.package_address,
        'blueprint_name': value.blueprint_name,
        'function_name': value.function_name,
        'type': value.type,
    };
}

