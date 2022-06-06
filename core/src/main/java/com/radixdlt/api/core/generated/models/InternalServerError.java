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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.CoreErrorDetails;
import com.radixdlt.api.core.generated.models.InternalServerError;
import com.radixdlt.api.core.generated.models.InternalServerErrorAllOf;
import com.radixdlt.api.core.generated.models.InvalidHexError;
import com.radixdlt.api.core.generated.models.InvalidJsonError;
import com.radixdlt.api.core.generated.models.InvalidTransactionError;
import com.radixdlt.api.core.generated.models.MempoolFullError;
import com.radixdlt.api.core.generated.models.NetworkNotSupportedError;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.common.JSON;
/**
 * InternalServerError
 */
@JsonPropertyOrder({
  InternalServerError.JSON_PROPERTY_EXCEPTION,
  InternalServerError.JSON_PROPERTY_CAUSE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = InternalServerError.class, name = "InternalServerError"),
  @JsonSubTypes.Type(value = InvalidHexError.class, name = "InvalidHexError"),
  @JsonSubTypes.Type(value = InvalidJsonError.class, name = "InvalidJsonError"),
  @JsonSubTypes.Type(value = InvalidTransactionError.class, name = "InvalidTransactionError"),
  @JsonSubTypes.Type(value = MempoolFullError.class, name = "MempoolFullError"),
  @JsonSubTypes.Type(value = NetworkNotSupportedError.class, name = "NetworkNotSupportedError"),
})

public class InternalServerError extends CoreErrorDetails {
  public static final String JSON_PROPERTY_EXCEPTION = "exception";
  private String exception;

  public static final String JSON_PROPERTY_CAUSE = "cause";
  private String cause;


  public InternalServerError exception(String exception) {
    this.exception = exception;
    return this;
  }

   /**
   * Get exception
   * @return exception
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EXCEPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getException() {
    return exception;
  }


  @JsonProperty(JSON_PROPERTY_EXCEPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setException(String exception) {
    this.exception = exception;
  }


  public InternalServerError cause(String cause) {
    this.cause = cause;
    return this;
  }

   /**
   * Get cause
   * @return cause
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CAUSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCause() {
    return cause;
  }


  @JsonProperty(JSON_PROPERTY_CAUSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCause(String cause) {
    this.cause = cause;
  }


  /**
   * Return true if this InternalServerError object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InternalServerError internalServerError = (InternalServerError) o;
    return Objects.equals(this.exception, internalServerError.exception) &&
        Objects.equals(this.cause, internalServerError.cause) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exception, cause, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InternalServerError {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
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

static {
  // Initialize and register the discriminator mappings.
  Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
  mappings.put("InternalServerError", InternalServerError.class);
  mappings.put("InvalidHexError", InvalidHexError.class);
  mappings.put("InvalidJsonError", InvalidJsonError.class);
  mappings.put("InvalidTransactionError", InvalidTransactionError.class);
  mappings.put("MempoolFullError", MempoolFullError.class);
  mappings.put("NetworkNotSupportedError", NetworkNotSupportedError.class);
  mappings.put("InternalServerError", InternalServerError.class);
  JSON.registerDiscriminator(InternalServerError.class, "type", mappings);
}
}

