package oolong.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import oolong.Dispatch
import oolong.Effect

fun <Msg> timeout(period: Long, scope: CoroutineScope = GlobalScope, msg: () -> Msg): Effect<Msg> {
    return Effect { dispatch: Dispatch<Msg> ->
        scope.launch {
            delay(period)
            dispatch(msg())
        }
    }
}

fun <Msg> interval(
    period: Long,
    initialDelay: Long = 0L,
    scope: CoroutineScope = GlobalScope,
    msg: () -> Msg
): Effect<Msg> {
    return Effect { dispatch: Dispatch<Msg> ->
        scope.launch {
            delay(initialDelay)
            while (isActive) {
                delay(period)
                dispatch(msg())
            }
        }
    }
}
