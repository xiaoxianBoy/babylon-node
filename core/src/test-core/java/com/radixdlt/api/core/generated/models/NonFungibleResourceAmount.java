/*
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.FungibleResourceAmount;
import com.radixdlt.api.core.generated.models.NonFungibleLocalId;
import com.radixdlt.api.core.generated.models.NonFungibleResourceAmount;
import com.radixdlt.api.core.generated.models.NonFungibleResourceAmountAllOf;
import com.radixdlt.api.core.generated.models.ResourceAmount;
import com.radixdlt.api.core.generated.models.ResourceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * NonFungibleResourceAmount
 */
@JsonPropertyOrder({
  NonFungibleResourceAmount.JSON_PROPERTY_AMOUNT,
  NonFungibleResourceAmount.JSON_PROPERTY_NON_FUNGIBLE_IDS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "resource_type", // ignore manually set resource_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the resource_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "resource_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = FungibleResourceAmount.class, name = "Fungible"),
  @JsonSubTypes.Type(value = NonFungibleResourceAmount.class, name = "NonFungible"),
})

public class NonFungibleResourceAmount extends ResourceAmount {
  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private String amount;

  public static final String JSON_PROPERTY_NON_FUNGIBLE_IDS = "non_fungible_ids";
  private List<NonFungibleLocalId> nonFungibleIds = new ArrayList<>();

  public NonFungibleResourceAmount() { 
  }

  public NonFungibleResourceAmount amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The string-encoded decimal representing the amount of this resource (some decimal for fungible resources, a whole integer for non-fungible resources). A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return amount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The string-encoded decimal representing the amount of this resource (some decimal for fungible resources, a whole integer for non-fungible resources). A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAmount() {
    return amount;
  }


  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAmount(String amount) {
    this.amount = amount;
  }


  public NonFungibleResourceAmount nonFungibleIds(List<NonFungibleLocalId> nonFungibleIds) {
    this.nonFungibleIds = nonFungibleIds;
    return this;
  }

  public NonFungibleResourceAmount addNonFungibleIdsItem(NonFungibleLocalId nonFungibleIdsItem) {
    this.nonFungibleIds.add(nonFungibleIdsItem);
    return this;
  }

   /**
   * Get nonFungibleIds
   * @return nonFungibleIds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NON_FUNGIBLE_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<NonFungibleLocalId> getNonFungibleIds() {
    return nonFungibleIds;
  }


  @JsonProperty(JSON_PROPERTY_NON_FUNGIBLE_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNonFungibleIds(List<NonFungibleLocalId> nonFungibleIds) {
    this.nonFungibleIds = nonFungibleIds;
  }


  /**
   * Return true if this NonFungibleResourceAmount object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonFungibleResourceAmount nonFungibleResourceAmount = (NonFungibleResourceAmount) o;
    return Objects.equals(this.amount, nonFungibleResourceAmount.amount) &&
        Objects.equals(this.nonFungibleIds, nonFungibleResourceAmount.nonFungibleIds) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, nonFungibleIds, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NonFungibleResourceAmount {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    nonFungibleIds: ").append(toIndentedString(nonFungibleIds)).append("\n");
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

static {
  // Initialize and register the discriminator mappings.
  Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
  mappings.put("Fungible", FungibleResourceAmount.class);
  mappings.put("NonFungible", NonFungibleResourceAmount.class);
  mappings.put("NonFungibleResourceAmount", NonFungibleResourceAmount.class);
  JSON.registerDiscriminator(NonFungibleResourceAmount.class, "resource_type", mappings);
}
}

