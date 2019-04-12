package oolong

/**
 * An interface to encapsulate the requirements of a compositional child in a [Program].
 */
interface Component<Model, Msg, Props> {

    /**
     * Creates a next state and side-effects from a message and current state
     *
     * @param msg the message to interpret
     * @param model the current state
     */
    fun update(msg: Msg, model: Model): Next<Model, Msg>

    /**
     * Creates view properties from the current state
     *
     * @param model the current state
     */
    fun view(model: Model): Props

}
