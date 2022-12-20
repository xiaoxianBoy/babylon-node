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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TransactionSubmitResponse
 */
@JsonPropertyOrder({
  TransactionSubmitResponse.JSON_PROPERTY_DUPLICATE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionSubmitResponse {
  public static final String JSON_PROPERTY_DUPLICATE = "duplicate";
  private Boolean duplicate;

  public TransactionSubmitResponse() { 
  }

  public TransactionSubmitResponse duplicate(Boolean duplicate) {
    this.duplicate = duplicate;
    return this;
  }

   /**
   * Is true if the transaction is a duplicate of an existing transaction in the mempool.
   * @return duplicate
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Is true if the transaction is a duplicate of an existing transaction in the mempool.")
  @JsonProperty(JSON_PROPERTY_DUPLICATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getDuplicate() {
    return duplicate;
  }


  @JsonProperty(JSON_PROPERTY_DUPLICATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDuplicate(Boolean duplicate) {
    this.duplicate = duplicate;
  }


  /**
   * Return true if this TransactionSubmitResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionSubmitResponse transactionSubmitResponse = (TransactionSubmitResponse) o;
    return Objects.equals(this.duplicate, transactionSubmitResponse.duplicate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(duplicate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionSubmitResponse {\n");
    sb.append("    duplicate: ").append(toIndentedString(duplicate)).append("\n");
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
