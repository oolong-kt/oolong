package oolong.util

import oolong.Effect

/**
 * Create an empty effect
 */
fun <Msg> noEffect(): Effect<Msg> =
    batchEffects(emptyList())

/**
 * Compose a list of effects into a single effect
 *
 * @param effects a list of effects
 */
fun <Msg> batchEffects(vararg effects: Effect<Msg>): Effect<Msg> =
    batchEffects(effects.toList())

/**
 * Compose a list of effects into a single effect
 *
 * @param effects a list of effects
 */
fun <Msg> batchEffects(effects: Iterable<Effect<Msg>>): Effect<Msg> =
    Effect { dispatch -> for (effect in effects) effect(dispatch) }
