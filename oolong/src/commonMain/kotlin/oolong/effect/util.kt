package oolong.effect

import oolong.Effect

/**
 * Create an empty effect.
 */
fun <Msg> none(): Effect<Msg> =
    batch(emptyList())

/**
 * Compose a list of effects into a single effect.
 *
 * @param effects a list of effects
 */
fun <Msg> batch(vararg effects: Effect<Msg>): Effect<Msg> =
    batch(effects.asIterable())

/**
 * Compose a list of effects into a single effect.
 *
 * @param effects a list of effects
 */
fun <Msg> batch(effects: Iterable<Effect<Msg>>): Effect<Msg> =
    { dispatch -> for (effect in effects) effect(dispatch) }

/**
 * Map from [Effect] of [A] to [Effect] of [B]
 */
fun <A, B> map(effect: Effect<A>, f: (A) -> B): Effect<B> =
    { dispatch -> effect { a -> dispatch(f(a)) } }
