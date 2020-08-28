package oolong.effect.ext

import oolong.effect
import oolong.effect.Effect
import oolong.effect.batch
import oolong.effect.effect
import oolong.effect.map

/**
 * Compose this [Effect] with [effect].
 */
operator fun <Msg : Any> Effect<Msg>.plus(other: Effect<Msg>): Effect<Msg> =
    batch(this, other)

/**
 * Transform this [Effect] of type [A] to an [Effect] of type [B] using [f].
 */
fun <A : Any, B : Any> Effect<A>.map(f: (A) -> B): Effect<B> =
    map(this, f)
