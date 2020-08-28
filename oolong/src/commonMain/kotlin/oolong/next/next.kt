package oolong.next

import oolong.effect.Effect
import oolong.effect.map

// Types

/**
 * A pair of the next [Model] and [Effect] of type [Msg].
 */
typealias Next<Model, Msg> = Pair<Model, Effect<Msg>>

// Transformers

/**
 * Transform [next] of type [A] and [B] to [Next] of type [C] and [D] using [fa] and [fb].
 *
 * See: [https://oolong-kt.org/recipes/navigation/#functions](https://oolong-kt.org/recipes/navigation/#functions)
 */
fun <A : Any, B : Any, C : Any, D : Any> bimap(next: Next<A, B>, fa: (A) -> C, fb: (B) -> D): Next<C, D> =
    fa(next.first) to map(next.second, fb)
