package oolong.next.ext

import oolong.next.Next
import oolong.next.bimap

/**
 * Transform this [Next] of type [A] and [B] to [Next] of type [C] and [D] using [fa] and [fb].
 */
fun <A : Any, B : Any, C : Any, D : Any> Next<A, B>.bimap(fa: (A) -> C, fb: (B) -> D): Next<C, D> =
    bimap(this, fa, fb)
