/*
 * Babylon Core API - RCnet v3.1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
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
import com.radixdlt.api.core.generated.models.PresentedBadge;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * LtsStateAccountDepositBehaviourRequest
 */
@JsonPropertyOrder({
  LtsStateAccountDepositBehaviourRequest.JSON_PROPERTY_NETWORK,
  LtsStateAccountDepositBehaviourRequest.JSON_PROPERTY_ACCOUNT_ADDRESS,
  LtsStateAccountDepositBehaviourRequest.JSON_PROPERTY_RESOURCE_ADDRESSES,
  LtsStateAccountDepositBehaviourRequest.JSON_PROPERTY_BADGE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LtsStateAccountDepositBehaviourRequest {
  public static final String JSON_PROPERTY_NETWORK = "network";
  private String network;

  public static final String JSON_PROPERTY_ACCOUNT_ADDRESS = "account_address";
  private String accountAddress;

  public static final String JSON_PROPERTY_RESOURCE_ADDRESSES = "resource_addresses";
  private List<String> resourceAddresses = null;

  public static final String JSON_PROPERTY_BADGE = "badge";
  private PresentedBadge badge;

  public LtsStateAccountDepositBehaviourRequest() { 
  }

  public LtsStateAccountDepositBehaviourRequest network(String network) {
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


  public LtsStateAccountDepositBehaviourRequest accountAddress(String accountAddress) {
    this.accountAddress = accountAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the account&#39;s address.
   * @return accountAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the account's address.")
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


  public LtsStateAccountDepositBehaviourRequest resourceAddresses(List<String> resourceAddresses) {
    this.resourceAddresses = resourceAddresses;
    return this;
  }

  public LtsStateAccountDepositBehaviourRequest addResourceAddressesItem(String resourceAddressesItem) {
    if (this.resourceAddresses == null) {
      this.resourceAddresses = new ArrayList<>();
    }
    this.resourceAddresses.add(resourceAddressesItem);
    return this;
  }

   /**
   * The resource addresses to check the deposit behaviours of.
   * @return resourceAddresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The resource addresses to check the deposit behaviours of.")
  @JsonProperty(JSON_PROPERTY_RESOURCE_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getResourceAddresses() {
    return resourceAddresses;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResourceAddresses(List<String> resourceAddresses) {
    this.resourceAddresses = resourceAddresses;
  }


  public LtsStateAccountDepositBehaviourRequest badge(PresentedBadge badge) {
    this.badge = badge;
    return this;
  }

   /**
   * Get badge
   * @return badge
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BADGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PresentedBadge getBadge() {
    return badge;
  }


  @JsonProperty(JSON_PROPERTY_BADGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBadge(PresentedBadge badge) {
    this.badge = badge;
  }


  /**
   * Return true if this LtsStateAccountDepositBehaviourRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LtsStateAccountDepositBehaviourRequest ltsStateAccountDepositBehaviourRequest = (LtsStateAccountDepositBehaviourRequest) o;
    return Objects.equals(this.network, ltsStateAccountDepositBehaviourRequest.network) &&
        Objects.equals(this.accountAddress, ltsStateAccountDepositBehaviourRequest.accountAddress) &&
        Objects.equals(this.resourceAddresses, ltsStateAccountDepositBehaviourRequest.resourceAddresses) &&
        Objects.equals(this.badge, ltsStateAccountDepositBehaviourRequest.badge);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, accountAddress, resourceAddresses, badge);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LtsStateAccountDepositBehaviourRequest {\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    accountAddress: ").append(toIndentedString(accountAddress)).append("\n");
    sb.append("    resourceAddresses: ").append(toIndentedString(resourceAddresses)).append("\n");
    sb.append("    badge: ").append(toIndentedString(badge)).append("\n");
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

