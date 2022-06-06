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

import com.radixdlt.lang.Functions.*;
import com.radixdlt.lang.Option.None;
import com.radixdlt.lang.Option.Some;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Implementation of basic immutable container for value which may or may not be present.
 *
 * @param <T> Type of contained value
 */
public sealed interface Option<T> permits Some, None {
  /**
   * Convert instance into other instance of different type using provided mapping function.
   *
   * @param mapper Mapping function
   * @param <U> Type of new value
   * @return transformed instance
   */
  default <U> Option<U> map(FN1<U, ? super T> mapper) {
    return fold(Option::empty, t -> present(mapper.apply(t)));
  }

  /**
   * Replace current instance with the value returned by provided supplier.
   *
   * @param supplier Source of replacement value.
   * @return current instance if it is empty or the instance with the replacement value if current
   *     instance is preseent.
   */
  default <U> Option<U> map(Supplier<U> supplier) {
    return fold(Option::empty, t -> present(supplier.get()));
  }

  /**
   * Replace current present instance with another one generated by applying provided mapper to
   * value stored in this instance. Empty instance is replaced with empty instance of new type
   * matching type of provided mapping function.
   *
   * @param mapper Mapping function
   * @param <U> New type
   * @return Instance of new type
   */
  default <U> Option<U> flatMap(FN1<Option<U>, ? super T> mapper) {
    return fold(Option::empty, mapper);
  }

  /**
   * Replace current instance with the instance returned by provided supplier.
   *
   * @param supplier Source of replacement value.
   * @return current instance if it is empty or the instance with the replacement value if current
   *     instance is present.
   */
  default <U> Option<U> flatMap(Supplier<Option<U>> supplier) {
    return fold(Option::empty, unused -> supplier.get());
  }

  /**
   * Transform instance according to results of testing of contained value with provided predicate.
   * If instance is empty, it remains empty. If instance contains value, this value is passed to
   * predicate. If predicate returns <code>true</code> then instance remains untouched. If predicate
   * returns <code>false</code> then empty instance is returned instead.
   *
   * @param predicate Predicate to test instance value.
   * @return current instance if it is not empty and predicate returns <code>true</code> and empty
   *     instance otherwise
   */
  default Option<T> filter(Predicate<? super T> predicate) {
    return fold(Option::empty, v -> predicate.test(v) ? this : empty());
  }

  /**
   * Pass internal value to provided consumer in-line. Consumer is invoked only if current instance
   * is not empty. This is a convenience method which can be inserted at any point of fluent call
   * chain. Note that provided consumer should not change value in any way (for example, if
   * contained value is mutable collection/map/array/etc.) and should not throw any kind of
   * exceptions.
   *
   * @param consumer Consumer to pass contained value to
   * @return this instance for fluent call chaining
   */
  default Option<T> onPresent(Consumer<? super T> consumer) {
    apply(Functions::unitFn, consumer);
    return this;
  }

  default Option<T> onSome(Consumer<? super T> consumer) {
    apply(Functions::unitFn, consumer);
    return this;
  }

  /**
   * Execute action if instance is empty and do nothing otherwise.
   *
   * @param action Action to perform on empty instance
   * @return this instance for fluent call chaining
   */
  default Option<T> onEmpty(Runnable action) {
    apply(action, Functions::unitFn);
    return this;
  }

  default Option<T> onNone(Runnable action) {
    apply(action, Functions::unitFn);
    return this;
  }

  /**
   * Convenience method which allows performing specific actions for empty and present instances at
   * once.
   *
   * @param emptyValConsumer Action to perform in case of empty instance
   * @param nonEmptyValConsumer Action to perform on present instance value
   * @return this instance for fluent call chaining
   */
  default Option<T> apply(Runnable emptyValConsumer, Consumer<? super T> nonEmptyValConsumer) {
    fold(
        () -> {
          emptyValConsumer.run();
          return null;
        },
        t2 -> {
          nonEmptyValConsumer.accept(t2);
          return null;
        });
    return this;
  }

  /**
   * Return current value stored in current instance if current instance is present. If current
   * instance is empty then return provided replacement value.
   *
   * @param replacement Replacement value returned in case if current instance is empty
   * @return either value stored in current instance or provided replacement value if current
   *     instance is empty
   */
  default T or(T replacement) {
    return fold(() -> replacement, Functions::id);
  }

