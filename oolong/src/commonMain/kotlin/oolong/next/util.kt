package oolong.next

import oolong.Effect
import oolong.effect.map
import oolong.effect.none

/**
 * Create a pair of [model] to [effect] where [effect] defaults to [none].
 */
fun <Model, Msg> next(model: Model, effect: Effect<Msg> = none()): Pair<Model, Effect<Msg>> =
    model to effect

/**
 * Transform [next] of type [A] to [Effect] of type [B] to [Pair] of type [C] to [Effect] of type [D] using [fa] and
 * [fb].
 */
fun <A, B, C, D> bimap(next: Pair<A, Effect<B>>, fa: (A) -> C, fb: (B) -> D): Pair<C, Effect<D>> =
    fa(next.first) to map(next.second, fb)
