/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
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
 * RCStateAccountResourceBalanceRequest
 */
@JsonPropertyOrder({
  RCStateAccountResourceBalanceRequest.JSON_PROPERTY_NETWORK,
  RCStateAccountResourceBalanceRequest.JSON_PROPERTY_ACCOUNT_ADDRESS,
  RCStateAccountResourceBalanceRequest.JSON_PROPERTY_RESOURCE_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class RCStateAccountResourceBalanceRequest {
  public static final String JSON_PROPERTY_NETWORK = "network";
  private String network;

  public static final String JSON_PROPERTY_ACCOUNT_ADDRESS = "account_address";
  private String accountAddress;

  public static final String JSON_PROPERTY_RESOURCE_ADDRESS = "resource_address";
  private String resourceAddress;

  public RCStateAccountResourceBalanceRequest() { 
  }

  public RCStateAccountResourceBalanceRequest network(String network) {
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


  public RCStateAccountResourceBalanceRequest accountAddress(String accountAddress) {
    this.accountAddress = accountAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the account&#39;s address
   * @return accountAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the account's address")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccountAddress() {
    return accountAddress;
  }


  @JsonProperty(JSON_PROPERTY_ACCOUNT_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccountAddress(String accountAddress) {
    this.accountAddress = accountAddress;
  }


  public RCStateAccountResourceBalanceRequest resourceAddress(String resourceAddress) {
    this.resourceAddress = resourceAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the resource address
   * @return resourceAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the resource address")
  @JsonProperty(JSON_PROPERTY_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getResourceAddress() {
    return resourceAddress;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceAddress(String resourceAddress) {
    this.resourceAddress = resourceAddress;
  }


  /**
   * Return true if this RCStateAccountResourceBalanceRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RCStateAccountResourceBalanceRequest rcStateAccountResourceBalanceRequest = (RCStateAccountResourceBalanceRequest) o;
    return Objects.equals(this.network, rcStateAccountResourceBalanceRequest.network) &&
        Objects.equals(this.accountAddress, rcStateAccountResourceBalanceRequest.accountAddress) &&
        Objects.equals(this.resourceAddress, rcStateAccountResourceBalanceRequest.resourceAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, accountAddress, resourceAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RCStateAccountResourceBalanceRequest {\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    accountAddress: ").append(toIndentedString(accountAddress)).append("\n");
    sb.append("    resourceAddress: ").append(toIndentedString(resourceAddress)).append("\n");
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

