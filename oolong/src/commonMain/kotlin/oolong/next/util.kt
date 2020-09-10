package oolong.next

import oolong.Effect
import oolong.effect.map

/**
 * Map from [Pair] of [A] and [Effect] of [B] to [Pair] of [C] and Effect of [D].
 *
 * See: [https://oolong-kt.org/recipes/navigation/](https://oolong-kt.org/recipes/navigation/)
 */
fun <A, B, C, D> bimap(next: Pair<A, Effect<B>>, fa: (A) -> C, fb: (B) -> D): Pair<C, Effect<D>> =
    fa(next.first) to map(next.second, fb)
