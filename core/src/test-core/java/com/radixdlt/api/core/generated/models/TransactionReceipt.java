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
import com.radixdlt.api.core.generated.models.FeeSummary;
import com.radixdlt.api.core.generated.models.NextEpoch;
import com.radixdlt.api.core.generated.models.SborData;
import com.radixdlt.api.core.generated.models.StateUpdates;
import com.radixdlt.api.core.generated.models.TransactionStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The transaction execution receipt
 */
@ApiModel(description = "The transaction execution receipt")
@JsonPropertyOrder({
  TransactionReceipt.JSON_PROPERTY_STATUS,
  TransactionReceipt.JSON_PROPERTY_FEE_SUMMARY,
  TransactionReceipt.JSON_PROPERTY_STATE_UPDATES,
  TransactionReceipt.JSON_PROPERTY_NEXT_EPOCH,
  TransactionReceipt.JSON_PROPERTY_OUTPUT,
  TransactionReceipt.JSON_PROPERTY_ERROR_MESSAGE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionReceipt {
  public static final String JSON_PROPERTY_STATUS = "status";
  private TransactionStatus status;

  public static final String JSON_PROPERTY_FEE_SUMMARY = "fee_summary";
  private FeeSummary feeSummary;

  public static final String JSON_PROPERTY_STATE_UPDATES = "state_updates";
  private StateUpdates stateUpdates;

  public static final String JSON_PROPERTY_NEXT_EPOCH = "next_epoch";
  private NextEpoch nextEpoch;

  public static final String JSON_PROPERTY_OUTPUT = "output";
  private List<SborData> output = null;

  public static final String JSON_PROPERTY_ERROR_MESSAGE = "error_message";
  private String errorMessage;

  public TransactionReceipt() { 
  }

  public TransactionReceipt status(TransactionStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TransactionStatus getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(TransactionStatus status) {
    this.status = status;
  }


  public TransactionReceipt feeSummary(FeeSummary feeSummary) {
    this.feeSummary = feeSummary;
    return this;
  }

   /**
   * Get feeSummary
   * @return feeSummary
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FEE_SUMMARY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public FeeSummary getFeeSummary() {
    return feeSummary;
  }


  @JsonProperty(JSON_PROPERTY_FEE_SUMMARY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFeeSummary(FeeSummary feeSummary) {
    this.feeSummary = feeSummary;
  }


  public TransactionReceipt stateUpdates(StateUpdates stateUpdates) {
    this.stateUpdates = stateUpdates;
    return this;
  }

   /**
   * Get stateUpdates
   * @return stateUpdates
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATE_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public StateUpdates getStateUpdates() {
    return stateUpdates;
  }


  @JsonProperty(JSON_PROPERTY_STATE_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStateUpdates(StateUpdates stateUpdates) {
    this.stateUpdates = stateUpdates;
  }


  public TransactionReceipt nextEpoch(NextEpoch nextEpoch) {
    this.nextEpoch = nextEpoch;
    return this;
  }

   /**
   * Get nextEpoch
   * @return nextEpoch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NEXT_EPOCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NextEpoch getNextEpoch() {
    return nextEpoch;
  }


  @JsonProperty(JSON_PROPERTY_NEXT_EPOCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNextEpoch(NextEpoch nextEpoch) {
    this.nextEpoch = nextEpoch;
  }


  public TransactionReceipt output(List<SborData> output) {
    this.output = output;
    return this;
  }

  public TransactionReceipt addOutputItem(SborData outputItem) {
    if (this.output == null) {
      this.output = new ArrayList<>();
    }
    this.output.add(outputItem);
    return this;
  }

   /**
   * The manifest line-by-line engine return data (only present if status is Succeeded)
   * @return output
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The manifest line-by-line engine return data (only present if status is Succeeded)")
  @JsonProperty(JSON_PROPERTY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SborData> getOutput() {
    return output;
  }


  @JsonProperty(JSON_PROPERTY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOutput(List<SborData> output) {
    this.output = output;
  }


  public TransactionReceipt errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

   /**
   * Error message (only present if status is Failed or Rejected)
   * @return errorMessage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Error message (only present if status is Failed or Rejected)")
  @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getErrorMessage() {
    return errorMessage;
  }


  @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }


  /**
   * Return true if this TransactionReceipt object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionReceipt transactionReceipt = (TransactionReceipt) o;
    return Objects.equals(this.status, transactionReceipt.status) &&
        Objects.equals(this.feeSummary, transactionReceipt.feeSummary) &&
        Objects.equals(this.stateUpdates, transactionReceipt.stateUpdates) &&
        Objects.equals(this.nextEpoch, transactionReceipt.nextEpoch) &&
        Objects.equals(this.output, transactionReceipt.output) &&
        Objects.equals(this.errorMessage, transactionReceipt.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, feeSummary, stateUpdates, nextEpoch, output, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionReceipt {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    feeSummary: ").append(toIndentedString(feeSummary)).append("\n");
    sb.append("    stateUpdates: ").append(toIndentedString(stateUpdates)).append("\n");
    sb.append("    nextEpoch: ").append(toIndentedString(nextEpoch)).append("\n");
    sb.append("    output: ").append(toIndentedString(output)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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

