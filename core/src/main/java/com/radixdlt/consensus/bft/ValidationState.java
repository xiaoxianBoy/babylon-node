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

package com.radixdlt.consensus.bft;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import com.radixdlt.consensus.TimestampedECDSASignature;
import com.radixdlt.consensus.TimestampedECDSASignatures;
import com.radixdlt.crypto.ECDSASecp256k1Signature;
import com.radixdlt.utils.UInt256;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Keeps track of current validation state for a thing that needs multiple correct signatures for a
 * quorum.
 */
@NotThreadSafe
public final class ValidationState {

  private final BFTValidatorSet validatorSet;
  private final Map<BFTValidatorId, TimestampedECDSASignature> signedValidators;
  private transient UInt256 signedPower;
  private final transient UInt256 threshold;

  /**
   * Construct empty validation state for given hash and set of validator keys.
   *
   * @param validatorSet The validator set
   */
  public static ValidationState forValidatorSet(BFTValidatorSet validatorSet) {
    return new ValidationState(validatorSet);
  }

  private ValidationState(BFTValidatorSet validatorSet) {
    this.validatorSet = Objects.requireNonNull(validatorSet);
    this.signedValidators = new HashMap<>();
    this.signedPower = UInt256.ZERO;
    this.threshold = threshold(validatorSet.getTotalPower());
  }

  /**
   * Removes the signature for the specified key, if present.
   *
   * @param validatorId the validator whose signature is to be removed
   */
  public void removeSignature(BFTValidatorId validatorId) {
    if (this.validatorSet.containsValidator(validatorId)) {
      this.signedValidators.computeIfPresent(
          validatorId,
          (k, v) -> {
            this.signedPower = this.signedPower.subtract(this.validatorSet.getPower(validatorId));
            return null;
          });
    }
  }

  /**
   * Adds key and signature to our list of signing keys and signatures. Note that it is assumed that
   * signature validation is performed elsewhere.
   *
   * @param validatorId The validator ID
   * @param timestamp The timestamp of the signature
   * @param signature The signature to verify
   * @return whether the key was added or not
   */
  public boolean addSignature(
      BFTValidatorId validatorId, long timestamp, ECDSASecp256k1Signature signature) {
    if (validatorSet.containsValidator(validatorId)
        && !this.signedValidators.containsKey(validatorId)) {
      this.signedValidators.computeIfAbsent(
          validatorId,
          k -> {
            UInt256 weight = this.validatorSet.getPower(validatorId);
            this.signedPower = this.signedPower.add(weight);
            return TimestampedECDSASignature.from(timestamp, signature);
          });
      return true;
    }
    return false;
  }

  /** @return {@code true} if we have not accumulated any signatures, {@code false} otherwise. */
  public boolean isEmpty() {
    return this.signedValidators.isEmpty();
  }

  /** @return {@code true} if we have enough valid signatures to form a quorum, */
  public boolean complete() {
    return signedPower.compareTo(threshold) >= 0;
  }

  /**
   * @return an {@link TimestampedECDSASignatures} object for our current set of valid signatures
   */
  public TimestampedECDSASignatures signatures() {
    return new TimestampedECDSASignatures(ImmutableMap.copyOf(this.signedValidators));
  }

  @VisibleForTesting
  static UInt256 threshold(UInt256 n) {
    return n.subtract(acceptableFaults(n));
  }

  @VisibleForTesting
  static UInt256 acceptableFaults(UInt256 n) {
    // Compute acceptable faults based on Byzantine limit n = 3f + 1
    // i.e. f = (n - 1) / 3
    return n.isZero() ? n : n.decrement().divide(UInt256.THREE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validatorSet, signedValidators);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof ValidationState) {
      ValidationState that = (ValidationState) obj;
      return Objects.equals(this.validatorSet, that.validatorSet)
          && Objects.equals(this.signedValidators, that.signedValidators);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format(
        "%s[validatorSet=%s, signedValidators=%s]",
        getClass().getSimpleName(), validatorSet, signedValidators);
  }
}
