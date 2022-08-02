/*
 * Babylon Core API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TransactionFeeSummary
 */
@JsonPropertyOrder({
  TransactionFeeSummary.JSON_PROPERTY_COST_UNIT_LIMIT,
  TransactionFeeSummary.JSON_PROPERTY_COST_UNIT_CONSUMED,
  TransactionFeeSummary.JSON_PROPERTY_COST_UNIT_PRICE,
  TransactionFeeSummary.JSON_PROPERTY_BURNED,
  TransactionFeeSummary.JSON_PROPERTY_TIPPED
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionFeeSummary {
  public static final String JSON_PROPERTY_COST_UNIT_LIMIT = "cost_unit_limit";
  private String costUnitLimit;

  public static final String JSON_PROPERTY_COST_UNIT_CONSUMED = "cost_unit_consumed";
  private String costUnitConsumed;

  public static final String JSON_PROPERTY_COST_UNIT_PRICE = "cost_unit_price";
  private String costUnitPrice;

  public static final String JSON_PROPERTY_BURNED = "burned";
  private String burned;

  public static final String JSON_PROPERTY_TIPPED = "tipped";
  private String tipped;


  public TransactionFeeSummary costUnitLimit(String costUnitLimit) {
    this.costUnitLimit = costUnitLimit;
    return this;
  }

   /**
   * Get costUnitLimit
   * @return costUnitLimit
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COST_UNIT_LIMIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCostUnitLimit() {
    return costUnitLimit;
  }


  @JsonProperty(JSON_PROPERTY_COST_UNIT_LIMIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCostUnitLimit(String costUnitLimit) {
    this.costUnitLimit = costUnitLimit;
  }


  public TransactionFeeSummary costUnitConsumed(String costUnitConsumed) {
    this.costUnitConsumed = costUnitConsumed;
    return this;
  }

   /**
   * Get costUnitConsumed
   * @return costUnitConsumed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COST_UNIT_CONSUMED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCostUnitConsumed() {
    return costUnitConsumed;
  }


  @JsonProperty(JSON_PROPERTY_COST_UNIT_CONSUMED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCostUnitConsumed(String costUnitConsumed) {
    this.costUnitConsumed = costUnitConsumed;
  }


  public TransactionFeeSummary costUnitPrice(String costUnitPrice) {
    this.costUnitPrice = costUnitPrice;
    return this;
  }

   /**
   * Get costUnitPrice
   * @return costUnitPrice
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COST_UNIT_PRICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCostUnitPrice() {
    return costUnitPrice;
  }


  @JsonProperty(JSON_PROPERTY_COST_UNIT_PRICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCostUnitPrice(String costUnitPrice) {
    this.costUnitPrice = costUnitPrice;
  }


  public TransactionFeeSummary burned(String burned) {
    this.burned = burned;
    return this;
  }

   /**
   * Get burned
   * @return burned
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BURNED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBurned() {
    return burned;
  }


  @JsonProperty(JSON_PROPERTY_BURNED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBurned(String burned) {
    this.burned = burned;
  }


  public TransactionFeeSummary tipped(String tipped) {
    this.tipped = tipped;
    return this;
  }

   /**
   * Get tipped
   * @return tipped
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TIPPED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTipped() {
    return tipped;
  }


  @JsonProperty(JSON_PROPERTY_TIPPED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTipped(String tipped) {
    this.tipped = tipped;
  }


  /**
   * Return true if this TransactionFeeSummary object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionFeeSummary transactionFeeSummary = (TransactionFeeSummary) o;
    return Objects.equals(this.costUnitLimit, transactionFeeSummary.costUnitLimit) &&
        Objects.equals(this.costUnitConsumed, transactionFeeSummary.costUnitConsumed) &&
        Objects.equals(this.costUnitPrice, transactionFeeSummary.costUnitPrice) &&
        Objects.equals(this.burned, transactionFeeSummary.burned) &&
        Objects.equals(this.tipped, transactionFeeSummary.tipped);
  }

  @Override
  public int hashCode() {
    return Objects.hash(costUnitLimit, costUnitConsumed, costUnitPrice, burned, tipped);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionFeeSummary {\n");
    sb.append("    costUnitLimit: ").append(toIndentedString(costUnitLimit)).append("\n");
    sb.append("    costUnitConsumed: ").append(toIndentedString(costUnitConsumed)).append("\n");
    sb.append("    costUnitPrice: ").append(toIndentedString(costUnitPrice)).append("\n");
    sb.append("    burned: ").append(toIndentedString(burned)).append("\n");
    sb.append("    tipped: ").append(toIndentedString(tipped)).append("\n");
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

