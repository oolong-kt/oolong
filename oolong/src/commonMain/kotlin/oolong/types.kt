package oolong

import kotlinx.coroutines.CoroutineScope

/**
 * Dispatches a message to the runtime
 *
 * @param msg the message to send
 */
typealias Dispatch<Msg> = (msg: Msg) -> Unit

/**
 * Runs a side-effect away from the runtime
 *
 * @param dispatch the dispatch function
 */
typealias Effect<Msg> = suspend CoroutineScope.(dispatch: Dispatch<Msg>) -> Any?

/**
 * A pair of the next state and side-effects
 */
typealias Next<Model, Msg> = Pair<Model, Effect<Msg>>

/**
 * Creates an initial state and side-effects
 */
typealias Init<Model, Msg> = () -> Next<Model, Msg>

/**
 * Creates a next state and side-effects from a message and current state
 *
 * @param msg the message to interpret
 * @param model the current state
 */
typealias Update<Model, Msg> = (msg: Msg, model: Model) -> Next<Model, Msg>

/**
 * Creates view properties from the current state
 *
 * @param model the current state
 * @param dispatch the dispatch function
 */
typealias View<Model, Props> = (model: Model) -> Props

/**
 * Renders the view properties
 *
 * @param props view properties
 */
typealias Render<Msg, Props> = (props: Props, dispatch: Dispatch<Msg>) -> Any?

/**
 * Stops the function and cleans up resources
 */
@Deprecated(
    "Use Job instead",
    ReplaceWith("Job", "kotlinx.coroutines.Job")
)
typealias Dispose = () -> Unit

/**
 * [Effect] builder function.
 */
fun <Msg> effect(block: Effect<Msg>): Effect<Msg> = block

/**
 * [Init] builder function.
 */
fun <Model, Msg> init(block: Init<Model, Msg>): Init<Model, Msg> = block

/**
 * [Update] builder function.
 */
fun <Model, Msg> update(block: Update<Model, Msg>): Update<Model, Msg> = block

/**
 * [View] builder function.
 */
fun <Model, Props> view(block: View<Model, Props>): View<Model, Props> = block

/**
 * [Render] builder function.
 */
fun <Props, Msg> render(block: Render<Props, Msg>): Render<Props, Msg> = block
