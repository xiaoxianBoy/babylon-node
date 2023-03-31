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
import com.radixdlt.api.core.generated.models.AccessControllerSubstate;
import com.radixdlt.api.core.generated.models.AccessRulesSubstate;
import com.radixdlt.api.core.generated.models.AccountSubstate;
import com.radixdlt.api.core.generated.models.ClockSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.ComponentStateSubstate;
import com.radixdlt.api.core.generated.models.EpochManagerSubstate;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerSubstate;
import com.radixdlt.api.core.generated.models.KeyValueStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.MetadataEntrySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerSubstate;
import com.radixdlt.api.core.generated.models.PackageCodeSubstate;
import com.radixdlt.api.core.generated.models.PackageCodeTypeSubstate;
import com.radixdlt.api.core.generated.models.PackageFunctionAccessRulesSubstate;
import com.radixdlt.api.core.generated.models.PackageInfoSubstate;
import com.radixdlt.api.core.generated.models.PackageInfoSubstateAllOf;
import com.radixdlt.api.core.generated.models.PackageRoyaltySubstate;
import com.radixdlt.api.core.generated.models.PackageSchema;
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.TypeInfoSubstate;
import com.radixdlt.api.core.generated.models.ValidatorSetSubstate;
import com.radixdlt.api.core.generated.models.ValidatorSubstate;
import com.radixdlt.api.core.generated.models.VaultFungibleSubstate;
import com.radixdlt.api.core.generated.models.VaultInfoSubstate;
import com.radixdlt.api.core.generated.models.VaultNonFungibleSubstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * PackageInfoSubstate
 */
