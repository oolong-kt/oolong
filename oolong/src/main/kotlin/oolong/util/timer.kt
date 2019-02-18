package oolong.util

import oolong.Effect
import java.util.Date
import java.util.TimerTask
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timer

/**
 * Call [timer] with a generator function of [Msg].
 *
 * @param msg generator function of [Msg]
 * @return [Effect] of [Msg]
 */
fun <Msg> timer(
    name: String? = null,
    daemon: Boolean = false,
    initialDelay: Long = 0.toLong(),
    period: Long,
    msg: () -> Msg
): Effect<Msg> =
    effect(msg) { action -> timer(name, daemon, initialDelay, period, action) }

/**
 * Call [timer] with a generator function of [Msg].
 *
 * @param msg generator function of [Msg]
 * @return [Effect] of [Msg]
 */
fun <Msg> timer(
    name: String? = null,
    daemon: Boolean = false,
    startAt: Date,
    period: Long,
    msg: () -> Msg
): Effect<Msg> =
    effect(msg) { action -> timer(name, daemon, startAt, period, action) }

/**
 * Call [fixedRateTimer] with a generator function of [Msg].
 *
 * @param msg generator function of [Msg]
 * @return [Effect] of [Msg]
 */
fun <Msg> fixedRateTimer(
    name: String? = null,
    daemon: Boolean = false,
    initialDelay: Long = 0.toLong(),
    period: Long,
    msg: () -> Msg
): Effect<Msg> =
    effect(msg) { action -> fixedRateTimer(name, daemon, initialDelay, period, action) }

/**
 * Call [fixedRateTimer] with a generator function of [Msg].
 *
 * @param msg generator function of [Msg]
 * @return [Effect] of [Msg]
 */
fun <Msg> fixedRateTimer(
    name: String? = null,
    daemon: Boolean = false,
    startAt: Date,
    period: Long,
    msg: () -> Msg
): Effect<Msg> =
    effect(msg) { action -> fixedRateTimer(name, daemon, startAt, period, action) }

private inline fun <Msg> effect(
    crossinline msg: () -> Msg,
    crossinline block: (TimerTask.() -> Unit) -> Unit
): Effect<Msg> =
    Effect { dispatch -> block { dispatch(msg()) } }