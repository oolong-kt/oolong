package oolong.util

import oolong.platform.Effect
import java.util.Random

/**
 * Call [Random.nextBoolean] with a mapping of [Boolean] to [Msg].
 *
 * @param msg map function of [Boolean] to [Msg]
 * @return [Effect] of [Msg] for the generated [Boolean]
 */
fun <Msg> Random.nextBoolean(msg: (Boolean) -> Msg) =
    Effect<Msg> { dispatch ->
        dispatch(msg(nextBoolean()))
    }

/**
 * Call [Random.nextDouble] with a mapping of [Double] to [Msg].
 *
 * @param msg map function of [Double] to [Msg]
 * @return [Effect] of [Msg] for the generated [Double]
 */
fun <Msg> Random.nextDouble(msg: (Double) -> Msg) =
    Effect<Msg> { dispatch ->
        dispatch(msg(nextDouble()))
    }

/**
 * Call [Random.nextFloat] with a mapping of [Float] to [Msg].
 *
 * @param msg map function of [Float] to [Msg]
 * @return [Effect] of [Msg] for the generated [Float]
 */
fun <Msg> Random.nextFloat(msg: (Float) -> Msg) =
    Effect<Msg> { dispatch ->
        dispatch(msg(nextFloat()))
    }

/**
 * Call [Random.nextGaussianDouble] with a mapping of [Double] to [Msg].
 *
 * @param msg map function of [Double] to [Msg]
 * @return [Effect] of [Msg] for the generated [Double]
 */
fun <Msg> Random.nextGaussian(msg: (Double) -> Msg) =
    Effect<Msg> { dispatch ->
        dispatch(msg(nextGaussian()))
    }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> Random.nextInt(bound: Int, msg: (Int) -> Msg) =
    Effect<Msg> { dispatch ->
        dispatch(msg(nextInt(bound)))
    }

/**
 * Call [Random.nextInt] with a mapping of [Int] to [Msg].
 *
 * @param msg map function of [Int] to [Msg]
 * @return [Effect] of [Msg] for the generated [Int]
 */
fun <Msg> Random.nextInt(msg: (Int) -> Msg) =
    Effect<Msg> { dispatch ->
        dispatch(msg(nextInt()))
    }

/**
 * Call [Random.nextLong] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Effect] of [Msg] for the generated [Long]
 */
fun <Msg> Random.nextLong(msg: (Long) -> Msg) =
    Effect<Msg> { dispatch ->
        dispatch(msg(nextLong()))
    }
