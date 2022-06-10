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

package com.radixdlt.lang;

import static com.radixdlt.lang.Tuple.*;

import com.radixdlt.lang.Functions.*;
import com.radixdlt.lang.Result.Failure;
import com.radixdlt.lang.Result.Success;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Representation of the operation result. The result can be either success or failure. In case of
 * success it holds value returned by the operation. In case of failure it holds a failure
 * description.
 *
 * @param <T> Type of value in case of success.
 */
@SuppressWarnings("unused")
public sealed interface Result<T> permits Success, Failure {
  /**
   * Transform operation result value into value of other type and wrap new value into {@link
   * Result}. Transformation takes place if current instance (this) contains successful result,
   * otherwise current instance remains unchanged and transformation function is not invoked.
   *
   * @param mapper Function to transform successful value
   * @return transformed value (in case of success) or current instance (in case of failure)
   */
  @SuppressWarnings("unchecked")
  default <R> Result<R> map(Func1<? super T, R> mapper) {
    return fold(l -> (Result<R>) this, r -> success(mapper.apply(r)));
  }

  /**
   * Replace value stored in current instance with value of other type. Replacing takes place only
   * if current instance (this) contains successful result, otherwise current instance remains
   * unchanged.
   *
   * @param supplier Source of the replacement value.
   * @return transformed value (in case of success) or current instance (in case of failure)
   */
  @SuppressWarnings("unchecked")
  default <R> Result<R> map(Supplier<R> supplier) {
    return fold(l -> (Result<R>) this, unused -> success(supplier.get()));
  }

  /**
   * Transform operation result into another operation result. In case if current instance (this) is
   * an error, transformation function is not invoked and value remains the same.
   *
   * @param mapper Function to apply to result
   * @return transformed value (in case of success) or current instance (in case of failure)
   */
  @SuppressWarnings("unchecked")
  default <R> Result<R> flatMap(Func1<? super T, Result<R>> mapper) {
    return fold(t -> (Result<R>) this, mapper);
  }

  /**
   * Replace current instance with the instance returned by provided {@link Supplier}. The
   * replacement happens only if current instance contains successful result, otherwise current
   * instance remains unchanged.
   *
   * @param mapper Source of the replacement result.
   * @return replacement result (in case of success) or current instance (in case of failure)
   */
  @SuppressWarnings("unchecked")
  default <R> Result<R> flatMap(Supplier<Result<R>> mapper) {
    return fold(t -> (Result<R>) this, unused -> mapper.get());
  }

  /**
   * Apply consumers to result value. Note that depending on the result (success or failure) only
   * one consumer will be applied at a time.
   *
   * @param failureConsumer Consumer for failure result
   * @param successConsumer Consumer for success result
   * @return current instance
   */
  default Result<T> apply(
      Consumer<? super Cause> failureConsumer, Consumer<? super T> successConsumer) {
    return fold(
        t -> {
          failureConsumer.accept(t);
          return this;
        },
        t -> {
          successConsumer.accept(t);
          return this;
        });
  }

  /**
   * Pass successful operation result value into provided consumer.
   *
   * @param consumer Consumer to pass value to
   * @return current instance for fluent call chaining
   */
  default Result<T> onSuccess(Consumer<T> consumer) {
    fold(
        Functions::toNull,
        v -> {
          consumer.accept(v);
          return null;
        });
    return this;
  }

  default Result<T> onOk(Consumer<T> consumer) {
    fold(
        Functions::toNull,
        v -> {
          consumer.accept(v);
          return null;
        });
    return this;
  }

  /**
   * Run provided action in case of success.
   *
   * @return current instance for fluent call chaining
   */
  default Result<T> onSuccessDo(Runnable action) {
    fold(
        Functions::toNull,
        v -> {
          action.run();
          return null;
        });
    return this;
  }

  default Result<T> onOkDo(Runnable action) {
    fold(
        Functions::toNull,
        v -> {
          action.run();
          return null;
        });
    return this;
  }

  /**
   * Pass failure operation result value into provided consumer.
   *
   * @param consumer Consumer to pass value to
   * @return current instance for fluent call chaining
   */
  default Result<T> onFailure(Consumer<? super Cause> consumer) {
    fold(
        v -> {
          consumer.accept(v);
          return null;
        },
        Functions::toNull);
    return this;
  }

