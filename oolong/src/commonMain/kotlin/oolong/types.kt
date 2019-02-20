package oolong

/**
 * Dispatches a message to the runtime
 *
 * @param msg the message to send
 */
typealias Dispatch<Msg> = (msg: Msg) -> Unit

// A type inference compiler bug prevents Effect from being a typealias.
//
// typealias Effect<Msg> = (dispatch: Dispatch<Msg>) -> Unit
// fun <Msg> Effect(block: (dispatch: Dispatch<Msg>) -> Unit): Effect<Msg> = { dispatch -> block(dispatch) }

/**
 * Runs a side-effect away from the runtime
 *
 * @param dispatch the dispatch function
 */
// remove out variance when inference compiler bug is fixed
class Effect<Msg>(private val block: (Dispatch<Msg>) -> Unit) {
    operator fun invoke(dispatch: Dispatch<Msg>) = block(dispatch)
}

/**
 * A pair of the next state and side-effects
 */
// remove out variance when inference compiler bug is fixed
typealias Next<Model, Msg> = Pair<Model, Effect<out Msg>>

/**
 * Creates an initial state and side-effects
 */
// remove out variance when inference compiler bug is fixed
typealias Init<Model, Msg> = () -> Next<Model, out Msg>

/**
 * Creates a next state and side-effects from a message and current state
 *
 * @param msg the message to interpret
 * @param model the current state
 */
// remove out variance when inference compiler bug is fixed
typealias Update<Model, Msg> = (msg: Msg, model: Model) -> Next<Model, out Msg>

/**
 * Creates view properties from the current state
 *
 * @param model the current state
 * @param dispatch the dispatch function
 */
typealias View<Model, Msg, Props> = (model: Model, dispatch: Dispatch<Msg>) -> Props

/**
 * Renders the view properties
 *
 * @param props view properties
 */
typealias Render<Props> = (props: Props) -> Unit

/**
 * Stops the runtime and cleans up resources
 */
typealias Dispose = () -> Unit

