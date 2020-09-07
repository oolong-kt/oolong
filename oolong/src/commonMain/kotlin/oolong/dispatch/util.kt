package oolong.dispatch

import oolong.Dispatch

/**
 * Contramap from [Dispatch] of [A] to [Dispatch] of [B]
 *
 * See: [https://oolong-kt.org/recipes/navigation/](https://oolong-kt.org/recipes/navigation/)
 */
fun <A, B> contramap(dispatch: Dispatch<A>, f: (B) -> A): Dispatch<B> =
    { b -> dispatch(f(b)) }
