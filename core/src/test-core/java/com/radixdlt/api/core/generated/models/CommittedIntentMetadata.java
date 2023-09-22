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
 * CommittedIntentMetadata
 */
@JsonPropertyOrder({
  CommittedIntentMetadata.JSON_PROPERTY_STATE_VERSION,
  CommittedIntentMetadata.JSON_PROPERTY_PAYLOAD_HASH,
  CommittedIntentMetadata.JSON_PROPERTY_PAYLOAD_HASH_BECH32M,
  CommittedIntentMetadata.JSON_PROPERTY_IS_SAME_TRANSACTION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CommittedIntentMetadata {
  public static final String JSON_PROPERTY_STATE_VERSION = "state_version";
  private Long stateVersion;

  public static final String JSON_PROPERTY_PAYLOAD_HASH = "payload_hash";
  private String payloadHash;

  public static final String JSON_PROPERTY_PAYLOAD_HASH_BECH32M = "payload_hash_bech32m";
  private String payloadHashBech32m;

  public static final String JSON_PROPERTY_IS_SAME_TRANSACTION = "is_same_transaction";
  private Boolean isSameTransaction;

  public CommittedIntentMetadata() { 
  }

  public CommittedIntentMetadata stateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
    return this;
  }

   /**
   * Get stateVersion
   * minimum: 1
   * maximum: 100000000000000
   * @return stateVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getStateVersion() {
    return stateVersion;
  }


  @JsonProperty(JSON_PROPERTY_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
  }


  public CommittedIntentMetadata payloadHash(String payloadHash) {
    this.payloadHash = payloadHash;
    return this;
  }

   /**
   * The hex-encoded notarized transaction hash for a user transaction. This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature. 
   * @return payloadHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded notarized transaction hash for a user transaction. This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature. ")
  @JsonProperty(JSON_PROPERTY_PAYLOAD_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPayloadHash() {
    return payloadHash;
  }


  @JsonProperty(JSON_PROPERTY_PAYLOAD_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPayloadHash(String payloadHash) {
    this.payloadHash = payloadHash;
  }


  public CommittedIntentMetadata payloadHashBech32m(String payloadHashBech32m) {
    this.payloadHashBech32m = payloadHashBech32m;
    return this;
  }

   /**
   * The Bech32m-encoded human readable &#x60;NotarizedTransactionHash&#x60;.
   * @return payloadHashBech32m
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable `NotarizedTransactionHash`.")
  @JsonProperty(JSON_PROPERTY_PAYLOAD_HASH_BECH32M)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPayloadHashBech32m() {
    return payloadHashBech32m;
  }


  @JsonProperty(JSON_PROPERTY_PAYLOAD_HASH_BECH32M)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPayloadHashBech32m(String payloadHashBech32m) {
    this.payloadHashBech32m = payloadHashBech32m;
  }


  public CommittedIntentMetadata isSameTransaction(Boolean isSameTransaction) {
    this.isSameTransaction = isSameTransaction;
    return this;
  }

   /**
   * Whether the intent was committed in a transaction with the same payload. This is a convenience field, which can also be computed using &#x60;payload_hash&#x60; by a client knowing the payload of the submitted transaction. 
   * @return isSameTransaction
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the intent was committed in a transaction with the same payload. This is a convenience field, which can also be computed using `payload_hash` by a client knowing the payload of the submitted transaction. ")
  @JsonProperty(JSON_PROPERTY_IS_SAME_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsSameTransaction() {
    return isSameTransaction;
  }


  @JsonProperty(JSON_PROPERTY_IS_SAME_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsSameTransaction(Boolean isSameTransaction) {
    this.isSameTransaction = isSameTransaction;
  }


  /**
   * Return true if this CommittedIntentMetadata object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommittedIntentMetadata committedIntentMetadata = (CommittedIntentMetadata) o;
    return Objects.equals(this.stateVersion, committedIntentMetadata.stateVersion) &&
        Objects.equals(this.payloadHash, committedIntentMetadata.payloadHash) &&
        Objects.equals(this.payloadHashBech32m, committedIntentMetadata.payloadHashBech32m) &&
        Objects.equals(this.isSameTransaction, committedIntentMetadata.isSameTransaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateVersion, payloadHash, payloadHashBech32m, isSameTransaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommittedIntentMetadata {\n");
    sb.append("    stateVersion: ").append(toIndentedString(stateVersion)).append("\n");
    sb.append("    payloadHash: ").append(toIndentedString(payloadHash)).append("\n");
    sb.append("    payloadHashBech32m: ").append(toIndentedString(payloadHashBech32m)).append("\n");
    sb.append("    isSameTransaction: ").append(toIndentedString(isSameTransaction)).append("\n");
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

