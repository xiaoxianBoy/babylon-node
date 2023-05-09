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
 * Requested SBOR formats
 */
@ApiModel(description = "Requested SBOR formats")
@JsonPropertyOrder({
  SborFormats.JSON_PROPERTY_RAW_HEX,
  SborFormats.JSON_PROPERTY_PROGRAMMATIC_JSON
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SborFormats {
  public static final String JSON_PROPERTY_RAW_HEX = "raw_hex";
  private Boolean rawHex;

  public static final String JSON_PROPERTY_PROGRAMMATIC_JSON = "programmatic_json";
  private Boolean programmaticJson;

  public SborFormats() { 
  }

  public SborFormats rawHex(Boolean rawHex) {
    this.rawHex = rawHex;
    return this;
  }

   /**
   * Whether to return the raw hex-encoded bytes (default true)
   * @return rawHex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether to return the raw hex-encoded bytes (default true)")
  @JsonProperty(JSON_PROPERTY_RAW_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getRawHex() {
    return rawHex;
  }


  @JsonProperty(JSON_PROPERTY_RAW_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRawHex(Boolean rawHex) {
    this.rawHex = rawHex;
  }


  public SborFormats programmaticJson(Boolean programmaticJson) {
    this.programmaticJson = programmaticJson;
    return this;
  }

   /**
   * Whether to return the programmatic json format (default true)
   * @return programmaticJson
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether to return the programmatic json format (default true)")
  @JsonProperty(JSON_PROPERTY_PROGRAMMATIC_JSON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getProgrammaticJson() {
    return programmaticJson;
  }


  @JsonProperty(JSON_PROPERTY_PROGRAMMATIC_JSON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProgrammaticJson(Boolean programmaticJson) {
    this.programmaticJson = programmaticJson;
  }


  /**
   * Return true if this SborFormats object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SborFormats sborFormats = (SborFormats) o;
    return Objects.equals(this.rawHex, sborFormats.rawHex) &&
        Objects.equals(this.programmaticJson, sborFormats.programmaticJson);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawHex, programmaticJson);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SborFormats {\n");
    sb.append("    rawHex: ").append(toIndentedString(rawHex)).append("\n");
    sb.append("    programmaticJson: ").append(toIndentedString(programmaticJson)).append("\n");
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

