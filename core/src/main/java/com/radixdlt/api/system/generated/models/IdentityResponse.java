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
 * IdentityResponse
 */
@JsonPropertyOrder({
  IdentityResponse.JSON_PROPERTY_PUBLIC_KEY_HEX,
  IdentityResponse.JSON_PROPERTY_NODE_ADDRESS,
  IdentityResponse.JSON_PROPERTY_NODE_URI,
  IdentityResponse.JSON_PROPERTY_NODE_NAME,
  IdentityResponse.JSON_PROPERTY_NODE_ID,
  IdentityResponse.JSON_PROPERTY_VALIDATOR_ADDRESS,
  IdentityResponse.JSON_PROPERTY_VALIDATOR_NAME,
  IdentityResponse.JSON_PROPERTY_CONSENSUS_STATUS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IdentityResponse {
  public static final String JSON_PROPERTY_PUBLIC_KEY_HEX = "public_key_hex";
  private String publicKeyHex;

  public static final String JSON_PROPERTY_NODE_ADDRESS = "node_address";
  private String nodeAddress;

  public static final String JSON_PROPERTY_NODE_URI = "node_uri";
  private String nodeUri;

  public static final String JSON_PROPERTY_NODE_NAME = "node_name";
  private String nodeName;

  public static final String JSON_PROPERTY_NODE_ID = "node_id";
  private String nodeId;

  public static final String JSON_PROPERTY_VALIDATOR_ADDRESS = "validator_address";
  private String validatorAddress;

  public static final String JSON_PROPERTY_VALIDATOR_NAME = "validator_name";
  private String validatorName;

  /**
   * Gets or Sets consensusStatus
   */
  public enum ConsensusStatusEnum {
    VALIDATING_IN_CURRENT_EPOCH("VALIDATING_IN_CURRENT_EPOCH"),
    
    NOT_VALIDATING_IN_CURRENT_EPOCH("NOT_VALIDATING_IN_CURRENT_EPOCH"),
    
    NOT_CONFIGURED_AS_VALIDATOR("NOT_CONFIGURED_AS_VALIDATOR");

    private String value;

    ConsensusStatusEnum(String value) {
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
    public static ConsensusStatusEnum fromValue(String value) {
      for (ConsensusStatusEnum b : ConsensusStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_CONSENSUS_STATUS = "consensus_status";
  private ConsensusStatusEnum consensusStatus;


  public IdentityResponse publicKeyHex(String publicKeyHex) {
    this.publicKeyHex = publicKeyHex;
    return this;
  }

   /**
   * The hex-encoded compressed ECDSA Secp256k1 public key (33 bytes) which the node is using. 
   * @return publicKeyHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded compressed ECDSA Secp256k1 public key (33 bytes) which the node is using. ")
  @JsonProperty(JSON_PROPERTY_PUBLIC_KEY_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPublicKeyHex() {
    return publicKeyHex;
  }


  @JsonProperty(JSON_PROPERTY_PUBLIC_KEY_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPublicKeyHex(String publicKeyHex) {
    this.publicKeyHex = publicKeyHex;
  }


  public IdentityResponse nodeAddress(String nodeAddress) {
    this.nodeAddress = nodeAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable node address, which is a representation of its public key. 
   * @return nodeAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable node address, which is a representation of its public key. ")
  @JsonProperty(JSON_PROPERTY_NODE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNodeAddress() {
    return nodeAddress;
  }


  @JsonProperty(JSON_PROPERTY_NODE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNodeAddress(String nodeAddress) {
    this.nodeAddress = nodeAddress;
  }


  public IdentityResponse nodeUri(String nodeUri) {
    this.nodeUri = nodeUri;
    return this;
  }

   /**
   * The Bech32m-encoded human readable node URI, which is a representation of its public key and IP. 
   * @return nodeUri
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable node URI, which is a representation of its public key and IP. ")
  @JsonProperty(JSON_PROPERTY_NODE_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNodeUri() {
    return nodeUri;
  }


  @JsonProperty(JSON_PROPERTY_NODE_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNodeUri(String nodeUri) {
    this.nodeUri = nodeUri;
  }


  public IdentityResponse nodeName(String nodeName) {
    this.nodeName = nodeName;
    return this;
  }

   /**
   * The name that the node gives to itself internally, used for (eg) logging. 
   * @return nodeName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The name that the node gives to itself internally, used for (eg) logging. ")
  @JsonProperty(JSON_PROPERTY_NODE_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNodeName() {
    return nodeName;
  }


  @JsonProperty(JSON_PROPERTY_NODE_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }


  public IdentityResponse nodeId(String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

   /**
   * The id that the node gives to itself internally. 
   * @return nodeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The id that the node gives to itself internally. ")
  @JsonProperty(JSON_PROPERTY_NODE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNodeId() {
    return nodeId;
  }


  @JsonProperty(JSON_PROPERTY_NODE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }


  public IdentityResponse validatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable validator address which the node believes it is. Depending on node configuration, this was either matched from genesis, or directly configured. 
   * @return validatorAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Bech32m-encoded human readable validator address which the node believes it is. Depending on node configuration, this was either matched from genesis, or directly configured. ")
  @JsonProperty(JSON_PROPERTY_VALIDATOR_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getValidatorAddress() {
    return validatorAddress;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValidatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
  }


  public IdentityResponse validatorName(String validatorName) {
    this.validatorName = validatorName;
    return this;
  }

   /**
   * A shortened representation of the configured validator identity, used for (eg) logging. 
   * @return validatorName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A shortened representation of the configured validator identity, used for (eg) logging. ")
  @JsonProperty(JSON_PROPERTY_VALIDATOR_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getValidatorName() {
    return validatorName;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValidatorName(String validatorName) {
    this.validatorName = validatorName;
  }


  public IdentityResponse consensusStatus(ConsensusStatusEnum consensusStatus) {
    this.consensusStatus = consensusStatus;
    return this;
  }

   /**
   * Get consensusStatus
   * @return consensusStatus
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CONSENSUS_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ConsensusStatusEnum getConsensusStatus() {
    return consensusStatus;
  }


  @JsonProperty(JSON_PROPERTY_CONSENSUS_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setConsensusStatus(ConsensusStatusEnum consensusStatus) {
    this.consensusStatus = consensusStatus;
  }


  /**
   * Return true if this IdentityResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityResponse identityResponse = (IdentityResponse) o;
    return Objects.equals(this.publicKeyHex, identityResponse.publicKeyHex) &&
        Objects.equals(this.nodeAddress, identityResponse.nodeAddress) &&
        Objects.equals(this.nodeUri, identityResponse.nodeUri) &&
        Objects.equals(this.nodeName, identityResponse.nodeName) &&
        Objects.equals(this.nodeId, identityResponse.nodeId) &&
        Objects.equals(this.validatorAddress, identityResponse.validatorAddress) &&
        Objects.equals(this.validatorName, identityResponse.validatorName) &&
        Objects.equals(this.consensusStatus, identityResponse.consensusStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publicKeyHex, nodeAddress, nodeUri, nodeName, nodeId, validatorAddress, validatorName, consensusStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityResponse {\n");
    sb.append("    publicKeyHex: ").append(toIndentedString(publicKeyHex)).append("\n");
    sb.append("    nodeAddress: ").append(toIndentedString(nodeAddress)).append("\n");
    sb.append("    nodeUri: ").append(toIndentedString(nodeUri)).append("\n");
    sb.append("    nodeName: ").append(toIndentedString(nodeName)).append("\n");
    sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
    sb.append("    validatorAddress: ").append(toIndentedString(validatorAddress)).append("\n");
    sb.append("    validatorName: ").append(toIndentedString(validatorName)).append("\n");
    sb.append("    consensusStatus: ").append(toIndentedString(consensusStatus)).append("\n");
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

