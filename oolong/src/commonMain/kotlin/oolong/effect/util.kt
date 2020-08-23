package oolong.effect

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import oolong.Dispose
import oolong.Effect
import oolong.effect

/**
 * Create an empty [Effect].
 */
fun <Msg : Any> none(): Effect<Msg> = {}

/**
 * Compose [effects] into a single [Effect].
 */
fun <Msg : Any> batch(vararg effects: Effect<Msg>): Effect<Msg> =
    batch(effects.asIterable())

/**
 * Compose [effects] into a single [Effect].
 */
fun <Msg : Any> batch(effects: Iterable<Effect<Msg>>): Effect<Msg> =
    { dispatch -> for (effect in effects) launch { effect(dispatch) } }

/**
 * Map from [Effect] of [A] to [Effect] of [B]
 */
fun <A : Any, B : Any> map(effect: Effect<A>, f: (A) -> B): Effect<B> =
    { dispatch -> effect { a -> dispatch(f(a)) } }

/**
 * Create a [Pair] of [effect] and a [Dispose] which cancels [effect].
 */
fun <Msg : Any> disposableEffect(effect: Effect<Msg>): Pair<Effect<Msg>, Dispose> {
    val supervisor = SupervisorJob()
    val dispose = { supervisor.cancel() }
    return effect<Msg> { dispatch ->
        withContext(coroutineContext + supervisor) {
            effect(dispatch)
        }
    } to dispose
}
