package oolong.delay

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import oolong.Dispatch
import oolong.Dispose
import oolong.Effect
import oolong.effect

/**
 * Generate a [Msg] after a specified delay.
 *
 * @param delay the delay length before the effect is invoked
 * @param scope the [CoroutineScope] in which to run the effect
 * @param msg generator function of [Msg]
 * @return A pair of effect and dispose
 */
fun <Msg> timeout(delay: Long, scope: CoroutineScope = GlobalScope, msg: () -> Msg): Pair<Effect<Msg>, Dispose> {
    return delayed(delay, scope) { dispatch ->
        dispatch(msg())
        cancel()
    }
}

/**
 * Generate [Msg]s at a specified delay.
 *
 * @param delay the delay length before the effect is invoked
 * @param scope the [CoroutineScope] in which to run the effect
 * @param msg generator function of [Msg]
 * @return A pair of effect and dispose
 */
fun <Msg> interval(delay: Long, scope: CoroutineScope = GlobalScope, msg: () -> Msg): Pair<Effect<Msg>, Dispose> {
    return delayed(delay, scope) { dispatch ->
        dispatch(msg())
    }
}

private inline fun <Msg> delayed(
    delay: Long,
    scope: CoroutineScope = GlobalScope,
    crossinline block: Job.(Dispatch<Msg>) -> Unit
): Pair<Effect<Msg>, Dispose> {
    val supervisor = SupervisorJob()
    return effect { dispatch: Dispatch<Msg> ->
        with(scope + supervisor) {
            launch {
                while (supervisor.isActive) {
                    delay(delay)
                    with(supervisor) {
                        if (isActive) {
                            launch { block(dispatch) }
                        }
                    }
                }
            }
        }
        Unit
    } to { supervisor.cancel() }
}
