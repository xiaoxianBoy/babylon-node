/*
 * Radix System API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.system.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.system.generated.models.EnactAtStartOfAnEpochIfSupportedAndWithinBoundsCondition;
import com.radixdlt.api.system.generated.models.EnactUnconditionallyAtEpochCondition;
import com.radixdlt.api.system.generated.models.ProtocolUpdateEnactmentConditionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.common.JSON;
/**
 * ProtocolUpdateEnactmentCondition
 */
@JsonPropertyOrder({
  ProtocolUpdateEnactmentCondition.JSON_PROPERTY_TYPE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = EnactAtStartOfAnEpochIfSupportedAndWithinBoundsCondition.class, name = "EnactAtStartOfAnEpochIfSupportedAndWithinBounds"),
  @JsonSubTypes.Type(value = EnactAtStartOfAnEpochIfSupportedAndWithinBoundsCondition.class, name = "EnactAtStartOfAnEpochIfSupportedAndWithinBoundsCondition"),
  @JsonSubTypes.Type(value = EnactUnconditionallyAtEpochCondition.class, name = "EnactUnconditionallyAtEpoch"),
  @JsonSubTypes.Type(value = EnactUnconditionallyAtEpochCondition.class, name = "EnactUnconditionallyAtEpochCondition"),
})

public class ProtocolUpdateEnactmentCondition {
  public static final String JSON_PROPERTY_TYPE = "type";
  private ProtocolUpdateEnactmentConditionType type;


  public ProtocolUpdateEnactmentCondition type(ProtocolUpdateEnactmentConditionType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ProtocolUpdateEnactmentConditionType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(ProtocolUpdateEnactmentConditionType type) {
    this.type = type;
  }


  /**
   * Return true if this ProtocolUpdateEnactmentCondition object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProtocolUpdateEnactmentCondition protocolUpdateEnactmentCondition = (ProtocolUpdateEnactmentCondition) o;
    return Objects.equals(this.type, protocolUpdateEnactmentCondition.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProtocolUpdateEnactmentCondition {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
  mappings.put("EnactAtStartOfAnEpochIfSupportedAndWithinBounds", EnactAtStartOfAnEpochIfSupportedAndWithinBoundsCondition.class);
  mappings.put("EnactAtStartOfAnEpochIfSupportedAndWithinBoundsCondition", EnactAtStartOfAnEpochIfSupportedAndWithinBoundsCondition.class);
  mappings.put("EnactUnconditionallyAtEpoch", EnactUnconditionallyAtEpochCondition.class);
  mappings.put("EnactUnconditionallyAtEpochCondition", EnactUnconditionallyAtEpochCondition.class);
  mappings.put("ProtocolUpdateEnactmentCondition", ProtocolUpdateEnactmentCondition.class);
  JSON.registerDiscriminator(ProtocolUpdateEnactmentCondition.class, "type", mappings);
}
}
