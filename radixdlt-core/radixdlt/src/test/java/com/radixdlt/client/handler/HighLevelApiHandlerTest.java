/*
 * (C) Copyright 2021 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.radixdlt.client.handler;

import com.radixdlt.client.AccountAddress;
import com.radixdlt.constraintmachine.ConstraintMachine;
import com.radixdlt.crypto.ECPublicKey;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.encoders.Hex;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.radixdlt.client.api.TransactionStatus;
import com.radixdlt.client.api.TxHistoryEntry;
import com.radixdlt.client.service.HighLevelApiService;
import com.radixdlt.client.service.SubmissionService;
import com.radixdlt.client.service.TransactionStatusService;
import com.radixdlt.client.service.ValidatorInfoService;
import com.radixdlt.client.store.ActionEntry;
import com.radixdlt.client.store.MessageEntry;
import com.radixdlt.client.store.TokenBalance;
import com.radixdlt.client.store.TokenDefinitionRecord;
import com.radixdlt.crypto.ECDSASignature;
import com.radixdlt.crypto.ECKeyPair;
import com.radixdlt.crypto.HashUtils;
import com.radixdlt.identifiers.AID;
import com.radixdlt.identifiers.REAddr;
import com.radixdlt.utils.UInt256;
import com.radixdlt.utils.UInt384;
import com.radixdlt.utils.functional.Result;

import java.io.ByteArrayOutputStream;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.radix.api.jsonrpc.JsonRpcUtil.jsonArray;
import static org.radix.api.jsonrpc.JsonRpcUtil.jsonObject;

import static com.radixdlt.client.api.TransactionStatus.CONFIRMED;
import static com.radixdlt.client.api.TransactionStatus.FAILED;
import static com.radixdlt.client.api.TransactionStatus.PENDING;
import static com.radixdlt.client.api.TransactionStatus.TRANSACTION_NOT_FOUND;
import static com.radixdlt.client.store.berkeley.BalanceEntry.createBalance;
import static com.radixdlt.utils.functional.Tuple.tuple;

public class HighLevelApiHandlerTest {
	private static final ECPublicKey PUB_KEY = ECKeyPair.generateNew().getPublicKey();
	private static final REAddr ACCOUNT_ADDR = REAddr.ofPubKeyAccount(PUB_KEY);
	private static final String ADDRESS = AccountAddress.of(ACCOUNT_ADDR);
	private static final ECPublicKey V1 = ECKeyPair.generateNew().getPublicKey();
	private static final ECPublicKey V2 = ECKeyPair.generateNew().getPublicKey();
	private static final ECPublicKey V3 = ECKeyPair.generateNew().getPublicKey();

	private final HighLevelApiService highLevelApiService = mock(HighLevelApiService.class);
	private final TransactionStatusService transactionStatusService = mock(TransactionStatusService.class);
	private final SubmissionService submissionService = mock(SubmissionService.class);
	private final ValidatorInfoService validatorInfoService = mock(ValidatorInfoService.class);
	private final HighLevelApiHandler handler = new HighLevelApiHandler(
		highLevelApiService, transactionStatusService, submissionService, validatorInfoService
	);

	@Test
	public void testTokenBalance() {
		var balance1 = TokenBalance.create(REAddr.ofHashedKey(PUB_KEY, "xyz"), UInt384.TWO);
		var balance2 = TokenBalance.create(REAddr.ofHashedKey(PUB_KEY, "yzs"), UInt384.FIVE);
		var balance3 = TokenBalance.create(REAddr.ofHashedKey(PUB_KEY, "zxy"), UInt384.EIGHT);

		when(highLevelApiService.getTokenBalances(any(REAddr.class)))
			.thenReturn(Result.ok(List.of(balance1, balance2, balance3)));

		var response = handler.handleTokenBalances(requestWith(jsonArray().put(ADDRESS)));

		assertNotNull(response);

		var result = response.getJSONObject("result");
		assertEquals(ADDRESS, result.getString("owner"));

		var list = result.getJSONArray("tokenBalances");

		assertEquals(3, list.length());
		assertEquals(UInt384.TWO, list.getJSONObject(0).get("amount"));
		assertEquals(UInt384.FIVE, list.getJSONObject(1).get("amount"));
		assertEquals(UInt384.EIGHT, list.getJSONObject(2).get("amount"));
	}

	@Test
	public void testStakePositions() {
		var balance1 = createBalance(ACCOUNT_ADDR, V1, REAddr.ofNativeToken(), UInt384.TWO);
		var balance2 = createBalance(ACCOUNT_ADDR, V2, REAddr.ofNativeToken(), UInt384.FIVE);
		var balance3 = createBalance(ACCOUNT_ADDR, V3, REAddr.ofNativeToken(), UInt384.EIGHT);

		when(highLevelApiService.getStakePositions(any(REAddr.class)))
			.thenReturn(Result.ok(List.of(balance1, balance2, balance3)));

		var response = handler.handleStakePositions(requestWith(jsonArray().put(ADDRESS)));

		assertNotNull(response);

		var list = response.getJSONArray("result");

		assertEquals(3, list.length());
		assertEquals(UInt384.TWO, list.getJSONObject(0).get("amount"));
		assertEquals(UInt384.FIVE, list.getJSONObject(1).get("amount"));
		assertEquals(UInt384.EIGHT, list.getJSONObject(2).get("amount"));
	}

	@Test
	public void testNativeToken() {
		when(highLevelApiService.getNativeTokenDescription())
			.thenReturn(buildNativeToken());

		var response = handler.handleNativeToken(requestWith());
		assertNotNull(response);

		var result = response.getJSONObject("result");
		assertNotNull(result);
		assertEquals("xrd", result.getString("name"));
		assertEquals("xrd xrd", result.getString("description"));
		assertEquals(UInt384.EIGHT, result.get("currentSupply"));
	}

	@Test
	public void testTokenInfo() {
		when(highLevelApiService.getTokenDescription(any(String.class)))
			.thenReturn(buildToken("fyy"));

		var params = jsonArray().put(REAddr.ofHashedKey(PUB_KEY, "fyy").toString());
		var response = handler.handleTokenInfo(requestWith(params));
		assertNotNull(response);

		var result = response.getJSONObject("result");
		assertNotNull(result);
		assertEquals("fyy", result.getString("name"));
		assertEquals("fyy fyy", result.getString("description"));
		assertEquals(UInt384.EIGHT, result.get("currentSupply"));
	}

	@Test
	public void testTransactionHistory() {
		var entry = createTxHistoryEntry(AID.ZERO);

		when(highLevelApiService.getTransactionHistory(any(), eq(5), any()))
			.thenReturn(Result.ok(tuple(Optional.ofNullable(entry.timestamp()), List.of(entry))));

		var params = jsonArray().put(ADDRESS).put(5);
		var response = handler.handleTransactionHistory(requestWith(params));

		assertNotNull(response);

		var result = response.getJSONObject("result");

		assertTrue(result.has("cursor"));
		assertTrue(result.has("transactions"));
		var transactions = result.getJSONArray("transactions");
		assertEquals(1, transactions.length());

		validateHistoryEntry(entry, transactions.getJSONObject(0));
	}

	@Test
	public void testLookupTransaction() {
		var txId = AID.from(randomBytes());
		var entry = createTxHistoryEntry(txId);

		when(highLevelApiService.getTransaction(txId)).thenReturn(Result.ok(entry));

		var params = requestWith(jsonArray().put(txId.toString()));
		var response = handler.handleLookupTransaction(params);

		assertNotNull(response);
		validateHistoryEntry(entry, response.getJSONObject("result"));
	}

	@Test
	public void testTransactionStatus() {
		var txId = AID.from(randomBytes());

		when(transactionStatusService.getTransactionStatus(any()))
			.thenReturn(PENDING, CONFIRMED, FAILED, TRANSACTION_NOT_FOUND);

		var request = requestWith(jsonArray().put(txId.toString()));

		validateTransactionStatusResponse(PENDING, txId, handler.handleTransactionStatus(request));
		validateTransactionStatusResponse(CONFIRMED, txId, handler.handleTransactionStatus(request));
		validateTransactionStatusResponse(FAILED, txId, handler.handleTransactionStatus(request));
		validateTransactionStatusResponse(TRANSACTION_NOT_FOUND, txId, handler.handleTransactionStatus(request));
	}

	@Test
	public void testFinalizeTransaction() {
		var aid = AID.from(randomBytes());

		when(submissionService.calculateTxId(any(), any()))
			.thenReturn(Result.ok(aid));

		var blob = randomBytes();
		var hash = ConstraintMachine.computeHashToSignFromBytes(blob).asBytes();

		var transaction = jsonObject()
			.put("blob", Hex.toHexString(blob))
			.put("hashOfBlobToSign", Hex.toHexString(hash));

		var keyPair = ECKeyPair.generateNew();

		var signature = keyPair.sign(hash);
		var params = jsonArray()
			.put(transaction)
			.put(encodeToDer(signature))
			.put(keyPair.getPublicKey().toHex());

		var response = handler.handleFinalizeTransaction(requestWith(params));

		assertNotNull(response);
		assertTrue(response.has("result"));

		var result = response.getJSONObject("result");

		assertTrue(result.has("txID"));

		assertEquals(aid, result.get("txID"));
	}

	@Test
	public void testSubmitTransaction() {
		var aid = AID.from(randomBytes());

		when(submissionService.submitTx(any(), any(), any()))
			.thenReturn(Result.ok(aid));

		var blob = randomBytes();
		var hash = ConstraintMachine.computeHashToSignFromBytes(blob).asBytes();

		var transaction = jsonObject()
			.put("blob", Hex.toHexString(blob))
			.put("hashOfBlobToSign", Hex.toHexString(hash));

		var keyPair = ECKeyPair.generateNew();

		var signature = keyPair.sign(hash);
		var params = jsonArray()
			.put(transaction)
			.put(encodeToDer(signature))
			.put(keyPair.getPublicKey().toHex())
			.put(aid.toString());

		var response = handler.handleSubmitTransaction(requestWith(params));

		assertNotNull(response);
		assertTrue(response.has("result"));

		var result = response.getJSONObject("result");

		assertTrue(result.has("txID"));

		assertEquals(aid, result.get("txID"));
	}

	private String encodeToDer(ECDSASignature signature) {
		try {
			ASN1EncodableVector vector = new ASN1EncodableVector();
			vector.add(new ASN1Integer(signature.getR()));
			vector.add(new ASN1Integer(signature.getS()));

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ASN1OutputStream asnOS = ASN1OutputStream.create(baos);

			asnOS.writeObject(new DERSequence(vector));
			asnOS.flush();

			return Hex.toHexString(baos.toByteArray());
		} catch (Exception e) {
			fail();
			return null;
		}
	}

	private final Random random = new Random();

	private byte[] randomBytes() {
		return HashUtils.random256().asBytes();
	}

	private void validateTransactionStatusResponse(TransactionStatus status, AID txId, JSONObject response) {
		assertNotNull(response);

		var result = response.getJSONObject("result");
		assertEquals(txId, result.get("txID"));

		if (status == TRANSACTION_NOT_FOUND) {
			assertEquals(status.name(), result.get("failure"));
			assertFalse(result.has("status"));
		} else {
			assertEquals(status.name(), result.get("status"));
			assertFalse(result.has("failure"));
		}
	}

	private void validateHistoryEntry(TxHistoryEntry entry, JSONObject historyEntry) {
		assertEquals(UInt256.ONE, historyEntry.get("fee"));
		assertEquals(DateTimeFormatter.ISO_INSTANT.format(entry.timestamp()), historyEntry.getString("sentAt"));
		assertEquals(entry.getTxId(), historyEntry.get("txID"));

		assertTrue(historyEntry.has("actions"));
		var actions = historyEntry.getJSONArray("actions");
		assertEquals(1, actions.length());

		var singleAction = actions.getJSONObject(0);
		assertEquals("Other", singleAction.getString("type"));
	}

	private TxHistoryEntry createTxHistoryEntry(AID txId) {
		var now = Instant.ofEpochMilli(Instant.now().toEpochMilli());
		var action = ActionEntry.unknown();
		return TxHistoryEntry.create(
			txId, now, UInt256.ONE, MessageEntry.fromPlainString("text"), List.of(action)
		);
	}

	private JSONObject requestWith() {
		return requestWith(null);
	}

	private JSONObject requestWith(JSONArray params) {
		return jsonObject().put("id", "1").putOpt("params", params);
	}

	private Result<TokenDefinitionRecord> buildNativeToken() {
		return buildToken("xrd");
	}

	private Result<TokenDefinitionRecord> buildToken(String name) {
		return Result.ok(
			TokenDefinitionRecord.create(
				name, name, REAddr.ofHashedKey(PUB_KEY, name), name + " " + name, UInt384.EIGHT,
				"http://" + name.toLowerCase() + ".icon.url", "http://" + name.toLowerCase() + "home.url",
				false
			));
	}
}