package oolong

interface Program<Model, Msg, Props> {

    fun init(): Next<Model, Msg>

    fun update(msg: Msg, model: Model): Next<Model, Msg>

    fun view(model: Model, dispatch: Dispatch<Msg>): Props

}