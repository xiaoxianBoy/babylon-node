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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.CommittedIntentMetadata;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitErrorDetails;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitErrorDetailsType;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitIntentAlreadyCommitted;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitIntentAlreadyCommittedAllOf;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitPriorityThresholdNotMetErrorDetails;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitRejectedErrorDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * LtsTransactionSubmitIntentAlreadyCommitted
 */
@JsonPropertyOrder({
  LtsTransactionSubmitIntentAlreadyCommitted.JSON_PROPERTY_COMMITTED_AS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = LtsTransactionSubmitIntentAlreadyCommitted.class, name = "IntentAlreadyCommitted"),
  @JsonSubTypes.Type(value = LtsTransactionSubmitPriorityThresholdNotMetErrorDetails.class, name = "PriorityThresholdNotMet"),
  @JsonSubTypes.Type(value = LtsTransactionSubmitRejectedErrorDetails.class, name = "Rejected"),
})

public class LtsTransactionSubmitIntentAlreadyCommitted extends LtsTransactionSubmitErrorDetails {
  public static final String JSON_PROPERTY_COMMITTED_AS = "committed_as";
  private CommittedIntentMetadata committedAs;

  public LtsTransactionSubmitIntentAlreadyCommitted() { 
  }

  public LtsTransactionSubmitIntentAlreadyCommitted committedAs(CommittedIntentMetadata committedAs) {
    this.committedAs = committedAs;
    return this;
  }

   /**
   * Get committedAs
   * @return committedAs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COMMITTED_AS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CommittedIntentMetadata getCommittedAs() {
    return committedAs;
  }


  @JsonProperty(JSON_PROPERTY_COMMITTED_AS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCommittedAs(CommittedIntentMetadata committedAs) {
    this.committedAs = committedAs;
  }


  /**
   * Return true if this LtsTransactionSubmitIntentAlreadyCommitted object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LtsTransactionSubmitIntentAlreadyCommitted ltsTransactionSubmitIntentAlreadyCommitted = (LtsTransactionSubmitIntentAlreadyCommitted) o;
    return Objects.equals(this.committedAs, ltsTransactionSubmitIntentAlreadyCommitted.committedAs) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(committedAs, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LtsTransactionSubmitIntentAlreadyCommitted {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    committedAs: ").append(toIndentedString(committedAs)).append("\n");
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
  mappings.put("IntentAlreadyCommitted", LtsTransactionSubmitIntentAlreadyCommitted.class);
  mappings.put("PriorityThresholdNotMet", LtsTransactionSubmitPriorityThresholdNotMetErrorDetails.class);
  mappings.put("Rejected", LtsTransactionSubmitRejectedErrorDetails.class);
  mappings.put("LtsTransactionSubmitIntentAlreadyCommitted", LtsTransactionSubmitIntentAlreadyCommitted.class);
  JSON.registerDiscriminator(LtsTransactionSubmitIntentAlreadyCommitted.class, "type", mappings);
}
}

