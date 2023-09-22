/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (v1.0.0)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as runtime from '../runtime';
import type {
  BasicErrorResponse,
  LtsStateAccountAllFungibleResourceBalancesRequest,
  LtsStateAccountAllFungibleResourceBalancesResponse,
  LtsStateAccountDepositBehaviourRequest,
  LtsStateAccountDepositBehaviourResponse,
  LtsStateAccountFungibleResourceBalanceRequest,
  LtsStateAccountFungibleResourceBalanceResponse,
  LtsStreamAccountTransactionOutcomesRequest,
  LtsStreamAccountTransactionOutcomesResponse,
  LtsStreamTransactionOutcomesRequest,
  LtsStreamTransactionOutcomesResponse,
  LtsTransactionConstructionRequest,
  LtsTransactionConstructionResponse,
  LtsTransactionStatusRequest,
  LtsTransactionStatusResponse,
  LtsTransactionSubmitRequest,
  LtsTransactionSubmitResponse,
  TransactionSubmitErrorResponse,
} from '../models';
import {
    BasicErrorResponseFromJSON,
    BasicErrorResponseToJSON,
    LtsStateAccountAllFungibleResourceBalancesRequestFromJSON,
    LtsStateAccountAllFungibleResourceBalancesRequestToJSON,
    LtsStateAccountAllFungibleResourceBalancesResponseFromJSON,
    LtsStateAccountAllFungibleResourceBalancesResponseToJSON,
    LtsStateAccountDepositBehaviourRequestFromJSON,
    LtsStateAccountDepositBehaviourRequestToJSON,
    LtsStateAccountDepositBehaviourResponseFromJSON,
    LtsStateAccountDepositBehaviourResponseToJSON,
    LtsStateAccountFungibleResourceBalanceRequestFromJSON,
    LtsStateAccountFungibleResourceBalanceRequestToJSON,
    LtsStateAccountFungibleResourceBalanceResponseFromJSON,
    LtsStateAccountFungibleResourceBalanceResponseToJSON,
    LtsStreamAccountTransactionOutcomesRequestFromJSON,
    LtsStreamAccountTransactionOutcomesRequestToJSON,
    LtsStreamAccountTransactionOutcomesResponseFromJSON,
    LtsStreamAccountTransactionOutcomesResponseToJSON,
    LtsStreamTransactionOutcomesRequestFromJSON,
    LtsStreamTransactionOutcomesRequestToJSON,
    LtsStreamTransactionOutcomesResponseFromJSON,
    LtsStreamTransactionOutcomesResponseToJSON,
    LtsTransactionConstructionRequestFromJSON,
    LtsTransactionConstructionRequestToJSON,
    LtsTransactionConstructionResponseFromJSON,
    LtsTransactionConstructionResponseToJSON,
    LtsTransactionStatusRequestFromJSON,
    LtsTransactionStatusRequestToJSON,
    LtsTransactionStatusResponseFromJSON,
    LtsTransactionStatusResponseToJSON,
    LtsTransactionSubmitRequestFromJSON,
    LtsTransactionSubmitRequestToJSON,
    LtsTransactionSubmitResponseFromJSON,
    LtsTransactionSubmitResponseToJSON,
    TransactionSubmitErrorResponseFromJSON,
    TransactionSubmitErrorResponseToJSON,
} from '../models';

export interface LtsStateAccountAllFungibleResourceBalancesPostRequest {
    ltsStateAccountAllFungibleResourceBalancesRequest: LtsStateAccountAllFungibleResourceBalancesRequest;
}

export interface LtsStateAccountDepositBehaviourPostRequest {
    ltsStateAccountDepositBehaviourRequest: LtsStateAccountDepositBehaviourRequest;
}

export interface LtsStateAccountFungibleResourceBalancePostRequest {
    ltsStateAccountFungibleResourceBalanceRequest: LtsStateAccountFungibleResourceBalanceRequest;
}

export interface LtsStreamAccountTransactionOutcomesPostRequest {
    ltsStreamAccountTransactionOutcomesRequest: LtsStreamAccountTransactionOutcomesRequest;
}

export interface LtsStreamTransactionOutcomesPostRequest {
    ltsStreamTransactionOutcomesRequest: LtsStreamTransactionOutcomesRequest;
}

export interface LtsTransactionConstructionPostRequest {
    ltsTransactionConstructionRequest: LtsTransactionConstructionRequest;
}

export interface LtsTransactionStatusPostRequest {
    ltsTransactionStatusRequest: LtsTransactionStatusRequest;
}

export interface LtsTransactionSubmitPostRequest {
    ltsTransactionSubmitRequest: LtsTransactionSubmitRequest;
}

/**
 * 
 */
export class LTSApi extends runtime.BaseAPI {

