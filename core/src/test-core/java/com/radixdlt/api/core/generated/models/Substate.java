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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.AccessControllerFieldStateSubstate;
import com.radixdlt.api.core.generated.models.AccessRulesModuleFieldAccessRulesSubstate;
import com.radixdlt.api.core.generated.models.AccountDepositRuleIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.AccountFieldStateSubstate;
import com.radixdlt.api.core.generated.models.AccountVaultIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerCurrentTimeRoundedToMinutesSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerCurrentTimeSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldConfigSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentProposalStatisticSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldCurrentValidatorSetSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerFieldStateSubstate;
import com.radixdlt.api.core.generated.models.ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerFieldDivisibilitySubstate;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerFieldTotalSupplySubstate;
import com.radixdlt.api.core.generated.models.FungibleVaultFieldBalanceSubstate;
import com.radixdlt.api.core.generated.models.GenericKeyValueStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.GenericScryptoComponentFieldStateSubstate;
import com.radixdlt.api.core.generated.models.MetadataModuleEntrySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerDataEntrySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerFieldIdTypeSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerFieldMutableFieldsSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerFieldTotalSupplySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleVaultContentsIndexEntrySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleVaultFieldBalanceSubstate;
import com.radixdlt.api.core.generated.models.PackageFieldCodeSubstate;
import com.radixdlt.api.core.generated.models.PackageFieldCodeTypeSubstate;
import com.radixdlt.api.core.generated.models.PackageFieldFunctionAccessRulesSubstate;
import com.radixdlt.api.core.generated.models.PackageFieldInfoSubstate;
import com.radixdlt.api.core.generated.models.PackageFieldRoyaltySubstate;
import com.radixdlt.api.core.generated.models.RoyaltyModuleFieldAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.RoyaltyModuleFieldConfigSubstate;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.TypeInfoModuleFieldTypeInfoSubstate;
import com.radixdlt.api.core.generated.models.ValidatorFieldStateSubstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * Substate
 */
