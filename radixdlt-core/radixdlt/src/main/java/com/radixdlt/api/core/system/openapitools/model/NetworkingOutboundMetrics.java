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
 * NetworkingOutboundMetrics
 */
@JsonPropertyOrder({
  NetworkingOutboundMetrics.JSON_PROPERTY_PROCESSED,
  NetworkingOutboundMetrics.JSON_PROPERTY_ABORTED,
  NetworkingOutboundMetrics.JSON_PROPERTY_PENDING,
  NetworkingOutboundMetrics.JSON_PROPERTY_SENT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-26T18:26:53.100586-06:00[America/Chicago]")
public class NetworkingOutboundMetrics {
  public static final String JSON_PROPERTY_PROCESSED = "processed";
  private Long processed;

  public static final String JSON_PROPERTY_ABORTED = "aborted";
  private Long aborted;

  public static final String JSON_PROPERTY_PENDING = "pending";
  private Long pending;

  public static final String JSON_PROPERTY_SENT = "sent";
  private Long sent;


  public NetworkingOutboundMetrics processed(Long processed) {
    this.processed = processed;
    return this;
  }

   /**
   * Get processed
   * @return processed
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PROCESSED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getProcessed() {
    return processed;
  }


  @JsonProperty(JSON_PROPERTY_PROCESSED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProcessed(Long processed) {
    this.processed = processed;
  }


  public NetworkingOutboundMetrics aborted(Long aborted) {
    this.aborted = aborted;
    return this;
  }

   /**
   * Get aborted
   * @return aborted
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ABORTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getAborted() {
    return aborted;
  }


  @JsonProperty(JSON_PROPERTY_ABORTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAborted(Long aborted) {
    this.aborted = aborted;
  }


  public NetworkingOutboundMetrics pending(Long pending) {
    this.pending = pending;
    return this;
  }

   /**
   * Get pending
   * @return pending
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PENDING)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getPending() {
    return pending;
  }


  @JsonProperty(JSON_PROPERTY_PENDING)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPending(Long pending) {
    this.pending = pending;
  }


  public NetworkingOutboundMetrics sent(Long sent) {
    this.sent = sent;
    return this;
  }

   /**
   * Get sent
   * @return sent
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getSent() {
    return sent;
  }


  @JsonProperty(JSON_PROPERTY_SENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSent(Long sent) {
    this.sent = sent;
  }


  /**
   * Return true if this NetworkingOutboundMetrics object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkingOutboundMetrics networkingOutboundMetrics = (NetworkingOutboundMetrics) o;
    return Objects.equals(this.processed, networkingOutboundMetrics.processed) &&
        Objects.equals(this.aborted, networkingOutboundMetrics.aborted) &&
        Objects.equals(this.pending, networkingOutboundMetrics.pending) &&
        Objects.equals(this.sent, networkingOutboundMetrics.sent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processed, aborted, pending, sent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkingOutboundMetrics {\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    aborted: ").append(toIndentedString(aborted)).append("\n");
    sb.append("    pending: ").append(toIndentedString(pending)).append("\n");
    sb.append("    sent: ").append(toIndentedString(sent)).append("\n");
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

