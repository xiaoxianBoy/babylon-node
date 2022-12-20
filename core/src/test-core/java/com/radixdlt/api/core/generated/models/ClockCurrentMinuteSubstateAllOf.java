/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ClockCurrentMinuteSubstateAllOf
 */
@JsonPropertyOrder({
  ClockCurrentMinuteSubstateAllOf.JSON_PROPERTY_TIMESTAMP_MS_ROUNDED_DOWN_TO_MINUTE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ClockCurrentMinuteSubstateAllOf {
  public static final String JSON_PROPERTY_TIMESTAMP_MS_ROUNDED_DOWN_TO_MINUTE = "timestamp_ms_rounded_down_to_minute";
  private Long timestampMsRoundedDownToMinute;

  public ClockCurrentMinuteSubstateAllOf() { 
  }

  public ClockCurrentMinuteSubstateAllOf timestampMsRoundedDownToMinute(Long timestampMsRoundedDownToMinute) {
    this.timestampMsRoundedDownToMinute = timestampMsRoundedDownToMinute;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^14&#x60;, marking the ledger unix timestamp in ms (rounded down to the current minute)
   * minimum: 0
   * maximum: 100000000000000
   * @return timestampMsRoundedDownToMinute
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^14`, marking the ledger unix timestamp in ms (rounded down to the current minute)")
  @JsonProperty(JSON_PROPERTY_TIMESTAMP_MS_ROUNDED_DOWN_TO_MINUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTimestampMsRoundedDownToMinute() {
    return timestampMsRoundedDownToMinute;
  }


  @JsonProperty(JSON_PROPERTY_TIMESTAMP_MS_ROUNDED_DOWN_TO_MINUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimestampMsRoundedDownToMinute(Long timestampMsRoundedDownToMinute) {
    this.timestampMsRoundedDownToMinute = timestampMsRoundedDownToMinute;
  }


  /**
   * Return true if this ClockCurrentMinuteSubstate_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClockCurrentMinuteSubstateAllOf clockCurrentMinuteSubstateAllOf = (ClockCurrentMinuteSubstateAllOf) o;
    return Objects.equals(this.timestampMsRoundedDownToMinute, clockCurrentMinuteSubstateAllOf.timestampMsRoundedDownToMinute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestampMsRoundedDownToMinute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClockCurrentMinuteSubstateAllOf {\n");
    sb.append("    timestampMsRoundedDownToMinute: ").append(toIndentedString(timestampMsRoundedDownToMinute)).append("\n");
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