    /**
     * Returns balances for all resources associated with an account
     * Get All Account Balances
     */
    async ltsStateAccountAllFungibleResourceBalancesPostRaw(requestParameters: LtsStateAccountAllFungibleResourceBalancesPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<LtsStateAccountAllFungibleResourceBalancesResponse>> {
        if (requestParameters.ltsStateAccountAllFungibleResourceBalancesRequest === null || requestParameters.ltsStateAccountAllFungibleResourceBalancesRequest === undefined) {
            throw new runtime.RequiredError('ltsStateAccountAllFungibleResourceBalancesRequest','Required parameter requestParameters.ltsStateAccountAllFungibleResourceBalancesRequest was null or undefined when calling ltsStateAccountAllFungibleResourceBalancesPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/lts/state/account-all-fungible-resource-balances`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: LtsStateAccountAllFungibleResourceBalancesRequestToJSON(requestParameters.ltsStateAccountAllFungibleResourceBalancesRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => LtsStateAccountAllFungibleResourceBalancesResponseFromJSON(jsonValue));
    }

    /**
     * Returns balances for all resources associated with an account
     * Get All Account Balances
     */
    async ltsStateAccountAllFungibleResourceBalancesPost(requestParameters: LtsStateAccountAllFungibleResourceBalancesPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<LtsStateAccountAllFungibleResourceBalancesResponse> {
        const response = await this.ltsStateAccountAllFungibleResourceBalancesPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Returns deposit behaviour of a single account for multiple resource addresses
     * Get Account Deposit Behaviour
     */
    async ltsStateAccountDepositBehaviourPostRaw(requestParameters: LtsStateAccountDepositBehaviourPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<LtsStateAccountDepositBehaviourResponse>> {
        if (requestParameters.ltsStateAccountDepositBehaviourRequest === null || requestParameters.ltsStateAccountDepositBehaviourRequest === undefined) {
            throw new runtime.RequiredError('ltsStateAccountDepositBehaviourRequest','Required parameter requestParameters.ltsStateAccountDepositBehaviourRequest was null or undefined when calling ltsStateAccountDepositBehaviourPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/lts/state/account-deposit-behaviour`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: LtsStateAccountDepositBehaviourRequestToJSON(requestParameters.ltsStateAccountDepositBehaviourRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => LtsStateAccountDepositBehaviourResponseFromJSON(jsonValue));
    }

    /**
     * Returns deposit behaviour of a single account for multiple resource addresses
     * Get Account Deposit Behaviour
     */
    async ltsStateAccountDepositBehaviourPost(requestParameters: LtsStateAccountDepositBehaviourPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<LtsStateAccountDepositBehaviourResponse> {
        const response = await this.ltsStateAccountDepositBehaviourPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Returns balance of a single fungible resource in an account
     * Get Single Account Balance
     */
    async ltsStateAccountFungibleResourceBalancePostRaw(requestParameters: LtsStateAccountFungibleResourceBalancePostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<LtsStateAccountFungibleResourceBalanceResponse>> {
        if (requestParameters.ltsStateAccountFungibleResourceBalanceRequest === null || requestParameters.ltsStateAccountFungibleResourceBalanceRequest === undefined) {
            throw new runtime.RequiredError('ltsStateAccountFungibleResourceBalanceRequest','Required parameter requestParameters.ltsStateAccountFungibleResourceBalanceRequest was null or undefined when calling ltsStateAccountFungibleResourceBalancePost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/lts/state/account-fungible-resource-balance`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: LtsStateAccountFungibleResourceBalanceRequestToJSON(requestParameters.ltsStateAccountFungibleResourceBalanceRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => LtsStateAccountFungibleResourceBalanceResponseFromJSON(jsonValue));
    }

    /**
     * Returns balance of a single fungible resource in an account
     * Get Single Account Balance
     */
    async ltsStateAccountFungibleResourceBalancePost(requestParameters: LtsStateAccountFungibleResourceBalancePostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<LtsStateAccountFungibleResourceBalanceResponse> {
        const response = await this.ltsStateAccountFungibleResourceBalancePostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Returns a list of committed transaction outcomes (containing balance changes) from a given state version, filtered to only transactions which involved the given account. 
     * Get Account Transaction Outcomes
     */
    async ltsStreamAccountTransactionOutcomesPostRaw(requestParameters: LtsStreamAccountTransactionOutcomesPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<LtsStreamAccountTransactionOutcomesResponse>> {
        if (requestParameters.ltsStreamAccountTransactionOutcomesRequest === null || requestParameters.ltsStreamAccountTransactionOutcomesRequest === undefined) {
            throw new runtime.RequiredError('ltsStreamAccountTransactionOutcomesRequest','Required parameter requestParameters.ltsStreamAccountTransactionOutcomesRequest was null or undefined when calling ltsStreamAccountTransactionOutcomesPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/lts/stream/account-transaction-outcomes`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: LtsStreamAccountTransactionOutcomesRequestToJSON(requestParameters.ltsStreamAccountTransactionOutcomesRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => LtsStreamAccountTransactionOutcomesResponseFromJSON(jsonValue));
    }

    /**
     * Returns a list of committed transaction outcomes (containing balance changes) from a given state version, filtered to only transactions which involved the given account. 
     * Get Account Transaction Outcomes
     */
    async ltsStreamAccountTransactionOutcomesPost(requestParameters: LtsStreamAccountTransactionOutcomesPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<LtsStreamAccountTransactionOutcomesResponse> {
        const response = await this.ltsStreamAccountTransactionOutcomesPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Returns a list of committed transaction outcomes (containing balance changes) from a given state version. 
     * Get Transaction Outcomes
     */
    async ltsStreamTransactionOutcomesPostRaw(requestParameters: LtsStreamTransactionOutcomesPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<LtsStreamTransactionOutcomesResponse>> {
        if (requestParameters.ltsStreamTransactionOutcomesRequest === null || requestParameters.ltsStreamTransactionOutcomesRequest === undefined) {
            throw new runtime.RequiredError('ltsStreamTransactionOutcomesRequest','Required parameter requestParameters.ltsStreamTransactionOutcomesRequest was null or undefined when calling ltsStreamTransactionOutcomesPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/lts/stream/transaction-outcomes`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: LtsStreamTransactionOutcomesRequestToJSON(requestParameters.ltsStreamTransactionOutcomesRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => LtsStreamTransactionOutcomesResponseFromJSON(jsonValue));
    }

    /**
     * Returns a list of committed transaction outcomes (containing balance changes) from a given state version. 
     * Get Transaction Outcomes
     */
    async ltsStreamTransactionOutcomesPost(requestParameters: LtsStreamTransactionOutcomesPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<LtsStreamTransactionOutcomesResponse> {
        const response = await this.ltsStreamTransactionOutcomesPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Returns information necessary to build a transaction
     * Get Construction Metadata
     */
    async ltsTransactionConstructionPostRaw(requestParameters: LtsTransactionConstructionPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<LtsTransactionConstructionResponse>> {
        if (requestParameters.ltsTransactionConstructionRequest === null || requestParameters.ltsTransactionConstructionRequest === undefined) {
            throw new runtime.RequiredError('ltsTransactionConstructionRequest','Required parameter requestParameters.ltsTransactionConstructionRequest was null or undefined when calling ltsTransactionConstructionPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/lts/transaction/construction`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: LtsTransactionConstructionRequestToJSON(requestParameters.ltsTransactionConstructionRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => LtsTransactionConstructionResponseFromJSON(jsonValue));
    }

    /**
     * Returns information necessary to build a transaction
     * Get Construction Metadata
     */
    async ltsTransactionConstructionPost(requestParameters: LtsTransactionConstructionPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<LtsTransactionConstructionResponse> {
        const response = await this.ltsTransactionConstructionPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Shares the node\'s knowledge of any payloads associated with the given intent hash. Generally there will be a single payload for a given intent, but it\'s theoretically possible there may be multiple. This knowledge is summarised into a status for the intent. This summarised status in the response is likely sufficient for most clients. 
     * Get Transaction Status
     */
    async ltsTransactionStatusPostRaw(requestParameters: LtsTransactionStatusPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<LtsTransactionStatusResponse>> {
        if (requestParameters.ltsTransactionStatusRequest === null || requestParameters.ltsTransactionStatusRequest === undefined) {
            throw new runtime.RequiredError('ltsTransactionStatusRequest','Required parameter requestParameters.ltsTransactionStatusRequest was null or undefined when calling ltsTransactionStatusPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/lts/transaction/status`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: LtsTransactionStatusRequestToJSON(requestParameters.ltsTransactionStatusRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => LtsTransactionStatusResponseFromJSON(jsonValue));
    }

    /**
     * Shares the node\'s knowledge of any payloads associated with the given intent hash. Generally there will be a single payload for a given intent, but it\'s theoretically possible there may be multiple. This knowledge is summarised into a status for the intent. This summarised status in the response is likely sufficient for most clients. 
     * Get Transaction Status
     */
    async ltsTransactionStatusPost(requestParameters: LtsTransactionStatusPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<LtsTransactionStatusResponse> {
        const response = await this.ltsTransactionStatusPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Submits a notarized transaction to the network. Returns whether the transaction submission was already included in the node\'s mempool. 
     * Submit Transaction
     */
    async ltsTransactionSubmitPostRaw(requestParameters: LtsTransactionSubmitPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<LtsTransactionSubmitResponse>> {
        if (requestParameters.ltsTransactionSubmitRequest === null || requestParameters.ltsTransactionSubmitRequest === undefined) {
            throw new runtime.RequiredError('ltsTransactionSubmitRequest','Required parameter requestParameters.ltsTransactionSubmitRequest was null or undefined when calling ltsTransactionSubmitPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/lts/transaction/submit`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: LtsTransactionSubmitRequestToJSON(requestParameters.ltsTransactionSubmitRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => LtsTransactionSubmitResponseFromJSON(jsonValue));
    }

    /**
     * Submits a notarized transaction to the network. Returns whether the transaction submission was already included in the node\'s mempool. 
     * Submit Transaction
     */
    async ltsTransactionSubmitPost(requestParameters: LtsTransactionSubmitPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<LtsTransactionSubmitResponse> {
        const response = await this.ltsTransactionSubmitPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

}
