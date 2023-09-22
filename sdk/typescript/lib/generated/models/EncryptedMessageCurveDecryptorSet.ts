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
import type { EncryptedMessageDecryptor } from './EncryptedMessageDecryptor';
import {
    EncryptedMessageDecryptorFromJSON,
    EncryptedMessageDecryptorFromJSONTyped,
    EncryptedMessageDecryptorToJSON,
} from './EncryptedMessageDecryptor';
import type { PublicKey } from './PublicKey';
import {
    PublicKeyFromJSON,
    PublicKeyFromJSONTyped,
    PublicKeyToJSON,
} from './PublicKey';

/**
 * A decryptor set for a particular ECDSA curve type.
 * The (128-bit) AES-GCM symmetric key is encrypted separately for each decryptor public key via (256-bit) AES-KeyWrap.
 * AES-KeyWrap uses a key derived via a KDF (Key Derivation Function) using a shared secret.
 * For each decryptor public key, we create a shared curve point `G` via static Diffie-Helman between the decryptor public key, and a per-transaction ephemeral public key for that curve type.
 * We then use that shared secret with a key derivation function to create the (256-bit) KEK (Key Encrypting Key):
 * `KEK = HKDF(hash: Blake2b, secret: x co-ord of G, salt: [], length: 256 bits)`.
 * @export
 * @interface EncryptedMessageCurveDecryptorSet
 */
export interface EncryptedMessageCurveDecryptorSet {
    /**
     * 
     * @type {PublicKey}
     * @memberof EncryptedMessageCurveDecryptorSet
     */
    dh_ephemeral_public_key: PublicKey;
    /**
     * 
     * @type {Array<EncryptedMessageDecryptor>}
     * @memberof EncryptedMessageCurveDecryptorSet
     */
    decryptors: Array<EncryptedMessageDecryptor>;
}

/**
 * Check if a given object implements the EncryptedMessageCurveDecryptorSet interface.
 */
export function instanceOfEncryptedMessageCurveDecryptorSet(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "dh_ephemeral_public_key" in value;
    isInstance = isInstance && "decryptors" in value;

    return isInstance;
}

export function EncryptedMessageCurveDecryptorSetFromJSON(json: any): EncryptedMessageCurveDecryptorSet {
    return EncryptedMessageCurveDecryptorSetFromJSONTyped(json, false);
}

export function EncryptedMessageCurveDecryptorSetFromJSONTyped(json: any, ignoreDiscriminator: boolean): EncryptedMessageCurveDecryptorSet {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'dh_ephemeral_public_key': PublicKeyFromJSON(json['dh_ephemeral_public_key']),
        'decryptors': ((json['decryptors'] as Array<any>).map(EncryptedMessageDecryptorFromJSON)),
    };
}

export function EncryptedMessageCurveDecryptorSetToJSON(value?: EncryptedMessageCurveDecryptorSet | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'dh_ephemeral_public_key': PublicKeyToJSON(value.dh_ephemeral_public_key),
        'decryptors': ((value.decryptors as Array<any>).map(EncryptedMessageDecryptorToJSON)),
    };
}

