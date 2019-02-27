package oolong

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
typealias Effect<Msg> = (dispatch: Dispatch<Msg>) -> Unit

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

