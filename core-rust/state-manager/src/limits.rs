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

use node_common::config::limits::VertexLimitsConfig;
use radix_engine::transaction::ExecutionMetrics;

#[derive(Debug, Clone, PartialEq, Eq)]
pub enum VertexLimitsExceeded {
    TransactionsCount,
    TransactionsSize,
    ExecutionCostUnitsConsumed,
    SubstateReadSize,
    SubstateReadCount,
    SubstateWriteSize,
    SubstateWriteCount,
}

pub struct VertexLimitsTracker {
    pub total_transactions_count: usize,
    pub total_transactions_size: usize,
    pub total_execution_cost_units_consumed: usize,
    pub total_substate_read_size: usize,
    pub total_substate_read_count: usize,
    pub total_substate_write_size: usize,
    pub total_substate_write_count: usize,
}

impl VertexLimitsTracker {
    pub fn new() -> Self {
        Self {
            total_transactions_count: 0,
            total_transactions_size: 0,
            total_execution_cost_units_consumed: 0,
            total_substate_read_size: 0,
            total_substate_read_count: 0,
            total_substate_write_size: 0,
            total_substate_write_count: 0,
        }
    }

    pub fn check_pre_execution(
        &self,
        limits_config: &VertexLimitsConfig,
        transaction_size: usize,
    ) -> Result<(), VertexLimitsExceeded> {
        if self.total_transactions_count + 1 > limits_config.max_total_transactions_count {
            return Err(VertexLimitsExceeded::TransactionsCount);
        }

        if self.total_substate_read_size + transaction_size
            > limits_config.max_total_transactions_size
        {
            return Err(VertexLimitsExceeded::TransactionsSize);
        }

        Ok(())
    }

    pub fn check_post_execution(
        &self,
        limits_config: &VertexLimitsConfig,
        execution_metrics: &ExecutionMetrics,
    ) -> Result<(), VertexLimitsExceeded> {
        if self.total_execution_cost_units_consumed
            + execution_metrics.execution_cost_units_consumed
            > limits_config.max_total_execution_cost_units_consumed
        {
            return Err(VertexLimitsExceeded::ExecutionCostUnitsConsumed);
        }

        if self.total_substate_read_size + execution_metrics.substate_read_size
            > limits_config.max_total_substate_read_size
        {
            return Err(VertexLimitsExceeded::SubstateReadSize);
        }

        if self.total_substate_read_count + execution_metrics.substate_read_count
            > limits_config.max_total_substate_read_count
        {
            return Err(VertexLimitsExceeded::SubstateReadCount);
        }

        if self.total_substate_write_size + execution_metrics.substate_write_size
            > limits_config.max_total_substate_write_size
        {
            return Err(VertexLimitsExceeded::SubstateWriteSize);
        }

        if self.total_substate_write_count + execution_metrics.substate_write_count
            > limits_config.max_total_substate_write_count
        {
            return Err(VertexLimitsExceeded::SubstateWriteCount);
        }

        Ok(())
    }

    pub fn advance(&mut self, transaction_size: usize, execution_metrics: &ExecutionMetrics) {
        self.total_transactions_count += 1;
        self.total_transactions_size += transaction_size;
        self.total_execution_cost_units_consumed += execution_metrics.execution_cost_units_consumed;
        self.total_substate_read_count += execution_metrics.substate_read_count;
        self.total_substate_read_size += execution_metrics.substate_read_size;
        self.total_substate_write_count += execution_metrics.substate_write_count;
        self.total_substate_write_size += execution_metrics.substate_write_size;
    }

    pub fn is_full(&self, limits_config: &VertexLimitsConfig) -> bool {
        self.total_transactions_count >= limits_config.max_total_transactions_count
            || self.total_transactions_size >= limits_config.max_total_substate_read_size
            || self.total_execution_cost_units_consumed
                >= limits_config.max_total_execution_cost_units_consumed
            || self.total_substate_read_count >= limits_config.max_total_substate_read_count
            || self.total_substate_read_size >= limits_config.max_total_substate_read_size
            || self.total_substate_write_count >= limits_config.max_total_substate_write_count
            || self.total_substate_write_size >= limits_config.max_total_substate_write_size
    }
}
