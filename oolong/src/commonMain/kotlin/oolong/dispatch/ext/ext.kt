package oolong.dispatch.ext

import oolong.dispatch.Dispatch
import oolong.dispatch.contramap

/**
 * Transform this [Dispatch] of type [B] to [Dispatch] of type [A] using [f].
 *
 * See: [https://oolong-kt.org/recipes/navigation/#functions](https://oolong-kt.org/recipes/navigation/#functions)
 */
fun <A : Any, B : Any> Dispatch<B>.contramap(f: (A) -> B): Dispatch<A> =
    contramap(this, f)
