package oolong.delay

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import oolong.Effect

/**
 * Generate a [Msg] after a specified timeMillis.
 *
 * @param timeMillis time in milliseconds.
 * @param msg generator function of [Msg]
 * @return a delayed effect
 */
@Deprecated("To be removed in the next major release")
fun <Msg> delay(timeMillis: Long, msg: suspend CoroutineScope.() -> Msg): Effect<Msg> =
    { dispatch ->
        delay(timeMillis)
        dispatch(msg())
    }

/**
 * Generate [Msg]s at a specified timeMillis.
 *
 * @param timeMillis time in milliseconds.
 * @param msg generator function of [Msg]
 * @return a delayed effect
 */
@Deprecated("To be removed in the next major release")
fun <Msg> interval(timeMillis: Long, msg: suspend CoroutineScope.() -> Msg): Effect<Msg> =
    { dispatch ->
        while (isActive) {
            delay(timeMillis)
            if (isActive) {
                launch { dispatch(msg()) }
            }
        }
    }
