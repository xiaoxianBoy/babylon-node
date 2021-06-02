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

package com.radixdlt.atommodel;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.radixdlt.atommodel.tokens.Bucket;
import com.radixdlt.constraintmachine.Particle;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class BucketEqualsHashCode {
	private static final ImmutableMap<Class<?>, ImmutableList<String>> ignoredFieldsByClass = ImmutableMap.of(
	);

	@Test
	public void verify_all_buckets_correctly_override_equals_and_hash_code() {
		final Set<Class<? extends Bucket>> subTypes = new HashSet<>();
		subTypes.addAll(findSubTypesInPkg("org.radix"));
		subTypes.addAll(findSubTypesInPkg("com.radixdlt"));

		subTypes.stream()
			.filter(cls -> !Modifier.isAbstract(cls.getModifiers()))
			.forEachOrdered(this::testEquals);
	}

	private void testEquals(Class<? extends Bucket> cls) {
		final String[] ignoredFields = ignoredFieldsByClass.entrySet().stream()
			.filter(e -> e.getKey().isAssignableFrom(cls))
			.flatMap(e -> e.getValue().stream())
			.toArray(String[]::new);

		EqualsVerifier.forClass(cls)
			.suppress(Warning.NONFINAL_FIELDS)
			.withIgnoredFields(ignoredFields)
			.verify();
	}

	private Set<Class<? extends Bucket>> findSubTypesInPkg(String packagePrefix) {
		return new Reflections(packagePrefix).getSubTypesOf(Bucket.class);
	}
}
