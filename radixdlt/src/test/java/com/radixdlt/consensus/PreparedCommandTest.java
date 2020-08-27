/*
 * (C) Copyright 2020 Radix DLT Ltd
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
 */

package com.radixdlt.consensus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.radixdlt.crypto.Hash;
import org.junit.Before;
import org.junit.Test;

public class PreparedCommandTest {
	private PreparedCommand preparedCommand;
	private Hash timestampedSignatureHash;

	@Before
	public void setup() {
		this.timestampedSignatureHash = mock(Hash.class);
		this.preparedCommand = PreparedCommand.create(12345, timestampedSignatureHash, false);
	}

	@Test
	public void testGetters() {
		assertThat(preparedCommand.getStateVersion()).isEqualTo(12345);
		assertThat(preparedCommand.getTimestampedSignaturesHash()).isEqualTo(timestampedSignatureHash);
		assertThat(preparedCommand.isEndOfEpoch()).isFalse();
	}
}