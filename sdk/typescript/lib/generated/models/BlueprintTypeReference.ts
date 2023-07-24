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

import {
    BlueprintSchemaBlueprintTypeReference,
    instanceOfBlueprintSchemaBlueprintTypeReference,
    BlueprintSchemaBlueprintTypeReferenceFromJSON,
    BlueprintSchemaBlueprintTypeReferenceFromJSONTyped,
    BlueprintSchemaBlueprintTypeReferenceToJSON,
} from './BlueprintSchemaBlueprintTypeReference';
import {
    InstanceSchemaBlueprintTypeReference,
    instanceOfInstanceSchemaBlueprintTypeReference,
    InstanceSchemaBlueprintTypeReferenceFromJSON,
    InstanceSchemaBlueprintTypeReferenceFromJSONTyped,
    InstanceSchemaBlueprintTypeReferenceToJSON,
} from './InstanceSchemaBlueprintTypeReference';

/**
 * @type BlueprintTypeReference
 * 
 * @export
 */
export type BlueprintTypeReference = { type: 'BlueprintSchema' } & BlueprintSchemaBlueprintTypeReference | { type: 'InstanceSchema' } & InstanceSchemaBlueprintTypeReference;

export function BlueprintTypeReferenceFromJSON(json: any): BlueprintTypeReference {
    return BlueprintTypeReferenceFromJSONTyped(json, false);
}

export function BlueprintTypeReferenceFromJSONTyped(json: any, ignoreDiscriminator: boolean): BlueprintTypeReference {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    switch (json['type']) {
        case 'BlueprintSchema':
            return {...BlueprintSchemaBlueprintTypeReferenceFromJSONTyped(json, true), type: 'BlueprintSchema'};
        case 'InstanceSchema':
            return {...InstanceSchemaBlueprintTypeReferenceFromJSONTyped(json, true), type: 'InstanceSchema'};
        default:
            throw new Error(`No variant of BlueprintTypeReference exists with 'type=${json['type']}'`);
    }
}

export function BlueprintTypeReferenceToJSON(value?: BlueprintTypeReference | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    switch (value['type']) {
        case 'BlueprintSchema':
            return BlueprintSchemaBlueprintTypeReferenceToJSON(value);
        case 'InstanceSchema':
            return InstanceSchemaBlueprintTypeReferenceToJSON(value);
        default:
            throw new Error(`No variant of BlueprintTypeReference exists with 'type=${value['type']}'`);
    }

}

