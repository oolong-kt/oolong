package oolong.dispatch

// Types

/**
 * Dispatches a message to the runtime
 */
typealias Dispatch<Msg> = (Msg) -> Unit

// Transformations

/**
 * Transform [dispatch] of type [B] to a [Dispatch] of type [A] using [f].
 *
 * See: [https://oolong-kt.org/recipes/navigation/#functions](https://oolong-kt.org/recipes/navigation/#functions)
 */
fun <A : Any, B : Any> contramap(dispatch: Dispatch<A>, f: (B) -> A): Dispatch<B> =
    { b -> dispatch(f(b)) }
