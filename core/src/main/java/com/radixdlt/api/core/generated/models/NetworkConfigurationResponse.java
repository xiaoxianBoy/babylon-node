/*
 * Babylon Core API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
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
import com.radixdlt.api.core.generated.models.Bech32HRPs;
import com.radixdlt.api.core.generated.models.NetworkConfigurationResponseVersion;
import com.radixdlt.api.core.generated.models.NetworkIdentifier;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * NetworkConfigurationResponse
 */
@JsonPropertyOrder({
  NetworkConfigurationResponse.JSON_PROPERTY_VERSION,
  NetworkConfigurationResponse.JSON_PROPERTY_NETWORK_IDENTIFIER,
  NetworkConfigurationResponse.JSON_PROPERTY_BECH32_HUMAN_READABLE_PARTS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class NetworkConfigurationResponse {
  public static final String JSON_PROPERTY_VERSION = "version";
  private NetworkConfigurationResponseVersion version;

  public static final String JSON_PROPERTY_NETWORK_IDENTIFIER = "network_identifier";
  private NetworkIdentifier networkIdentifier;

  public static final String JSON_PROPERTY_BECH32_HUMAN_READABLE_PARTS = "bech32_human_readable_parts";
  private Bech32HRPs bech32HumanReadableParts;


  public NetworkConfigurationResponse version(NetworkConfigurationResponseVersion version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public NetworkConfigurationResponseVersion getVersion() {
    return version;
  }


  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVersion(NetworkConfigurationResponseVersion version) {
    this.version = version;
  }


  public NetworkConfigurationResponse networkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
    return this;
  }

   /**
   * Get networkIdentifier
   * @return networkIdentifier
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NETWORK_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public NetworkIdentifier getNetworkIdentifier() {
    return networkIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_NETWORK_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNetworkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
  }


  public NetworkConfigurationResponse bech32HumanReadableParts(Bech32HRPs bech32HumanReadableParts) {
    this.bech32HumanReadableParts = bech32HumanReadableParts;
    return this;
  }

   /**
   * Get bech32HumanReadableParts
   * @return bech32HumanReadableParts
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BECH32_HUMAN_READABLE_PARTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Bech32HRPs getBech32HumanReadableParts() {
    return bech32HumanReadableParts;
  }


  @JsonProperty(JSON_PROPERTY_BECH32_HUMAN_READABLE_PARTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBech32HumanReadableParts(Bech32HRPs bech32HumanReadableParts) {
    this.bech32HumanReadableParts = bech32HumanReadableParts;
  }


  /**
   * Return true if this NetworkConfigurationResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkConfigurationResponse networkConfigurationResponse = (NetworkConfigurationResponse) o;
    return Objects.equals(this.version, networkConfigurationResponse.version) &&
        Objects.equals(this.networkIdentifier, networkConfigurationResponse.networkIdentifier) &&
        Objects.equals(this.bech32HumanReadableParts, networkConfigurationResponse.bech32HumanReadableParts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, networkIdentifier, bech32HumanReadableParts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkConfigurationResponse {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    bech32HumanReadableParts: ").append(toIndentedString(bech32HumanReadableParts)).append("\n");
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