  /**
   * Return current value stored in current instance if current instance is present. If current
   * instance is empty then return value returned by provided supplier. If current instance is not
   * empty then supplier is not invoked.
   *
   * @param supplier Supplier for replacement value returned in case if current instance is empty
   * @return either value stored in current instance or value returned by provided supplier if
   *     current instance is empty
   */
  default T or(Supplier<T> supplier) {
    return fold(supplier, Functions::id);
  }

  /**
   * Return current instance if current instance is present. If current instance is empty then
   * return provided replacement option instance.
   *
   * @param replacement Replacement option instance for case when current instance is empty
   * @return either current instance or provided replacement instance if current instance is empty
   */
  default Option<T> orElse(Option<T> replacement) {
    return fold(() -> replacement, unused -> this);
  }

  /**
   * Return current instance if current instance is present. If current instance is empty then
   * retrieve replacement Option instance from given {@link Supplier}.
   *
   * @param supplier Source if replacement option instance for case when current instance is empty
   * @return either current instance or provided replacement instance if current instance is empty
   */
  default Option<T> orElse(Supplier<Option<T>> supplier) {
    return fold(supplier, unused -> this);
  }

  /**
   * Check if current instance is present.
   *
   * @return {@code true} if instance is present and {@code false} otherwise.
   */
  default boolean isPresent() {
    return fold(() -> false, Functions::toTrue);
  }

  /**
   * Check if current instance is empty.
   *
   * @return {@code true} if instance is empty and {@code false} otherwise.
   */
  default boolean isEmpty() {
    return fold(() -> true, Functions::toFalse);
  }

  /**
   * Stream current instance. For empty instance empty stream is created. For present instance the
   * stream with single element is returned. The element is the value stored in current instance.
   *
   * @return created stream
   */
  default Stream<T> stream() {
    return fold(Stream::empty, Stream::of);
  }

  /**
   * Convert current instance to instance of {@link Result}. The present instance is converted into
   * success result. The empty instance is converted into failure result with provided {@link
   * Cause}.
   *
   * @param cause the failure necessary for conversion of empty instance.
   * @return created instance
   */
  default Result<T> toResult(Cause cause) {
    return fold(cause::result, Result::success);
  }

  /**
   * Convert current instance to instance of {@link Optional}. The present instance is converted
   * into present instance of {@link Optional}. The empty instance is converted into empty instance
   * of {@link Optional}.
   *
   * @return created instance
   */
  default Optional<T> toOptional() {
    return fold(Optional::empty, Optional::of);
  }

  /**
   * Handle both possible states (empty/present) and produce single result from it.
   *
   * @param emptyMapper function to produce value in case of empty instance
   * @param presentMapper function to transform present value into output value
   * @return result of application of one of the mappers.
   */
  <R> R fold(Supplier<? extends R> emptyMapper, FN1<? extends R, ? super T> presentMapper);

  /**
   * Convert nullable value into instance of {@link Option}. This method converts {@code null} to
   * empty instance and any other value into present instance.
   *
   * @param value Value to convert.
   * @return created instance.
   */
  static <T> Option<T> option(T value) {
    return value == null ? Option.empty() : Option.present(value);
  }

  /**
   * Create instance of {@link Option} from {@link Optional}.
   *
   * @param optional input optional instance.
   * @return created instance.
   */
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  static <T> Option<T> from(Optional<T> optional) {
    return option(optional.orElse(null));
  }

  /**
   * Create empty instance.
   *
   * @return Created instance
   */
  @SuppressWarnings("unchecked")
  static <R> Option<R> empty() {
    return NONE;
  }

  /**
   * Create empty instance.
   *
   * @return Created instance
   */
  @SuppressWarnings("unchecked")
  static <R> Option<R> none() {
    return NONE;
  }

  /**
   * Create a present instance with the passed value.
   *
   * @param value Value to be stored in the created instance.
   * @return Created instance
   */
  static <R> Option<R> present(R value) {
    return new Some<>(value);
  }

  /**
   * Create a present instance with the passed value.
   *
   * @param value Value to be stored in the created instance.
   * @return Created instance
   */
  static <R> Option<R> some(R value) {
    return new Some<>(value);
  }

  final class Some<T> implements Option<T> {
    private final T value;

    private Some(T value) {
      this.value = value;
    }

    @Override
    public <R> R fold(
        Supplier<? extends R> emptyMapper, FN1<? extends R, ? super T> presentMapper) {
      return presentMapper.apply(value);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }

