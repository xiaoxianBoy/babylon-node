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

package com.radixdlt.integration.steady_state.deterministic.rev2.consensus_ledger_sync;

import static com.radixdlt.environment.deterministic.network.MessageSelector.randomSelector;
import static com.radixdlt.harness.deterministic.invariants.DeterministicMonitors.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.google.inject.Module;
import com.radixdlt.harness.deterministic.DeterministicTest;
import com.radixdlt.harness.deterministic.NodesReader;
import com.radixdlt.harness.predicates.NodesPredicate;
import com.radixdlt.modules.FunctionalRadixNodeModule;
import com.radixdlt.modules.FunctionalRadixNodeModule.ConsensusConfig;
import com.radixdlt.modules.FunctionalRadixNodeModule.LedgerConfig;
import com.radixdlt.modules.FunctionalRadixNodeModule.SafetyRecoveryConfig;
import com.radixdlt.modules.StateComputerConfig;
import com.radixdlt.networks.Network;
import com.radixdlt.rev2.REV2TransactionGenerator;
import com.radixdlt.rev2.modules.MockedVertexStoreModule;
import com.radixdlt.statemanager.REv2DatabaseConfig;
import com.radixdlt.sync.SyncRelayConfig;
import java.util.*;
import java.util.function.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public final class MultiNodeRebootTest {
  @Parameterized.Parameters
  public static Collection<Object[]> numNodes() {
    return List.of(new Object[][] {{4, 500}, {10, 200}});
  }

  public static Function<Integer, NodeLiveness> MIXED_LIVENESS_EACH_ROUND =
      (round) -> {
        round += 31;
        if (round % 11 == 0 || round % 12 == 0) return NodeLiveness.AllDown;
        if (round % 19 == 0) return NodeLiveness.AllUp;
        return (round % 2 == 0)
            ? NodeLiveness.Each30PercentProbabilityUp
            : NodeLiveness.Each50PercentProbabilityUp;
      };

  private static final Logger logger = LogManager.getLogger();

  @Rule public TemporaryFolder folder = new TemporaryFolder();

  private final Random random = new Random(12345);
  private final int numValidators;
  private final int numTestRounds;

  public MultiNodeRebootTest(int numValidators, int numTestRounds) {
    this.numValidators = numValidators;
    this.numTestRounds = numTestRounds;
  }

  private DeterministicTest createTest(
      SafetyRecoveryConfig safetyRecoveryConfig, Module overrideModule) {
    var databaseConfig = REv2DatabaseConfig.rocksDB(folder.getRoot().getAbsolutePath());
    var builder =
        DeterministicTest.builder()
            .numNodes(numValidators, 0)
            .messageSelector(randomSelector(random))
            .addMonitors(byzantineBehaviorNotDetected(), ledgerTransactionSafety());

    if (overrideModule != null) {
      builder.overrideWithIncorrectModule(overrideModule);
    }

    return builder.functionalNodeModule(
        new FunctionalRadixNodeModule(
            false,
            safetyRecoveryConfig,
            ConsensusConfig.of(1000),
            LedgerConfig.stateComputerWithSyncRelay(
                StateComputerConfig.rev2(
                    Network.INTEGRATIONTESTNET.getId(),
                    databaseConfig,
                    StateComputerConfig.REV2ProposerConfig.transactionGenerator(
                        new REV2TransactionGenerator(), 1)),
                SyncRelayConfig.of(5000, 10, 5000L))));
  }

  private void runTest(
      int numDownValidators,
      Function<Integer, NodeLiveness> livenessStrategy,
      SafetyRecoveryConfig safetyRecoveryConfig) {
    runTest(numDownValidators, livenessStrategy, safetyRecoveryConfig, null);
  }

  private void runTest(
      int numValidatorsAlwaysDown,
      Function<Integer, NodeLiveness> livenessStrategy,
      SafetyRecoveryConfig safetyRecoveryConfig,
      Module overrideModule) {
    try (var test = createTest(safetyRecoveryConfig, overrideModule)) {
      test.startAllNodes();

      startOrShutdownNodes(test, numValidatorsAlwaysDown, NodeLiveness.AllUp);

      for (int testRound = 0; testRound < numTestRounds; testRound++) {
        var numNodesLive = test.numNodesLive();
        if (numNodesLive > numValidators * 2 / 3) {
          // Network has a quorum of nodes so should still be able to maintain ledger liveness
          long stateVersion = NodesReader.getHighestStateVersion(test.getNodeInjectors());
          test.runUntilState(NodesPredicate.anyAtOrOverStateVersion(stateVersion + 5), 50000);
        } else if (numNodesLive > 0) {
          // Network has less than the required quorum of nodes so liveness not guaranteed
          test.runForCount(random.nextInt(numNodesLive * 50, numNodesLive * 100));
        }
        // Else all nodes down, network can't do anything - so advance

        var updatedNodeCount =
            startOrShutdownNodes(test, numValidatorsAlwaysDown, livenessStrategy.apply(testRound));

        logger.info(
            "Test_round={}/{}, updated_nodes={}, live_nodes={}",
            testRound + 1,
            numTestRounds,
            updatedNodeCount,
            test.getLiveNodeIndices());
      }
    }
  }

  public enum NodeLiveness {
    AllUp,
    Each30PercentProbabilityUp,
    Each50PercentProbabilityUp,
    AllDown
  }

  private int startOrShutdownNodes(
      DeterministicTest test, int numAlwaysDownValidators, NodeLiveness nodeLiveness) {
    int updatedNodeCount = 0;
    for (var nodeIndex : test.getNodeIndices()) {
      var nodeIsCurrentlyLive = test.getNodes().isNodeLive(nodeIndex);
      if (shouldBeLive(nodeIndex, numAlwaysDownValidators, nodeLiveness)) {
        if (!nodeIsCurrentlyLive) {
          updatedNodeCount += 1;
          test.startNode(nodeIndex);
        }
      } else {
        if (nodeIsCurrentlyLive) {
          updatedNodeCount += 1;
          test.shutdownNode(nodeIndex);
        }
      }
    }
    return updatedNodeCount;
  }

  private boolean shouldBeLive(
      int nodeIndex, int numAlwaysDownValidators, NodeLiveness nodeLiveness) {
    if (nodeIndex < numAlwaysDownValidators) return false;
    switch (nodeLiveness) {
      case AllUp -> {
        return true;
      }
      case Each30PercentProbabilityUp -> {
        return random.nextInt(100) < 30;
      }
      case Each50PercentProbabilityUp -> {
        return random.nextInt(100) < 50;
      }
      case AllDown -> {
        return false;
      }
    }
    throw new IllegalStateException("Shouldn't be able to get here");
  }

  @Test
  public void restart_all_nodes_intermittently() {
    runTest(
        0,
        MIXED_LIVENESS_EACH_ROUND,
        SafetyRecoveryConfig.berkeleyStore(folder.getRoot().getAbsolutePath()));
  }

  @Test
  public void restart_all_nodes_intermittently_with_bad_safety_recovery_should_fail() {
    assertThatThrownBy(() -> runTest(0, MIXED_LIVENESS_EACH_ROUND, SafetyRecoveryConfig.mocked()))
        .hasRootCauseExactlyInstanceOf(ByzantineBehaviorDetected.class);
  }

  @Test
  public void restart_all_nodes_intermittently_with_bad_liveness_recovery_should_fail() {
    assertThatThrownBy(
            () ->
                runTest(
                    0,
                    MIXED_LIVENESS_EACH_ROUND,
                    SafetyRecoveryConfig.berkeleyStore(folder.getRoot().getAbsolutePath()),
                    new MockedVertexStoreModule()))
        .isInstanceOf(DeterministicTest.NeverReachedStateException.class);
  }

  @Test
  public void restart_all_nodes_intermittently_while_f_nodes_down() {
    runTest(
        (numValidators - 1) / 3,
        MIXED_LIVENESS_EACH_ROUND,
        SafetyRecoveryConfig.berkeleyStore(folder.getRoot().getAbsolutePath()));
  }
}