@JsonPropertyOrder({
  Substate.JSON_PROPERTY_SUBSTATE_TYPE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "substate_type", // ignore manually set substate_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the substate_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "substate_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AccessControllerFieldStateSubstate.class, name = "AccessControllerFieldState"),
  @JsonSubTypes.Type(value = AccessControllerFieldStateSubstate.class, name = "AccessControllerFieldStateSubstate"),
  @JsonSubTypes.Type(value = AccessRulesModuleFieldAccessRulesSubstate.class, name = "AccessRulesModuleFieldAccessRules"),
  @JsonSubTypes.Type(value = AccessRulesModuleFieldAccessRulesSubstate.class, name = "AccessRulesModuleFieldAccessRulesSubstate"),
  @JsonSubTypes.Type(value = AccountDepositRuleIndexEntrySubstate.class, name = "AccountDepositRuleIndexEntry"),
  @JsonSubTypes.Type(value = AccountDepositRuleIndexEntrySubstate.class, name = "AccountDepositRuleIndexEntrySubstate"),
  @JsonSubTypes.Type(value = AccountFieldStateSubstate.class, name = "AccountFieldState"),
  @JsonSubTypes.Type(value = AccountFieldStateSubstate.class, name = "AccountFieldStateSubstate"),
  @JsonSubTypes.Type(value = AccountVaultIndexEntrySubstate.class, name = "AccountVaultIndexEntry"),
  @JsonSubTypes.Type(value = AccountVaultIndexEntrySubstate.class, name = "AccountVaultIndexEntrySubstate"),
  @JsonSubTypes.Type(value = ConsensusManagerCurrentTimeRoundedToMinutesSubstate.class, name = "ConsensusManagerCurrentTimeRoundedToMinutesSubstate"),
  @JsonSubTypes.Type(value = ConsensusManagerCurrentTimeSubstate.class, name = "ConsensusManagerCurrentTimeSubstate"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldConfigSubstate.class, name = "ConsensusManagerFieldConfig"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldConfigSubstate.class, name = "ConsensusManagerFieldConfigSubstate"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldCurrentProposalStatisticSubstate.class, name = "ConsensusManagerFieldCurrentProposalStatistic"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldCurrentProposalStatisticSubstate.class, name = "ConsensusManagerFieldCurrentProposalStatisticSubstate"),
  @JsonSubTypes.Type(value = ConsensusManagerCurrentTimeSubstate.class, name = "ConsensusManagerFieldCurrentTime"),
  @JsonSubTypes.Type(value = ConsensusManagerCurrentTimeRoundedToMinutesSubstate.class, name = "ConsensusManagerFieldCurrentTimeRoundedToMinutes"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldCurrentValidatorSetSubstate.class, name = "ConsensusManagerFieldCurrentValidatorSet"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldCurrentValidatorSetSubstate.class, name = "ConsensusManagerFieldCurrentValidatorSetSubstate"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldStateSubstate.class, name = "ConsensusManagerFieldState"),
  @JsonSubTypes.Type(value = ConsensusManagerFieldStateSubstate.class, name = "ConsensusManagerFieldStateSubstate"),
  @JsonSubTypes.Type(value = ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate.class, name = "ConsensusManagerRegisteredValidatorsByStakeIndexEntry"),
  @JsonSubTypes.Type(value = ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate.class, name = "ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate"),
  @JsonSubTypes.Type(value = FungibleResourceManagerFieldDivisibilitySubstate.class, name = "FungibleResourceManagerFieldDivisibility"),
  @JsonSubTypes.Type(value = FungibleResourceManagerFieldDivisibilitySubstate.class, name = "FungibleResourceManagerFieldDivisibilitySubstate"),
  @JsonSubTypes.Type(value = FungibleResourceManagerFieldTotalSupplySubstate.class, name = "FungibleResourceManagerFieldTotalSupply"),
  @JsonSubTypes.Type(value = FungibleResourceManagerFieldTotalSupplySubstate.class, name = "FungibleResourceManagerFieldTotalSupplySubstate"),
  @JsonSubTypes.Type(value = FungibleVaultFieldBalanceSubstate.class, name = "FungibleVaultFieldBalance"),
  @JsonSubTypes.Type(value = FungibleVaultFieldBalanceSubstate.class, name = "FungibleVaultFieldBalanceSubstate"),
  @JsonSubTypes.Type(value = GenericKeyValueStoreEntrySubstate.class, name = "GenericKeyValueStoreEntry"),
  @JsonSubTypes.Type(value = GenericKeyValueStoreEntrySubstate.class, name = "GenericKeyValueStoreEntrySubstate"),
  @JsonSubTypes.Type(value = GenericScryptoComponentFieldStateSubstate.class, name = "GenericScryptoComponentFieldState"),
  @JsonSubTypes.Type(value = GenericScryptoComponentFieldStateSubstate.class, name = "GenericScryptoComponentFieldStateSubstate"),
  @JsonSubTypes.Type(value = MetadataModuleEntrySubstate.class, name = "MetadataModuleEntry"),
  @JsonSubTypes.Type(value = MetadataModuleEntrySubstate.class, name = "MetadataModuleEntrySubstate"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerDataEntrySubstate.class, name = "NonFungibleResourceManagerDataEntry"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerDataEntrySubstate.class, name = "NonFungibleResourceManagerDataEntrySubstate"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldIdTypeSubstate.class, name = "NonFungibleResourceManagerFieldIdType"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldIdTypeSubstate.class, name = "NonFungibleResourceManagerFieldIdTypeSubstate"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldMutableFieldsSubstate.class, name = "NonFungibleResourceManagerFieldMutableFields"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldMutableFieldsSubstate.class, name = "NonFungibleResourceManagerFieldMutableFieldsSubstate"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldTotalSupplySubstate.class, name = "NonFungibleResourceManagerFieldTotalSupply"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerFieldTotalSupplySubstate.class, name = "NonFungibleResourceManagerFieldTotalSupplySubstate"),
  @JsonSubTypes.Type(value = NonFungibleVaultContentsIndexEntrySubstate.class, name = "NonFungibleVaultContentsIndexEntry"),
  @JsonSubTypes.Type(value = NonFungibleVaultContentsIndexEntrySubstate.class, name = "NonFungibleVaultContentsIndexEntrySubstate"),
  @JsonSubTypes.Type(value = NonFungibleVaultFieldBalanceSubstate.class, name = "NonFungibleVaultFieldBalance"),
  @JsonSubTypes.Type(value = NonFungibleVaultFieldBalanceSubstate.class, name = "NonFungibleVaultFieldBalanceSubstate"),
  @JsonSubTypes.Type(value = PackageFieldCodeSubstate.class, name = "PackageFieldCode"),
  @JsonSubTypes.Type(value = PackageFieldCodeSubstate.class, name = "PackageFieldCodeSubstate"),
  @JsonSubTypes.Type(value = PackageFieldCodeTypeSubstate.class, name = "PackageFieldCodeType"),
  @JsonSubTypes.Type(value = PackageFieldCodeTypeSubstate.class, name = "PackageFieldCodeTypeSubstate"),
  @JsonSubTypes.Type(value = PackageFieldFunctionAccessRulesSubstate.class, name = "PackageFieldFunctionAccessRules"),
  @JsonSubTypes.Type(value = PackageFieldFunctionAccessRulesSubstate.class, name = "PackageFieldFunctionAccessRulesSubstate"),
  @JsonSubTypes.Type(value = PackageFieldInfoSubstate.class, name = "PackageFieldInfo"),
  @JsonSubTypes.Type(value = PackageFieldInfoSubstate.class, name = "PackageFieldInfoSubstate"),
  @JsonSubTypes.Type(value = PackageFieldRoyaltySubstate.class, name = "PackageFieldRoyalty"),
  @JsonSubTypes.Type(value = PackageFieldRoyaltySubstate.class, name = "PackageFieldRoyaltySubstate"),
  @JsonSubTypes.Type(value = RoyaltyModuleFieldAccumulatorSubstate.class, name = "RoyaltyModuleFieldAccumulator"),
  @JsonSubTypes.Type(value = RoyaltyModuleFieldAccumulatorSubstate.class, name = "RoyaltyModuleFieldAccumulatorSubstate"),
  @JsonSubTypes.Type(value = RoyaltyModuleFieldConfigSubstate.class, name = "RoyaltyModuleFieldConfig"),
  @JsonSubTypes.Type(value = RoyaltyModuleFieldConfigSubstate.class, name = "RoyaltyModuleFieldConfigSubstate"),
  @JsonSubTypes.Type(value = TypeInfoModuleFieldTypeInfoSubstate.class, name = "TypeInfoModuleFieldTypeInfo"),
  @JsonSubTypes.Type(value = TypeInfoModuleFieldTypeInfoSubstate.class, name = "TypeInfoModuleFieldTypeInfoSubstate"),
  @JsonSubTypes.Type(value = ValidatorFieldStateSubstate.class, name = "ValidatorFieldState"),
  @JsonSubTypes.Type(value = ValidatorFieldStateSubstate.class, name = "ValidatorFieldStateSubstate"),
})

