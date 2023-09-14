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
import com.radixdlt.api.core.generated.models.FieldSchemaFeatureCondition;
import com.radixdlt.api.core.generated.models.FieldSchemaFeatureConditionAlways;
import com.radixdlt.api.core.generated.models.FieldSchemaFeatureConditionIfOuterObjectFeature;
import com.radixdlt.api.core.generated.models.FieldSchemaFeatureConditionIfOwnFeature;
import com.radixdlt.api.core.generated.models.FieldSchemaFeatureConditionIfOwnFeatureAllOf;
import com.radixdlt.api.core.generated.models.FieldSchemaFeatureConditionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * FieldSchemaFeatureConditionIfOwnFeature
 */
@JsonPropertyOrder({
  FieldSchemaFeatureConditionIfOwnFeature.JSON_PROPERTY_FEATURE_NAME
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = FieldSchemaFeatureConditionAlways.class, name = "Always"),
  @JsonSubTypes.Type(value = FieldSchemaFeatureConditionIfOuterObjectFeature.class, name = "IfOuterObjectFeature"),
  @JsonSubTypes.Type(value = FieldSchemaFeatureConditionIfOwnFeature.class, name = "IfOwnFeature"),
})

public class FieldSchemaFeatureConditionIfOwnFeature extends FieldSchemaFeatureCondition {
  public static final String JSON_PROPERTY_FEATURE_NAME = "feature_name";
  private String featureName;

  public FieldSchemaFeatureConditionIfOwnFeature() { 
  }

  public FieldSchemaFeatureConditionIfOwnFeature featureName(String featureName) {
    this.featureName = featureName;
    return this;
  }

   /**
   * Get featureName
   * @return featureName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FEATURE_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFeatureName() {
    return featureName;
  }


  @JsonProperty(JSON_PROPERTY_FEATURE_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFeatureName(String featureName) {
    this.featureName = featureName;
  }


  /**
   * Return true if this FieldSchemaFeatureConditionIfOwnFeature object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldSchemaFeatureConditionIfOwnFeature fieldSchemaFeatureConditionIfOwnFeature = (FieldSchemaFeatureConditionIfOwnFeature) o;
    return Objects.equals(this.featureName, fieldSchemaFeatureConditionIfOwnFeature.featureName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(featureName, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldSchemaFeatureConditionIfOwnFeature {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    featureName: ").append(toIndentedString(featureName)).append("\n");
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
  mappings.put("Always", FieldSchemaFeatureConditionAlways.class);
  mappings.put("IfOuterObjectFeature", FieldSchemaFeatureConditionIfOuterObjectFeature.class);
  mappings.put("IfOwnFeature", FieldSchemaFeatureConditionIfOwnFeature.class);
  mappings.put("FieldSchemaFeatureConditionIfOwnFeature", FieldSchemaFeatureConditionIfOwnFeature.class);
  JSON.registerDiscriminator(FieldSchemaFeatureConditionIfOwnFeature.class, "type", mappings);
}
}

