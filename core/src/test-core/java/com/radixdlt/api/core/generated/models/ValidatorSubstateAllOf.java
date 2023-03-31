/*
 * Babylon Core API - RCnet V1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.EcdsaSecp256k1PublicKey;
import com.radixdlt.api.core.generated.models.EntityReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ValidatorSubstateAllOf
 */
@JsonPropertyOrder({
  ValidatorSubstateAllOf.JSON_PROPERTY_EPOCH_MANAGER_ADDRESS,
  ValidatorSubstateAllOf.JSON_PROPERTY_VALIDATOR_ADDRESS,
  ValidatorSubstateAllOf.JSON_PROPERTY_PUBLIC_KEY,
  ValidatorSubstateAllOf.JSON_PROPERTY_STAKE_VAULT,
  ValidatorSubstateAllOf.JSON_PROPERTY_UNSTAKE_VAULT,
  ValidatorSubstateAllOf.JSON_PROPERTY_LIQUID_STAKE_UNIT_RESOURCE_ADDRESS,
  ValidatorSubstateAllOf.JSON_PROPERTY_UNSTAKE_CLAIM_TOKEN_RESOURCE_ADDRESS,
  ValidatorSubstateAllOf.JSON_PROPERTY_IS_REGISTERED
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ValidatorSubstateAllOf {
  public static final String JSON_PROPERTY_EPOCH_MANAGER_ADDRESS = "epoch_manager_address";
  private String epochManagerAddress;

  public static final String JSON_PROPERTY_VALIDATOR_ADDRESS = "validator_address";
  private String validatorAddress;

  public static final String JSON_PROPERTY_PUBLIC_KEY = "public_key";
  private EcdsaSecp256k1PublicKey publicKey;

  public static final String JSON_PROPERTY_STAKE_VAULT = "stake_vault";
  private EntityReference stakeVault;

  public static final String JSON_PROPERTY_UNSTAKE_VAULT = "unstake_vault";
  private EntityReference unstakeVault;

  public static final String JSON_PROPERTY_LIQUID_STAKE_UNIT_RESOURCE_ADDRESS = "liquid_stake_unit_resource_address";
  private String liquidStakeUnitResourceAddress;

  public static final String JSON_PROPERTY_UNSTAKE_CLAIM_TOKEN_RESOURCE_ADDRESS = "unstake_claim_token_resource_address";
  private String unstakeClaimTokenResourceAddress;

  public static final String JSON_PROPERTY_IS_REGISTERED = "is_registered";
  private Boolean isRegistered;

  public ValidatorSubstateAllOf() { 
  }

  public ValidatorSubstateAllOf epochManagerAddress(String epochManagerAddress) {
    this.epochManagerAddress = epochManagerAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the component address
   * @return epochManagerAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the component address")
  @JsonProperty(JSON_PROPERTY_EPOCH_MANAGER_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEpochManagerAddress() {
    return epochManagerAddress;
  }


  @JsonProperty(JSON_PROPERTY_EPOCH_MANAGER_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEpochManagerAddress(String epochManagerAddress) {
    this.epochManagerAddress = epochManagerAddress;
  }


  public ValidatorSubstateAllOf validatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the component address
   * @return validatorAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the component address")
  @JsonProperty(JSON_PROPERTY_VALIDATOR_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValidatorAddress() {
    return validatorAddress;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
  }


  public ValidatorSubstateAllOf publicKey(EcdsaSecp256k1PublicKey publicKey) {
    this.publicKey = publicKey;
    return this;
  }

   /**
   * Get publicKey
   * @return publicKey
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PUBLIC_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EcdsaSecp256k1PublicKey getPublicKey() {
    return publicKey;
  }


  @JsonProperty(JSON_PROPERTY_PUBLIC_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPublicKey(EcdsaSecp256k1PublicKey publicKey) {
    this.publicKey = publicKey;
  }


  public ValidatorSubstateAllOf stakeVault(EntityReference stakeVault) {
    this.stakeVault = stakeVault;
    return this;
  }

   /**
   * Get stakeVault
   * @return stakeVault
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STAKE_VAULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityReference getStakeVault() {
    return stakeVault;
  }


  @JsonProperty(JSON_PROPERTY_STAKE_VAULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStakeVault(EntityReference stakeVault) {
    this.stakeVault = stakeVault;
  }


  public ValidatorSubstateAllOf unstakeVault(EntityReference unstakeVault) {
    this.unstakeVault = unstakeVault;
    return this;
  }

   /**
   * Get unstakeVault
   * @return unstakeVault
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_UNSTAKE_VAULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityReference getUnstakeVault() {
    return unstakeVault;
  }


  @JsonProperty(JSON_PROPERTY_UNSTAKE_VAULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUnstakeVault(EntityReference unstakeVault) {
    this.unstakeVault = unstakeVault;
  }


  public ValidatorSubstateAllOf liquidStakeUnitResourceAddress(String liquidStakeUnitResourceAddress) {
    this.liquidStakeUnitResourceAddress = liquidStakeUnitResourceAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the resource address
   * @return liquidStakeUnitResourceAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the resource address")
  @JsonProperty(JSON_PROPERTY_LIQUID_STAKE_UNIT_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLiquidStakeUnitResourceAddress() {
    return liquidStakeUnitResourceAddress;
  }


  @JsonProperty(JSON_PROPERTY_LIQUID_STAKE_UNIT_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLiquidStakeUnitResourceAddress(String liquidStakeUnitResourceAddress) {
    this.liquidStakeUnitResourceAddress = liquidStakeUnitResourceAddress;
  }


  public ValidatorSubstateAllOf unstakeClaimTokenResourceAddress(String unstakeClaimTokenResourceAddress) {
    this.unstakeClaimTokenResourceAddress = unstakeClaimTokenResourceAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the resource address
   * @return unstakeClaimTokenResourceAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the resource address")
  @JsonProperty(JSON_PROPERTY_UNSTAKE_CLAIM_TOKEN_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUnstakeClaimTokenResourceAddress() {
    return unstakeClaimTokenResourceAddress;
  }


  @JsonProperty(JSON_PROPERTY_UNSTAKE_CLAIM_TOKEN_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUnstakeClaimTokenResourceAddress(String unstakeClaimTokenResourceAddress) {
    this.unstakeClaimTokenResourceAddress = unstakeClaimTokenResourceAddress;
  }


  public ValidatorSubstateAllOf isRegistered(Boolean isRegistered) {
    this.isRegistered = isRegistered;
    return this;
  }

   /**
   * Get isRegistered
   * @return isRegistered
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IS_REGISTERED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsRegistered() {
    return isRegistered;
  }


  @JsonProperty(JSON_PROPERTY_IS_REGISTERED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsRegistered(Boolean isRegistered) {
    this.isRegistered = isRegistered;
  }


  /**
   * Return true if this ValidatorSubstate_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidatorSubstateAllOf validatorSubstateAllOf = (ValidatorSubstateAllOf) o;
    return Objects.equals(this.epochManagerAddress, validatorSubstateAllOf.epochManagerAddress) &&
        Objects.equals(this.validatorAddress, validatorSubstateAllOf.validatorAddress) &&
        Objects.equals(this.publicKey, validatorSubstateAllOf.publicKey) &&
        Objects.equals(this.stakeVault, validatorSubstateAllOf.stakeVault) &&
        Objects.equals(this.unstakeVault, validatorSubstateAllOf.unstakeVault) &&
        Objects.equals(this.liquidStakeUnitResourceAddress, validatorSubstateAllOf.liquidStakeUnitResourceAddress) &&
        Objects.equals(this.unstakeClaimTokenResourceAddress, validatorSubstateAllOf.unstakeClaimTokenResourceAddress) &&
        Objects.equals(this.isRegistered, validatorSubstateAllOf.isRegistered);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epochManagerAddress, validatorAddress, publicKey, stakeVault, unstakeVault, liquidStakeUnitResourceAddress, unstakeClaimTokenResourceAddress, isRegistered);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidatorSubstateAllOf {\n");
    sb.append("    epochManagerAddress: ").append(toIndentedString(epochManagerAddress)).append("\n");
    sb.append("    validatorAddress: ").append(toIndentedString(validatorAddress)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
    sb.append("    stakeVault: ").append(toIndentedString(stakeVault)).append("\n");
    sb.append("    unstakeVault: ").append(toIndentedString(unstakeVault)).append("\n");
    sb.append("    liquidStakeUnitResourceAddress: ").append(toIndentedString(liquidStakeUnitResourceAddress)).append("\n");
    sb.append("    unstakeClaimTokenResourceAddress: ").append(toIndentedString(unstakeClaimTokenResourceAddress)).append("\n");
    sb.append("    isRegistered: ").append(toIndentedString(isRegistered)).append("\n");
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

