package oolong

import oolong.next.bimap

/**
 * Map from [Next] of [A] and [B] to [Next] of [C] and [D].
 *
 * [https://oolong-kt.org/recipes/navigation](https://oolong-kt.org/recipes/navigation)
 */
fun <A : Any, B : Any, C : Any, D : Any> Next<A, B>.bimap(fa: (A) -> C, fb: (B) -> D): Next<C, D> =
    bimap(this, fa, fb)
