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

package com.radixdlt.constraintmachine;

import com.radixdlt.atommodel.system.SystemParticle;

import java.util.List;
import java.util.stream.Stream;

/**
 * Transaction which has been successfully parsed and state checked by radix engine
 */
public final class ParsedTransaction {
	private final List<ParsedInstruction> instructions;

	public ParsedTransaction(List<ParsedInstruction> instructions) {
		this.instructions = instructions;
	}

	public boolean isUserCommand() {
		return instructions.stream().noneMatch(i -> i.getParticle() instanceof SystemParticle);
	}

	public List<ParsedInstruction> instructions() {
		return instructions;
	}

	public Stream<Particle> upSubstates() {
		return instructions.stream()
			.filter(ParsedInstruction::isUp)
			.map(ParsedInstruction::getParticle);
	}
}
