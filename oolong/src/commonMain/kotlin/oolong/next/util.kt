package oolong.next

import oolong.Next
import oolong.effect.map

/**
 * Map from [Next] of [A] and [B] to [Next] of [C] and [D]
 */
fun <A : Any, B : Any, C : Any, D : Any> bimap(next: Next<A, B>, fa: (A) -> C, fb: (B) -> D): Next<C, D> =
    fa(next.first) to map(next.second, fb)
