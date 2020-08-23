package oolong

import oolong.effect.batch
import oolong.effect.disposableEffect
import oolong.effect.map

/**
 * Compose this [Effect] with [effect].
 */
operator fun <Msg : Any> Effect<Msg>.plus(effect: Effect<Msg>): Effect<Msg> =
    batch(this, effect)

/**
 * Transform this [Effect] to [Effect] of type [B] using [f].
 */
fun <A : Any, B : Any> Effect<A>.map(f: (A) -> B): Effect<B> =
    map(this, f)

/**
 * Create a [Pair] of [effect] and [Dispose] which cancels [effect].
 */
fun <Msg : Any> Effect<Msg>.withDispose(): Pair<Effect<Msg>, Dispose> =
    disposableEffect(this)


