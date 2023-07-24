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
import type { FunctionSchema } from './FunctionSchema';
import {
    FunctionSchemaFromJSON,
    FunctionSchemaFromJSONTyped,
    FunctionSchemaToJSON,
} from './FunctionSchema';
import type { GenericTypeParameter } from './GenericTypeParameter';
import {
    GenericTypeParameterFromJSON,
    GenericTypeParameterFromJSONTyped,
    GenericTypeParameterToJSON,
} from './GenericTypeParameter';
import type { IndexedStateSchema } from './IndexedStateSchema';
import {
    IndexedStateSchemaFromJSON,
    IndexedStateSchemaFromJSONTyped,
    IndexedStateSchemaToJSON,
} from './IndexedStateSchema';
import type { TypePointer } from './TypePointer';
import {
    TypePointerFromJSON,
    TypePointerFromJSONTyped,
    TypePointerToJSON,
} from './TypePointer';

/**
 * 
 * @export
 * @interface BlueprintInterface
 */
export interface BlueprintInterface {
    /**
     * 
     * @type {string}
     * @memberof BlueprintInterface
     */
    outer_blueprint?: string;
    /**
     * Generic (SBOR) type parameters which need to be filled by a concrete instance
     * of this blueprint.
     * @type {Array<GenericTypeParameter>}
     * @memberof BlueprintInterface
     */
    generic_type_parameters: Array<GenericTypeParameter>;
    /**
     * 
     * @type {Array<string>}
     * @memberof BlueprintInterface
     */
    features: Array<string>;
    /**
     * 
     * @type {IndexedStateSchema}
     * @memberof BlueprintInterface
     */
    state: IndexedStateSchema;
    /**
     * A map from the function name to the FunctionSchema
     * @type {{ [key: string]: FunctionSchema; }}
     * @memberof BlueprintInterface
     */
    functions: { [key: string]: FunctionSchema; };
    /**
     * A map from the event name to the local type index for the event payload under the blueprint schema.
     * @type {{ [key: string]: TypePointer; }}
     * @memberof BlueprintInterface
     */
    events: { [key: string]: TypePointer; };
}

/**
 * Check if a given object implements the BlueprintInterface interface.
 */
export function instanceOfBlueprintInterface(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "generic_type_parameters" in value;
    isInstance = isInstance && "features" in value;
    isInstance = isInstance && "state" in value;
    isInstance = isInstance && "functions" in value;
    isInstance = isInstance && "events" in value;

    return isInstance;
}

export function BlueprintInterfaceFromJSON(json: any): BlueprintInterface {
    return BlueprintInterfaceFromJSONTyped(json, false);
}

export function BlueprintInterfaceFromJSONTyped(json: any, ignoreDiscriminator: boolean): BlueprintInterface {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'outer_blueprint': !exists(json, 'outer_blueprint') ? undefined : json['outer_blueprint'],
        'generic_type_parameters': ((json['generic_type_parameters'] as Array<any>).map(GenericTypeParameterFromJSON)),
        'features': json['features'],
        'state': IndexedStateSchemaFromJSON(json['state']),
        'functions': (mapValues(json['functions'], FunctionSchemaFromJSON)),
        'events': (mapValues(json['events'], TypePointerFromJSON)),
    };
}

export function BlueprintInterfaceToJSON(value?: BlueprintInterface | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'outer_blueprint': value.outer_blueprint,
        'generic_type_parameters': ((value.generic_type_parameters as Array<any>).map(GenericTypeParameterToJSON)),
        'features': value.features,
        'state': IndexedStateSchemaToJSON(value.state),
        'functions': (mapValues(value.functions, FunctionSchemaToJSON)),
        'events': (mapValues(value.events, TypePointerToJSON)),
    };
}

