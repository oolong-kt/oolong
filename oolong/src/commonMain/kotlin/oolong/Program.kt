package oolong

/**
 * An interface to encapsulate the requirements of an Oolong runtime.
 */
interface Program<Model, Msg, Props> {

    /**
     * Creates an initial state and side-effects
     */
    fun init(): Next<Model, Msg>

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
