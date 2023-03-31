/*
 * Babylon System API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html).  ## Integration and forward compatibility guarantees  We give no guarantees that endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.system.generated.models;

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
 * BFTConfiguration
 */
@JsonPropertyOrder({
  BFTConfiguration.JSON_PROPERTY_PACEMAKER_TIMEOUT,
  BFTConfiguration.JSON_PROPERTY_BFT_SYNC_PATIENCE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BFTConfiguration {
  public static final String JSON_PROPERTY_PACEMAKER_TIMEOUT = "pacemaker_timeout";
  private Long pacemakerTimeout;

  public static final String JSON_PROPERTY_BFT_SYNC_PATIENCE = "bft_sync_patience";
  private Integer bftSyncPatience;


  public BFTConfiguration pacemakerTimeout(Long pacemakerTimeout) {
    this.pacemakerTimeout = pacemakerTimeout;
    return this;
  }

   /**
   * Get pacemakerTimeout
   * @return pacemakerTimeout
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PACEMAKER_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getPacemakerTimeout() {
    return pacemakerTimeout;
  }


  @JsonProperty(JSON_PROPERTY_PACEMAKER_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPacemakerTimeout(Long pacemakerTimeout) {
    this.pacemakerTimeout = pacemakerTimeout;
  }


  public BFTConfiguration bftSyncPatience(Integer bftSyncPatience) {
    this.bftSyncPatience = bftSyncPatience;
    return this;
  }

   /**
   * Get bftSyncPatience
   * @return bftSyncPatience
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BFT_SYNC_PATIENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getBftSyncPatience() {
    return bftSyncPatience;
  }


  @JsonProperty(JSON_PROPERTY_BFT_SYNC_PATIENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBftSyncPatience(Integer bftSyncPatience) {
    this.bftSyncPatience = bftSyncPatience;
  }


  /**
   * Return true if this BFTConfiguration object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BFTConfiguration bfTConfiguration = (BFTConfiguration) o;
    return Objects.equals(this.pacemakerTimeout, bfTConfiguration.pacemakerTimeout) &&
        Objects.equals(this.bftSyncPatience, bfTConfiguration.bftSyncPatience);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pacemakerTimeout, bftSyncPatience);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BFTConfiguration {\n");
    sb.append("    pacemakerTimeout: ").append(toIndentedString(pacemakerTimeout)).append("\n");
    sb.append("    bftSyncPatience: ").append(toIndentedString(bftSyncPatience)).append("\n");
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

