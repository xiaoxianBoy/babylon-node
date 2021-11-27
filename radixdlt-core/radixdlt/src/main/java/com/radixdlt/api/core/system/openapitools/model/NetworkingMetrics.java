/*
 * Radix System API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.core.system.openapitools.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * NetworkingMetrics
 */
@JsonPropertyOrder({
  NetworkingMetrics.JSON_PROPERTY_BYTES_SENT,
  NetworkingMetrics.JSON_PROPERTY_BYTES_RECEIVED,
  NetworkingMetrics.JSON_PROPERTY_INBOUND,
  NetworkingMetrics.JSON_PROPERTY_OUTBOUND
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-26T18:26:53.100586-06:00[America/Chicago]")
public class NetworkingMetrics {
  public static final String JSON_PROPERTY_BYTES_SENT = "bytes_sent";
  private Long bytesSent;

  public static final String JSON_PROPERTY_BYTES_RECEIVED = "bytes_received";
  private Long bytesReceived;

  public static final String JSON_PROPERTY_INBOUND = "inbound";
  private NetworkingInboundMetrics inbound;

  public static final String JSON_PROPERTY_OUTBOUND = "outbound";
  private NetworkingOutboundMetrics outbound;


  public NetworkingMetrics bytesSent(Long bytesSent) {
    this.bytesSent = bytesSent;
    return this;
  }

   /**
   * Get bytesSent
   * @return bytesSent
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BYTES_SENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getBytesSent() {
    return bytesSent;
  }


  @JsonProperty(JSON_PROPERTY_BYTES_SENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBytesSent(Long bytesSent) {
    this.bytesSent = bytesSent;
  }


  public NetworkingMetrics bytesReceived(Long bytesReceived) {
    this.bytesReceived = bytesReceived;
    return this;
  }

   /**
   * Get bytesReceived
   * @return bytesReceived
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BYTES_RECEIVED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getBytesReceived() {
    return bytesReceived;
  }


  @JsonProperty(JSON_PROPERTY_BYTES_RECEIVED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBytesReceived(Long bytesReceived) {
    this.bytesReceived = bytesReceived;
  }


  public NetworkingMetrics inbound(NetworkingInboundMetrics inbound) {
    this.inbound = inbound;
    return this;
  }

   /**
   * Get inbound
   * @return inbound
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INBOUND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public NetworkingInboundMetrics getInbound() {
    return inbound;
  }


  @JsonProperty(JSON_PROPERTY_INBOUND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInbound(NetworkingInboundMetrics inbound) {
    this.inbound = inbound;
  }


  public NetworkingMetrics outbound(NetworkingOutboundMetrics outbound) {
    this.outbound = outbound;
    return this;
  }

   /**
   * Get outbound
   * @return outbound
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_OUTBOUND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public NetworkingOutboundMetrics getOutbound() {
    return outbound;
  }


  @JsonProperty(JSON_PROPERTY_OUTBOUND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOutbound(NetworkingOutboundMetrics outbound) {
    this.outbound = outbound;
  }


  /**
   * Return true if this NetworkingMetrics object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkingMetrics networkingMetrics = (NetworkingMetrics) o;
    return Objects.equals(this.bytesSent, networkingMetrics.bytesSent) &&
        Objects.equals(this.bytesReceived, networkingMetrics.bytesReceived) &&
        Objects.equals(this.inbound, networkingMetrics.inbound) &&
        Objects.equals(this.outbound, networkingMetrics.outbound);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bytesSent, bytesReceived, inbound, outbound);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkingMetrics {\n");
    sb.append("    bytesSent: ").append(toIndentedString(bytesSent)).append("\n");
    sb.append("    bytesReceived: ").append(toIndentedString(bytesReceived)).append("\n");
    sb.append("    inbound: ").append(toIndentedString(inbound)).append("\n");
    sb.append("    outbound: ").append(toIndentedString(outbound)).append("\n");
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

