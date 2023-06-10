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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ReferenceType
 */
@JsonPropertyOrder({
  ReferenceType.JSON_PROPERTY_RAW_BITS,
  ReferenceType.JSON_PROPERTY_NORMAL,
  ReferenceType.JSON_PROPERTY_DIRECT_ACCESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ReferenceType {
  public static final String JSON_PROPERTY_RAW_BITS = "raw_bits";
  private Long rawBits;

  public static final String JSON_PROPERTY_NORMAL = "normal";
  private Boolean normal;

  public static final String JSON_PROPERTY_DIRECT_ACCESS = "direct_access";
  private Boolean directAccess;

  public ReferenceType() { 
  }

  public ReferenceType rawBits(Long rawBits) {
    this.rawBits = rawBits;
    return this;
  }

   /**
   * Get rawBits
   * minimum: 0
   * maximum: 4294967295
   * @return rawBits
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RAW_BITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getRawBits() {
    return rawBits;
  }


  @JsonProperty(JSON_PROPERTY_RAW_BITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRawBits(Long rawBits) {
    this.rawBits = rawBits;
  }


  public ReferenceType normal(Boolean normal) {
    this.normal = normal;
    return this;
  }

   /**
   * Get normal
   * @return normal
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NORMAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getNormal() {
    return normal;
  }


  @JsonProperty(JSON_PROPERTY_NORMAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNormal(Boolean normal) {
    this.normal = normal;
  }


  public ReferenceType directAccess(Boolean directAccess) {
    this.directAccess = directAccess;
    return this;
  }

   /**
   * Get directAccess
   * @return directAccess
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DIRECT_ACCESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getDirectAccess() {
    return directAccess;
  }


  @JsonProperty(JSON_PROPERTY_DIRECT_ACCESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDirectAccess(Boolean directAccess) {
    this.directAccess = directAccess;
  }


  /**
   * Return true if this ReferenceType object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReferenceType referenceType = (ReferenceType) o;
    return Objects.equals(this.rawBits, referenceType.rawBits) &&
        Objects.equals(this.normal, referenceType.normal) &&
        Objects.equals(this.directAccess, referenceType.directAccess);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawBits, normal, directAccess);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReferenceType {\n");
    sb.append("    rawBits: ").append(toIndentedString(rawBits)).append("\n");
    sb.append("    normal: ").append(toIndentedString(normal)).append("\n");
    sb.append("    directAccess: ").append(toIndentedString(directAccess)).append("\n");
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
