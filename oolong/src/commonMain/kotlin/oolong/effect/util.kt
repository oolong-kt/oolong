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
 * Compose a collection of [Effect] into a single [Effect].
 *
 * @param effects a list of effects
 */
fun <Msg : Any> batch(vararg effects: Effect<Msg>): Effect<Msg> =
    batch(effects.asIterable())

/**
 * Compose a collection of [Effect] into a single [Effect].
 *
 * @param effects a list of effects
 */
fun <Msg : Any> batch(effects: Iterable<Effect<Msg>>): Effect<Msg> =
    { dispatch -> for (effect in effects) launch { effect(dispatch) } }

/**
 * Compose two [Effect]s into a single [Effect].
 *
 * @param effect an effect to add
 */
operator fun <Msg : Any> Effect<Msg>.plus(effect: Effect<Msg>): Effect<Msg> =
    batch(this, effect)

/**
 * Map from [Effect] of [A] to [Effect] of [B]
 */
fun <A : Any, B : Any> map(effect: Effect<A>, f: (A) -> B): Effect<B> =
    { dispatch -> effect { a -> dispatch(f(a)) } }

fun <A : Any, B : Any> Effect<A>.map(f: (A) -> B): Effect<B> =
    map(this, f)

/**
 * Create a [Pair] of [Effect] and [Dispose].
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

fun <Msg : Any> Effect<Msg>.disposableEffect(): Pair<Effect<Msg>, Dispose> =
    disposableEffect(this)
