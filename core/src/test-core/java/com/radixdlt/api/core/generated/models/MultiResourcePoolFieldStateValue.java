/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v2\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
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
import com.radixdlt.api.core.generated.models.PoolVault;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * MultiResourcePoolFieldStateValue
 */
@JsonPropertyOrder({
  MultiResourcePoolFieldStateValue.JSON_PROPERTY_VAULTS,
  MultiResourcePoolFieldStateValue.JSON_PROPERTY_POOL_UNIT_RESOURCE_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MultiResourcePoolFieldStateValue {
  public static final String JSON_PROPERTY_VAULTS = "vaults";
  private List<PoolVault> vaults = new ArrayList<>();

  public static final String JSON_PROPERTY_POOL_UNIT_RESOURCE_ADDRESS = "pool_unit_resource_address";
  private String poolUnitResourceAddress;

  public MultiResourcePoolFieldStateValue() { 
  }

  public MultiResourcePoolFieldStateValue vaults(List<PoolVault> vaults) {
    this.vaults = vaults;
    return this;
  }

  public MultiResourcePoolFieldStateValue addVaultsItem(PoolVault vaultsItem) {
    this.vaults.add(vaultsItem);
    return this;
  }

   /**
   * Get vaults
   * @return vaults
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<PoolVault> getVaults() {
    return vaults;
  }


  @JsonProperty(JSON_PROPERTY_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVaults(List<PoolVault> vaults) {
    this.vaults = vaults;
  }


  public MultiResourcePoolFieldStateValue poolUnitResourceAddress(String poolUnitResourceAddress) {
    this.poolUnitResourceAddress = poolUnitResourceAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the resource address
   * @return poolUnitResourceAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the resource address")
  @JsonProperty(JSON_PROPERTY_POOL_UNIT_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPoolUnitResourceAddress() {
    return poolUnitResourceAddress;
  }


  @JsonProperty(JSON_PROPERTY_POOL_UNIT_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPoolUnitResourceAddress(String poolUnitResourceAddress) {
    this.poolUnitResourceAddress = poolUnitResourceAddress;
  }


  /**
   * Return true if this MultiResourcePoolFieldStateValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultiResourcePoolFieldStateValue multiResourcePoolFieldStateValue = (MultiResourcePoolFieldStateValue) o;
    return Objects.equals(this.vaults, multiResourcePoolFieldStateValue.vaults) &&
        Objects.equals(this.poolUnitResourceAddress, multiResourcePoolFieldStateValue.poolUnitResourceAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vaults, poolUnitResourceAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultiResourcePoolFieldStateValue {\n");
    sb.append("    vaults: ").append(toIndentedString(vaults)).append("\n");
    sb.append("    poolUnitResourceAddress: ").append(toIndentedString(poolUnitResourceAddress)).append("\n");
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
