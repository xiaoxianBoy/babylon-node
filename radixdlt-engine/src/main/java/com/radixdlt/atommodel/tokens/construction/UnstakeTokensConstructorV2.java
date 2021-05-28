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

package com.radixdlt.atommodel.tokens.construction;

import com.radixdlt.atom.ActionConstructor;
import com.radixdlt.atom.TxBuilder;
import com.radixdlt.atom.TxBuilderException;
import com.radixdlt.atom.actions.UnstakeTokens;
import com.radixdlt.atommodel.system.state.EpochData;
import com.radixdlt.atommodel.system.state.Stake;
import com.radixdlt.atommodel.system.state.StakeShares;
import com.radixdlt.atommodel.system.state.SystemParticle;
import com.radixdlt.atommodel.tokens.scrypt.StakingConstraintScryptV3;
import com.radixdlt.atommodel.tokens.state.TokensParticle;
import com.radixdlt.identifiers.REAddr;

public class UnstakeTokensConstructorV2 implements ActionConstructor<UnstakeTokens> {
	@Override
	public void construct(UnstakeTokens action, TxBuilder txBuilder) throws TxBuilderException {
		// TODO: Replace with loadAddr()
		var epochUnlockedMaybe = txBuilder.find(EpochData.class, p -> true).map(EpochData::getEpoch);
		long epochUnlocked;
		if (epochUnlockedMaybe.isPresent()) {
			epochUnlocked = epochUnlockedMaybe.get() + StakingConstraintScryptV3.EPOCHS_LOCKED;
		} else {
			epochUnlocked = txBuilder.find(SystemParticle.class, p -> true)
				.map(SystemParticle::getEpoch).orElse(0L) + StakingConstraintScryptV3.EPOCHS_LOCKED;
		}

		txBuilder.downFungible(
			StakeShares.class,
			p -> p.getOwner().equals(action.accountAddr()) && p.getDelegateKey().equals(action.from()),
			action.amount(),
			amt -> new StakeShares(action.from(), action.accountAddr(), amt),
			"Not enough staked."
		);
		txBuilder.downFungible(
			Stake.class,
			p -> p.getValidatorKey().equals(action.from()),
			action.amount(),
			amt -> new Stake(amt, action.from()),
			"Not enough staked."
		);
		txBuilder.up(new TokensParticle(action.accountAddr(), action.amount(), REAddr.ofNativeToken(), epochUnlocked));
	}
}