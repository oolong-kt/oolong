package oolong.dispatch

import oolong.Dispatch

/**
 * Contramap from [Dispatch] of [A] to [Dispatch] of [B]
 */
fun <A : Any, B : Any> contramap(dispatch: Dispatch<A>, f: (B) -> A): Dispatch<B> =
    { b -> dispatch(f(b)) }
