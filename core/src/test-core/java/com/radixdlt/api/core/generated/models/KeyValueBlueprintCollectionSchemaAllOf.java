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
import com.radixdlt.api.core.generated.models.BlueprintTypeReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * KeyValueBlueprintCollectionSchemaAllOf
 */
@JsonPropertyOrder({
  KeyValueBlueprintCollectionSchemaAllOf.JSON_PROPERTY_KEY_TYPE_REFERENCE,
  KeyValueBlueprintCollectionSchemaAllOf.JSON_PROPERTY_VALUE_TYPE_REFERENCE,
  KeyValueBlueprintCollectionSchemaAllOf.JSON_PROPERTY_CAN_OWN
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class KeyValueBlueprintCollectionSchemaAllOf {
  public static final String JSON_PROPERTY_KEY_TYPE_REFERENCE = "key_type_reference";
  private BlueprintTypeReference keyTypeReference;

  public static final String JSON_PROPERTY_VALUE_TYPE_REFERENCE = "value_type_reference";
  private BlueprintTypeReference valueTypeReference;

  public static final String JSON_PROPERTY_CAN_OWN = "can_own";
  private Boolean canOwn;

  public KeyValueBlueprintCollectionSchemaAllOf() { 
  }

  public KeyValueBlueprintCollectionSchemaAllOf keyTypeReference(BlueprintTypeReference keyTypeReference) {
    this.keyTypeReference = keyTypeReference;
    return this;
  }

   /**
   * Get keyTypeReference
   * @return keyTypeReference
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KEY_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintTypeReference getKeyTypeReference() {
    return keyTypeReference;
  }


  @JsonProperty(JSON_PROPERTY_KEY_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKeyTypeReference(BlueprintTypeReference keyTypeReference) {
    this.keyTypeReference = keyTypeReference;
  }


  public KeyValueBlueprintCollectionSchemaAllOf valueTypeReference(BlueprintTypeReference valueTypeReference) {
    this.valueTypeReference = valueTypeReference;
    return this;
  }

   /**
   * Get valueTypeReference
   * @return valueTypeReference
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintTypeReference getValueTypeReference() {
    return valueTypeReference;
  }


  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValueTypeReference(BlueprintTypeReference valueTypeReference) {
    this.valueTypeReference = valueTypeReference;
  }


  public KeyValueBlueprintCollectionSchemaAllOf canOwn(Boolean canOwn) {
    this.canOwn = canOwn;
    return this;
  }

   /**
   * Whether the entries of the key-value store are allowed to own child nodes.
   * @return canOwn
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the entries of the key-value store are allowed to own child nodes.")
  @JsonProperty(JSON_PROPERTY_CAN_OWN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getCanOwn() {
    return canOwn;
  }


  @JsonProperty(JSON_PROPERTY_CAN_OWN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCanOwn(Boolean canOwn) {
    this.canOwn = canOwn;
  }


  /**
   * Return true if this KeyValueBlueprintCollectionSchema_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyValueBlueprintCollectionSchemaAllOf keyValueBlueprintCollectionSchemaAllOf = (KeyValueBlueprintCollectionSchemaAllOf) o;
    return Objects.equals(this.keyTypeReference, keyValueBlueprintCollectionSchemaAllOf.keyTypeReference) &&
        Objects.equals(this.valueTypeReference, keyValueBlueprintCollectionSchemaAllOf.valueTypeReference) &&
        Objects.equals(this.canOwn, keyValueBlueprintCollectionSchemaAllOf.canOwn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyTypeReference, valueTypeReference, canOwn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueBlueprintCollectionSchemaAllOf {\n");
    sb.append("    keyTypeReference: ").append(toIndentedString(keyTypeReference)).append("\n");
    sb.append("    valueTypeReference: ").append(toIndentedString(valueTypeReference)).append("\n");
    sb.append("    canOwn: ").append(toIndentedString(canOwn)).append("\n");
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

