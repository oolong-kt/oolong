package oolong.dispatch

import oolong.Dispatch

/**
 * Transform [dispatch] of type [A] to [Dispatch] of type [B] using [f].
 *
 * [https://oolong-kt.org/recipes/navigation](https://oolong-kt.org/recipes/navigation)
 */
fun <A : Any, B : Any> contramap(dispatch: Dispatch<A>, f: (B) -> A): Dispatch<B> =
    { b -> dispatch(f(b)) }
