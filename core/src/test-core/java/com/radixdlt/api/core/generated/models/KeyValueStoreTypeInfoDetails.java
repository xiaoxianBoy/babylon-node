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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.KeyValueStoreSchema;
import com.radixdlt.api.core.generated.models.KeyValueStoreTypeInfoDetails;
import com.radixdlt.api.core.generated.models.KeyValueStoreTypeInfoDetailsAllOf;
import com.radixdlt.api.core.generated.models.ObjectTypeInfoDetails;
import com.radixdlt.api.core.generated.models.TypeInfoDetails;
import com.radixdlt.api.core.generated.models.TypeInfoType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * KeyValueStoreTypeInfoDetails
 */
@JsonPropertyOrder({
  KeyValueStoreTypeInfoDetails.JSON_PROPERTY_KEY_VALUE_STORE_SCHEMA
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = KeyValueStoreTypeInfoDetails.class, name = "KeyValueStore"),
  @JsonSubTypes.Type(value = ObjectTypeInfoDetails.class, name = "Object"),
})

public class KeyValueStoreTypeInfoDetails extends TypeInfoDetails {
  public static final String JSON_PROPERTY_KEY_VALUE_STORE_SCHEMA = "key_value_store_schema";
  private KeyValueStoreSchema keyValueStoreSchema;

  public KeyValueStoreTypeInfoDetails() { 
  }

  public KeyValueStoreTypeInfoDetails keyValueStoreSchema(KeyValueStoreSchema keyValueStoreSchema) {
    this.keyValueStoreSchema = keyValueStoreSchema;
    return this;
  }

   /**
   * Get keyValueStoreSchema
   * @return keyValueStoreSchema
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KEY_VALUE_STORE_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public KeyValueStoreSchema getKeyValueStoreSchema() {
    return keyValueStoreSchema;
  }


  @JsonProperty(JSON_PROPERTY_KEY_VALUE_STORE_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKeyValueStoreSchema(KeyValueStoreSchema keyValueStoreSchema) {
    this.keyValueStoreSchema = keyValueStoreSchema;
  }


  /**
   * Return true if this KeyValueStoreTypeInfoDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyValueStoreTypeInfoDetails keyValueStoreTypeInfoDetails = (KeyValueStoreTypeInfoDetails) o;
    return Objects.equals(this.keyValueStoreSchema, keyValueStoreTypeInfoDetails.keyValueStoreSchema) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyValueStoreSchema, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueStoreTypeInfoDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    keyValueStoreSchema: ").append(toIndentedString(keyValueStoreSchema)).append("\n");
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
  mappings.put("KeyValueStore", KeyValueStoreTypeInfoDetails.class);
  mappings.put("Object", ObjectTypeInfoDetails.class);
  mappings.put("KeyValueStoreTypeInfoDetails", KeyValueStoreTypeInfoDetails.class);
  JSON.registerDiscriminator(KeyValueStoreTypeInfoDetails.class, "type", mappings);
}
}
