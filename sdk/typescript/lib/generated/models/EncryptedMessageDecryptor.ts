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
 * 
 * @export
 * @interface EncryptedMessageDecryptor
 */
export interface EncryptedMessageDecryptor {
    /**
     * The last 8 bytes of the Blake2b-256 hash of the public key bytes, in their standard Radix byte-serialization.
     * @type {string}
     * @memberof EncryptedMessageDecryptor
     */
    public_key_fingerprint_hex: string;
    /**
     * The hex-encoded wrapped key bytes from applying RFC 3394 (256-bit) AES-KeyWrap to the 128-bit message ephemeral public key, with the secret KEK provided by static Diffie-Helman between the decryptor public key, and the `dh_ephemeral_public_key` for that curve type.
     * The bytes are serialized (according to RFC 3394) as the concatenation `IV (first 8 bytes) || Cipher (wrapped 128-bit key, encoded as two 64-bit blocks)`.
     * @type {string}
     * @memberof EncryptedMessageDecryptor
     */
    aes_wrapped_key_hex: string;
}

/**
 * Check if a given object implements the EncryptedMessageDecryptor interface.
 */
export function instanceOfEncryptedMessageDecryptor(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "public_key_fingerprint_hex" in value;
    isInstance = isInstance && "aes_wrapped_key_hex" in value;

    return isInstance;
}

export function EncryptedMessageDecryptorFromJSON(json: any): EncryptedMessageDecryptor {
    return EncryptedMessageDecryptorFromJSONTyped(json, false);
}

export function EncryptedMessageDecryptorFromJSONTyped(json: any, ignoreDiscriminator: boolean): EncryptedMessageDecryptor {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'public_key_fingerprint_hex': json['public_key_fingerprint_hex'],
        'aes_wrapped_key_hex': json['aes_wrapped_key_hex'],
    };
}

export function EncryptedMessageDecryptorToJSON(value?: EncryptedMessageDecryptor | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'public_key_fingerprint_hex': value.public_key_fingerprint_hex,
        'aes_wrapped_key_hex': value.aes_wrapped_key_hex,
    };
}

