/*
 * Radix Gateway API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.9.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.gateway.openapitools.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.radixdlt.api.gateway.openapitools.JSON;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * InvalidValidatorAddress
 */
@JsonPropertyOrder({
  InvalidValidatorAddress.JSON_PROPERTY_INVALID_ACCOUNT_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-01T18:41:04.998487-06:00[America/Chicago]")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = BelowMinimumStakeError.class, name = "BelowMinimumStakeError"),
  @JsonSubTypes.Type(value = CouldNotConstructFeesError.class, name = "CouldNotConstructFeesError"),
  @JsonSubTypes.Type(value = InvalidAccountAddress.class, name = "InvalidAccountAddress"),
  @JsonSubTypes.Type(value = InvalidPublicKey.class, name = "InvalidPublicKey"),
  @JsonSubTypes.Type(value = InvalidTokenRRI.class, name = "InvalidTokenRRI"),
  @JsonSubTypes.Type(value = InvalidTokenSymbol.class, name = "InvalidTokenSymbol"),
  @JsonSubTypes.Type(value = InvalidValidatorAddress.class, name = "InvalidValidatorAddress"),
  @JsonSubTypes.Type(value = MessageTooLongError.class, name = "MessageTooLongError"),
  @JsonSubTypes.Type(value = NotEnoughResourcesError.class, name = "NotEnoughResourcesError"),
  @JsonSubTypes.Type(value = NotValidatorOwnerError.class, name = "NotValidatorOwnerError"),
  @JsonSubTypes.Type(value = TokenNotFound.class, name = "TokenNotFound"),
})

public class InvalidValidatorAddress extends ErrorDetails {
  public static final String JSON_PROPERTY_INVALID_ACCOUNT_ADDRESS = "invalid_account_address";
  private String invalidAccountAddress;


  public InvalidValidatorAddress invalidAccountAddress(String invalidAccountAddress) {
    this.invalidAccountAddress = invalidAccountAddress;
    return this;
  }

   /**
   * Get invalidAccountAddress
   * @return invalidAccountAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INVALID_ACCOUNT_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInvalidAccountAddress() {
    return invalidAccountAddress;
  }


  @JsonProperty(JSON_PROPERTY_INVALID_ACCOUNT_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvalidAccountAddress(String invalidAccountAddress) {
    this.invalidAccountAddress = invalidAccountAddress;
  }


  /**
   * Return true if this InvalidValidatorAddress object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvalidValidatorAddress invalidValidatorAddress = (InvalidValidatorAddress) o;
    return Objects.equals(this.invalidAccountAddress, invalidValidatorAddress.invalidAccountAddress) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(invalidAccountAddress, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvalidValidatorAddress {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    invalidAccountAddress: ").append(toIndentedString(invalidAccountAddress)).append("\n");
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
  mappings.put("BelowMinimumStakeError", BelowMinimumStakeError.class);
  mappings.put("CouldNotConstructFeesError", CouldNotConstructFeesError.class);
  mappings.put("InvalidAccountAddress", InvalidAccountAddress.class);
  mappings.put("InvalidPublicKey", InvalidPublicKey.class);
  mappings.put("InvalidTokenRRI", InvalidTokenRRI.class);
  mappings.put("InvalidTokenSymbol", InvalidTokenSymbol.class);
  mappings.put("InvalidValidatorAddress", InvalidValidatorAddress.class);
  mappings.put("MessageTooLongError", MessageTooLongError.class);
  mappings.put("NotEnoughResourcesError", NotEnoughResourcesError.class);
  mappings.put("NotValidatorOwnerError", NotValidatorOwnerError.class);
  mappings.put("TokenNotFound", TokenNotFound.class);
  mappings.put("InvalidValidatorAddress", InvalidValidatorAddress.class);
  JSON.registerDiscriminator(InvalidValidatorAddress.class, "type", mappings);
}
}

