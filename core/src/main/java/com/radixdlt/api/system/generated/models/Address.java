/*
 * Radix System API - Babylon (v1.0.0)
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: 1.0.0
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
 * Address
 */
@JsonPropertyOrder({
  Address.JSON_PROPERTY_URI,
  Address.JSON_PROPERTY_FAILED_HANDSHAKE,
  Address.JSON_PROPERTY_LAST_CONNECTION_STATUS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Address {
  public static final String JSON_PROPERTY_URI = "uri";
  private String uri;

  public static final String JSON_PROPERTY_FAILED_HANDSHAKE = "failed_handshake";
  private Boolean failedHandshake;

  /**
   * Gets or Sets lastConnectionStatus
   */
  public enum LastConnectionStatusEnum {
    SUCCESS("SUCCESS"),
    
    FAILURE("FAILURE"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    LastConnectionStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LastConnectionStatusEnum fromValue(String value) {
      for (LastConnectionStatusEnum b : LastConnectionStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_LAST_CONNECTION_STATUS = "last_connection_status";
  private LastConnectionStatusEnum lastConnectionStatus;


  public Address uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * Get uri
   * @return uri
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUri() {
    return uri;
  }


  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUri(String uri) {
    this.uri = uri;
  }


  public Address failedHandshake(Boolean failedHandshake) {
    this.failedHandshake = failedHandshake;
    return this;
  }

   /**
   * Get failedHandshake
   * @return failedHandshake
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FAILED_HANDSHAKE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getFailedHandshake() {
    return failedHandshake;
  }


  @JsonProperty(JSON_PROPERTY_FAILED_HANDSHAKE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFailedHandshake(Boolean failedHandshake) {
    this.failedHandshake = failedHandshake;
  }


  public Address lastConnectionStatus(LastConnectionStatusEnum lastConnectionStatus) {
    this.lastConnectionStatus = lastConnectionStatus;
    return this;
  }

   /**
   * Get lastConnectionStatus
   * @return lastConnectionStatus
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LAST_CONNECTION_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LastConnectionStatusEnum getLastConnectionStatus() {
    return lastConnectionStatus;
  }


  @JsonProperty(JSON_PROPERTY_LAST_CONNECTION_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastConnectionStatus(LastConnectionStatusEnum lastConnectionStatus) {
    this.lastConnectionStatus = lastConnectionStatus;
  }


  /**
   * Return true if this Address object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.uri, address.uri) &&
        Objects.equals(this.failedHandshake, address.failedHandshake) &&
        Objects.equals(this.lastConnectionStatus, address.lastConnectionStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri, failedHandshake, lastConnectionStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    failedHandshake: ").append(toIndentedString(failedHandshake)).append("\n");
    sb.append("    lastConnectionStatus: ").append(toIndentedString(lastConnectionStatus)).append("\n");
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

