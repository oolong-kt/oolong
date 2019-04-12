package oolong

/**
 * An interface to encapsulate the requirements of an Oolong runtime.
 */
interface Program<Model, Msg, Props> : Component<Model, Msg, Props> {

    /**
     * Creates an initial state and side-effects
     */
    fun init(): Next<Model, Msg>

}
