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

package com.radixdlt.application.faucet;

import com.radixdlt.identifiers.RadixAddress;

import java.util.Objects;

/**
 * Faucet request object
 */
public final class FaucetRequest {
	private final RadixAddress address;

	private FaucetRequest(RadixAddress address) {
		this.address = address;
	}

	public static FaucetRequest create(RadixAddress address) {
		Objects.requireNonNull(address);
		return new FaucetRequest(address);
	}

	public RadixAddress getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return String.format("%s{address=%s}", this.getClass().getSimpleName(), address);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(address);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FaucetRequest)) {
			return false;
		}
		var other = (FaucetRequest) o;
		return Objects.equals(this.address, other.address);
	}
}