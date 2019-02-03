package oolong

import oolong.platform.Effect
import oolong.platform.Sub

object Counter {

    lateinit var model: Model
    lateinit var dispatch: Dispatch<Msg>

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Model

    data class Model(
        val count: Int
    )

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Messages

    sealed class Msg {
        object Increment : Msg()
        object Decrement : Msg()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Functions

    val init: () -> Pair<Model, Effect<Msg>> = {
        Model(0) to Effect.none()
    }

    val update: (Msg, Model) -> Pair<Model, Effect<Msg>> = { msg, model ->
        when (msg) {
            Msg.Increment -> model.copy(count = model.count + 1)
            Msg.Decrement -> model.copy(count = model.count - 1)
        } to Effect.none()
    }

    val view: (Model, Dispatch<Msg>) -> Unit = { model, dispatch ->
        this.model = model
        this.dispatch = dispatch
    }

    val subscriptions: (Model) -> Sub<Msg> = {
        Sub.none()
    }

}
