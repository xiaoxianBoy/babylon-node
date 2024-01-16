/*
 * Radix Core API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.4
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
import com.radixdlt.api.core.generated.models.SubstateKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * FlashedSubstate
 */
@JsonPropertyOrder({
  FlashedSubstate.JSON_PROPERTY_ENTITY_ADDRESS,
  FlashedSubstate.JSON_PROPERTY_PARTITION_NUMBER,
  FlashedSubstate.JSON_PROPERTY_SUBSTATE_KEY,
  FlashedSubstate.JSON_PROPERTY_VALUE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FlashedSubstate {
  public static final String JSON_PROPERTY_ENTITY_ADDRESS = "entity_address";
  private String entityAddress;

  public static final String JSON_PROPERTY_PARTITION_NUMBER = "partition_number";
  private Integer partitionNumber;

  public static final String JSON_PROPERTY_SUBSTATE_KEY = "substate_key";
  private SubstateKey substateKey;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public FlashedSubstate() { 
  }

  public FlashedSubstate entityAddress(String entityAddress) {
    this.entityAddress = entityAddress;
    return this;
  }

   /**
   * Bech32m-encoded human readable version of the entity&#39;s address (ie the entity&#39;s node id)
   * @return entityAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Bech32m-encoded human readable version of the entity's address (ie the entity's node id)")
  @JsonProperty(JSON_PROPERTY_ENTITY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEntityAddress() {
    return entityAddress;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntityAddress(String entityAddress) {
    this.entityAddress = entityAddress;
  }


  public FlashedSubstate partitionNumber(Integer partitionNumber) {
    this.partitionNumber = partitionNumber;
    return this;
  }

   /**
   * Get partitionNumber
   * minimum: 0
   * maximum: 255
   * @return partitionNumber
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PARTITION_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getPartitionNumber() {
    return partitionNumber;
  }


  @JsonProperty(JSON_PROPERTY_PARTITION_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPartitionNumber(Integer partitionNumber) {
    this.partitionNumber = partitionNumber;
  }


  public FlashedSubstate substateKey(SubstateKey substateKey) {
    this.substateKey = substateKey;
    return this;
  }

   /**
   * Get substateKey
   * @return substateKey
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SUBSTATE_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SubstateKey getSubstateKey() {
    return substateKey;
  }


  @JsonProperty(JSON_PROPERTY_SUBSTATE_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubstateKey(SubstateKey substateKey) {
    this.substateKey = substateKey;
  }


  public FlashedSubstate value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The hex-encoded, SBOR-encoded substate data bytes.
   * @return value
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded, SBOR-encoded substate data bytes.")
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValue(String value) {
    this.value = value;
  }


  /**
   * Return true if this FlashedSubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlashedSubstate flashedSubstate = (FlashedSubstate) o;
    return Objects.equals(this.entityAddress, flashedSubstate.entityAddress) &&
        Objects.equals(this.partitionNumber, flashedSubstate.partitionNumber) &&
        Objects.equals(this.substateKey, flashedSubstate.substateKey) &&
        Objects.equals(this.value, flashedSubstate.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityAddress, partitionNumber, substateKey, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlashedSubstate {\n");
    sb.append("    entityAddress: ").append(toIndentedString(entityAddress)).append("\n");
    sb.append("    partitionNumber: ").append(toIndentedString(partitionNumber)).append("\n");
    sb.append("    substateKey: ").append(toIndentedString(substateKey)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
