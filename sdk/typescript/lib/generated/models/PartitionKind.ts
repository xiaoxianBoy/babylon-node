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


/**
 * The type of the partition:
 * - Field
 *   - Has key: TupleKey(u8) also known as an offset
 *   - No iteration exposed to engine
 *   - Is versioned / locked substate-by-substate
 * - KeyValue ("ConcurrentMap")
 *   - Has key: MapKey(Vec<u8>)
 *   - No iteration exposed to engine
 *   - Is versioned / locked substate-by-substate
 * - Index
 *   - Has key: MapKey(Vec<u8>)
 *   - Iteration exposed to engine via the MapKey's database key (ie hash of the key)
 *   - Is versioned / locked in its entirety
 * - SortedIndex
 *   - Has key: SortedU16Key(U16, Vec<u8>)
 *   - Iteration exposed to engine via the user-controlled U16 prefix and then the MapKey's database key (ie hash of the key)
 *   - Is versioned / locked in its entirety
 * @export
 */
export const PartitionKind = {
    Field: 'Field',
    KeyValue: 'KeyValue',
    Index: 'Index',
    SortedIndex: 'SortedIndex'
} as const;
export type PartitionKind = typeof PartitionKind[keyof typeof PartitionKind];


export function PartitionKindFromJSON(json: any): PartitionKind {
    return PartitionKindFromJSONTyped(json, false);
}

export function PartitionKindFromJSONTyped(json: any, ignoreDiscriminator: boolean): PartitionKind {
    return json as PartitionKind;
}

export function PartitionKindToJSON(value?: PartitionKind | null): any {
    return value as any;
}

