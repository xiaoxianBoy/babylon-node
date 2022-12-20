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
import com.radixdlt.api.core.generated.models.DynamicResourceDescriptorListBase;
import com.radixdlt.api.core.generated.models.DynamicResourceDescriptorListType;
import com.radixdlt.api.core.generated.models.SchemaPathDynamicAmountAllOf;
import com.radixdlt.api.core.generated.models.SchemaSubpath;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SchemaPathDynamicResourceDescriptorList
 */
@JsonPropertyOrder({
  SchemaPathDynamicResourceDescriptorList.JSON_PROPERTY_TYPE,
  SchemaPathDynamicResourceDescriptorList.JSON_PROPERTY_SCHEMA_PATH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SchemaPathDynamicResourceDescriptorList {
  public static final String JSON_PROPERTY_TYPE = "type";
  private DynamicResourceDescriptorListType type;

  public static final String JSON_PROPERTY_SCHEMA_PATH = "schema_path";
  private List<SchemaSubpath> schemaPath = new ArrayList<>();

  public SchemaPathDynamicResourceDescriptorList() { 
  }

  public SchemaPathDynamicResourceDescriptorList type(DynamicResourceDescriptorListType type) {
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

  public DynamicResourceDescriptorListType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(DynamicResourceDescriptorListType type) {
    this.type = type;
  }


  public SchemaPathDynamicResourceDescriptorList schemaPath(List<SchemaSubpath> schemaPath) {
    this.schemaPath = schemaPath;
    return this;
  }

  public SchemaPathDynamicResourceDescriptorList addSchemaPathItem(SchemaSubpath schemaPathItem) {
    this.schemaPath.add(schemaPathItem);
    return this;
  }

   /**
   * Get schemaPath
   * @return schemaPath
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SCHEMA_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SchemaSubpath> getSchemaPath() {
    return schemaPath;
  }


  @JsonProperty(JSON_PROPERTY_SCHEMA_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSchemaPath(List<SchemaSubpath> schemaPath) {
    this.schemaPath = schemaPath;
  }


  /**
   * Return true if this SchemaPathDynamicResourceDescriptorList object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SchemaPathDynamicResourceDescriptorList schemaPathDynamicResourceDescriptorList = (SchemaPathDynamicResourceDescriptorList) o;
    return Objects.equals(this.type, schemaPathDynamicResourceDescriptorList.type) &&
        Objects.equals(this.schemaPath, schemaPathDynamicResourceDescriptorList.schemaPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, schemaPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchemaPathDynamicResourceDescriptorList {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaPath: ").append(toIndentedString(schemaPath)).append("\n");
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
