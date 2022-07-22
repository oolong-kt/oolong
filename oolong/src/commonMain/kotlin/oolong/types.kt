package oolong

import kotlinx.coroutines.CoroutineScope

/**
 * A function to dispatch a Msg to the runtime in the runtime context.
 */
typealias Dispatch<Msg> = (Msg) -> Unit

/**
 * A function to run a side-effect in the effect context. Provides a Dispatch function to dispatch a Msg to the
 * runtime in the runtime context.
 */
typealias Effect<Msg> = suspend CoroutineScope.(Dispatch<Msg>) -> Any?

/**
 * [Effect] builder function.
 */
fun <Msg> effect(block: Effect<Msg>): Effect<Msg> = block

/**
 * Init builder function.
 */
fun <Model, Msg> init(block: Init<Model, Msg>): Init<Model, Msg> = block

/**
 * Update builder function.
 */
fun <Model, Msg> update(block: Update<Model, Msg>): Update<Model, Msg> =
    block

/**
 * View builder function.
 */
fun <Model, Props> view(block: View<Model, Props>): View<Model, Props> = block

/**
 * Render builder function.
 */
fun <Props, Msg> render(block: Render<Msg, Props>): Render<Msg, Props> = block

/*
Typealiases for the function signatures so that they're easily
referencable and a single source of truth for their signature
*/

/**
 * A pair of the next state and side-effects
 */
@Deprecated(
    "Use Pair<Model, Effect<Msg>> instead",
    ReplaceWith("Pair<Model, Effect<Msg>>", "kotlin.Pair", "oolong.Effect")
)
typealias Next<Model, Msg> = Pair<Model, Effect<Msg>>

/**
 * Creates an initial state and side-effects
 */
@Deprecated(
    "Use () -> Pair<Model, Effect<Msg>> instead",
    ReplaceWith("() -> Pair<Model, Effect<Msg>>", "kotlin.Pair", "oolong.Effect")
)
typealias Init<Model, Msg> = () -> Pair<Model, Effect<Msg>>

/**
 * Creates a next state and side-effects from a message and current state
 *
 * @param msg the message to interpret
 * @param model the current state
 */
@Deprecated(
    "Use (Msg, Model) -> Pair<Model, Effect<Msg>> instead",
    ReplaceWith("(Msg, Model) -> Pair<Model, Effect<Msg>>", "kotlin.Pair", "oolong.Effect")
)
typealias Update<Model, Msg> = (msg: Msg, model: Model) -> Pair<Model, Effect<Msg>>

/**
 * Creates view properties from the current state
 *
 * @param model the current state
 * @param dispatch the dispatch function
 */
@Deprecated(
    "Use (Model) -> Props instead",
    ReplaceWith("(Model) -> Props")
)
typealias View<Model, Props> = (model: Model) -> Props

/**
 * Renders the view properties
 *
 * @param props view properties
 */
@Deprecated(
    "Use (Props, Dispatch<Msg>) -> Any? instead",
    ReplaceWith("(Props, Dispatch<Msg>) -> Any?", "oolong.Dispatch")
)
typealias Render<Msg, Props> = (props: Props, dispatch: Dispatch<Msg>) -> Any?