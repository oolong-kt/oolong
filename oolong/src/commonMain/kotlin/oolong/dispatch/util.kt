package oolong.dispatch

import oolong.Dispatch

/**
 * Contramap from [Dispatch] of [A] to [Dispatch] of [B]
 */
fun <A, B> contramap(dispatch: Dispatch<A>, f: (B) -> A): Dispatch<B> =
    { a -> dispatch(f(a)) }