  default Result<T> onError(Consumer<? super Cause> consumer) {
    fold(
        v -> {
          consumer.accept(v);
          return null;
        },
        Functions::toNull);
    return this;
  }

  /**
   * Run provided action in case of failure.
   *
   * @return current instance for fluent call chaining
   */
  default Result<T> onFailureDo(Runnable action) {
    fold(
        v -> {
          action.run();
          return null;
        },
        Functions::toNull);
    return this;
  }

  default Result<T> onErrorDo(Runnable action) {
    fold(
        v -> {
          action.run();
          return null;
        },
        Functions::toNull);
    return this;
  }

  /**
   * Convert instance into {@link Option} of the same value type. Successful instance is converted
   * into present {@link Option} and failure - into empty {@link Option}. Note that during such a
   * conversion error information is lost.
   *
   * @return {@link Option} instance which is present in case of success and missing in case of
   *     failure.
   */
  default Option<T> toOption() {
    return fold(t1 -> Option.empty(), Option::option);
  }

  /**
   * Convert instance into {@link Option} of the same value type. Successful instance is converted
   * into empty {@link Option} and successful into empty {@link Option}.
   *
   * @return {@link Option} instance which is present in case of failure and empty in case of
   *     success.
   */
  default Option<Cause> toOptionErr() {
    return fold(Option::option, t1 -> Option.empty());
  }

  /**
   * Convert instance into {@link Optional} of the same value type. Successful instance is converted
   * into present {@link Optional} and failure - into empty {@link Optional}. Note that during such
   * a conversion error information is get lost.
   *
   * @return {@link Optional} instance which is present in case of success and missing in case of
   *     failure.
   */
  default Optional<T> toOptional() {
    return fold(t1 -> Optional.empty(), Optional::of);
  }

  /**
   * Check if instance is success.
   *
   * @return {@code true} if instance is success and {@code false} otherwise
   */
  default boolean isSuccess() {
    return fold(Functions::toFalse, Functions::toTrue);
  }

  /**
   * Check if instance is failure.
   *
   * @return {@code true} if instance is failure and {@code false} otherwise
   */
  default boolean isFailure() {
    return fold(Functions::toTrue, Functions::toFalse);
  }

  /**
   * Filter instance against provided predicate. If predicate returns {@code true} then instance
   * remains unchanged. If predicate returns {@code false}, then failure instance in created using
   * given {@link Cause}.
   *
   * @param cause failure to use in case if predicate returns {@code false}
   * @param predicate predicate to invoke
   * @return current instance if predicate returns {@code true} or {@link Failure} instance if
   *     predicate returns {@code false}
   */
  default Result<T> filter(Cause cause, Predicate<T> predicate) {
    return fold(v -> this, v -> predicate.test(v) ? this : failure(cause));
  }

  /**
   * Filter instance against provided predicate. If predicate returns {@code true} then instance
   * remains unchanged. If predicate returns {@code false}, then failure instance in created using
   * {@link Cause} created by provided function.
   *
   * @param causeMapper function which transforms the tested value into instance of {@link Cause} if
   *     predicate returns {@code false}
   * @param predicate predicate to invoke
   * @return current instance if predicate returns {@code true} or {@link Failure} instance if
   *     predicate returns {@code false}
   */
  default Result<T> filter(Func1<T, Cause> causeMapper, Predicate<T> predicate) {
    return fold(v -> this, v -> predicate.test(v) ? this : failure(causeMapper.apply(v)));
  }

  /**
   * Return value store in the current instance (if this instance represents successful result) or
   * provided replacement value.
   *
   * @param replacement replacement value returned if current instance represents failure.
   * @return value stored in current instance (in case of success) or replacement value.
   */
  default T or(T replacement) {
    return fold(unused -> replacement, Functions::id);
  }

  /**
   * Return value store in the current instance (if this instance represents successful result) or
   * value returned by provided supplier.
   *
   * @param supplier source of replacement value returned if current instance represents failure.
   * @return value stored in current instance (in case of success) or replacement value.
   */
  default T or(Supplier<T> supplier) {
    return fold(unused -> supplier.get(), Functions::id);
  }

