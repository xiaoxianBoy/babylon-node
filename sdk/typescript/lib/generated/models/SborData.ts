/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (v1.0.0)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * Various representations of an SBOR payload.
 * Some endpoints may allow opting in/out of each representation.
 * @export
 * @interface SborData
 */
export interface SborData {
    /**
     * The hex-encoded, raw SBOR-encoded data
     * @type {string}
     * @memberof SborData
     */
    hex?: string;
    /**
     * The (untyped) unannotated programmatic SBOR JSON
     * @type {any}
     * @memberof SborData
     */
    programmatic_json?: any | null;
}

/**
 * Check if a given object implements the SborData interface.
 */
export function instanceOfSborData(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function SborDataFromJSON(json: any): SborData {
    return SborDataFromJSONTyped(json, false);
}

export function SborDataFromJSONTyped(json: any, ignoreDiscriminator: boolean): SborData {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'hex': !exists(json, 'hex') ? undefined : json['hex'],
        'programmatic_json': !exists(json, 'programmatic_json') ? undefined : json['programmatic_json'],
    };
}

export function SborDataToJSON(value?: SborData | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'hex': value.hex,
        'programmatic_json': value.programmatic_json,
    };
}

