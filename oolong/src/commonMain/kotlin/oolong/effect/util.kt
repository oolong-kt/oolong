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
fun <Msg> none(): Effect<Msg> = {}

/**
 * Compose [effects] into a single [Effect].
 */
fun <Msg> batch(vararg effects: Effect<Msg>): Effect<Msg> =
    batch(effects.asIterable())

/**
 * Compose [effects] into a single [Effect].
 */
fun <Msg> batch(effects: Iterable<Effect<Msg>>): Effect<Msg> =
    { dispatch -> for (effect in effects) launch { effect(dispatch) } }

/**
 * Map [effect] of type [A] to [Effect] of [B] using [f].
 */
fun <A, B> map(effect: Effect<A>, f: (A) -> B): Effect<B> =
    { dispatch -> effect { a -> dispatch(f(a)) } }

/**
 * Create a [Pair] of [Effect] and [Dispose].
 */
@Deprecated("To be removed in the next major release")
fun <Msg> disposableEffect(effect: Effect<Msg>): Pair<Effect<Msg>, Dispose> {
    val supervisor = SupervisorJob()
    val dispose = { supervisor.cancel() }
    return effect<Msg> { dispatch ->
        withContext(coroutineContext + supervisor) {
            effect(dispatch)
        }
    } to dispose
}
