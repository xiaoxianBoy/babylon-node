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

package com.radixdlt.client.lib.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class RadixEngineData {
	private final long invalidProposedCommands;
	private final long systemTransactions;
	private final long userTransactions;

	private RadixEngineData(long invalidProposedCommands, long systemTransactions, long userTransactions) {
		this.invalidProposedCommands = invalidProposedCommands;
		this.systemTransactions = systemTransactions;
		this.userTransactions = userTransactions;
	}

	@JsonCreator
	public static RadixEngineData create(
		@JsonProperty(value = "invalidProposedCommands", required = true) long invalidProposedCommands,
		@JsonProperty(value = "systemTransactions", required = true) long systemTransactions,
		@JsonProperty(value = "userTransactions", required = true) long userTransactions
	) {
		return new RadixEngineData(invalidProposedCommands, systemTransactions, userTransactions);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof RadixEngineData)) {
			return false;
		}

		var that = (RadixEngineData) o;
		return invalidProposedCommands == that.invalidProposedCommands
			&& systemTransactions == that.systemTransactions
			&& userTransactions == that.userTransactions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(invalidProposedCommands, systemTransactions, userTransactions);
	}

	@Override
	public String toString() {
		return "{invalidProposedCommands:" + invalidProposedCommands
			+ ", systemTransactions:" + systemTransactions
			+ ", userTransactions:" + userTransactions + '}';
	}

	public long getInvalidProposedCommands() {
		return invalidProposedCommands;
	}

	public long getSystemTransactions() {
		return systemTransactions;
	}

	public long getUserTransactions() {
		return userTransactions;
	}
}