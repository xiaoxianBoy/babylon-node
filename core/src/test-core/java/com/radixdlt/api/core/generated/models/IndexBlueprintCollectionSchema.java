/*
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
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
import com.radixdlt.api.core.generated.models.BlueprintCollectionSchema;
import com.radixdlt.api.core.generated.models.BlueprintCollectionSchemaType;
import com.radixdlt.api.core.generated.models.BlueprintPayloadDef;
import com.radixdlt.api.core.generated.models.IndexBlueprintCollectionSchema;
import com.radixdlt.api.core.generated.models.IndexBlueprintCollectionSchemaAllOf;
import com.radixdlt.api.core.generated.models.KeyValueBlueprintCollectionSchema;
import com.radixdlt.api.core.generated.models.SortedIndexBlueprintCollectionSchema;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * IndexBlueprintCollectionSchema
 */
@JsonPropertyOrder({
  IndexBlueprintCollectionSchema.JSON_PROPERTY_KEY_TYPE_REF,
  IndexBlueprintCollectionSchema.JSON_PROPERTY_VALUE_TYPE_REF,
  IndexBlueprintCollectionSchema.JSON_PROPERTY_ALLOW_OWNERSHIP
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = IndexBlueprintCollectionSchema.class, name = "Index"),
  @JsonSubTypes.Type(value = KeyValueBlueprintCollectionSchema.class, name = "KeyValue"),
  @JsonSubTypes.Type(value = SortedIndexBlueprintCollectionSchema.class, name = "SortedIndex"),
})

public class IndexBlueprintCollectionSchema extends BlueprintCollectionSchema {
  public static final String JSON_PROPERTY_KEY_TYPE_REF = "key_type_ref";
  private BlueprintPayloadDef keyTypeRef;

  public static final String JSON_PROPERTY_VALUE_TYPE_REF = "value_type_ref";
  private BlueprintPayloadDef valueTypeRef;

  public static final String JSON_PROPERTY_ALLOW_OWNERSHIP = "allow_ownership";
  private Boolean allowOwnership;

  public IndexBlueprintCollectionSchema() { 
  }

  public IndexBlueprintCollectionSchema keyTypeRef(BlueprintPayloadDef keyTypeRef) {
    this.keyTypeRef = keyTypeRef;
    return this;
  }

   /**
   * Get keyTypeRef
   * @return keyTypeRef
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KEY_TYPE_REF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintPayloadDef getKeyTypeRef() {
    return keyTypeRef;
  }


  @JsonProperty(JSON_PROPERTY_KEY_TYPE_REF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKeyTypeRef(BlueprintPayloadDef keyTypeRef) {
    this.keyTypeRef = keyTypeRef;
  }


  public IndexBlueprintCollectionSchema valueTypeRef(BlueprintPayloadDef valueTypeRef) {
    this.valueTypeRef = valueTypeRef;
    return this;
  }

   /**
   * Get valueTypeRef
   * @return valueTypeRef
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_REF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintPayloadDef getValueTypeRef() {
    return valueTypeRef;
  }


  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_REF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValueTypeRef(BlueprintPayloadDef valueTypeRef) {
    this.valueTypeRef = valueTypeRef;
  }


  public IndexBlueprintCollectionSchema allowOwnership(Boolean allowOwnership) {
    this.allowOwnership = allowOwnership;
    return this;
  }

   /**
   * Whether the entries of the index partition are allowed to own child nodes.
   * @return allowOwnership
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the entries of the index partition are allowed to own child nodes.")
  @JsonProperty(JSON_PROPERTY_ALLOW_OWNERSHIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getAllowOwnership() {
    return allowOwnership;
  }


  @JsonProperty(JSON_PROPERTY_ALLOW_OWNERSHIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAllowOwnership(Boolean allowOwnership) {
    this.allowOwnership = allowOwnership;
  }


  /**
   * Return true if this IndexBlueprintCollectionSchema object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexBlueprintCollectionSchema indexBlueprintCollectionSchema = (IndexBlueprintCollectionSchema) o;
    return Objects.equals(this.keyTypeRef, indexBlueprintCollectionSchema.keyTypeRef) &&
        Objects.equals(this.valueTypeRef, indexBlueprintCollectionSchema.valueTypeRef) &&
        Objects.equals(this.allowOwnership, indexBlueprintCollectionSchema.allowOwnership) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyTypeRef, valueTypeRef, allowOwnership, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexBlueprintCollectionSchema {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    keyTypeRef: ").append(toIndentedString(keyTypeRef)).append("\n");
    sb.append("    valueTypeRef: ").append(toIndentedString(valueTypeRef)).append("\n");
    sb.append("    allowOwnership: ").append(toIndentedString(allowOwnership)).append("\n");
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
  mappings.put("Index", IndexBlueprintCollectionSchema.class);
  mappings.put("KeyValue", KeyValueBlueprintCollectionSchema.class);
  mappings.put("SortedIndex", SortedIndexBlueprintCollectionSchema.class);
  mappings.put("IndexBlueprintCollectionSchema", IndexBlueprintCollectionSchema.class);
  JSON.registerDiscriminator(IndexBlueprintCollectionSchema.class, "type", mappings);
}
}