  /**
   * Return current instance if this instance represents successful result or replacement instance
   * if current instance represents a failure.
   *
   * @param replacement replacement instance returned if current instance represents failure.
   * @return current instance (in case of success) or replacement instance.
   */
  default Result<T> orElse(Result<T> replacement) {
    return fold(unused -> replacement, unused -> this);
  }

  /**
   * Return current instance if this instance represents successful result or instance returned by
   * provided supplier if current instance represents a failure.
   *
   * @param supplier source of replacement instance returned if current instance represents failure.
   * @return current instance (in case of success) or replacement instance.
   */
  default Result<T> orElse(Supplier<Result<T>> supplier) {
    return fold(unused -> supplier.get(), unused -> this);
  }

  /**
   * This method allows "unwrapping" the value stored inside the Result instance. If the value is
   * missing then an {@link IllegalStateException} is thrown.
   *
   * @return value stored inside present instance.
   */
  default T unwrap() {
    return unwrap(v -> new IllegalStateException("Unwrap error: " + v.message()));
  }

  /**
   * This method allows "unwrapping" the value stored inside the Result instance. If the value is
   * missing then an exception is created from the cause and thrown.
   *
   * @param mapToException a map from the cause to a RuntimeException
   * @return value stored inside present instance.
   */
  default T unwrap(Function<? super Cause, RuntimeException> mapToException) {
    return fold(
        v -> {
          throw mapToException.apply(v);
        },
        Functions::id);
  }

  /**
   * Handle both possible states (success/failure) and produce single value from it.
   *
   * @param failureMapper function to transform failure into value
   * @param successMapper function to transform success into value
   * @return result of application of one of the mappers.
   */
  <R> R fold(
      Func1<? super Cause, ? extends R> failureMapper, Func1<? super T, ? extends R> successMapper);

  default Result<T> accept(Consumer<Cause> failureConsumer, Consumer<T> successConsumer) {
    return fold(
        failure -> {
          failureConsumer.accept(failure);
          return this;
        },
        success -> {
          successConsumer.accept(success);
          return this;
        });
  }

  /**
   * Create an instance of successful operation result.
   *
   * @param value Operation result
   * @return created instance
   */
  static <R> Result<R> success(R value) {
    return new Success<>(value);
  }

  static <R> Result<R> ok(R value) {
    return new Success<>(value);
  }

  record Success<T>(T value) implements Result<T> {
    @Override
    public <R> R fold(
        Func1<? super Cause, ? extends R> failureMapper,
        Func1<? super T, ? extends R> successMapper) {
      return successMapper.apply(value);
    }

    @Override
    public String toString() {
      return "Success(" + value.toString() + ")";
    }
  }

  /**
   * Create an instance of failure result.
   *
   * @param value Operation error value
   * @return created instance
   */
  static <R> Result<R> failure(Cause value) {
    return new Failure<>(value);
  }

  static <R> Result<R> err(Cause value) {
    return new Failure<>(value);
  }

  record Failure<T>(Cause cause) implements Result<T> {
    @Override
    public <R> R fold(
        Func1<? super Cause, ? extends R> failureMapper,
        Func1<? super T, ? extends R> successMapper) {
      return failureMapper.apply(cause);
    }

    @Override
    public String toString() {
      return "Failure(" + cause + ")";
    }
  }

  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  static <T> Result<T> fromOptional(Cause cause, Optional<T> source) {
    return source.map(Result::ok).orElseGet(cause::result);
  }

  /**
   * Wrap value returned by provided lambda into success {@link Result} if call succeeds or into
   * failure {@link Result} if call throws exception.
   *
   * @param exceptionMapper the function which will transform exception into instance of {@link
   *     Cause}
   * @param supplier the call to wrap
   * @return result of execution of the provided lambda wrapped into {@link Result}
   */
  static <R> Result<R> lift(
      Func1<? super Throwable, ? extends Cause> exceptionMapper, ThrowingSupplier<R> supplier) {
    try {
      return success(supplier.get());
    } catch (Throwable e) {
      return failure(exceptionMapper.apply(e));
    }
  }

  /**
   * Transform list of {@link Result} instances into {@link Result} with list of values.
   *
   * @param resultList input list
   * @return success instance if all {@link Result} instances in list are successes or failure
   *     instance with any instances in list is a failure
   */
  static <T> Result<List<T>> allOf(List<Result<T>> resultList) {
    var failure = new Cause[1];
    var values = new ArrayList<T>();

    resultList.forEach(val -> val.fold(f -> failure[0] = f, values::add));

    return failure[0] != null ? failure(failure[0]) : success(values);
  }

