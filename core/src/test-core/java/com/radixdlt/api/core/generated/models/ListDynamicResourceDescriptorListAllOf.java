/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
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
import com.radixdlt.api.core.generated.models.DynamicResourceDescriptor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ListDynamicResourceDescriptorListAllOf
 */
@JsonPropertyOrder({
  ListDynamicResourceDescriptorListAllOf.JSON_PROPERTY_RESOURCES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ListDynamicResourceDescriptorListAllOf {
  public static final String JSON_PROPERTY_RESOURCES = "resources";
  private List<DynamicResourceDescriptor> resources = new ArrayList<>();

  public ListDynamicResourceDescriptorListAllOf() { 
  }

  public ListDynamicResourceDescriptorListAllOf resources(List<DynamicResourceDescriptor> resources) {
    this.resources = resources;
    return this;
  }

  public ListDynamicResourceDescriptorListAllOf addResourcesItem(DynamicResourceDescriptor resourcesItem) {
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Get resources
   * @return resources
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<DynamicResourceDescriptor> getResources() {
    return resources;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResources(List<DynamicResourceDescriptor> resources) {
    this.resources = resources;
  }


  /**
   * Return true if this ListDynamicResourceDescriptorList_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListDynamicResourceDescriptorListAllOf listDynamicResourceDescriptorListAllOf = (ListDynamicResourceDescriptorListAllOf) o;
    return Objects.equals(this.resources, listDynamicResourceDescriptorListAllOf.resources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListDynamicResourceDescriptorListAllOf {\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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

