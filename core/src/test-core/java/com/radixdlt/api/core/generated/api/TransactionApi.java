/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v2\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.radixdlt.api.core.generated.api;

import com.radixdlt.api.core.generated.client.ApiClient;
import com.radixdlt.api.core.generated.client.ApiException;
import com.radixdlt.api.core.generated.client.ApiResponse;
import com.radixdlt.api.core.generated.client.Pair;

import com.radixdlt.api.core.generated.models.BasicErrorResponse;
import com.radixdlt.api.core.generated.models.TransactionCallPreviewRequest;
import com.radixdlt.api.core.generated.models.TransactionCallPreviewResponse;
import com.radixdlt.api.core.generated.models.TransactionParseRequest;
import com.radixdlt.api.core.generated.models.TransactionParseResponse;
import com.radixdlt.api.core.generated.models.TransactionPreviewRequest;
import com.radixdlt.api.core.generated.models.TransactionPreviewResponse;
import com.radixdlt.api.core.generated.models.TransactionReceiptRequest;
import com.radixdlt.api.core.generated.models.TransactionReceiptResponse;
import com.radixdlt.api.core.generated.models.TransactionStatusRequest;
import com.radixdlt.api.core.generated.models.TransactionStatusResponse;
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorResponse;
import com.radixdlt.api.core.generated.models.TransactionSubmitRequest;
import com.radixdlt.api.core.generated.models.TransactionSubmitResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public TransactionApi() {
    this(new ApiClient());
  }

  public TransactionApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Scrypto Call Preview
   * Preview a scrypto function or method call against the latest network state. Returns the result of the scrypto function or method call. 
   * @param transactionCallPreviewRequest  (required)
   * @return TransactionCallPreviewResponse
   * @throws ApiException if fails to make API call
   */
  public TransactionCallPreviewResponse transactionCallPreviewPost(TransactionCallPreviewRequest transactionCallPreviewRequest) throws ApiException {
    ApiResponse<TransactionCallPreviewResponse> localVarResponse = transactionCallPreviewPostWithHttpInfo(transactionCallPreviewRequest);
    return localVarResponse.getData();
  }

  /**
   * Scrypto Call Preview
   * Preview a scrypto function or method call against the latest network state. Returns the result of the scrypto function or method call. 
   * @param transactionCallPreviewRequest  (required)
   * @return ApiResponse&lt;TransactionCallPreviewResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<TransactionCallPreviewResponse> transactionCallPreviewPostWithHttpInfo(TransactionCallPreviewRequest transactionCallPreviewRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = transactionCallPreviewPostRequestBuilder(transactionCallPreviewRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("transactionCallPreviewPost", localVarResponse);
        }
        return new ApiResponse<TransactionCallPreviewResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<TransactionCallPreviewResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder transactionCallPreviewPostRequestBuilder(TransactionCallPreviewRequest transactionCallPreviewRequest) throws ApiException {
    // verify the required parameter 'transactionCallPreviewRequest' is set
    if (transactionCallPreviewRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'transactionCallPreviewRequest' when calling transactionCallPreviewPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/transaction/call-preview";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(transactionCallPreviewRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Parse Transaction Payload
   * Extracts the contents and hashes of various types of transaction payloads, or sub-payloads.
   * @param transactionParseRequest  (required)
   * @return TransactionParseResponse
   * @throws ApiException if fails to make API call
   */
  public TransactionParseResponse transactionParsePost(TransactionParseRequest transactionParseRequest) throws ApiException {
    ApiResponse<TransactionParseResponse> localVarResponse = transactionParsePostWithHttpInfo(transactionParseRequest);
    return localVarResponse.getData();
  }

  /**
   * Parse Transaction Payload
   * Extracts the contents and hashes of various types of transaction payloads, or sub-payloads.
   * @param transactionParseRequest  (required)
   * @return ApiResponse&lt;TransactionParseResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<TransactionParseResponse> transactionParsePostWithHttpInfo(TransactionParseRequest transactionParseRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = transactionParsePostRequestBuilder(transactionParseRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("transactionParsePost", localVarResponse);
        }
        return new ApiResponse<TransactionParseResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<TransactionParseResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder transactionParsePostRequestBuilder(TransactionParseRequest transactionParseRequest) throws ApiException {
    // verify the required parameter 'transactionParseRequest' is set
    if (transactionParseRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'transactionParseRequest' when calling transactionParsePost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/transaction/parse";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(transactionParseRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Transaction Preview
   * Preview a transaction against the latest network state, and returns the preview receipt. 
   * @param transactionPreviewRequest  (required)
   * @return TransactionPreviewResponse
   * @throws ApiException if fails to make API call
   */
  public TransactionPreviewResponse transactionPreviewPost(TransactionPreviewRequest transactionPreviewRequest) throws ApiException {
    ApiResponse<TransactionPreviewResponse> localVarResponse = transactionPreviewPostWithHttpInfo(transactionPreviewRequest);
    return localVarResponse.getData();
  }

  /**
   * Transaction Preview
   * Preview a transaction against the latest network state, and returns the preview receipt. 
   * @param transactionPreviewRequest  (required)
   * @return ApiResponse&lt;TransactionPreviewResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<TransactionPreviewResponse> transactionPreviewPostWithHttpInfo(TransactionPreviewRequest transactionPreviewRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = transactionPreviewPostRequestBuilder(transactionPreviewRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("transactionPreviewPost", localVarResponse);
        }
        return new ApiResponse<TransactionPreviewResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<TransactionPreviewResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder transactionPreviewPostRequestBuilder(TransactionPreviewRequest transactionPreviewRequest) throws ApiException {
    // verify the required parameter 'transactionPreviewRequest' is set
    if (transactionPreviewRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'transactionPreviewRequest' when calling transactionPreviewPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/transaction/preview";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(transactionPreviewRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get Transaction Receipt
   * Gets the transaction receipt for a committed transaction. 
   * @param transactionReceiptRequest  (required)
   * @return TransactionReceiptResponse
   * @throws ApiException if fails to make API call
   */
  public TransactionReceiptResponse transactionReceiptPost(TransactionReceiptRequest transactionReceiptRequest) throws ApiException {
    ApiResponse<TransactionReceiptResponse> localVarResponse = transactionReceiptPostWithHttpInfo(transactionReceiptRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Transaction Receipt
   * Gets the transaction receipt for a committed transaction. 
   * @param transactionReceiptRequest  (required)
   * @return ApiResponse&lt;TransactionReceiptResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<TransactionReceiptResponse> transactionReceiptPostWithHttpInfo(TransactionReceiptRequest transactionReceiptRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = transactionReceiptPostRequestBuilder(transactionReceiptRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("transactionReceiptPost", localVarResponse);
        }
        return new ApiResponse<TransactionReceiptResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<TransactionReceiptResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder transactionReceiptPostRequestBuilder(TransactionReceiptRequest transactionReceiptRequest) throws ApiException {
    // verify the required parameter 'transactionReceiptRequest' is set
    if (transactionReceiptRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'transactionReceiptRequest' when calling transactionReceiptPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/transaction/receipt";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(transactionReceiptRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get Transaction Status
   * Shares the node&#39;s knowledge of any payloads associated with the given intent hash. Generally there will be a single payload for a given intent, but it&#39;s theoretically possible there may be multiple. This knowledge is summarised into a status for the intent. This summarised status in the response is likely sufficient for most clients. 
   * @param transactionStatusRequest  (required)
   * @return TransactionStatusResponse
   * @throws ApiException if fails to make API call
   */
  public TransactionStatusResponse transactionStatusPost(TransactionStatusRequest transactionStatusRequest) throws ApiException {
    ApiResponse<TransactionStatusResponse> localVarResponse = transactionStatusPostWithHttpInfo(transactionStatusRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Transaction Status
   * Shares the node&#39;s knowledge of any payloads associated with the given intent hash. Generally there will be a single payload for a given intent, but it&#39;s theoretically possible there may be multiple. This knowledge is summarised into a status for the intent. This summarised status in the response is likely sufficient for most clients. 
   * @param transactionStatusRequest  (required)
   * @return ApiResponse&lt;TransactionStatusResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<TransactionStatusResponse> transactionStatusPostWithHttpInfo(TransactionStatusRequest transactionStatusRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = transactionStatusPostRequestBuilder(transactionStatusRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("transactionStatusPost", localVarResponse);
        }
        return new ApiResponse<TransactionStatusResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<TransactionStatusResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder transactionStatusPostRequestBuilder(TransactionStatusRequest transactionStatusRequest) throws ApiException {
    // verify the required parameter 'transactionStatusRequest' is set
    if (transactionStatusRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'transactionStatusRequest' when calling transactionStatusPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/transaction/status";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(transactionStatusRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Transaction Submit
   * Submits a notarized transaction to the network. Returns whether the transaction submission was already included in the node&#39;s mempool. 
   * @param transactionSubmitRequest  (required)
   * @return TransactionSubmitResponse
   * @throws ApiException if fails to make API call
   */
  public TransactionSubmitResponse transactionSubmitPost(TransactionSubmitRequest transactionSubmitRequest) throws ApiException {
    ApiResponse<TransactionSubmitResponse> localVarResponse = transactionSubmitPostWithHttpInfo(transactionSubmitRequest);
    return localVarResponse.getData();
  }

  /**
   * Transaction Submit
   * Submits a notarized transaction to the network. Returns whether the transaction submission was already included in the node&#39;s mempool. 
   * @param transactionSubmitRequest  (required)
   * @return ApiResponse&lt;TransactionSubmitResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<TransactionSubmitResponse> transactionSubmitPostWithHttpInfo(TransactionSubmitRequest transactionSubmitRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = transactionSubmitPostRequestBuilder(transactionSubmitRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("transactionSubmitPost", localVarResponse);
        }
        return new ApiResponse<TransactionSubmitResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<TransactionSubmitResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder transactionSubmitPostRequestBuilder(TransactionSubmitRequest transactionSubmitRequest) throws ApiException {
    // verify the required parameter 'transactionSubmitRequest' is set
    if (transactionSubmitRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'transactionSubmitRequest' when calling transactionSubmitPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/transaction/submit";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(transactionSubmitRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}
