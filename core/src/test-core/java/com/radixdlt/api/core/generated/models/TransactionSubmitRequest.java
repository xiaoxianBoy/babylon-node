/*
 * Babylon Core API - RCnet V1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.3.0
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
 * TransactionSubmitRequest
 */
@JsonPropertyOrder({
  TransactionSubmitRequest.JSON_PROPERTY_NETWORK,
  TransactionSubmitRequest.JSON_PROPERTY_NOTARIZED_TRANSACTION_HEX
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionSubmitRequest {
  public static final String JSON_PROPERTY_NETWORK = "network";
  private String network;

  public static final String JSON_PROPERTY_NOTARIZED_TRANSACTION_HEX = "notarized_transaction_hex";
  private String notarizedTransactionHex;

  public TransactionSubmitRequest() { 
  }

  public TransactionSubmitRequest network(String network) {
    this.network = network;
    return this;
  }

   /**
   * The logical name of the network
   * @return network
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{{network}}", required = true, value = "The logical name of the network")
  @JsonProperty(JSON_PROPERTY_NETWORK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNetwork() {
    return network;
  }


  @JsonProperty(JSON_PROPERTY_NETWORK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNetwork(String network) {
    this.network = network;
  }


  public TransactionSubmitRequest notarizedTransactionHex(String notarizedTransactionHex) {
    this.notarizedTransactionHex = notarizedTransactionHex;
    return this;
  }

   /**
   * A hex-encoded, compiled notarized transaction.
   * @return notarizedTransactionHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A hex-encoded, compiled notarized transaction.")
  @JsonProperty(JSON_PROPERTY_NOTARIZED_TRANSACTION_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNotarizedTransactionHex() {
    return notarizedTransactionHex;
  }


  @JsonProperty(JSON_PROPERTY_NOTARIZED_TRANSACTION_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNotarizedTransactionHex(String notarizedTransactionHex) {
    this.notarizedTransactionHex = notarizedTransactionHex;
  }


  /**
   * Return true if this TransactionSubmitRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionSubmitRequest transactionSubmitRequest = (TransactionSubmitRequest) o;
    return Objects.equals(this.network, transactionSubmitRequest.network) &&
        Objects.equals(this.notarizedTransactionHex, transactionSubmitRequest.notarizedTransactionHex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, notarizedTransactionHex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionSubmitRequest {\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    notarizedTransactionHex: ").append(toIndentedString(notarizedTransactionHex)).append("\n");
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

