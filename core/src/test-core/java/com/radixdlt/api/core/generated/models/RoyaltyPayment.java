/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.1.0
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
import com.radixdlt.api.core.generated.models.GlobalEntityReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RoyaltyPayment
 */
@JsonPropertyOrder({
  RoyaltyPayment.JSON_PROPERTY_ROYALTY_RECEIVER,
  RoyaltyPayment.JSON_PROPERTY_COST_UNIT_AMOUNT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class RoyaltyPayment {
  public static final String JSON_PROPERTY_ROYALTY_RECEIVER = "royalty_receiver";
  private GlobalEntityReference royaltyReceiver;

  public static final String JSON_PROPERTY_COST_UNIT_AMOUNT = "cost_unit_amount";
  private Long costUnitAmount;

  public RoyaltyPayment() { 
  }

  public RoyaltyPayment royaltyReceiver(GlobalEntityReference royaltyReceiver) {
    this.royaltyReceiver = royaltyReceiver;
    return this;
  }

   /**
   * Get royaltyReceiver
   * @return royaltyReceiver
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ROYALTY_RECEIVER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public GlobalEntityReference getRoyaltyReceiver() {
    return royaltyReceiver;
  }


  @JsonProperty(JSON_PROPERTY_ROYALTY_RECEIVER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRoyaltyReceiver(GlobalEntityReference royaltyReceiver) {
    this.royaltyReceiver = royaltyReceiver;
  }


  public RoyaltyPayment costUnitAmount(Long costUnitAmount) {
    this.costUnitAmount = costUnitAmount;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;2^32 - 1&#x60;, representing the amount of cost units of royalty paid to this receiver.
   * minimum: 0
   * maximum: 4294967295
   * @return costUnitAmount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `2^32 - 1`, representing the amount of cost units of royalty paid to this receiver.")
  @JsonProperty(JSON_PROPERTY_COST_UNIT_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getCostUnitAmount() {
    return costUnitAmount;
  }


  @JsonProperty(JSON_PROPERTY_COST_UNIT_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCostUnitAmount(Long costUnitAmount) {
    this.costUnitAmount = costUnitAmount;
  }


  /**
   * Return true if this RoyaltyPayment object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoyaltyPayment royaltyPayment = (RoyaltyPayment) o;
    return Objects.equals(this.royaltyReceiver, royaltyPayment.royaltyReceiver) &&
        Objects.equals(this.costUnitAmount, royaltyPayment.costUnitAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(royaltyReceiver, costUnitAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoyaltyPayment {\n");
    sb.append("    royaltyReceiver: ").append(toIndentedString(royaltyReceiver)).append("\n");
    sb.append("    costUnitAmount: ").append(toIndentedString(costUnitAmount)).append("\n");
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
