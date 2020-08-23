package oolong.delay

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import oolong.Effect

/**
 * Generate an [Effect] of [Msg] using [msg] after a specified [timeMillis] delay.
 */
fun <Msg : Any> delay(timeMillis: Long, msg: suspend CoroutineScope.() -> Msg): Effect<Msg> =
    { dispatch ->
        delay(timeMillis)
        dispatch(msg())
    }

/**
 * Generate an [Effect] of [Msg]s using [msg] at a specified [timeMillis] interval.
 */
fun <Msg : Any> interval(timeMillis: Long, msg: suspend CoroutineScope.() -> Msg): Effect<Msg> =
    { dispatch ->
        while (isActive) {
            delay(timeMillis)
            if (isActive) {
                launch { dispatch(msg()) }
            }
        }
    }