public class Substate {
  public static final String JSON_PROPERTY_SUBSTATE_TYPE = "substate_type";
  private SubstateType substateType;

  public Substate() { 
  }

  public Substate substateType(SubstateType substateType) {
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


  /**
   * Return true if this Substate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Substate substate = (Substate) o;
    return Objects.equals(this.substateType, substate.substateType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(substateType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Substate {\n");
    sb.append("    substateType: ").append(toIndentedString(substateType)).append("\n");
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
  mappings.put("AccessControllerFieldState", AccessControllerFieldStateSubstate.class);
  mappings.put("AccessControllerFieldStateSubstate", AccessControllerFieldStateSubstate.class);
  mappings.put("AccessRulesModuleFieldAccessRules", AccessRulesModuleFieldAccessRulesSubstate.class);
  mappings.put("AccessRulesModuleFieldAccessRulesSubstate", AccessRulesModuleFieldAccessRulesSubstate.class);
  mappings.put("AccountDepositRuleIndexEntry", AccountDepositRuleIndexEntrySubstate.class);
  mappings.put("AccountDepositRuleIndexEntrySubstate", AccountDepositRuleIndexEntrySubstate.class);
  mappings.put("AccountFieldState", AccountFieldStateSubstate.class);
  mappings.put("AccountFieldStateSubstate", AccountFieldStateSubstate.class);
  mappings.put("AccountVaultIndexEntry", AccountVaultIndexEntrySubstate.class);
  mappings.put("AccountVaultIndexEntrySubstate", AccountVaultIndexEntrySubstate.class);
  mappings.put("ConsensusManagerCurrentTimeRoundedToMinutesSubstate", ConsensusManagerCurrentTimeRoundedToMinutesSubstate.class);
  mappings.put("ConsensusManagerCurrentTimeSubstate", ConsensusManagerCurrentTimeSubstate.class);
  mappings.put("ConsensusManagerFieldConfig", ConsensusManagerFieldConfigSubstate.class);
  mappings.put("ConsensusManagerFieldConfigSubstate", ConsensusManagerFieldConfigSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentProposalStatistic", ConsensusManagerFieldCurrentProposalStatisticSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentProposalStatisticSubstate", ConsensusManagerFieldCurrentProposalStatisticSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentTime", ConsensusManagerCurrentTimeSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentTimeRoundedToMinutes", ConsensusManagerCurrentTimeRoundedToMinutesSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentValidatorSet", ConsensusManagerFieldCurrentValidatorSetSubstate.class);
  mappings.put("ConsensusManagerFieldCurrentValidatorSetSubstate", ConsensusManagerFieldCurrentValidatorSetSubstate.class);
  mappings.put("ConsensusManagerFieldState", ConsensusManagerFieldStateSubstate.class);
  mappings.put("ConsensusManagerFieldStateSubstate", ConsensusManagerFieldStateSubstate.class);
  mappings.put("ConsensusManagerRegisteredValidatorsByStakeIndexEntry", ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate.class);
  mappings.put("ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate", ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate.class);
  mappings.put("FungibleResourceManagerFieldDivisibility", FungibleResourceManagerFieldDivisibilitySubstate.class);
  mappings.put("FungibleResourceManagerFieldDivisibilitySubstate", FungibleResourceManagerFieldDivisibilitySubstate.class);
  mappings.put("FungibleResourceManagerFieldTotalSupply", FungibleResourceManagerFieldTotalSupplySubstate.class);
  mappings.put("FungibleResourceManagerFieldTotalSupplySubstate", FungibleResourceManagerFieldTotalSupplySubstate.class);
  mappings.put("FungibleVaultFieldBalance", FungibleVaultFieldBalanceSubstate.class);
  mappings.put("FungibleVaultFieldBalanceSubstate", FungibleVaultFieldBalanceSubstate.class);
  mappings.put("GenericKeyValueStoreEntry", GenericKeyValueStoreEntrySubstate.class);
  mappings.put("GenericKeyValueStoreEntrySubstate", GenericKeyValueStoreEntrySubstate.class);
  mappings.put("GenericScryptoComponentFieldState", GenericScryptoComponentFieldStateSubstate.class);
  mappings.put("GenericScryptoComponentFieldStateSubstate", GenericScryptoComponentFieldStateSubstate.class);
  mappings.put("MetadataModuleEntry", MetadataModuleEntrySubstate.class);
  mappings.put("MetadataModuleEntrySubstate", MetadataModuleEntrySubstate.class);
  mappings.put("NonFungibleResourceManagerDataEntry", NonFungibleResourceManagerDataEntrySubstate.class);
  mappings.put("NonFungibleResourceManagerDataEntrySubstate", NonFungibleResourceManagerDataEntrySubstate.class);
  mappings.put("NonFungibleResourceManagerFieldIdType", NonFungibleResourceManagerFieldIdTypeSubstate.class);
  mappings.put("NonFungibleResourceManagerFieldIdTypeSubstate", NonFungibleResourceManagerFieldIdTypeSubstate.class);
  mappings.put("NonFungibleResourceManagerFieldMutableFields", NonFungibleResourceManagerFieldMutableFieldsSubstate.class);
  mappings.put("NonFungibleResourceManagerFieldMutableFieldsSubstate", NonFungibleResourceManagerFieldMutableFieldsSubstate.class);
  mappings.put("NonFungibleResourceManagerFieldTotalSupply", NonFungibleResourceManagerFieldTotalSupplySubstate.class);
  mappings.put("NonFungibleResourceManagerFieldTotalSupplySubstate", NonFungibleResourceManagerFieldTotalSupplySubstate.class);
  mappings.put("NonFungibleVaultContentsIndexEntry", NonFungibleVaultContentsIndexEntrySubstate.class);
  mappings.put("NonFungibleVaultContentsIndexEntrySubstate", NonFungibleVaultContentsIndexEntrySubstate.class);
  mappings.put("NonFungibleVaultFieldBalance", NonFungibleVaultFieldBalanceSubstate.class);
  mappings.put("NonFungibleVaultFieldBalanceSubstate", NonFungibleVaultFieldBalanceSubstate.class);
  mappings.put("PackageFieldCode", PackageFieldCodeSubstate.class);
  mappings.put("PackageFieldCodeSubstate", PackageFieldCodeSubstate.class);
  mappings.put("PackageFieldCodeType", PackageFieldCodeTypeSubstate.class);
  mappings.put("PackageFieldCodeTypeSubstate", PackageFieldCodeTypeSubstate.class);
  mappings.put("PackageFieldFunctionAccessRules", PackageFieldFunctionAccessRulesSubstate.class);
  mappings.put("PackageFieldFunctionAccessRulesSubstate", PackageFieldFunctionAccessRulesSubstate.class);
  mappings.put("PackageFieldInfo", PackageFieldInfoSubstate.class);
  mappings.put("PackageFieldInfoSubstate", PackageFieldInfoSubstate.class);
  mappings.put("PackageFieldRoyalty", PackageFieldRoyaltySubstate.class);
  mappings.put("PackageFieldRoyaltySubstate", PackageFieldRoyaltySubstate.class);
  mappings.put("RoyaltyModuleFieldAccumulator", RoyaltyModuleFieldAccumulatorSubstate.class);
  mappings.put("RoyaltyModuleFieldAccumulatorSubstate", RoyaltyModuleFieldAccumulatorSubstate.class);
  mappings.put("RoyaltyModuleFieldConfig", RoyaltyModuleFieldConfigSubstate.class);
  mappings.put("RoyaltyModuleFieldConfigSubstate", RoyaltyModuleFieldConfigSubstate.class);
  mappings.put("TypeInfoModuleFieldTypeInfo", TypeInfoModuleFieldTypeInfoSubstate.class);
  mappings.put("TypeInfoModuleFieldTypeInfoSubstate", TypeInfoModuleFieldTypeInfoSubstate.class);
  mappings.put("ValidatorFieldState", ValidatorFieldStateSubstate.class);
  mappings.put("ValidatorFieldStateSubstate", ValidatorFieldStateSubstate.class);
  mappings.put("Substate", Substate.class);
  JSON.registerDiscriminator(Substate.class, "substate_type", mappings);
}
}

