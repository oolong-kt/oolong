package oolong.next

import oolong.Effect
import oolong.effect.map

/**
 * Transform [next] of type [A] to [Effect] of type [B] to [Pair] of type [C] to [Effect] of type [D] using [fa] and
 * [fb].
 */
fun <A, B, C, D> bimap(next: Pair<A, Effect<B>>, fa: (A) -> C, fb: (B) -> D): Pair<C, Effect<D>> =
    fa(next.first) to map(next.second, fb)
