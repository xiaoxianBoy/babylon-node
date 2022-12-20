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
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.V0StateComponentDescendentId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * V0StateComponentResponse
 */
@JsonPropertyOrder({
  V0StateComponentResponse.JSON_PROPERTY_INFO,
  V0StateComponentResponse.JSON_PROPERTY_STATE,
  V0StateComponentResponse.JSON_PROPERTY_ROYALTY_CONFIG,
  V0StateComponentResponse.JSON_PROPERTY_ROYALTY_ACCUMULATOR,
  V0StateComponentResponse.JSON_PROPERTY_METADATA,
  V0StateComponentResponse.JSON_PROPERTY_ACCESS_RULES,
  V0StateComponentResponse.JSON_PROPERTY_STATE_OWNED_VAULTS,
  V0StateComponentResponse.JSON_PROPERTY_DESCENDENT_IDS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V0StateComponentResponse {
  public static final String JSON_PROPERTY_INFO = "info";
  private Substate info;

  public static final String JSON_PROPERTY_STATE = "state";
  private Substate state;

  public static final String JSON_PROPERTY_ROYALTY_CONFIG = "royalty_config";
  private Substate royaltyConfig;

  public static final String JSON_PROPERTY_ROYALTY_ACCUMULATOR = "royalty_accumulator";
  private Substate royaltyAccumulator;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Substate metadata;

  public static final String JSON_PROPERTY_ACCESS_RULES = "access_rules";
  private Substate accessRules;

  public static final String JSON_PROPERTY_STATE_OWNED_VAULTS = "state_owned_vaults";
  private List<Substate> stateOwnedVaults = new ArrayList<>();

  public static final String JSON_PROPERTY_DESCENDENT_IDS = "descendent_ids";
  private List<V0StateComponentDescendentId> descendentIds = new ArrayList<>();

  public V0StateComponentResponse() { 
  }

  public V0StateComponentResponse info(Substate info) {
    this.info = info;
    return this;
  }

   /**
   * Get info
   * @return info
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getInfo() {
    return info;
  }


  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInfo(Substate info) {
    this.info = info;
  }


  public V0StateComponentResponse state(Substate state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setState(Substate state) {
    this.state = state;
  }


  public V0StateComponentResponse royaltyConfig(Substate royaltyConfig) {
    this.royaltyConfig = royaltyConfig;
    return this;
  }

   /**
   * Get royaltyConfig
   * @return royaltyConfig
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ROYALTY_CONFIG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getRoyaltyConfig() {
    return royaltyConfig;
  }


  @JsonProperty(JSON_PROPERTY_ROYALTY_CONFIG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRoyaltyConfig(Substate royaltyConfig) {
    this.royaltyConfig = royaltyConfig;
  }


  public V0StateComponentResponse royaltyAccumulator(Substate royaltyAccumulator) {
    this.royaltyAccumulator = royaltyAccumulator;
    return this;
  }

   /**
   * Get royaltyAccumulator
   * @return royaltyAccumulator
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ROYALTY_ACCUMULATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getRoyaltyAccumulator() {
    return royaltyAccumulator;
  }


  @JsonProperty(JSON_PROPERTY_ROYALTY_ACCUMULATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRoyaltyAccumulator(Substate royaltyAccumulator) {
    this.royaltyAccumulator = royaltyAccumulator;
  }


  public V0StateComponentResponse metadata(Substate metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getMetadata() {
    return metadata;
  }


  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMetadata(Substate metadata) {
    this.metadata = metadata;
  }


  public V0StateComponentResponse accessRules(Substate accessRules) {
    this.accessRules = accessRules;
    return this;
  }

   /**
   * Get accessRules
   * @return accessRules
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACCESS_RULES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getAccessRules() {
    return accessRules;
  }


  @JsonProperty(JSON_PROPERTY_ACCESS_RULES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccessRules(Substate accessRules) {
    this.accessRules = accessRules;
  }


  public V0StateComponentResponse stateOwnedVaults(List<Substate> stateOwnedVaults) {
    this.stateOwnedVaults = stateOwnedVaults;
    return this;
  }

  public V0StateComponentResponse addStateOwnedVaultsItem(Substate stateOwnedVaultsItem) {
    this.stateOwnedVaults.add(stateOwnedVaultsItem);
    return this;
  }

   /**
   * Any vaults owned directly or indirectly by the component
   * @return stateOwnedVaults
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Any vaults owned directly or indirectly by the component")
  @JsonProperty(JSON_PROPERTY_STATE_OWNED_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Substate> getStateOwnedVaults() {
    return stateOwnedVaults;
  }


  @JsonProperty(JSON_PROPERTY_STATE_OWNED_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStateOwnedVaults(List<Substate> stateOwnedVaults) {
    this.stateOwnedVaults = stateOwnedVaults;
  }


  public V0StateComponentResponse descendentIds(List<V0StateComponentDescendentId> descendentIds) {
    this.descendentIds = descendentIds;
    return this;
  }

  public V0StateComponentResponse addDescendentIdsItem(V0StateComponentDescendentId descendentIdsItem) {
    this.descendentIds.add(descendentIdsItem);
    return this;
  }

   /**
   * Any descendent nodes owned directly or indirectly by the component
   * @return descendentIds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Any descendent nodes owned directly or indirectly by the component")
  @JsonProperty(JSON_PROPERTY_DESCENDENT_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<V0StateComponentDescendentId> getDescendentIds() {
    return descendentIds;
  }


  @JsonProperty(JSON_PROPERTY_DESCENDENT_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescendentIds(List<V0StateComponentDescendentId> descendentIds) {
    this.descendentIds = descendentIds;
  }


  /**
   * Return true if this V0StateComponentResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V0StateComponentResponse v0StateComponentResponse = (V0StateComponentResponse) o;
    return Objects.equals(this.info, v0StateComponentResponse.info) &&
        Objects.equals(this.state, v0StateComponentResponse.state) &&
        Objects.equals(this.royaltyConfig, v0StateComponentResponse.royaltyConfig) &&
        Objects.equals(this.royaltyAccumulator, v0StateComponentResponse.royaltyAccumulator) &&
        Objects.equals(this.metadata, v0StateComponentResponse.metadata) &&
        Objects.equals(this.accessRules, v0StateComponentResponse.accessRules) &&
        Objects.equals(this.stateOwnedVaults, v0StateComponentResponse.stateOwnedVaults) &&
        Objects.equals(this.descendentIds, v0StateComponentResponse.descendentIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(info, state, royaltyConfig, royaltyAccumulator, metadata, accessRules, stateOwnedVaults, descendentIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V0StateComponentResponse {\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    royaltyConfig: ").append(toIndentedString(royaltyConfig)).append("\n");
    sb.append("    royaltyAccumulator: ").append(toIndentedString(royaltyAccumulator)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    accessRules: ").append(toIndentedString(accessRules)).append("\n");
    sb.append("    stateOwnedVaults: ").append(toIndentedString(stateOwnedVaults)).append("\n");
    sb.append("    descendentIds: ").append(toIndentedString(descendentIds)).append("\n");
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
