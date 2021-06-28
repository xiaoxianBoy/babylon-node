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

package com.radixdlt.application.system.construction;

import com.radixdlt.atom.ActionConstructor;
import com.radixdlt.atom.TxBuilder;
import com.radixdlt.atom.TxBuilderException;
import com.radixdlt.atom.actions.FeeReserveComplete;
import com.radixdlt.crypto.ECPublicKey;
import com.radixdlt.utils.UInt256;

import java.util.Optional;

public class FeeReserveCompleteConstructor implements ActionConstructor<FeeReserveComplete> {
	private final UInt256 costPerByte;
	public FeeReserveCompleteConstructor(UInt256 costPerByte) {
		this.costPerByte = costPerByte;
	}

	@Override
	public void construct(FeeReserveComplete action, TxBuilder builder) throws TxBuilderException {
		var feeReserve = Optional.ofNullable(builder.getFeeReserve()).orElse(UInt256.ZERO);
		var sigSize = 1 + 64 + 1;
		int curSize = builder.toLowLevelBuilder().size() + sigSize;
		var expectedFee1 = costPerByte.multiply(UInt256.from(curSize));
		if (feeReserve.compareTo(expectedFee1) < 0) {
			throw new FeeReserveCompleteException(feeReserve, expectedFee1);
		}

		if (feeReserve.compareTo(expectedFee1) == 0) {
			// Don't add END inst
			return;
		}

		// TODO: Clean this up
		var syscallSize = 0;
		syscallSize++; // REInstruction
		syscallSize++; // size
		syscallSize++; // syscall id
		syscallSize += UInt256.BYTES;

		var endSize = 1;
		var expectedSizeWithNoReturn = curSize + syscallSize + endSize;
		var expectedFee = costPerByte.multiply(UInt256.from(expectedSizeWithNoReturn));
		if (!expectedFee.equals(feeReserve)) {
			var expectedSizeWithReturn = expectedSizeWithNoReturn + getReturnedSubstateSize();
			expectedFee = costPerByte.multiply(UInt256.from(expectedSizeWithReturn));
		}
		if (feeReserve.compareTo(expectedFee) < 0) {
			throw new FeeReserveCompleteException(feeReserve, expectedFee);
		}
		var leftover = feeReserve.subtract(expectedFee);
		builder.takeFeeReserve(action.to(), leftover);
		builder.end();
	}

	private static int getReturnedSubstateSize() {
		var returnSubstateSize = 0;
		returnSubstateSize++; // REInstruction
		returnSubstateSize++; // Substate typeId
		returnSubstateSize++; // Reserved
		returnSubstateSize += ECPublicKey.COMPRESSED_BYTES + 1; // PubKey addr
		returnSubstateSize++; // Native token addr
		returnSubstateSize += UInt256.BYTES; // amount
		return returnSubstateSize;
	}
}
