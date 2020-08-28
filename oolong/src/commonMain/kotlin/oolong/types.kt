package oolong

/**
 * Dispatches a message to the runtime
 *
 * @param msg the message to send
 */
@Deprecated(
    "Use oolong.dispatch.Dispatch instead",
    ReplaceWith("Dispatch<Msg>", "oolong.dispatch.Dispatch")
)
typealias Dispatch<Msg> = oolong.dispatch.Dispatch<Msg>

/**
 * Runs a side-effect away from the runtime
 *
 * @param dispatch the dispatch function
 */
@Deprecated(
    "Use oolong.effect.Effect instead",
    ReplaceWith("Effect<Msg>", "oolong.effect.Effect")
)
typealias Effect<Msg> = oolong.effect.Effect<Msg>

/**
 * A pair of the next state and side-effects
 */
@Deprecated(
    "Use oolong.next.Next instead",
    ReplaceWith("oolong.next.Next<Model, Msg>", "oolong.next.Next")
)
typealias Next<Model, Msg> = oolong.next.Next<Model, Msg>


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
@Deprecated(
    "Use oolong.effect.effect(block) instead",
    ReplaceWith("oolong.effect.effect(block)", "oolong.effect.effect")
)
fun <Msg : Any> effect(block: Effect<Msg>): Effect<Msg> = oolong.effect.effect(block)

