package oolong.util.effect

import oolong.Effect
import oolong.Init
import oolong.Update

/**
 * Create an empty effect.
 */
fun <Msg> noEffect(): Effect<Msg> =
    batchEffects(emptyList())

/**
 * Compose a list of effects into a single effect.
 *
 * @param effects a list of effects
 */
fun <Msg> batchEffects(vararg effects: Effect<Msg>): Effect<Msg> =
    batchEffects(effects.asIterable())

/**
 * Compose a list of effects into a single effect.
 *
 * @param effects a list of effects
 */
fun <Msg> batchEffects(effects: Iterable<Effect<Msg>>): Effect<Msg> =
    { dispatch -> for (effect in effects) effect(dispatch) }

/**
 * Create an [Init] function with no effects.
 */
fun <Model, Msg> withoutEffects(init: () -> Model): Init<Model, Msg> =
    { init() to noEffect() }

/**
 * Create an [Update] function with no effects.
 */
fun <Model, Msg> withoutEffects(init: (msg: Msg, model: Model) -> Model): Update<Model, Msg> =
    { msg, model -> init(msg, model) to noEffect() }
