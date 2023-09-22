/*
 * Radix Core API - Babylon (v1.0.0)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.core.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * MempoolTransactionResponsePayloadsInner
 */
@JsonPropertyOrder({
  MempoolTransactionResponsePayloadsInner.JSON_PROPERTY_HASH,
  MempoolTransactionResponsePayloadsInner.JSON_PROPERTY_HASH_BECH32M,
  MempoolTransactionResponsePayloadsInner.JSON_PROPERTY_HEX,
  MempoolTransactionResponsePayloadsInner.JSON_PROPERTY_ERROR
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MempoolTransactionResponsePayloadsInner {
  public static final String JSON_PROPERTY_HASH = "hash";
  private String hash;

  public static final String JSON_PROPERTY_HASH_BECH32M = "hash_bech32m";
  private String hashBech32m;

  public static final String JSON_PROPERTY_HEX = "hex";
  private String hex;

  public static final String JSON_PROPERTY_ERROR = "error";
  private String error;

  public MempoolTransactionResponsePayloadsInner() { 
  }

  public MempoolTransactionResponsePayloadsInner hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * The hex-encoded notarized transaction hash for a user transaction. This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature. 
   * @return hash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded notarized transaction hash for a user transaction. This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature. ")
  @JsonProperty(JSON_PROPERTY_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHash() {
    return hash;
  }


  @JsonProperty(JSON_PROPERTY_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHash(String hash) {
    this.hash = hash;
  }


  public MempoolTransactionResponsePayloadsInner hashBech32m(String hashBech32m) {
    this.hashBech32m = hashBech32m;
    return this;
  }

   /**
   * The Bech32m-encoded human readable &#x60;NotarizedTransactionHash&#x60;.
   * @return hashBech32m
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable `NotarizedTransactionHash`.")
  @JsonProperty(JSON_PROPERTY_HASH_BECH32M)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHashBech32m() {
    return hashBech32m;
  }


  @JsonProperty(JSON_PROPERTY_HASH_BECH32M)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHashBech32m(String hashBech32m) {
    this.hashBech32m = hashBech32m;
  }


  public MempoolTransactionResponsePayloadsInner hex(String hex) {
    this.hex = hex;
    return this;
  }

   /**
   * The hex-encoded full notarized transaction payload - returned only if found in mempool.
   * @return hex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The hex-encoded full notarized transaction payload - returned only if found in mempool.")
  @JsonProperty(JSON_PROPERTY_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getHex() {
    return hex;
  }


  @JsonProperty(JSON_PROPERTY_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHex(String hex) {
    this.hex = hex;
  }


  public MempoolTransactionResponsePayloadsInner error(String error) {
    this.error = error;
    return this;
  }

   /**
   * Error message why &#x60;hex&#x60; field is missing: the transaction was not found in the mempool or the provided hash is invalid. 
   * @return error
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Error message why `hex` field is missing: the transaction was not found in the mempool or the provided hash is invalid. ")
  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getError() {
    return error;
  }


  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setError(String error) {
    this.error = error;
  }


  /**
   * Return true if this MempoolTransactionResponse_payloads_inner object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MempoolTransactionResponsePayloadsInner mempoolTransactionResponsePayloadsInner = (MempoolTransactionResponsePayloadsInner) o;
    return Objects.equals(this.hash, mempoolTransactionResponsePayloadsInner.hash) &&
        Objects.equals(this.hashBech32m, mempoolTransactionResponsePayloadsInner.hashBech32m) &&
        Objects.equals(this.hex, mempoolTransactionResponsePayloadsInner.hex) &&
        Objects.equals(this.error, mempoolTransactionResponsePayloadsInner.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hash, hashBech32m, hex, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MempoolTransactionResponsePayloadsInner {\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    hashBech32m: ").append(toIndentedString(hashBech32m)).append("\n");
    sb.append("    hex: ").append(toIndentedString(hex)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

