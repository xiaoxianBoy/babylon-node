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

package com.radixdlt.application.validator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.radixdlt.atom.TxBuilder;
import com.radixdlt.atom.TxBuilderException;
import com.radixdlt.atommodel.tokens.TokenDefinitionUtils;
import com.radixdlt.chaos.mempoolfiller.InMemoryWallet;
import com.radixdlt.consensus.Command;
import com.radixdlt.consensus.HashSigner;
import com.radixdlt.consensus.bft.Self;
import com.radixdlt.constraintmachine.Particle;
import com.radixdlt.engine.RadixEngine;
import com.radixdlt.environment.EventDispatcher;
import com.radixdlt.environment.EventProcessor;
import com.radixdlt.fees.FeeTable;
import com.radixdlt.fees.NativeToken;
import com.radixdlt.identifiers.RRI;
import com.radixdlt.identifiers.RadixAddress;
import com.radixdlt.mempool.MempoolAdd;
import com.radixdlt.serialization.DsonOutput;
import com.radixdlt.serialization.Serialization;
import com.radixdlt.statecomputer.LedgerAndBFTProof;
import com.radixdlt.utils.UInt256;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Registers/Unregisters self as a validator by submitting request
 * to the mempool.
 */
public final class ValidatorRegistrator {
	private static final Logger logger = LogManager.getLogger();
	private static final UInt256 FEE = UInt256.TEN.pow(TokenDefinitionUtils.SUB_UNITS_POW_10 - 3)
		.multiply(UInt256.from(50));

	private final RadixEngine<LedgerAndBFTProof> radixEngine;
	private final RadixAddress self;
	private final HashSigner hashSigner;
	private final Serialization serialization;
	private final EventDispatcher<MempoolAdd> mempoolAddEventDispatcher;

	// TODO: do something better than this hack
	@Inject(optional = true)
	private FeeTable feeTable;

	private final RRI tokenRRI;

	@Inject
	public ValidatorRegistrator(
		@Self RadixAddress self,
		@NativeToken RRI tokenRRI,
		@Named("RadixEngine") HashSigner hashSigner,
		Serialization serialization,
		RadixEngine<LedgerAndBFTProof> radixEngine,
		EventDispatcher<MempoolAdd> mempoolAddEventDispatcher
	) {
		this.self = self;
		this.tokenRRI = tokenRRI;
		this.hashSigner = hashSigner;
		this.serialization = serialization;
		this.radixEngine = radixEngine;
		this.mempoolAddEventDispatcher = mempoolAddEventDispatcher;
	}

	public EventProcessor<ValidatorRegistration> validatorRegistrationEventProcessor() {
		return this::process;
	}

	private void process(ValidatorRegistration registration) {
		var validatorState = radixEngine.getComputedState(ValidatorState.class);

		var particles = new ArrayList<Particle>();
		particles.add(validatorState.currentParticle());
		if (feeTable != null) {
			var wallet = radixEngine.getComputedState(InMemoryWallet.class);
			particles.addAll(wallet.particles());
		}
		var txBuilder = TxBuilder.newBuilder(self, particles);

		try {
			if (registration.isRegister()) {
				txBuilder.registerAsValidator();
			} else {
				txBuilder.unregisterAsValidator();
			}

			if (feeTable != null) {
				txBuilder.burnForFee(tokenRRI, FEE);
			}
		} catch (TxBuilderException e) {
			logger.warn(e.getMessage());
			return;
		}

		logger.info("Validator submitting {}.", registration.isRegister() ? "register" : "unregister");
		var atom = txBuilder.signAndBuild(hashSigner::sign);
		var payload = serialization.toDson(atom, DsonOutput.Output.ALL);
		var command = new Command(payload);
		this.mempoolAddEventDispatcher.dispatch(MempoolAdd.create(command));
	}
}