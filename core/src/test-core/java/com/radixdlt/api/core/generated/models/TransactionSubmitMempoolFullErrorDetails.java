/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
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
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorDetails;
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorDetailsType;
import com.radixdlt.api.core.generated.models.TransactionSubmitMempoolFullErrorDetails;
import com.radixdlt.api.core.generated.models.TransactionSubmitMempoolFullErrorDetailsAllOf;
import com.radixdlt.api.core.generated.models.TransactionSubmitRejectedErrorDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * TransactionSubmitMempoolFullErrorDetails
 */
@JsonPropertyOrder({
  TransactionSubmitMempoolFullErrorDetails.JSON_PROPERTY_MEMPOOL_CAPACITY
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = TransactionSubmitMempoolFullErrorDetails.class, name = "MempoolFull"),
  @JsonSubTypes.Type(value = TransactionSubmitRejectedErrorDetails.class, name = "Rejected"),
})

public class TransactionSubmitMempoolFullErrorDetails extends TransactionSubmitErrorDetails {
  public static final String JSON_PROPERTY_MEMPOOL_CAPACITY = "mempool_capacity";
  private Integer mempoolCapacity;

  public TransactionSubmitMempoolFullErrorDetails() { 
  }

  public TransactionSubmitMempoolFullErrorDetails mempoolCapacity(Integer mempoolCapacity) {
    this.mempoolCapacity = mempoolCapacity;
    return this;
  }

   /**
   * Get mempoolCapacity
   * minimum: 0
   * maximum: 10000
   * @return mempoolCapacity
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_MEMPOOL_CAPACITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getMempoolCapacity() {
    return mempoolCapacity;
  }


  @JsonProperty(JSON_PROPERTY_MEMPOOL_CAPACITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMempoolCapacity(Integer mempoolCapacity) {
    this.mempoolCapacity = mempoolCapacity;
  }


  /**
   * Return true if this TransactionSubmitMempoolFullErrorDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionSubmitMempoolFullErrorDetails transactionSubmitMempoolFullErrorDetails = (TransactionSubmitMempoolFullErrorDetails) o;
    return Objects.equals(this.mempoolCapacity, transactionSubmitMempoolFullErrorDetails.mempoolCapacity) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mempoolCapacity, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionSubmitMempoolFullErrorDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    mempoolCapacity: ").append(toIndentedString(mempoolCapacity)).append("\n");
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
  mappings.put("MempoolFull", TransactionSubmitMempoolFullErrorDetails.class);
  mappings.put("Rejected", TransactionSubmitRejectedErrorDetails.class);
  mappings.put("TransactionSubmitMempoolFullErrorDetails", TransactionSubmitMempoolFullErrorDetails.class);
  JSON.registerDiscriminator(TransactionSubmitMempoolFullErrorDetails.class, "type", mappings);
}
}