      return o instanceof Some<?> some && value.equals(some.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value);
    }

    @Override
    public String toString() {
      return "Some(" + value.toString() + ")";
    }
  }

  final class None<T> implements Option<T> {
    @Override
    public <R> R fold(
        Supplier<? extends R> emptyMapper, FN1<? extends R, ? super T> presentMapper) {
      return emptyMapper.get();
    }

    @Override
    public String toString() {
      return "None()";
    }
  }

  @SuppressWarnings({"rawtypes"})
  None NONE = new None();

  /**
   * This method allows "unwrapping" the value stored inside the Option instance. If value is
   * missing then {@link IllegalStateException} is thrown.
   *
   * <p>WARNING!!!<br>
   * This method should be avoided in the production code. It's main intended use case -
   * simplification of the tests. For this reason method is marked as {@link Deprecated}. This
   * generates warning at compile time.
   *
   * @return value stored inside present instance.
   * @deprecated to prevent unchecked use.
   */
  @Deprecated
  default T unwrap() {
    return fold(
        () -> {
          throw new IllegalStateException("Option is empty!!!");
        },
        Functions::id);
  }

  /**
   * Find first present option among ones passed as parameters.
   *
   * @return first present option or empty option if all input options are empty.
   */
  @SafeVarargs
  static <T> Option<T> any(Option<T>... ops) {
    for (var option : ops) {
      if (option.isPresent()) {
        return option;
      }
    }
    return empty();
  }

  /**
   * Find first present option among ones passed as parameters. Unlike {@link #any(Option[])}
   * method, only first parameter is evaluated eagerly, others are evaluated lazily and only if
   * previous evaluated instances were empty.
   *
   * @return first present option or empty option if all input options are empty.
   */
  @SafeVarargs
  static <T> Option<T> any(Option<T> op, Supplier<Option<T>>... ops) {
    return op.fold(
        () -> {
          for (var option : ops) {
            var result = option.get();
            if (result.isPresent()) {
              return result;
            }
          }
          return op;
        },
        unused -> op);
  }

  /**
   * Transform a number of Option values into Option instance containing list of values. Result is
   * empty Option if any values in the input is empty. Otherwise, result is a present option with
   * list of values which were stored inside input Option instances.
   *
   * @param values values to transform.
   * @return Empty option if input list contains empty Option instances. Otherwise, returns Option
   *     containing list of values.
   */
  @SafeVarargs
  @SuppressWarnings("varargs")
  static <T> Option<List<T>> allOf(Option<T>... values) {
    return allOf(List.of(values));
  }

  /**
   * Transform a list of Option values into Option instance containing list of values. Result is
   * empty Option if any values in the list is empty. Otherwise, result is a present option with
   * list of values which were stored inside input Option instances.
   *
   * @param values values to transform.
   * @return Empty option if input list contains empty Option instances. Otherwise, returns Option
   *     containing list of values.
   */
  static <T> Option<List<T>> allOf(List<Option<T>> values) {
    var result = new ArrayList<T>();
    for (var value : values) {
      if (value.isEmpty()) {
        return empty();
      }
      value.onPresent(result::add);
    }
    return present(result);
  }

  /**
   * Transform option into option of tuple with single value. The result is empty if input option is
   * empty. Otherwise, resulting instance contains tuple with input option value.
   *
   * @return {@link Mapper1} prepared for further transformation.
   */
  static <T1> Mapper1<T1> all(Option<T1> op1) {
    return () -> op1.flatMap(v1 -> option(Tuple.tuple(v1)));
  }

  /**
   * Transform options into option of tuple of two values. The result is empty if any input option
   * is empty. Otherwise, resulting instance contains tuple with values from input options.
   *
   * @return {@link Mapper2} prepared for further transformation.
   */
  static <T1, T2> Mapper2<T1, T2> all(Option<T1> op1, Option<T2> op2) {
    return () -> op1.flatMap(v1 -> op2.flatMap(v2 -> option(Tuple.tuple(v1, v2))));
  }

  /**
   * Transform options into option of tuple of three values. The result is empty if any input option
   * is empty. Otherwise, resulting instance contains tuple with values from input options.
   *
   * @return {@link Mapper3} prepared for further transformation.
   */
  static <T1, T2, T3> Mapper3<T1, T2, T3> all(Option<T1> op1, Option<T2> op2, Option<T3> op3) {
    return () ->
        op1.flatMap(v1 -> op2.flatMap(v2 -> op3.flatMap(v3 -> option(Tuple.tuple(v1, v2, v3)))));
  }

  /**
   * Transform options into option of tuple of four values. The result is empty if any input option
   * is empty. Otherwise, resulting instance contains tuple with values from input options.
   *
   * @return {@link Mapper4} prepared for further transformation.
   */
  static <T1, T2, T3, T4> Mapper4<T1, T2, T3, T4> all(
      Option<T1> op1, Option<T2> op2, Option<T3> op3, Option<T4> op4) {
    return () ->
        op1.flatMap(
            v1 ->
                op2.flatMap(
                    v2 ->
                        op3.flatMap(
                            v3 -> op4.flatMap(v4 -> Option.option(Tuple.tuple(v1, v2, v3, v4))))));
  }

  /**
   * Transform options into option of tuple of five values. The result is empty if any input option
   * is empty. Otherwise, resulting instance contains tuple with values from input options.
   *
   * @return {@link Mapper5} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5> Mapper5<T1, T2, T3, T4, T5> all(
      Option<T1> op1, Option<T2> op2, Option<T3> op3, Option<T4> op4, Option<T5> op5) {
    return () ->
        op1.flatMap(
            v1 ->
                op2.flatMap(
                    v2 ->
                        op3.flatMap(
                            v3 ->
                                op4.flatMap(
                                    v4 ->
                                        op5.flatMap(
                                            v5 -> option(Tuple.tuple(v1, v2, v3, v4, v5)))))));
  }

  /**
   * Transform options into option of tuple of six values. The result is empty if any input option
   * is empty. Otherwise, resulting instance contains tuple with values from input options.
   *
   * @return {@link Mapper6} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5, T6> Mapper6<T1, T2, T3, T4, T5, T6> all(
      Option<T1> op1,
      Option<T2> op2,
      Option<T3> op3,
      Option<T4> op4,
      Option<T5> op5,
      Option<T6> op6) {
    return () ->
        op1.flatMap(
            v1 ->
                op2.flatMap(
                    v2 ->
                        op3.flatMap(
                            v3 ->
                                op4.flatMap(
                                    v4 ->
                                        op5.flatMap(
                                            v5 ->
                                                op6.flatMap(
                                                    v6 ->
                                                        option(
                                                            Tuple.tuple(
                                                                v1, v2, v3, v4, v5, v6))))))));
  }

  /**
   * Transform options into option of tuple of seven values. The result is empty if any input option
   * is empty. Otherwise, resulting instance contains tuple with values from input options.
   *
   * @return {@link Mapper7} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5, T6, T7> Mapper7<T1, T2, T3, T4, T5, T6, T7> all(
      Option<T1> op1,
      Option<T2> op2,
      Option<T3> op3,
      Option<T4> op4,
      Option<T5> op5,
      Option<T6> op6,
      Option<T7> op7) {
    return () ->
        op1.flatMap(
            v1 ->
                op2.flatMap(
                    v2 ->
                        op3.flatMap(
                            v3 ->
                                op4.flatMap(
                                    v4 ->
                                        op5.flatMap(
                                            v5 ->
                                                op6.flatMap(
                                                    v6 ->
                                                        op7.flatMap(
                                                            v7 ->
                                                                option(
                                                                    Tuple.tuple(
                                                                        v1, v2, v3, v4, v5, v6,
                                                                        v7)))))))));
  }

  /**
   * Transform options into option of tuple of eight values. The result is empty if any input option
   * is empty. Otherwise, resulting instance contains tuple with values from input options.
   *
   * @return {@link Mapper8} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5, T6, T7, T8> Mapper8<T1, T2, T3, T4, T5, T6, T7, T8> all(
      Option<T1> op1,
      Option<T2> op2,
      Option<T3> op3,
      Option<T4> op4,
      Option<T5> op5,
      Option<T6> op6,
      Option<T7> op7,
      Option<T8> op8) {
    return () ->
        op1.flatMap(
            v1 ->
                op2.flatMap(
                    v2 ->
                        op3.flatMap(
                            v3 ->
                                op4.flatMap(
                                    v4 ->
                                        op5.flatMap(
                                            v5 ->
                                                op6.flatMap(
                                                    v6 ->
                                                        op7.flatMap(
                                                            v7 ->
                                                                op8.flatMap(
                                                                    v8 ->
                                                                        option(
                                                                            Tuple.tuple(
                                                                                v1, v2, v3, v4, v5,
                                                                                v6, v7,
                                                                                v8))))))))));
  }

  /**
   * Transform options into option of tuple of nine values. The result is empty if any input option
   * is empty. Otherwise, resulting instance contains tuple with values from input options.
   *
   * @return {@link Mapper9} prepared for further transformation.
   */
  static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Mapper9<T1, T2, T3, T4, T5, T6, T7, T8, T9> all(
      Option<T1> op1,
      Option<T2> op2,
      Option<T3> op3,
      Option<T4> op4,
      Option<T5> op5,
      Option<T6> op6,
      Option<T7> op7,
      Option<T8> op8,
      Option<T9> op9) {
    return () ->
        op1.flatMap(
            v1 ->
                op2.flatMap(
                    v2 ->
                        op3.flatMap(
                            v3 ->
                                op4.flatMap(
                                    v4 ->
                                        op5.flatMap(
                                            v5 ->
                                                op6.flatMap(
                                                    v6 ->
                                                        op7.flatMap(
                                                            v7 ->
                                                                op8.flatMap(
                                                                    v8 ->
                                                                        op9.flatMap(
                                                                            v9 ->
                                                                                option(
                                                                                    Tuple.tuple(
                                                                                        v1, v2, v3,
                                                                                        v4, v5, v6,
                                                                                        v7, v8,
                                                                                        v9)))))))))));
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple1} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper1<T1> {
    Option<Tuple.Tuple1<T1>> id();

    default <R> Option<R> map(FN1<R, T1> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN1<Option<R>, T1> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple2} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper2<T1, T2> {
    Option<Tuple.Tuple2<T1, T2>> id();

    default <R> Option<R> map(FN2<R, T1, T2> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN2<Option<R>, T1, T2> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple3} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper3<T1, T2, T3> {
    Option<Tuple.Tuple3<T1, T2, T3>> id();

    default <R> Option<R> map(FN3<R, T1, T2, T3> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN3<Option<R>, T1, T2, T3> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple4} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper4<T1, T2, T3, T4> {
    Option<Tuple.Tuple4<T1, T2, T3, T4>> id();

    default <R> Option<R> map(FN4<R, T1, T2, T3, T4> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN4<Option<R>, T1, T2, T3, T4> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple5} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper5<T1, T2, T3, T4, T5> {
    Option<Tuple.Tuple5<T1, T2, T3, T4, T5>> id();

    default <R> Option<R> map(FN5<R, T1, T2, T3, T4, T5> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN5<Option<R>, T1, T2, T3, T4, T5> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple6} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper6<T1, T2, T3, T4, T5, T6> {
    Option<Tuple.Tuple6<T1, T2, T3, T4, T5, T6>> id();

    default <R> Option<R> map(FN6<R, T1, T2, T3, T4, T5, T6> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN6<Option<R>, T1, T2, T3, T4, T5, T6> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple7} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper7<T1, T2, T3, T4, T5, T6, T7> {
    Option<Tuple.Tuple7<T1, T2, T3, T4, T5, T6, T7>> id();

    default <R> Option<R> map(FN7<R, T1, T2, T3, T4, T5, T6, T7> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN7<Option<R>, T1, T2, T3, T4, T5, T6, T7> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple8} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper8<T1, T2, T3, T4, T5, T6, T7, T8> {
    Option<Tuple.Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> id();

    default <R> Option<R> map(FN8<R, T1, T2, T3, T4, T5, T6, T7, T8> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN8<Option<R>, T1, T2, T3, T4, T5, T6, T7, T8> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }

  /**
   * Helper interface for convenient {@link Tuple.Tuple9} transformation. In case if you need to
   * return a tuple, it might be more convenient to return this interface instead. For example,
   * instead of this:
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
  @FunctionalInterface
  interface Mapper9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
    Option<Tuple.Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> id();

    default <R> Option<R> map(FN9<R, T1, T2, T3, T4, T5, T6, T7, T8, T9> mapper) {
      return id().map(tuple -> tuple.map(mapper));
    }

    default <R> Option<R> flatMap(FN9<Option<R>, T1, T2, T3, T4, T5, T6, T7, T8, T9> mapper) {
      return id().flatMap(tuple -> tuple.map(mapper));
    }
  }
}