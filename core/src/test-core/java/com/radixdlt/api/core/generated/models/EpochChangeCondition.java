/*
 * Radix Core API - Babylon (v1.0.0)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: 1.0.0
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
 * EpochChangeCondition
 */
@JsonPropertyOrder({
  EpochChangeCondition.JSON_PROPERTY_MIN_ROUND_COUNT,
  EpochChangeCondition.JSON_PROPERTY_MAX_ROUND_COUNT,
  EpochChangeCondition.JSON_PROPERTY_TARGET_DURATION_MILLIS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EpochChangeCondition {
  public static final String JSON_PROPERTY_MIN_ROUND_COUNT = "min_round_count";
  private Long minRoundCount;

  public static final String JSON_PROPERTY_MAX_ROUND_COUNT = "max_round_count";
  private Long maxRoundCount;

  public static final String JSON_PROPERTY_TARGET_DURATION_MILLIS = "target_duration_millis";
  private Long targetDurationMillis;

  public EpochChangeCondition() { 
  }

  public EpochChangeCondition minRoundCount(Long minRoundCount) {
    this.minRoundCount = minRoundCount;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the minimum number of rounds per epoch
   * minimum: 0
   * maximum: 10000000000
   * @return minRoundCount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the minimum number of rounds per epoch")
  @JsonProperty(JSON_PROPERTY_MIN_ROUND_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getMinRoundCount() {
    return minRoundCount;
  }


  @JsonProperty(JSON_PROPERTY_MIN_ROUND_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMinRoundCount(Long minRoundCount) {
    this.minRoundCount = minRoundCount;
  }


  public EpochChangeCondition maxRoundCount(Long maxRoundCount) {
    this.maxRoundCount = maxRoundCount;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the maximum number of rounds per epoch
   * minimum: 0
   * maximum: 10000000000
   * @return maxRoundCount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the maximum number of rounds per epoch")
  @JsonProperty(JSON_PROPERTY_MAX_ROUND_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getMaxRoundCount() {
    return maxRoundCount;
  }


  @JsonProperty(JSON_PROPERTY_MAX_ROUND_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMaxRoundCount(Long maxRoundCount) {
    this.maxRoundCount = maxRoundCount;
  }


  public EpochChangeCondition targetDurationMillis(Long targetDurationMillis) {
    this.targetDurationMillis = targetDurationMillis;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the target number of milliseconds per epoch, assuming the round number is within the min and max range. 
   * minimum: 0
   * maximum: 10000000000
   * @return targetDurationMillis
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the target number of milliseconds per epoch, assuming the round number is within the min and max range. ")
  @JsonProperty(JSON_PROPERTY_TARGET_DURATION_MILLIS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTargetDurationMillis() {
    return targetDurationMillis;
  }


  @JsonProperty(JSON_PROPERTY_TARGET_DURATION_MILLIS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTargetDurationMillis(Long targetDurationMillis) {
    this.targetDurationMillis = targetDurationMillis;
  }


  /**
   * Return true if this EpochChangeCondition object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EpochChangeCondition epochChangeCondition = (EpochChangeCondition) o;
    return Objects.equals(this.minRoundCount, epochChangeCondition.minRoundCount) &&
        Objects.equals(this.maxRoundCount, epochChangeCondition.maxRoundCount) &&
        Objects.equals(this.targetDurationMillis, epochChangeCondition.targetDurationMillis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minRoundCount, maxRoundCount, targetDurationMillis);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EpochChangeCondition {\n");
    sb.append("    minRoundCount: ").append(toIndentedString(minRoundCount)).append("\n");
    sb.append("    maxRoundCount: ").append(toIndentedString(maxRoundCount)).append("\n");
    sb.append("    targetDurationMillis: ").append(toIndentedString(targetDurationMillis)).append("\n");
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

