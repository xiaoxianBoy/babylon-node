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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.ObjectHook;
import com.radixdlt.api.core.generated.models.PackageExport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * HookExport
 */
@JsonPropertyOrder({
  HookExport.JSON_PROPERTY_OBJECT_HOOK,
  HookExport.JSON_PROPERTY_EXPORT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class HookExport {
  public static final String JSON_PROPERTY_OBJECT_HOOK = "object_hook";
  private ObjectHook objectHook;

  public static final String JSON_PROPERTY_EXPORT = "export";
  private PackageExport export;

  public HookExport() { 
  }

  public HookExport objectHook(ObjectHook objectHook) {
    this.objectHook = objectHook;
    return this;
  }

   /**
   * Get objectHook
   * @return objectHook
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_OBJECT_HOOK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ObjectHook getObjectHook() {
    return objectHook;
  }


  @JsonProperty(JSON_PROPERTY_OBJECT_HOOK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObjectHook(ObjectHook objectHook) {
    this.objectHook = objectHook;
  }


  public HookExport export(PackageExport export) {
    this.export = export;
    return this;
  }

   /**
   * Get export
   * @return export
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EXPORT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PackageExport getExport() {
    return export;
  }


  @JsonProperty(JSON_PROPERTY_EXPORT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExport(PackageExport export) {
    this.export = export;
  }


  /**
   * Return true if this HookExport object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HookExport hookExport = (HookExport) o;
    return Objects.equals(this.objectHook, hookExport.objectHook) &&
        Objects.equals(this.export, hookExport.export);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectHook, export);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HookExport {\n");
    sb.append("    objectHook: ").append(toIndentedString(objectHook)).append("\n");
    sb.append("    export: ").append(toIndentedString(export)).append("\n");
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
