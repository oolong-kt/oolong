package oolong.effect

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import oolong.Dispose
import oolong.dispatch.Dispatch
import oolong.effect

// Typed

/**
 * Runs a side-effect away from the runtime
 */
typealias Effect<Msg> = suspend CoroutineScope.(dispatch: Dispatch<Msg>) -> Any?

// Builders

/**
 * [Effect] builder function.
 */
fun <Msg : Any> effect(block: Effect<Msg>): Effect<Msg> = block

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

// Transformers

/**
 * Transform [effect] of type [A] to an [Effect] of type [B] using [f].
 */
fun <A : Any, B : Any> map(effect: Effect<A>, f: (A) -> B): Effect<B> =
    { dispatch -> effect { a -> dispatch(f(a)) } }

/**
 * Create a [Pair] of [Effect] and [Dispose].
 */
@Deprecated("To be removed in the next minor release")
fun <Msg : Any> disposableEffect(effect: Effect<Msg>): Pair<Effect<Msg>, Dispose> {
    val supervisor = SupervisorJob()
    val dispose = { supervisor.cancel() }
    return effect<Msg> { dispatch ->
        withContext(coroutineContext + supervisor) {
            effect(dispatch)
        }
    } to dispose
}
