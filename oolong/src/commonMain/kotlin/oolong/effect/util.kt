package oolong.effect

import kotlinx.coroutines.launch
import oolong.Effect

/** Create an empty [Effect]. */
fun <Msg> none(): Effect<Msg> = {}

/** Compose [effects] into a single [Effect]. */
fun <Msg> batch(vararg effects: Effect<Msg>): Effect<Msg> = batch(effects.asIterable())

/** Compose [effects] into a single [Effect]. */
fun <Msg> batch(effects: Iterable<Effect<Msg>>): Effect<Msg> = { dispatch ->
    for (effect in effects) launch { effect(dispatch) }
}

/** Map [effect] of type [A] to [Effect] of [B] using [f]. */
fun <A, B> map(effect: Effect<A>, f: (A) -> B): Effect<B> = { dispatch ->
    effect { a -> dispatch(f(a)) }
}
