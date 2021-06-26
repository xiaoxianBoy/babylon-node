/*
 * (C) Copyright 2021 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 */

package com.radixdlt.atommodel.tokens;

import com.radixdlt.atom.ActionConstructor;
import com.radixdlt.atom.ActionConstructors;
import com.radixdlt.atom.TxBuilderException;
import com.radixdlt.atom.TxnConstructionRequest;
import com.radixdlt.atom.actions.CreateMutableToken;
import com.radixdlt.atom.actions.MintToken;
import com.radixdlt.atom.actions.StakeTokens;
import com.radixdlt.atom.actions.UpdateAllowDelegationFlag;
import com.radixdlt.atom.actions.UpdateValidatorOwnerAddress;
import com.radixdlt.atommodel.system.state.ValidatorStakeData;
import com.radixdlt.atommodel.tokens.construction.CreateMutableTokenConstructor;
import com.radixdlt.atommodel.tokens.construction.MintTokenConstructor;
import com.radixdlt.atommodel.tokens.construction.StakeTokensConstructorV3;
import com.radixdlt.atommodel.tokens.scrypt.StakingConstraintScryptV4;
import com.radixdlt.atommodel.tokens.scrypt.TokensConstraintScryptV3;
import com.radixdlt.atommodel.validators.construction.UpdateAllowDelegationFlagConstructor;
import com.radixdlt.atommodel.validators.construction.UpdateValidatorOwnerConstructor;
import com.radixdlt.atommodel.validators.scrypt.ValidatorConstraintScryptV2;
import com.radixdlt.atomos.CMAtomOS;
import com.radixdlt.atomos.ConstraintScrypt;
import com.radixdlt.constraintmachine.ConstraintMachine;
import com.radixdlt.constraintmachine.PermissionLevel;
import com.radixdlt.crypto.ECKeyPair;
import com.radixdlt.engine.RadixEngine;
import com.radixdlt.engine.parser.REParser;
import com.radixdlt.identifiers.REAddr;
import com.radixdlt.store.EngineStore;
import com.radixdlt.store.InMemoryEngineStore;
import com.radixdlt.utils.Pair;
import com.radixdlt.utils.UInt256;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(Parameterized.class)
public class DelegationFlagTest {

	@Parameterized.Parameters
	public static Collection<Object[]> parameters() {
		var startAmounts = List.of(UInt256.TEN);
		var stakeAmounts = List.of(UInt256.TEN);
		var scrypts = List.of(
			Pair.of(
				List.of(new TokensConstraintScryptV3(), new StakingConstraintScryptV4(), new ValidatorConstraintScryptV2(2)),
				new StakeTokensConstructorV3()
			)
		);

		var parameters = new ArrayList<Object[]>();
		for (var scrypt : scrypts) {
			for (var startAmount : startAmounts) {
				for (var stakeAmount : stakeAmounts) {
					var param = new Object[] {
						startAmount,
						stakeAmount,
						scrypt.getFirst(),
						scrypt.getSecond()
					};
					parameters.add(param);
				}
			}
		}
		return parameters;
	}


	private RadixEngine<Void> engine;
	private EngineStore<Void> store;
	private final UInt256 startAmt;
	private final UInt256 stakeAmt;
	private final List<ConstraintScrypt> scrypts;
	private final ActionConstructor<StakeTokens> stakeTokensConstructor;

	public DelegationFlagTest(
		UInt256 startAmt,
		UInt256 stakeAmt,
		List<ConstraintScrypt> scrypts,
		ActionConstructor<StakeTokens> stakeTokensConstructor
	) {
		this.startAmt = ValidatorStakeData.MINIMUM_STAKE.multiply(startAmt);
		this.stakeAmt = ValidatorStakeData.MINIMUM_STAKE.multiply(stakeAmt);
		this.scrypts = scrypts;
		this.stakeTokensConstructor = stakeTokensConstructor;
	}

