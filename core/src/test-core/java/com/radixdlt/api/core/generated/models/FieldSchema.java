/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
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
import com.radixdlt.api.core.generated.models.FieldSchemaFeatureCondition;
import com.radixdlt.api.core.generated.models.TypePointer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * FieldSchema
 */
@JsonPropertyOrder({
  FieldSchema.JSON_PROPERTY_FIELD_TYPE_POINTER,
  FieldSchema.JSON_PROPERTY_CONDITION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FieldSchema {
  public static final String JSON_PROPERTY_FIELD_TYPE_POINTER = "field_type_pointer";
  private TypePointer fieldTypePointer;

  public static final String JSON_PROPERTY_CONDITION = "condition";
  private FieldSchemaFeatureCondition condition;

  public FieldSchema() { 
  }

  public FieldSchema fieldTypePointer(TypePointer fieldTypePointer) {
    this.fieldTypePointer = fieldTypePointer;
    return this;
  }

   /**
   * Get fieldTypePointer
   * @return fieldTypePointer
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FIELD_TYPE_POINTER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypePointer getFieldTypePointer() {
    return fieldTypePointer;
  }


  @JsonProperty(JSON_PROPERTY_FIELD_TYPE_POINTER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFieldTypePointer(TypePointer fieldTypePointer) {
    this.fieldTypePointer = fieldTypePointer;
  }


  public FieldSchema condition(FieldSchemaFeatureCondition condition) {
    this.condition = condition;
    return this;
  }

   /**
   * Get condition
   * @return condition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONDITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FieldSchemaFeatureCondition getCondition() {
    return condition;
  }


  @JsonProperty(JSON_PROPERTY_CONDITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCondition(FieldSchemaFeatureCondition condition) {
    this.condition = condition;
  }


  /**
   * Return true if this FieldSchema object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldSchema fieldSchema = (FieldSchema) o;
    return Objects.equals(this.fieldTypePointer, fieldSchema.fieldTypePointer) &&
        Objects.equals(this.condition, fieldSchema.condition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldTypePointer, condition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldSchema {\n");
    sb.append("    fieldTypePointer: ").append(toIndentedString(fieldTypePointer)).append("\n");
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
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

