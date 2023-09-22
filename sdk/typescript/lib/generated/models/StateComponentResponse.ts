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
import type { LedgerStateSummary } from './LedgerStateSummary';
import {
    LedgerStateSummaryFromJSON,
    LedgerStateSummaryFromJSONTyped,
    LedgerStateSummaryToJSON,
} from './LedgerStateSummary';
import type { StateComponentDescendentNode } from './StateComponentDescendentNode';
import {
    StateComponentDescendentNodeFromJSON,
    StateComponentDescendentNodeFromJSONTyped,
    StateComponentDescendentNodeToJSON,
} from './StateComponentDescendentNode';
import type { Substate } from './Substate';
import {
    SubstateFromJSON,
    SubstateFromJSONTyped,
    SubstateToJSON,
} from './Substate';
import type { VaultBalance } from './VaultBalance';
import {
    VaultBalanceFromJSON,
    VaultBalanceFromJSONTyped,
    VaultBalanceToJSON,
} from './VaultBalance';

/**
 * 
 * @export
 * @interface StateComponentResponse
 */
export interface StateComponentResponse {
    /**
     * 
     * @type {LedgerStateSummary}
     * @memberof StateComponentResponse
     */
    at_ledger_state: LedgerStateSummary;
    /**
     * 
     * @type {Substate}
     * @memberof StateComponentResponse
     */
    info: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateComponentResponse
     */
    state: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateComponentResponse
     */
    royalty_accumulator?: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateComponentResponse
     */
    owner_role: Substate;
    /**
     * Any vaults owned directly or indirectly by the component
     * @type {Array<VaultBalance>}
     * @memberof StateComponentResponse
     */
    vaults: Array<VaultBalance>;
    /**
     * Any descendent nodes owned directly or indirectly by the component
     * @type {Array<StateComponentDescendentNode>}
     * @memberof StateComponentResponse
     */
    descendent_nodes: Array<StateComponentDescendentNode>;
}

/**
 * Check if a given object implements the StateComponentResponse interface.
 */
export function instanceOfStateComponentResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "at_ledger_state" in value;
    isInstance = isInstance && "info" in value;
    isInstance = isInstance && "state" in value;
    isInstance = isInstance && "owner_role" in value;
    isInstance = isInstance && "vaults" in value;
    isInstance = isInstance && "descendent_nodes" in value;

    return isInstance;
}

export function StateComponentResponseFromJSON(json: any): StateComponentResponse {
    return StateComponentResponseFromJSONTyped(json, false);
}

export function StateComponentResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): StateComponentResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'at_ledger_state': LedgerStateSummaryFromJSON(json['at_ledger_state']),
        'info': SubstateFromJSON(json['info']),
        'state': SubstateFromJSON(json['state']),
        'royalty_accumulator': !exists(json, 'royalty_accumulator') ? undefined : SubstateFromJSON(json['royalty_accumulator']),
        'owner_role': SubstateFromJSON(json['owner_role']),
        'vaults': ((json['vaults'] as Array<any>).map(VaultBalanceFromJSON)),
        'descendent_nodes': ((json['descendent_nodes'] as Array<any>).map(StateComponentDescendentNodeFromJSON)),
    };
}

export function StateComponentResponseToJSON(value?: StateComponentResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'at_ledger_state': LedgerStateSummaryToJSON(value.at_ledger_state),
        'info': SubstateToJSON(value.info),
        'state': SubstateToJSON(value.state),
        'royalty_accumulator': SubstateToJSON(value.royalty_accumulator),
        'owner_role': SubstateToJSON(value.owner_role),
        'vaults': ((value.vaults as Array<any>).map(VaultBalanceToJSON)),
        'descendent_nodes': ((value.descendent_nodes as Array<any>).map(StateComponentDescendentNodeToJSON)),
    };
}

