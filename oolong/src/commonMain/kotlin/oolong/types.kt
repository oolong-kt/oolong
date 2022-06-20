package oolong

import kotlinx.coroutines.CoroutineScope

/** A function to dispatch a Msg to the runtime in the runtime context. */
typealias Dispatch<Msg> = (Msg) -> Unit

/**
 * A function to run a side-effect in the effect context. Provides a Dispatch function to dispatch a
 * Msg to the runtime in the runtime context.
 */
typealias Effect<Msg> = suspend CoroutineScope.(Dispatch<Msg>) -> Any?

/** [Effect] builder function. */
fun <Msg> effect(
    block: Effect<Msg>,
): Effect<Msg> = block

/** Init builder function. */
fun <Model, Msg> init(
    block: () -> Pair<Model, Effect<Msg>>,
): () -> Pair<Model, Effect<Msg>> = block

/** Update builder function. */
fun <Model, Msg> update(
    block: (Msg, Model) -> Pair<Model, Effect<Msg>>,
): (Msg, Model) -> Pair<Model, Effect<Msg>> = block

/** View builder function. */
@Suppress("DeprecatedCallableAddReplaceWith")
@Deprecated(DEPRECATION_MESSAGE_DISPATCH_RELOCATED)
fun <Model, Props> view(block: (Model) -> Props): (Model) -> Props = block

/** View builder function. */
fun <Model, Msg, Props> view(
    block: (Model, Dispatch<Msg>) -> Props,
): (Model, Dispatch<Msg>) -> Props = block

/** Render builder function. */
@Suppress("DeprecatedCallableAddReplaceWith")
@Deprecated(DEPRECATION_MESSAGE_DISPATCH_RELOCATED)
fun <Props, Msg> render(
    block: (Props, Dispatch<Msg>) -> Any?,
): (Props, Dispatch<Msg>) -> Any? = block

/** Render builder function. */
fun <Props> render(
    block: (Props) -> Any?,
): (Props) -> Any? = block
