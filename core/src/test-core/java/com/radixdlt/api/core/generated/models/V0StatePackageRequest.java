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
 * V0StatePackageRequest
 */
@JsonPropertyOrder({
  V0StatePackageRequest.JSON_PROPERTY_PACKAGE_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V0StatePackageRequest {
  public static final String JSON_PROPERTY_PACKAGE_ADDRESS = "package_address";
  private String packageAddress;

  public V0StatePackageRequest() { 
  }

  public V0StatePackageRequest packageAddress(String packageAddress) {
    this.packageAddress = packageAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the package&#39;s global address
   * @return packageAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the package's global address")
  @JsonProperty(JSON_PROPERTY_PACKAGE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPackageAddress() {
    return packageAddress;
  }


  @JsonProperty(JSON_PROPERTY_PACKAGE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPackageAddress(String packageAddress) {
    this.packageAddress = packageAddress;
  }


  /**
   * Return true if this V0StatePackageRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V0StatePackageRequest v0StatePackageRequest = (V0StatePackageRequest) o;
    return Objects.equals(this.packageAddress, v0StatePackageRequest.packageAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packageAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V0StatePackageRequest {\n");
    sb.append("    packageAddress: ").append(toIndentedString(packageAddress)).append("\n");
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
