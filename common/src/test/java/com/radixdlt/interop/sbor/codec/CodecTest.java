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

package com.radixdlt.interop.sbor.codec;

import static com.radixdlt.lang.Either.left;
import static com.radixdlt.lang.Either.right;
import static com.radixdlt.lang.Option.none;
import static com.radixdlt.lang.Option.some;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.radixdlt.interop.sbor.codec.dto.SimpleRecord;
import com.radixdlt.lang.Unit;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class CodecTest {
  @Test
  public void unitCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encode(Unit.unit()).unwrap();

    assertEquals(1, r0.length);
    assertEquals(0, r0[0]); // Type == 0x00 - Unit

    var r1 = codec.decode(r0, Unit.class).unwrap();

    assertEquals(Unit.unit(), r1);
  }

  @Test
  public void booleanCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encode(true).unwrap();

    assertEquals(2, r0.length);
    assertEquals(1, r0[0]); // Type == 0x01 - Boolean
    assertEquals(1, r0[1]); // Value = 1 == true

    var r1 = codec.decode(r0, boolean.class).unwrap();

    assertTrue(r1);
  }

  @Test
  public void byteCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encode((byte) 0x5A).unwrap();

    assertEquals(2, r0.length);
    assertEquals(7, r0[0]); // Type == 0x07 - u8
    assertEquals(0x5A, r0[1]); // Value == 0x5A

    var r1 = codec.decode(r0, byte.class).unwrap();

    assertEquals((byte) 0x5A, (byte) r1);
  }

  @Test
  public void shortCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encode((short) 0x1234).unwrap();

    assertEquals(3, r0.length);
    assertEquals(3, r0[0]); // Type == 0x03 - i16
    assertEquals(0x34, r0[1]); // Value
    assertEquals(0x12, r0[2]); // Value

    var r1 = codec.decode(r0, short.class).unwrap();

    assertEquals((short) 0x1234, (short) r1);
  }

  @Test
  public void intCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encode(0x12345678).unwrap();

    assertEquals(5, r0.length);
    assertEquals(4, r0[0]); // Type == 0x04 - i32
    assertEquals(0x78, r0[1]); // Value
    assertEquals(0x56, r0[2]); // Value
    assertEquals(0x34, r0[3]); // Value
    assertEquals(0x12, r0[4]); // Value

    var r1 = codec.decode(r0, int.class).unwrap();

    assertEquals(0x12345678, (int) r1);
  }

  @Test
  public void longCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encode(0x0123_4567_89AB_CDEFL).unwrap();

    assertEquals(9, r0.length);
    assertEquals(5, r0[0]); // Type == 0x05 - i64
    assertEquals(0xEF, r0[1] & 0xFF); // Value
    assertEquals(0xCD, r0[2] & 0xFF); // Value
    assertEquals(0xAB, r0[3] & 0xFF); // Value
    assertEquals(0x89, r0[4] & 0xFF); // Value
    assertEquals(0x67, r0[5]); // Value
    assertEquals(0x45, r0[6]); // Value
    assertEquals(0x23, r0[7]); // Value
    assertEquals(0x01, r0[8]); // Value

    var r1 = codec.decode(r0, long.class).unwrap();

    assertEquals(0x0123_4567_89AB_CDEFL, (long) r1);
  }

  @Test
  public void stringCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encode("Test string").unwrap();

    assertEquals(16, r0.length);
    assertEquals(0x0C, r0[0]); // Type == 0x0C - String
    assertEquals(11, r0[1]); // String length 0
    assertEquals(0, r0[2]); // String length 1
    assertEquals(0, r0[3]); // String length 2
    assertEquals(0, r0[4]); // String length 3
    assertEquals('T', r0[5]);
    assertEquals('e', r0[6]);
    assertEquals('s', r0[7]);
    assertEquals('t', r0[8]);
    assertEquals(' ', r0[9]);
    assertEquals('s', r0[10]);
    assertEquals('t', r0[11]);
    assertEquals('r', r0[12]);
    assertEquals('i', r0[13]);
    assertEquals('n', r0[14]);
    assertEquals('g', r0[15]);

    var r1 = codec.decode(r0, String.class).unwrap();

    assertEquals("Test string", r1);
  }

  @Test
  public void byteArrayCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());
    var testVector = new byte[] {0x01, 0x02, 0x03, 0x04, 0x05};

    var r0 = codec.encode(testVector).unwrap();

    assertEquals(11, r0.length);
    assertEquals(0x30, r0[0]); // Type == 0x30 - Vector
    assertEquals(0x07, r0[1]); // Type == 0x07 - u8
    assertEquals(5, r0[2]); // Array length 0
    assertEquals(0, r0[3]); // Array length 1
    assertEquals(0, r0[4]); // Array length 2
    assertEquals(0, r0[5]); // Array length 3
    assertEquals(0x01, r0[6]);
    assertEquals(0x02, r0[7]);
    assertEquals(0x03, r0[8]);
    assertEquals(0x04, r0[9]);
    assertEquals(0x05, r0[10]);

    var r1 = codec.decode(r0, byte[].class).unwrap();

    assertArrayEquals(testVector, r1);
  }

  @Test
  public void shortArrayCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());
    var testVector = new short[] {0x0102, 0x0304};

    var r0 = codec.encode(testVector).unwrap();

    assertEquals(10, r0.length);
    assertEquals(0x30, r0[0]); // Type == 0x30 - Vector
    assertEquals(0x03, r0[1]); // Type == 0x03 - i16
    assertEquals(2, r0[2]); // Array length 0
    assertEquals(0, r0[3]); // Array length 1
    assertEquals(0, r0[4]); // Array length 2
    assertEquals(0, r0[5]); // Array length 3
    assertEquals(0x02, r0[6]);
    assertEquals(0x01, r0[7]);
    assertEquals(0x04, r0[8]);
    assertEquals(0x03, r0[9]);

    var r1 = codec.decode(r0, short[].class).unwrap();

    assertArrayEquals(testVector, r1);
  }

  @Test
  public void intArrayCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());
    var testVector = new int[] {0x01020304, 0x05060708, 0x090A0B0C};

    var r0 = codec.encode(testVector).unwrap();

    assertEquals(18, r0.length);
    assertEquals(0x30, r0[0]); // Type == 0x30 - Vector
    assertEquals(0x04, r0[1]); // Type == 0x04 - i32
    assertEquals(3, r0[2]); // Array length 0
    assertEquals(0, r0[3]); // Array length 1
    assertEquals(0, r0[4]); // Array length 2
    assertEquals(0, r0[5]); // Array length 3
    assertEquals(0x04, r0[6]);
    assertEquals(0x03, r0[7]);
    assertEquals(0x02, r0[8]);
    assertEquals(0x01, r0[9]);
    assertEquals(0x08, r0[10]);
    assertEquals(0x07, r0[11]);
    assertEquals(0x06, r0[12]);
    assertEquals(0x05, r0[13]);
    assertEquals(0x0C, r0[14]);
    assertEquals(0x0B, r0[15]);
    assertEquals(0x0A, r0[16]);
    assertEquals(0x09, r0[17]);

    var r1 = codec.decode(r0, int[].class).unwrap();

    assertArrayEquals(testVector, r1);
  }

  @Test
  public void longArrayCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());
    var testVector = new long[] {0x0102030405060708L, 0x090A0B0C11121314L};

    var r0 = codec.encode(testVector).unwrap();

    assertEquals(22, r0.length);
    assertEquals(0x30, r0[0]); // Type == 0x30 - Vector
    assertEquals(0x05, r0[1]); // Type == 0x05 - i64
    assertEquals(2, r0[2]); // Array length 0
    assertEquals(0, r0[3]); // Array length 1
    assertEquals(0, r0[4]); // Array length 2
    assertEquals(0, r0[5]); // Array length 3
    assertEquals(0x08, r0[6]);
    assertEquals(0x07, r0[7]);
    assertEquals(0x06, r0[8]);
    assertEquals(0x05, r0[9]);
    assertEquals(0x04, r0[10]);
    assertEquals(0x03, r0[11]);
    assertEquals(0x02, r0[12]);
    assertEquals(0x01, r0[13]);
    assertEquals(0x14, r0[14]);
    assertEquals(0x13, r0[15]);
    assertEquals(0x12, r0[16]);
    assertEquals(0x11, r0[17]);
    assertEquals(0x0C, r0[18]);
    assertEquals(0x0B, r0[19]);
    assertEquals(0x0A, r0[20]);
    assertEquals(0x09, r0[21]);

    var r1 = codec.decode(r0, long[].class).unwrap();

    assertArrayEquals(testVector, r1);
  }

  @Test
  public void someOptionCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encodeOption(some("Test value")).unwrap();

    assertEquals(17, r0.length);
    assertEquals(0x20, r0[0]); // Type == 0x20 - Option
    assertEquals(0x01, r0[1]); // Value - present
    assertEquals(0x0C, r0[2]); // Stored type - 0x0C - String

    var r1 = codec.decodeOption(r0, String.class).unwrap();

    assertEquals(some("Test value"), r1);
  }

  @Test
  public void noneOptionCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encodeOption(none()).unwrap();

    assertEquals(2, r0.length);
    assertEquals(0x20, r0[0]); // Type == 0x20 - Option
    assertEquals(0x00, r0[1]); // Value - missing

    var r1 = codec.decodeOption(r0, String.class).unwrap();

    assertEquals(none(), r1);
  }

  @Test
  public void leftEitherCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encodeEither(left("Some value")).unwrap();

    assertEquals(17, r0.length);
    assertEquals(0x24, r0[0]); // Type == 0x24 - Either
    assertEquals(0x01, r0[1]); // Value - left
    assertEquals(0x0C, r0[2]); // Value type - String

    var r1 = codec.decodeEither(r0, String.class, Long.class).unwrap();

    assertEquals(left("Some value"), r1);
  }

  @Test
  public void rightEitherCanBeEncodedAndDecoded() {
    var codec = new Codec(new CodecMap());

    var r0 = codec.encodeEither(right(123L)).unwrap();

    assertEquals(11, r0.length);
    assertEquals(0x24, r0[0]); // Type == 0x24 - Either
    assertEquals(0x00, r0[1]); // Value - right
    assertEquals(0x05, r0[2]); // Value type - i64

    var r1 = codec.decodeEither(r0, String.class, Long.class).unwrap();

    assertEquals(right(123L), r1);
  }

  @Test
  public void objectTreeCanBeEncodedAndDecoded() {
    var codec =
        new Codec(
            new CodecMap().register(SimpleRecord.class, new SimpleRecord.SimpleRecordCodec()));

    var testValue = new SimpleRecord(1234567, "Some string", left(4567L), some(false));

    var r0 = codec.encode(testValue).unwrap();

    assertEquals(41, r0.length);
    assertEquals(0x10, r0[0]); // Type == 0x10 - Struct
    assertEquals(0x04, r0[1]); // Field count - 4
    assertEquals(0x00, r0[2]); //
    assertEquals(0x00, r0[3]); //
    assertEquals(0x00, r0[4]); //

    var r1 = codec.decode(r0, SimpleRecord.class).unwrap();

    assertEquals(testValue, r1);
  }
}