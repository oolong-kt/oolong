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
 * Create [Effect] of [Random.nextBits] with a mapping of [Int] to [Msg] using [Msg] using [msg].
 */
fun <Msg : Any> nextBits(bitCount: Int, msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextBits(bitCount))) }

/**
 * Create [Effect] of [Random.nextBoolean] with a mapping of [Boolean] to [Msg] using [msg].
 */
fun <Msg : Any> nextBoolean(msg: suspend CoroutineScope.(Boolean) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextBoolean())) }

/**
 * Create [Effect] of [Random.nextBytes] with a mapping of [ByteArray] to [Msg] using [msg]
 */
fun <Msg : Any> nextBytes(
    array: ByteArray,
    fromIndex: Int,
    toIndex: Int,
    msg: suspend CoroutineScope.(ByteArray) -> Msg
): Effect<Msg> = { dispatch -> dispatch(msg(Random.nextBytes(array, fromIndex, toIndex))) }

/**
 * Create [Effect] of [Random.nextBytes] with a mapping of [ByteArray] to [Msg] using [msg].
 */
fun <Msg : Any> nextBytes(array: ByteArray, msg: suspend CoroutineScope.(ByteArray) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextBytes(array))) }

/**
 * Create [Effect] of [Random.nextBytes] with a mapping of [ByteArray] to [Msg] using [msg].
 */
fun <Msg : Any> nextBytes(size: Int, msg: suspend CoroutineScope.(ByteArray) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextBytes(size))) }

/**
 * Create [Effect] of [Random.nextDouble] with a mapping of [Double] to [Msg] using [msg].
 */
fun <Msg : Any> nextDouble(msg: suspend CoroutineScope.(Double) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextDouble())) }

/**
 * Create [Effect] of [Random.nextDouble] with a mapping of [Double] to [Msg] using [msg].
 */
fun <Msg : Any> nextDouble(until: Double, msg: suspend CoroutineScope.(Double) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextDouble(until))) }

/**
 * Create [Effect] of [Random.nextDouble] with a mapping of [Double] to [Msg] using [msg].
 */
fun <Msg : Any> nextDouble(from: Double, until: Double, msg: suspend CoroutineScope.(Double) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextDouble(from, until))) }

/**
 * Create [Effect] of [Random.nextFloat] with a mapping of [Float] to [Msg] using [msg].
 */
fun <Msg : Any> nextFloat(msg: suspend CoroutineScope.(Float) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextFloat())) }

/**
 * Create [Effect] of [Random.nextInt] with a mapping of [Int] to [Msg] using [msg].
 */
fun <Msg : Any> nextInt(msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextInt())) }

/**
 * Create [Effect] of [Random.nextInt] with a mapping of [Int] to [Msg] using [msg].
 */
fun <Msg : Any> nextInt(until: Int, msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextInt(until))) }

/**
 * Create [Effect] of [Random.nextInt] with a mapping of [Int] to [Msg] using [msg].
 */
fun <Msg : Any> nextInt(from: Int, until: Int, msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextInt(from, until))) }

/**
 * Create [Effect] of [Random.nextInt] with a mapping of [Int] to [Msg] using [msg].
 */
fun <Msg : Any> nextInt(range: IntRange, msg: suspend CoroutineScope.(Int) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextInt(range))) }

/**
 * Create [Effect] of [Random.nextLong] with a mapping of [Long] to [Msg] using [msg].
 */
fun <Msg : Any> nextLong(msg: suspend CoroutineScope.(Long) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextLong())) }

/**
 * Create [Effect] of [Random.nextLong] with a mapping of [Long] to [Msg] using [msg].
 */
fun <Msg : Any> nextLong(until: Long, msg: suspend CoroutineScope.(Long) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextLong(until))) }

/**
 * Create [Effect] of [Random.nextLong] with a mapping of [Long] to [Msg] using [msg].
 */
fun <Msg : Any> nextLong(from: Long, until: Long, msg: suspend CoroutineScope.(Long) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextLong(from, until))) }

/**
 * Create [Effect] of [Random.nextLong] with a mapping of [Long] to [Msg] using [msg].
 */
fun <Msg : Any> nextLong(range: LongRange, msg: suspend CoroutineScope.(Long) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextLong(range))) }

/**
 * Create [Effect] of [Random.nextUBytes] with a mapping of [UByteArray] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextUBytes(array: UByteArray, msg: suspend CoroutineScope.(UByteArray) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUBytes(array))) }

/**
 * Create [Effect] of [Random.nextUBytes] with a mapping of [UByteArray] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextUBytes(size: Int, msg: suspend CoroutineScope.(UByteArray) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUBytes(size))) }

/**
 * Create [Effect] of [Random.nextUInt] with a mapping of [UInt] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextUInt(msg: suspend CoroutineScope.(UInt) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUInt())) }

/**
 * Create [Effect] of [Random.nextUInt] with a mapping of [UInt] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextUInt(until: UInt, msg: suspend CoroutineScope.(UInt) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUInt(until))) }

/**
 * Create [Effect] of [Random.nextUInt] with a mapping of [UInt] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextUInt(from: UInt, until: UInt, msg: suspend CoroutineScope.(UInt) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUInt(from, until))) }

/**
 * Create [Effect] of [Random.nextUInt] with a mapping of [UInt] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextUInt(range: UIntRange, msg: suspend CoroutineScope.(UInt) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextUInt(range))) }

/**
 * Create [Effect] of [Random.nextULong] with a mapping of [ULong] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextULong(msg: suspend CoroutineScope.(ULong) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextULong())) }

/**
 * Create [Effect] of [Random.nextULong] with a mapping of [ULong] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextULong(until: ULong, msg: suspend CoroutineScope.(ULong) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextULong(until))) }

/**
 * Create [Effect] of [Random.nextULong] with a mapping of [ULong] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextULong(from: ULong, until: ULong, msg: suspend CoroutineScope.(ULong) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextULong(from, until))) }

/**
 * Create [Effect] of [Random.nextULong] with a mapping of [ULong] to [Msg] using [msg].
 */
@ExperimentalUnsignedTypes
fun <Msg : Any> nextULong(range: ULongRange, msg: suspend CoroutineScope.(ULong) -> Msg): Effect<Msg> =
    { dispatch -> dispatch(msg(Random.nextULong(range))) }
