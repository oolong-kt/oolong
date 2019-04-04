package oolong.next

import oolong.Next
import oolong.effect.map

/**
 * Map from [Next] of [A] and [B] to [Next] of [Model] and [Msg]
 */
fun <A, B, Model, Msg> map(next: Next<A, B>, fa: (A) -> Model, fb: (B) -> Msg): Next<Model, Msg> =
    fa(next.first) to map(next.second, fb)
