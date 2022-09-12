/* Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */

package com.radixdlt.rev2;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.*;
import com.radixdlt.addressing.Addressing;
import com.radixdlt.consensus.MockedConsensusRecoveryModule;
import com.radixdlt.consensus.bft.BFTNode;
import com.radixdlt.consensus.bft.ExecutedVertex;
import com.radixdlt.consensus.bft.Round;
import com.radixdlt.consensus.liveness.ProposalGenerator;
import com.radixdlt.crypto.ECKeyPair;
import com.radixdlt.environment.deterministic.DeterministicProcessor;
import com.radixdlt.environment.deterministic.network.DeterministicNetwork;
import com.radixdlt.environment.deterministic.network.MessageMutator;
import com.radixdlt.environment.deterministic.network.MessageSelector;
import com.radixdlt.harness.deterministic.DeterministicEnvironmentModule;
import com.radixdlt.keys.InMemoryBFTKeyModule;
import com.radixdlt.ledger.MockedLedgerRecoveryModule;
import com.radixdlt.messaging.TestMessagingModule;
import com.radixdlt.modules.CryptoModule;
import com.radixdlt.modules.FunctionalRadixNodeModule;
import com.radixdlt.modules.FunctionalRadixNodeModule.ConsensusConfig;
import com.radixdlt.modules.FunctionalRadixNodeModule.LedgerConfig;
import com.radixdlt.modules.StateComputerConfig;
import com.radixdlt.modules.StateComputerConfig.REV2ProposerConfig;
import com.radixdlt.monitoring.SystemCounters;
import com.radixdlt.monitoring.SystemCountersImpl;
import com.radixdlt.networks.Network;
import com.radixdlt.p2p.TestP2PModule;
import com.radixdlt.rev2.modules.MockedPersistenceStoreModule;
import com.radixdlt.statemanager.REv2DatabaseConfig;
import com.radixdlt.transaction.REv2TransactionAndProofStore;
import com.radixdlt.transaction.TransactionBuilder;
import com.radixdlt.transactions.RawTransaction;
import com.radixdlt.utils.PrivateKeys;
import com.radixdlt.utils.TimeSupplier;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public final class REv2RejectedTransactionTest {
  private static final ECKeyPair TEST_KEY = PrivateKeys.ofNumeric(1);
  private static final NetworkDefinition NETWORK_DEFINITION = NetworkDefinition.LOCAL_SIMULATOR;

  private final DeterministicNetwork network =
      new DeterministicNetwork(
          List.of(BFTNode.create(TEST_KEY.getPublicKey())),
          MessageSelector.firstSelector(),
          MessageMutator.nothing());

  @Rule public TemporaryFolder folder = new TemporaryFolder();
  @Inject private DeterministicProcessor processor;
  @Inject private REv2TransactionAndProofStore transactionStoreReader;

  private Injector createInjector(ProposalGenerator proposalGenerator) {
    return Guice.createInjector(
        new CryptoModule(),
        new TestMessagingModule.Builder().withDefaultRateLimit().build(),
        new MockedLedgerRecoveryModule(),
        new MockedConsensusRecoveryModule.Builder()
            .withNodes(List.of(BFTNode.create(TEST_KEY.getPublicKey())))
            .build(),
        new MockedPersistenceStoreModule(),
        new FunctionalRadixNodeModule(
            false,
            ConsensusConfig.of(),
            LedgerConfig.stateComputerNoSync(
                StateComputerConfig.rev2(
                    Network.LOCALSIMULATOR.getId(),
                    new REv2DatabaseConfig.RocksDB(folder.getRoot().getAbsolutePath()),
                    REV2ProposerConfig.transactionGenerator(proposalGenerator)))),
        new TestP2PModule.Builder().build(),
        new InMemoryBFTKeyModule(TEST_KEY),
        new DeterministicEnvironmentModule(
            network.createSender(BFTNode.create(TEST_KEY.getPublicKey()))),
        new AbstractModule() {
          @Override
          protected void configure() {
            bind(SystemCounters.class).to(SystemCountersImpl.class).in(Scopes.SINGLETON);
            bind(Addressing.class).toInstance(Addressing.ofNetwork(Network.LOCALSIMULATOR));
            bind(TimeSupplier.class).toInstance(System::currentTimeMillis);
          }
        });
  }

  private static RawTransaction createRejectableTransaction() {
    var rejectableManifest =
        "CALL_METHOD"
            + " ComponentAddress(\"account_sim1q02r73u7nv47h80e30pc3q6ylsj7mgvparm3pnsm780qgsy064\")"
            + " \"withdraw_by_amount\" Decimal(\"5.0\")"
            + " ResourceAddress(\"resource_sim1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqzqu57yag\");";
    var header = TransactionHeader.defaults(NETWORK_DEFINITION, 1, TEST_KEY.getPublicKey(), false);
    var intentBytes =
        TransactionBuilder.createIntent(NETWORK_DEFINITION, header, rejectableManifest);
    return REv2TestTransactions.constructTransaction(intentBytes, TEST_KEY, List.of(TEST_KEY));
  }

  private static class ControlledProposerGenerator implements ProposalGenerator {
    private RawTransaction nextTransaction = null;

    @Override
    public List<RawTransaction> getTransactionsForProposal(
        Round round, List<ExecutedVertex> prepared) {
      if (nextTransaction == null) {
        return List.of();
      } else {
        var txns = List.of(nextTransaction);
        this.nextTransaction = null;
        return txns;
      }
    }
  }

  @Test
  public void rejected_transaction_in_proposal_should_not_be_committed() {
    var proposalGenerator = new ControlledProposerGenerator();

    // Arrange: Start single node network
    createInjector(proposalGenerator).injectMembers(this);
    var newAccountTransaction = createRejectableTransaction();

    // Act: Submit transaction to mempool and run consensus
    processor.start();
    for (int i = 0; i < 1000; i++) {
      var msg = network.nextMessage().value();
      processor.handleMessage(msg.origin(), msg.message(), msg.typeLiteral());
    }
    proposalGenerator.nextTransaction = newAccountTransaction;
    for (int i = 0; i < 1000; i++) {
      var msg = network.nextMessage().value();
      processor.handleMessage(msg.origin(), msg.message(), msg.typeLiteral());
    }

    // Assert: Check transaction and post submission state
    assertThat(proposalGenerator.nextTransaction).isNull();
    // Verify that no transaction was committed
    assertThat(transactionStoreReader.getLastProof()).isEmpty();
  }
}