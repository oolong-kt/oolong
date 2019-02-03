package oolong

import oolong.platform.Effect

object Counter {

    lateinit var props: Props

    data class Model(
        val count: Int
    )

    sealed class Msg {
        object Increment : Msg()
        object Decrement : Msg()
    }

    data class Props(
        val count: Int,
        val increment: () -> Unit,
        val decrement: () -> Unit
    )

    val init: () -> Pair<Model, Effect<Msg>> = {
        Model(0) to Effect.none()
    }

    val update: (Msg, Model) -> Pair<Model, Effect<Msg>> = { msg, model ->
        when (msg) {
            Msg.Increment -> model.copy(count = model.count + 1)
            Msg.Decrement -> model.copy(count = model.count - 1)
        } to Effect.none()
    }

    val view: View<Model, Msg, Props> = { model, dispatch ->
        Props(
            model.count,
            { dispatch(Msg.Increment) },
            { dispatch(Msg.Decrement) }
        )
    }

    val render: Render<Props> = { props ->
        this.props = props
    }

    val subscriptions: (Model) -> Effect<Msg> = {
        Effect.none()
    }

}
