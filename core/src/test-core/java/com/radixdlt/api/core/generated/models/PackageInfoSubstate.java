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
import com.radixdlt.api.core.generated.models.BlueprintData;
import com.radixdlt.api.core.generated.models.PackageInfoSubstateAllOf;
import com.radixdlt.api.core.generated.models.SubstateBase;
import com.radixdlt.api.core.generated.models.SubstateType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PackageInfoSubstate
 */
@JsonPropertyOrder({
  PackageInfoSubstate.JSON_PROPERTY_SUBSTATE_TYPE,
  PackageInfoSubstate.JSON_PROPERTY_CODE_HEX,
  PackageInfoSubstate.JSON_PROPERTY_BLUEPRINTS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PackageInfoSubstate {
  public static final String JSON_PROPERTY_SUBSTATE_TYPE = "substate_type";
  private SubstateType substateType;

  public static final String JSON_PROPERTY_CODE_HEX = "code_hex";
  private String codeHex;

  public static final String JSON_PROPERTY_BLUEPRINTS = "blueprints";
  private Map<String, BlueprintData> blueprints = new HashMap<>();

  public PackageInfoSubstate() { 
  }

  public PackageInfoSubstate substateType(SubstateType substateType) {
    this.substateType = substateType;
    return this;
  }

   /**
   * Get substateType
   * @return substateType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SUBSTATE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SubstateType getSubstateType() {
    return substateType;
  }


  @JsonProperty(JSON_PROPERTY_SUBSTATE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubstateType(SubstateType substateType) {
    this.substateType = substateType;
  }


  public PackageInfoSubstate codeHex(String codeHex) {
    this.codeHex = codeHex;
    return this;
  }

   /**
   * The hex-encoded package code
   * @return codeHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded package code")
  @JsonProperty(JSON_PROPERTY_CODE_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCodeHex() {
    return codeHex;
  }


  @JsonProperty(JSON_PROPERTY_CODE_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCodeHex(String codeHex) {
    this.codeHex = codeHex;
  }


  public PackageInfoSubstate blueprints(Map<String, BlueprintData> blueprints) {
    this.blueprints = blueprints;
    return this;
  }

  public PackageInfoSubstate putBlueprintsItem(String key, BlueprintData blueprintsItem) {
    this.blueprints.put(key, blueprintsItem);
    return this;
  }

   /**
   * A map from the blueprint name to BlueprintData
   * @return blueprints
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A map from the blueprint name to BlueprintData")
  @JsonProperty(JSON_PROPERTY_BLUEPRINTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Map<String, BlueprintData> getBlueprints() {
    return blueprints;
  }


  @JsonProperty(JSON_PROPERTY_BLUEPRINTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBlueprints(Map<String, BlueprintData> blueprints) {
    this.blueprints = blueprints;
  }


  /**
   * Return true if this PackageInfoSubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackageInfoSubstate packageInfoSubstate = (PackageInfoSubstate) o;
    return Objects.equals(this.substateType, packageInfoSubstate.substateType) &&
        Objects.equals(this.codeHex, packageInfoSubstate.codeHex) &&
        Objects.equals(this.blueprints, packageInfoSubstate.blueprints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(substateType, codeHex, blueprints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageInfoSubstate {\n");
    sb.append("    substateType: ").append(toIndentedString(substateType)).append("\n");
    sb.append("    codeHex: ").append(toIndentedString(codeHex)).append("\n");
    sb.append("    blueprints: ").append(toIndentedString(blueprints)).append("\n");
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
