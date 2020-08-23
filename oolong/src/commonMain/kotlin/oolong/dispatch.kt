package oolong

import oolong.dispatch.contramap

/**
 * Transform this [Dispatch] to [Dispatch] of type [B] using [f].
 *
 * [https://oolong-kt.org/recipes/navigation](https://oolong-kt.org/recipes/navigation)
 */
fun <A : Any, B : Any> Dispatch<A>.contramap(f: (B) -> A): Dispatch<B> =
    contramap(this, f)

