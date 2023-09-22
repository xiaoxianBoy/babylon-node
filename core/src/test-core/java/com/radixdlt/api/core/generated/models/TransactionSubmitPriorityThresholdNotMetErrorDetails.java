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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitPriorityThresholdNotMetErrorDetailsAllOf;
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorDetails;
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorDetailsType;
import com.radixdlt.api.core.generated.models.TransactionSubmitIntentAlreadyCommitted;
import com.radixdlt.api.core.generated.models.TransactionSubmitPriorityThresholdNotMetErrorDetails;
import com.radixdlt.api.core.generated.models.TransactionSubmitRejectedErrorDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * TransactionSubmitPriorityThresholdNotMetErrorDetails
 */
@JsonPropertyOrder({
  TransactionSubmitPriorityThresholdNotMetErrorDetails.JSON_PROPERTY_TIP_PERCENTAGE,
  TransactionSubmitPriorityThresholdNotMetErrorDetails.JSON_PROPERTY_MIN_TIP_PERCENTAGE_REQUIRED
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = TransactionSubmitIntentAlreadyCommitted.class, name = "IntentAlreadyCommitted"),
  @JsonSubTypes.Type(value = TransactionSubmitPriorityThresholdNotMetErrorDetails.class, name = "PriorityThresholdNotMet"),
  @JsonSubTypes.Type(value = TransactionSubmitRejectedErrorDetails.class, name = "Rejected"),
})

public class TransactionSubmitPriorityThresholdNotMetErrorDetails extends TransactionSubmitErrorDetails {
  public static final String JSON_PROPERTY_TIP_PERCENTAGE = "tip_percentage";
  private Integer tipPercentage;

  public static final String JSON_PROPERTY_MIN_TIP_PERCENTAGE_REQUIRED = "min_tip_percentage_required";
  private Integer minTipPercentageRequired;

  public TransactionSubmitPriorityThresholdNotMetErrorDetails() { 
  }

  public TransactionSubmitPriorityThresholdNotMetErrorDetails tipPercentage(Integer tipPercentage) {
    this.tipPercentage = tipPercentage;
    return this;
  }

   /**
   * Tip percentage of the submitted (and rejected) transaction. 
   * minimum: 0
   * maximum: 65535
   * @return tipPercentage
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Tip percentage of the submitted (and rejected) transaction. ")
  @JsonProperty(JSON_PROPERTY_TIP_PERCENTAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getTipPercentage() {
    return tipPercentage;
  }


  @JsonProperty(JSON_PROPERTY_TIP_PERCENTAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTipPercentage(Integer tipPercentage) {
    this.tipPercentage = tipPercentage;
  }


  public TransactionSubmitPriorityThresholdNotMetErrorDetails minTipPercentageRequired(Integer minTipPercentageRequired) {
    this.minTipPercentageRequired = minTipPercentageRequired;
    return this;
  }

   /**
   * A lower bound for tip percentage at current mempool state. Anything lower than this will very likely result in a mempool rejection. A missing value means there is no tip that can guarantee submission. 
   * minimum: 0
   * maximum: 65535
   * @return minTipPercentageRequired
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A lower bound for tip percentage at current mempool state. Anything lower than this will very likely result in a mempool rejection. A missing value means there is no tip that can guarantee submission. ")
  @JsonProperty(JSON_PROPERTY_MIN_TIP_PERCENTAGE_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMinTipPercentageRequired() {
    return minTipPercentageRequired;
  }


  @JsonProperty(JSON_PROPERTY_MIN_TIP_PERCENTAGE_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMinTipPercentageRequired(Integer minTipPercentageRequired) {
    this.minTipPercentageRequired = minTipPercentageRequired;
  }


  /**
   * Return true if this TransactionSubmitPriorityThresholdNotMetErrorDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionSubmitPriorityThresholdNotMetErrorDetails transactionSubmitPriorityThresholdNotMetErrorDetails = (TransactionSubmitPriorityThresholdNotMetErrorDetails) o;
    return Objects.equals(this.tipPercentage, transactionSubmitPriorityThresholdNotMetErrorDetails.tipPercentage) &&
        Objects.equals(this.minTipPercentageRequired, transactionSubmitPriorityThresholdNotMetErrorDetails.minTipPercentageRequired) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipPercentage, minTipPercentageRequired, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionSubmitPriorityThresholdNotMetErrorDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    tipPercentage: ").append(toIndentedString(tipPercentage)).append("\n");
    sb.append("    minTipPercentageRequired: ").append(toIndentedString(minTipPercentageRequired)).append("\n");
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
  mappings.put("IntentAlreadyCommitted", TransactionSubmitIntentAlreadyCommitted.class);
  mappings.put("PriorityThresholdNotMet", TransactionSubmitPriorityThresholdNotMetErrorDetails.class);
  mappings.put("Rejected", TransactionSubmitRejectedErrorDetails.class);
  mappings.put("TransactionSubmitPriorityThresholdNotMetErrorDetails", TransactionSubmitPriorityThresholdNotMetErrorDetails.class);
  JSON.registerDiscriminator(TransactionSubmitPriorityThresholdNotMetErrorDetails.class, "type", mappings);
}
}