	@Before
	public void setup() {
		var cmAtomOS = new CMAtomOS();
		scrypts.forEach(cmAtomOS::load);
		var cm = new ConstraintMachine(
			cmAtomOS.virtualizedUpParticles(),
			cmAtomOS.getProcedures()
		);
		var parser = new REParser(cmAtomOS.buildSubstateDeserialization());
		var serialization = cmAtomOS.buildSubstateSerialization();
		this.store = new InMemoryEngineStore<>();
		this.engine = new RadixEngine<>(
			parser,
			serialization,
			ActionConstructors.newBuilder()
				.put(StakeTokens.class, stakeTokensConstructor)
				.put(CreateMutableToken.class, new CreateMutableTokenConstructor())
				.put(MintToken.class, new MintTokenConstructor())
				.put(UpdateAllowDelegationFlag.class, new UpdateAllowDelegationFlagConstructor())
				.put(UpdateValidatorOwnerAddress.class, new UpdateValidatorOwnerConstructor())
				.build(),
			cm,
			store
		);
	}

	@Test
	public void cannot_construct_stake_tokens_if_delegation_flag_set_to_false() throws Exception {
		// Arrange
		var key = ECKeyPair.generateNew();
		var accountAddr = REAddr.ofPubKeyAccount(key.getPublicKey());
		var txn = this.engine.construct(
			TxnConstructionRequest.create()
				.action(new CreateMutableToken(null, "xrd", "Name", "", "", ""))
				.action(new MintToken(REAddr.ofNativeToken(), accountAddr, startAmt))
		).buildWithoutSignature();
		var validatorKey = ECKeyPair.generateNew();
		this.engine.execute(List.of(txn), null, PermissionLevel.SYSTEM);

		// Act
		assertThatThrownBy(() -> this.engine.construct(new StakeTokens(accountAddr, validatorKey.getPublicKey(), stakeAmt))
			.signAndBuild(key::sign)).isInstanceOf(TxBuilderException.class);
	}

	@Test
	public void can_stake_tokens_if_delegation_flag_set_to_false_and_am_owner() throws Exception {
		// Arrange
		var key = ECKeyPair.generateNew();
		var accountAddr = REAddr.ofPubKeyAccount(key.getPublicKey());
		var txn = this.engine.construct(
			TxnConstructionRequest.create()
				.action(new CreateMutableToken(null, "xrd", "Name", "", "", ""))
				.action(new MintToken(REAddr.ofNativeToken(), accountAddr, startAmt))
		).buildWithoutSignature();
		this.engine.execute(List.of(txn), null, PermissionLevel.SYSTEM);

		// Act
		var stake = this.engine.construct(new StakeTokens(accountAddr, key.getPublicKey(), stakeAmt))
			.signAndBuild(key::sign);
		this.engine.execute(List.of(stake));
	}


	@Test
	public void can_stake_tokens_if_delegation_flag_set_to_false_and_changed_owner() throws Exception {
		// Arrange
		var key = ECKeyPair.generateNew();
		var accountAddr = REAddr.ofPubKeyAccount(key.getPublicKey());
		var txn = this.engine.construct(
			TxnConstructionRequest.create()
				.action(new CreateMutableToken(null, "xrd", "Name", "", "", ""))
				.action(new MintToken(REAddr.ofNativeToken(), accountAddr, startAmt))
		).buildWithoutSignature();
		var validatorKey = ECKeyPair.generateNew();
		this.engine.execute(List.of(txn), null, PermissionLevel.SYSTEM);
		var update = this.engine.construct(
			TxnConstructionRequest.create()
				.action(new UpdateValidatorOwnerAddress(validatorKey.getPublicKey(), accountAddr))
		).signAndBuild(validatorKey::sign);
		this.engine.execute(List.of(update));

		// Act
		var stake = this.engine.construct(new StakeTokens(accountAddr, key.getPublicKey(), stakeAmt))
			.signAndBuild(key::sign);
		this.engine.execute(List.of(stake));
	}
}