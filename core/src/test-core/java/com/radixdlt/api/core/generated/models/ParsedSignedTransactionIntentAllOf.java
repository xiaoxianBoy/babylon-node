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
import com.radixdlt.api.core.generated.models.ParsedSignedTransactionIntentAllOfIdentifiers;
import com.radixdlt.api.core.generated.models.SignedTransactionIntent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ParsedSignedTransactionIntentAllOf
 */
@JsonPropertyOrder({
  ParsedSignedTransactionIntentAllOf.JSON_PROPERTY_SIGNED_INTENT,
  ParsedSignedTransactionIntentAllOf.JSON_PROPERTY_IDENTIFIERS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ParsedSignedTransactionIntentAllOf {
  public static final String JSON_PROPERTY_SIGNED_INTENT = "signed_intent";
  private SignedTransactionIntent signedIntent;

  public static final String JSON_PROPERTY_IDENTIFIERS = "identifiers";
  private ParsedSignedTransactionIntentAllOfIdentifiers identifiers;

  public ParsedSignedTransactionIntentAllOf() { 
  }

  public ParsedSignedTransactionIntentAllOf signedIntent(SignedTransactionIntent signedIntent) {
    this.signedIntent = signedIntent;
    return this;
  }

   /**
   * Get signedIntent
   * @return signedIntent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SIGNED_INTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SignedTransactionIntent getSignedIntent() {
    return signedIntent;
  }


  @JsonProperty(JSON_PROPERTY_SIGNED_INTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignedIntent(SignedTransactionIntent signedIntent) {
    this.signedIntent = signedIntent;
  }


  public ParsedSignedTransactionIntentAllOf identifiers(ParsedSignedTransactionIntentAllOfIdentifiers identifiers) {
    this.identifiers = identifiers;
    return this;
  }

   /**
   * Get identifiers
   * @return identifiers
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ParsedSignedTransactionIntentAllOfIdentifiers getIdentifiers() {
    return identifiers;
  }


  @JsonProperty(JSON_PROPERTY_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIdentifiers(ParsedSignedTransactionIntentAllOfIdentifiers identifiers) {
    this.identifiers = identifiers;
  }


  /**
   * Return true if this ParsedSignedTransactionIntent_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParsedSignedTransactionIntentAllOf parsedSignedTransactionIntentAllOf = (ParsedSignedTransactionIntentAllOf) o;
    return Objects.equals(this.signedIntent, parsedSignedTransactionIntentAllOf.signedIntent) &&
        Objects.equals(this.identifiers, parsedSignedTransactionIntentAllOf.identifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signedIntent, identifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParsedSignedTransactionIntentAllOf {\n");
    sb.append("    signedIntent: ").append(toIndentedString(signedIntent)).append("\n");
    sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
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

