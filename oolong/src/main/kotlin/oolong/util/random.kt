package oolong.util

import oolong.Effect
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong
import kotlin.random.nextUBytes
import kotlin.random.nextUInt
import kotlin.random.nextULong

/**
 * Call [Random.nextBits] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> Random.nextBits(bitCount: Int, msg: (Int) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextBits(bitCount) }

/**
 * Call [Random.nextBoolean] with a mapping of [Boolean] to [Msg].
 *
 * @param msg map function of [Boolean] to [Msg]
 * @return [Effect] of [Msg] for the generated [Boolean]
 */
fun <Msg> Random.nextBoolean(msg: (Boolean) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextBoolean() }

/**
 * Call [Random.nextBytes] with a mapping of [ByteArray] to [Msg].
 *
 * @param msg map function of [ByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [ByteArray]
 */
fun <Msg> Random.nextBytes(
    array: ByteArray,
    fromIndex: Int,
    toIndex: Int,
    msg: (ByteArray) -> Msg
): Effect<Msg> =
    effect(msg) { Random.nextBytes(array, fromIndex, toIndex) }

/**
 * Call [Random.nextBytes] with a mapping of [ByteArray] to [Msg].
 *
 * @param msg map function of [ByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [ByteArray]
 */
fun <Msg> Random.nextBytes(array: ByteArray, msg: (ByteArray) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextBytes(array) }

/**
 * Call [Random.nextBytes] with a mapping of [ByteArray] to [Msg].
 *
 * @param msg map function of [ByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [ByteArray]
 */
fun <Msg> Random.nextBytes(size: Int, msg: (ByteArray) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextBytes(size) }

/**
 * Call [Random.nextDouble] with a mapping of [Double] to [Msg].
 *
 * @param msg map function of [Double] to [Msg]
 * @return [Effect] of [Msg] for the generated [Double]
 */
fun <Msg> Random.nextDouble(msg: (Double) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextDouble() }

/**
 * Call [Random.nextDouble] with a mapping of [Double] to [Msg].
 *
 * @param msg map function of [Double] to [Msg]
 * @return [Effect] of [Msg] for the generated [Double]
 */
fun <Msg> Random.nextDouble(until: Double, msg: (Double) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextDouble(until) }

/**
 * Call [Random.nextDouble] with a mapping of [Double] to [Msg].
 *
 * @param msg map function of [Double] to [Msg]
 * @return [Effect] of [Msg] for the generated [Double]
 */
fun <Msg> Random.nextDouble(from: Double, until: Double, msg: (Double) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextDouble(from, until) }

/**
 * Call [Random.nextFloat] with a mapping of [Float] to [Msg].
 *
 * @param msg map function of [Float] to [Msg]
 * @return [Effect] of [Msg] for the generated [Float]
 */
fun <Msg> Random.nextFloat(msg: (Float) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextFloat() }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> Random.nextInt(msg: (Int) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextInt() }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> Random.nextInt(until: Int, msg: (Int) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextInt(until) }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> Random.nextInt(from: Int, until: Int, msg: (Int) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextInt(from, until) }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> Random.nextInt(range: IntRange, msg: (Int) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextInt(range) }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> Random.nextLong(msg: (Long) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextLong() }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> Random.nextLong(until: Long, msg: (Long) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextLong(until) }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> Random.nextLong(from: Long, until: Long, msg: (Long) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextLong(from, until) }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> Random.nextLong(range: LongRange, msg: (Long) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextLong(range) }

/**
 * Call [Random.nextUBytes] with a mapping of [UByteArray] to [Msg].
 *
 * @param msg map function of [UByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [UByteArray]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextUBytes(array: UByteArray, msg: (UByteArray) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextUBytes(array) }

/**
 * Call [Random.nextUBytes] with a mapping of [UByteArray] to [Msg].
 *
 * @param msg map function of [UByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [UByteArray]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextUBytes(size: Int, msg: (UByteArray) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextUBytes(size) }

/**
 * Call [Random.nextUInt] with a mapping of [UInt] to [Msg].
 *
 * @param msg map function of [UInt] to [Msg]
 * @return [Effect] of [Msg] for the generated [UInt]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextUInt(msg: (UInt) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextUInt() }

/**
 * Call [Random.nextUInt] with a mapping of [UInt] to [Msg].
 *
 * @param msg map function of [UInt] to [Msg]
 * @return [Effect] of [Msg] for the generated [UInt]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextUInt(until: UInt, msg: (UInt) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextUInt(until) }

/**
 * Call [Random.nextUInt] with a mapping of [UInt] to [Msg].
 *
 * @param msg map function of [UInt] to [Msg]
 * @return [Effect] of [Msg] for the generated [UInt]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextUInt(from: UInt, until: UInt, msg: (UInt) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextUInt(from, until) }

/**
 * Call [Random.nextUInt] with a mapping of [UInt] to [Msg].
 *
 * @param msg map function of [UInt] to [Msg]
 * @return [Effect] of [Msg] for the generated [UInt]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextUInt(range: UIntRange, msg: (UInt) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextUInt(range) }

/**
 * Call [Random.nextULong] with a mapping of [ULong] to [Msg].
 *
 * @param msg map function of [ULong] to [Msg]
 * @return [Effect] of [Msg] for the generated [ULong]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextULong(msg: (ULong) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextULong() }

/**
 * Call [Random.nextULong] with a mapping of [ULong] to [Msg].
 *
 * @param msg map function of [ULong] to [Msg]
 * @return [Effect] of [Msg] for the generated [ULong]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextULong(until: ULong, msg: (ULong) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextULong(until) }

/**
 * Call [Random.nextULong] with a mapping of [ULong] to [Msg].
 *
 * @param msg map function of [ULong] to [Msg]
 * @return [Effect] of [Msg] for the generated [ULong]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextULong(from: ULong, until: ULong, msg: (ULong) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextULong(from, until) }

/**
 * Call [Random.nextULong] with a mapping of [ULong] to [Msg].
 *
 * @param msg map function of [ULong] to [Msg]
 * @return [Effect] of [Msg] for the generated [ULong]
 */
@ExperimentalUnsignedTypes
fun <Msg> Random.nextULong(range: ULongRange, msg: (ULong) -> Msg): Effect<Msg> =
    effect(msg) { Random.nextULong(range) }

private inline fun <T, Msg> effect(
    crossinline msg: (T) -> Msg,
    crossinline block: () -> T
): Effect<Msg> = Effect { dispatch -> dispatch(msg(block())) }