  /**
   * Find and return first success instance among provided.
   *
   * @param first first input result
   * @param results remaining input results
   * @return first success instance among provided
   */
  @SafeVarargs
  static <T> Result<T> any(Result<T> first, Result<T>... results) {
    if (first.isSuccess()) {
      return first;
    }

    for (var result : results) {
      if (result.isSuccess()) {
        return result;
      }
    }

    return first;
  }

  /**
   * Lazy version of the {@link #any(Result, Result[])}.
   *
   * @param first first instance to check
   * @param suppliers suppliers which provide remaining instances for check
   * @return first success instance among provided
   */
  @SafeVarargs
  static <T> Result<T> any(Result<T> first, Supplier<Result<T>>... suppliers) {
    if (first.isSuccess()) {
      return first;
    }

    for (var supplier : suppliers) {
      var result = supplier.get();

      if (result.isSuccess()) {
        return result;
      }
    }

    return first;
  }

  @SafeVarargs
  static Result<Unit> allOf(Result<Unit>... values) {
    for (var value : values) {
      if (value.isFailure()) {
        return value;
      }
    }
    return Unit.unitResult();
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper1} prepared for further transformation.
   */
  static <T1> Mapper1<T1> all(Result<T1> value) {
    return () -> value.flatMap(vv1 -> success(tuple(vv1)));
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper2} prepared for further transformation.
   */
  static <T1, T2> Mapper2<T1, T2> all(Result<T1> value1, Result<T2> value2) {
    return () -> value1.flatMap(vv1 -> value2.flatMap(vv2 -> success(tuple(vv1, vv2))));
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper3} prepared for further transformation.
   */
  static <T1, T2, T3> Mapper3<T1, T2, T3> all(
      Result<T1> value1, Result<T2> value2, Result<T3> value3) {
    return () ->
        value1.flatMap(
            vv1 -> value2.flatMap(vv2 -> value3.flatMap(vv3 -> success(tuple(vv1, vv2, vv3)))));
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper4} prepared for further transformation.
   */
  static <T1, T2, T3, T4> Mapper4<T1, T2, T3, T4> all(
      Result<T1> value1, Result<T2> value2, Result<T3> value3, Result<T4> value4) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 -> value4.flatMap(vv4 -> success(tuple(vv1, vv2, vv3, vv4))))));
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper5} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5> Mapper5<T1, T2, T3, T4, T5> all(
      Result<T1> value1,
      Result<T2> value2,
      Result<T3> value3,
      Result<T4> value4,
      Result<T5> value5) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 ->
                                value4.flatMap(
                                    vv4 ->
                                        value5.flatMap(
                                            vv5 -> success(tuple(vv1, vv2, vv3, vv4, vv5)))))));
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper6} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5, T6> Mapper6<T1, T2, T3, T4, T5, T6> all(
      Result<T1> value1,
      Result<T2> value2,
      Result<T3> value3,
      Result<T4> value4,
      Result<T5> value5,
      Result<T6> value6) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 ->
                                value4.flatMap(
                                    vv4 ->
                                        value5.flatMap(
                                            vv5 ->
                                                value6.flatMap(
                                                    vv6 ->
                                                        success(
                                                            tuple(
                                                                vv1, vv2, vv3, vv4, vv5,
                                                                vv6))))))));
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper7} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5, T6, T7> Mapper7<T1, T2, T3, T4, T5, T6, T7> all(
      Result<T1> value1,
      Result<T2> value2,
      Result<T3> value3,
      Result<T4> value4,
      Result<T5> value5,
      Result<T6> value6,
      Result<T7> value7) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 ->
                                value4.flatMap(
                                    vv4 ->
                                        value5.flatMap(
                                            vv5 ->
                                                value6.flatMap(
                                                    vv6 ->
                                                        value7.flatMap(
                                                            vv7 ->
                                                                success(
                                                                    tuple(
                                                                        vv1, vv2, vv3, vv4, vv5,
                                                                        vv6, vv7)))))))));
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper8} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5, T6, T7, T8> Mapper8<T1, T2, T3, T4, T5, T6, T7, T8> all(
      Result<T1> value1,
      Result<T2> value2,
      Result<T3> value3,
      Result<T4> value4,
      Result<T5> value5,
      Result<T6> value6,
      Result<T7> value7,
      Result<T8> value8) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 ->
                                value4.flatMap(
                                    vv4 ->
                                        value5.flatMap(
                                            vv5 ->
                                                value6.flatMap(
                                                    vv6 ->
                                                        value7.flatMap(
                                                            vv7 ->
                                                                value8.flatMap(
                                                                    vv8 ->
                                                                        success(
                                                                            tuple(
                                                                                vv1, vv2, vv3, vv4,
                                                                                vv5, vv6, vv7,
                                                                                vv8))))))))));
  }

  /**
   * Transform provided results into single result containing tuple of values. The result is failure
   * if any input result is failure. Otherwise returned instance contains tuple with values from
   * input results.
   *
   * @return {@link Mapper9} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Mapper9<T1, T2, T3, T4, T5, T6, T7, T8, T9> all(
      Result<T1> value1,
      Result<T2> value2,
      Result<T3> value3,
      Result<T4> value4,
      Result<T5> value5,
      Result<T6> value6,
      Result<T7> value7,
      Result<T8> value8,
      Result<T9> value9) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 ->
                                value4.flatMap(
                                    vv4 ->
                                        value5.flatMap(
                                            vv5 ->
                                                value6.flatMap(
                                                    vv6 ->
                                                        value7.flatMap(
                                                            vv7 ->
                                                                value8.flatMap(
                                                                    vv8 ->
                                                                        value9.flatMap(
                                                                            vv9 ->
                                                                                success(
                                                                                    tuple(
                                                                                        vv1, vv2,
                                                                                        vv3, vv4,
                                                                                        vv5, vv6,
                                                                                        vv7, vv8,
                                                                                        vv9)))))))))));
  }

  static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
      Mapper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> all(
          Result<T1> value1,
          Result<T2> value2,
          Result<T3> value3,
          Result<T4> value4,
          Result<T5> value5,
          Result<T6> value6,
          Result<T7> value7,
          Result<T8> value8,
          Result<T9> value9,
          Result<T10> value10) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 ->
                                value4.flatMap(
                                    vv4 ->
                                        value5.flatMap(
                                            vv5 ->
                                                value6.flatMap(
                                                    vv6 ->
                                                        value7.flatMap(
                                                            vv7 ->
                                                                value8.flatMap(
                                                                    vv8 ->
                                                                        value9.flatMap(
                                                                            vv9 ->
                                                                                value10.flatMap(
                                                                                    vv10 ->
                                                                                        success(
                                                                                            tuple(
                                                                                                vv1,
                                                                                                vv2,
                                                                                                vv3,
                                                                                                vv4,
                                                                                                vv5,
                                                                                                vv6,
                                                                                                vv7,
                                                                                                vv8,
                                                                                                vv9,
                                                                                                vv10))))))))))));
  }

  static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>
      Mapper11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> all(
          Result<T1> value1,
          Result<T2> value2,
          Result<T3> value3,
          Result<T4> value4,
          Result<T5> value5,
          Result<T6> value6,
          Result<T7> value7,
          Result<T8> value8,
          Result<T9> value9,
          Result<T10> value10,
          Result<T11> value11) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 ->
                                value4.flatMap(
                                    vv4 ->
                                        value5.flatMap(
                                            vv5 ->
                                                value6.flatMap(
                                                    vv6 ->
                                                        value7.flatMap(
                                                            vv7 ->
                                                                value8.flatMap(
                                                                    vv8 ->
                                                                        value9.flatMap(
                                                                            vv9 ->
                                                                                value10.flatMap(
                                                                                    vv10 ->
                                                                                        value11
                                                                                            .flatMap(
                                                                                                vv11 ->
                                                                                                    success(
                                                                                                        tuple(
                                                                                                            vv1,
                                                                                                            vv2,
                                                                                                            vv3,
                                                                                                            vv4,
                                                                                                            vv5,
                                                                                                            vv6,
                                                                                                            vv7,
                                                                                                            vv8,
                                                                                                            vv9,
                                                                                                            vv10,
                                                                                                            vv11)))))))))))));
  }

  static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>
      Mapper12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> all(
          Result<T1> value1,
          Result<T2> value2,
          Result<T3> value3,
          Result<T4> value4,
          Result<T5> value5,
          Result<T6> value6,
          Result<T7> value7,
          Result<T8> value8,
          Result<T9> value9,
          Result<T10> value10,
          Result<T11> value11,
          Result<T12> value12) {
    return () ->
        value1.flatMap(
            vv1 ->
                value2.flatMap(
                    vv2 ->
                        value3.flatMap(
                            vv3 ->
                                value4.flatMap(
                                    vv4 ->
                                        value5.flatMap(
                                            vv5 ->
                                                value6.flatMap(
                                                    vv6 ->
                                                        value7.flatMap(
                                                            vv7 ->
                                                                value8.flatMap(
                                                                    vv8 ->
                                                                        value9.flatMap(
                                                                            vv9 ->
                                                                                value10.flatMap(
                                                                                    vv10 ->
                                                                                        value11
                                                                                            .flatMap(
                                                                                                vv11 ->
                                                                                                    value12
                                                                                                        .flatMap(
                                                                                                            vv12 ->
                                                                                                                success(
                                                                                                                    tuple(
                                                                                                                        vv1,
                                                                                                                        vv2,
                                                                                                                        vv3,
                                                                                                                        vv4,
                                                                                                                        vv5,
                                                                                                                        vv6,
                                                                                                                        vv7,
                                                                                                                        vv8,
                                                                                                                        vv9,
                                                                                                                        vv10,
                                                                                                                        vv11,
                                                                                                                        vv12))))))))))))));
  }

  /**
   * Helper interface for convenient {@link Tuple1} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper1<T1> {
    Result<Tuple1<T1>> id();

    default <R> Result<R> map(Func1<T1, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func1<T1, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple2} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper2<T1, T2> {
    Result<Tuple2<T1, T2>> id();

    default <R> Result<R> map(Func2<T1, T2, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func2<T1, T2, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple3} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper3<T1, T2, T3> {
    Result<Tuple3<T1, T2, T3>> id();

    default <R> Result<R> map(Func3<T1, T2, T3, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func3<T1, T2, T3, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple4} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper4<T1, T2, T3, T4> {
    Result<Tuple4<T1, T2, T3, T4>> id();

    default <R> Result<R> map(Func4<T1, T2, T3, T4, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func4<T1, T2, T3, T4, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple5} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper5<T1, T2, T3, T4, T5> {
    Result<Tuple5<T1, T2, T3, T4, T5>> id();

    default <R> Result<R> map(Func5<T1, T2, T3, T4, T5, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func5<T1, T2, T3, T4, T5, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple6} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper6<T1, T2, T3, T4, T5, T6> {
    Result<Tuple6<T1, T2, T3, T4, T5, T6>> id();

    default <R> Result<R> map(Func6<T1, T2, T3, T4, T5, T6, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func6<T1, T2, T3, T4, T5, T6, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple7} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper7<T1, T2, T3, T4, T5, T6, T7> {
    Result<Tuple7<T1, T2, T3, T4, T5, T6, T7>> id();

    default <R> Result<R> map(Func7<T1, T2, T3, T4, T5, T6, T7, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func7<T1, T2, T3, T4, T5, T6, T7, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple8} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper8<T1, T2, T3, T4, T5, T6, T7, T8> {
    Result<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> id();

    default <R> Result<R> map(Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func8<T1, T2, T3, T4, T5, T6, T7, T8, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple9} transformation. In case if you need to return a
   * tuple, it might be more convenient to return this interface instead. For example, instead of
   * this:
   *
   * <blockquote>
   *
   * <pre>
   *     return tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   *
   * return this:
   *
   * <blockquote>
   *
   * <pre>
   *     return () -> tuple(value, ...);
   * </pre>
   *
   * </blockquote>
   */
  interface Mapper9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
    Result<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> id();

    default <R> Result<R> map(Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  interface Mapper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> {
    Result<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> id();

    default <R> Result<R> map(Func10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(
        Func10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  interface Mapper11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> {
    Result<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> id();

    default <R> Result<R> map(Func11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(
        Func11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  interface Mapper12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> {
    Result<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> id();

    default <R> Result<R> map(Func12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Result<R> flatMap(
        Func12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, Result<R>> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }
}
