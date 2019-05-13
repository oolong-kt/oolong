package oolong.random

import kotlinx.coroutines.CoroutineScope
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
fun <Msg> nextBits(bitCount: Int, msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextBits(bitCount))) }

/**
 * Call [Random.nextBoolean] with a mapping of [Boolean] to [Msg].
 *
 * @param msg map function of [Boolean] to [Msg]
 * @return [Effect] of [Msg] for the generated [Boolean]
 */
fun <Msg> nextBoolean(msg: suspend CoroutineScope.(Boolean) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextBoolean())) }

/**
 * Call [Random.nextBytes] with a mapping of [ByteArray] to [Msg].
 *
 * @param msg map function of [ByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [ByteArray]
 */
fun <Msg> nextBytes(
    array: ByteArray,
    fromIndex: Int,
    toIndex: Int,
    msg: suspend CoroutineScope.(ByteArray) -> Msg
): Effect<Msg> = { dispatch -> dispatch(msg(Random.nextBytes(array, fromIndex, toIndex))) }

/**
 * Call [Random.nextBytes] with a mapping of [ByteArray] to [Msg].
 *
 * @param msg map function of [ByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [ByteArray]
 */
fun <Msg> nextBytes(array: ByteArray, msg: suspend CoroutineScope.(ByteArray) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextBytes(array))) }

/**
 * Call [Random.nextBytes] with a mapping of [ByteArray] to [Msg].
 *
 * @param msg map function of [ByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [ByteArray]
 */
fun <Msg> nextBytes(size: Int, msg: suspend CoroutineScope.(ByteArray) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextBytes(size))) }

/**
 * Call [Random.nextDouble] with a mapping of [Double] to [Msg].
 *
 * @param msg map function of [Double] to [Msg]
 * @return [Effect] of [Msg] for the generated [Double]
 */
fun <Msg> nextDouble(msg: suspend CoroutineScope.(Double) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextDouble())) }

/**
 * Call [Random.nextDouble] with a mapping of [Double] to [Msg].
 *
 * @param msg map function of [Double] to [Msg]
 * @return [Effect] of [Msg] for the generated [Double]
 */
fun <Msg> nextDouble(until: Double, msg: suspend CoroutineScope.(Double) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextDouble(until))) }

/**
 * Call [Random.nextDouble] with a mapping of [Double] to [Msg].
 *
 * @param msg map function of [Double] to [Msg]
 * @return [Effect] of [Msg] for the generated [Double]
 */
fun <Msg> nextDouble(from: Double, until: Double, msg: suspend CoroutineScope.(Double) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextDouble(from, until))) }

/**
 * Call [Random.nextFloat] with a mapping of [Float] to [Msg].
 *
 * @param msg map function of [Float] to [Msg]
 * @return [Effect] of [Msg] for the generated [Float]
 */
fun <Msg> nextFloat(msg: suspend CoroutineScope.(Float) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextFloat())) }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> nextInt(msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextInt())) }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> nextInt(until: Int, msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextInt(until))) }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> nextInt(from: Int, until: Int, msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextInt(from, until))) }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> nextInt(range: IntRange, msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextInt(range))) }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> nextLong(msg: suspend CoroutineScope.(Long) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextLong())) }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> nextLong(until: Long, msg: suspend CoroutineScope.(Long) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextLong(until))) }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> nextLong(from: Long, until: Long, msg: suspend CoroutineScope.(Long) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextLong(from, until))) }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> nextLong(range: LongRange, msg: suspend CoroutineScope.(Long) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextLong(range))) }

/**
 * Call [Random.nextUBytes] with a mapping of [UByteArray] to [Msg].
 *
 * @param msg map function of [UByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [UByteArray]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextUBytes(array: UByteArray, msg: suspend CoroutineScope.(UByteArray) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUBytes(array))) }

/**
 * Call [Random.nextUBytes] with a mapping of [UByteArray] to [Msg].
 *
 * @param msg map function of [UByteArray] to [Msg]
 * @return [Effect] of [Msg] for the generated [UByteArray]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextUBytes(size: Int, msg: suspend CoroutineScope.(UByteArray) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUBytes(size))) }

/**
 * Call [Random.nextUInt] with a mapping of [UInt] to [Msg].
 *
 * @param msg map function of [UInt] to [Msg]
 * @return [Effect] of [Msg] for the generated [UInt]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextUInt(msg: suspend CoroutineScope.(UInt) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUInt())) }

/**
 * Call [Random.nextUInt] with a mapping of [UInt] to [Msg].
 *
 * @param msg map function of [UInt] to [Msg]
 * @return [Effect] of [Msg] for the generated [UInt]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextUInt(until: UInt, msg: suspend CoroutineScope.(UInt) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUInt(until))) }

/**
 * Call [Random.nextUInt] with a mapping of [UInt] to [Msg].
 *
 * @param msg map function of [UInt] to [Msg]
 * @return [Effect] of [Msg] for the generated [UInt]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextUInt(from: UInt, until: UInt, msg: suspend CoroutineScope.(UInt) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUInt(from, until))) }

/**
 * Call [Random.nextUInt] with a mapping of [UInt] to [Msg].
 *
 * @param msg map function of [UInt] to [Msg]
 * @return [Effect] of [Msg] for the generated [UInt]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextUInt(range: UIntRange, msg: suspend CoroutineScope.(UInt) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUInt(range))) }

/**
 * Call [Random.nextULong] with a mapping of [ULong] to [Msg].
 *
 * @param msg map function of [ULong] to [Msg]
 * @return [Effect] of [Msg] for the generated [ULong]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextULong(msg: suspend CoroutineScope.(ULong) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextULong())) }

/**
 * Call [Random.nextULong] with a mapping of [ULong] to [Msg].
 *
 * @param msg map function of [ULong] to [Msg]
 * @return [Effect] of [Msg] for the generated [ULong]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextULong(until: ULong, msg: suspend CoroutineScope.(ULong) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextULong(until))) }

/**
 * Call [Random.nextULong] with a mapping of [ULong] to [Msg].
 *
 * @param msg map function of [ULong] to [Msg]
 * @return [Effect] of [Msg] for the generated [ULong]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextULong(from: ULong, until: ULong, msg: suspend CoroutineScope.(ULong) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextULong(from, until))) }

/**
 * Call [Random.nextULong] with a mapping of [ULong] to [Msg].
 *
 * @param msg map function of [ULong] to [Msg]
 * @return [Effect] of [Msg] for the generated [ULong]
 */
@ExperimentalUnsignedTypes
fun <Msg> nextULong(range: ULongRange, msg: suspend CoroutineScope.(ULong) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextULong(range))) }