@JsonPropertyOrder({
  PackageInfoSubstate.JSON_PROPERTY_PACKAGE_SCHEMA,
  PackageInfoSubstate.JSON_PROPERTY_DEPENDENT_RESOURCES,
  PackageInfoSubstate.JSON_PROPERTY_DEPENDENT_COMPONENTS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "substate_type", // ignore manually set substate_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the substate_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "substate_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AccessControllerSubstate.class, name = "AccessController"),
  @JsonSubTypes.Type(value = AccessRulesSubstate.class, name = "AccessRules"),
  @JsonSubTypes.Type(value = AccountSubstate.class, name = "Account"),
  @JsonSubTypes.Type(value = ClockSubstate.class, name = "Clock"),
  @JsonSubTypes.Type(value = ComponentRoyaltyAccumulatorSubstate.class, name = "ComponentRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = ComponentRoyaltyConfigSubstate.class, name = "ComponentRoyaltyConfig"),
  @JsonSubTypes.Type(value = ComponentStateSubstate.class, name = "ComponentState"),
  @JsonSubTypes.Type(value = EpochManagerSubstate.class, name = "EpochManager"),
  @JsonSubTypes.Type(value = FungibleResourceManagerSubstate.class, name = "FungibleResourceManager"),
  @JsonSubTypes.Type(value = KeyValueStoreEntrySubstate.class, name = "KeyValueStoreEntry"),
  @JsonSubTypes.Type(value = MetadataEntrySubstate.class, name = "MetadataEntry"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerSubstate.class, name = "NonFungibleResourceManager"),
  @JsonSubTypes.Type(value = PackageCodeSubstate.class, name = "PackageCode"),
  @JsonSubTypes.Type(value = PackageCodeTypeSubstate.class, name = "PackageCodeType"),
  @JsonSubTypes.Type(value = PackageFunctionAccessRulesSubstate.class, name = "PackageFunctionAccessRules"),
  @JsonSubTypes.Type(value = PackageInfoSubstate.class, name = "PackageInfo"),
  @JsonSubTypes.Type(value = PackageRoyaltySubstate.class, name = "PackageRoyalty"),
  @JsonSubTypes.Type(value = TypeInfoSubstate.class, name = "TypeInfo"),
  @JsonSubTypes.Type(value = ValidatorSubstate.class, name = "Validator"),
  @JsonSubTypes.Type(value = ValidatorSetSubstate.class, name = "ValidatorSet"),
  @JsonSubTypes.Type(value = VaultFungibleSubstate.class, name = "VaultFungible"),
  @JsonSubTypes.Type(value = VaultInfoSubstate.class, name = "VaultInfo"),
  @JsonSubTypes.Type(value = VaultNonFungibleSubstate.class, name = "VaultNonFungible"),
})

public class PackageInfoSubstate extends Substate {
  public static final String JSON_PROPERTY_PACKAGE_SCHEMA = "package_schema";
  private PackageSchema packageSchema;

  public static final String JSON_PROPERTY_DEPENDENT_RESOURCES = "dependent_resources";
  private List<String> dependentResources = new ArrayList<>();

  public static final String JSON_PROPERTY_DEPENDENT_COMPONENTS = "dependent_components";
  private List<String> dependentComponents = new ArrayList<>();

  public PackageInfoSubstate() { 
  }

  public PackageInfoSubstate packageSchema(PackageSchema packageSchema) {
    this.packageSchema = packageSchema;
    return this;
  }

   /**
   * Get packageSchema
   * @return packageSchema
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PACKAGE_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PackageSchema getPackageSchema() {
    return packageSchema;
  }


  @JsonProperty(JSON_PROPERTY_PACKAGE_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPackageSchema(PackageSchema packageSchema) {
    this.packageSchema = packageSchema;
  }


  public PackageInfoSubstate dependentResources(List<String> dependentResources) {
    this.dependentResources = dependentResources;
    return this;
  }

  public PackageInfoSubstate addDependentResourcesItem(String dependentResourcesItem) {
    this.dependentResources.add(dependentResourcesItem);
    return this;
  }

   /**
   * Get dependentResources
   * @return dependentResources
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DEPENDENT_RESOURCES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getDependentResources() {
    return dependentResources;
  }


  @JsonProperty(JSON_PROPERTY_DEPENDENT_RESOURCES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDependentResources(List<String> dependentResources) {
    this.dependentResources = dependentResources;
  }


  public PackageInfoSubstate dependentComponents(List<String> dependentComponents) {
    this.dependentComponents = dependentComponents;
    return this;
  }

  public PackageInfoSubstate addDependentComponentsItem(String dependentComponentsItem) {
    this.dependentComponents.add(dependentComponentsItem);
    return this;
  }

   /**
   * Get dependentComponents
   * @return dependentComponents
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DEPENDENT_COMPONENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getDependentComponents() {
    return dependentComponents;
  }


  @JsonProperty(JSON_PROPERTY_DEPENDENT_COMPONENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDependentComponents(List<String> dependentComponents) {
    this.dependentComponents = dependentComponents;
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
    return Objects.equals(this.packageSchema, packageInfoSubstate.packageSchema) &&
        Objects.equals(this.dependentResources, packageInfoSubstate.dependentResources) &&
        Objects.equals(this.dependentComponents, packageInfoSubstate.dependentComponents) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packageSchema, dependentResources, dependentComponents, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageInfoSubstate {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    packageSchema: ").append(toIndentedString(packageSchema)).append("\n");
    sb.append("    dependentResources: ").append(toIndentedString(dependentResources)).append("\n");
    sb.append("    dependentComponents: ").append(toIndentedString(dependentComponents)).append("\n");
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
  mappings.put("AccessController", AccessControllerSubstate.class);
  mappings.put("AccessRules", AccessRulesSubstate.class);
  mappings.put("Account", AccountSubstate.class);
  mappings.put("Clock", ClockSubstate.class);
  mappings.put("ComponentRoyaltyAccumulator", ComponentRoyaltyAccumulatorSubstate.class);
  mappings.put("ComponentRoyaltyConfig", ComponentRoyaltyConfigSubstate.class);
  mappings.put("ComponentState", ComponentStateSubstate.class);
  mappings.put("EpochManager", EpochManagerSubstate.class);
  mappings.put("FungibleResourceManager", FungibleResourceManagerSubstate.class);
  mappings.put("KeyValueStoreEntry", KeyValueStoreEntrySubstate.class);
  mappings.put("MetadataEntry", MetadataEntrySubstate.class);
  mappings.put("NonFungibleResourceManager", NonFungibleResourceManagerSubstate.class);
  mappings.put("PackageCode", PackageCodeSubstate.class);
  mappings.put("PackageCodeType", PackageCodeTypeSubstate.class);
  mappings.put("PackageFunctionAccessRules", PackageFunctionAccessRulesSubstate.class);
  mappings.put("PackageInfo", PackageInfoSubstate.class);
  mappings.put("PackageRoyalty", PackageRoyaltySubstate.class);
  mappings.put("TypeInfo", TypeInfoSubstate.class);
  mappings.put("Validator", ValidatorSubstate.class);
  mappings.put("ValidatorSet", ValidatorSetSubstate.class);
  mappings.put("VaultFungible", VaultFungibleSubstate.class);
  mappings.put("VaultInfo", VaultInfoSubstate.class);
  mappings.put("VaultNonFungible", VaultNonFungibleSubstate.class);
  mappings.put("PackageInfoSubstate", PackageInfoSubstate.class);
  JSON.registerDiscriminator(PackageInfoSubstate.class, "substate_type", mappings);
}
}

