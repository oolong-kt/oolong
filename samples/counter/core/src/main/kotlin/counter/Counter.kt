package counter

import oolong.Init
import oolong.Update
import oolong.View
import oolong.platform.Effect

object Counter {

    data class Model(
        val count: Int = 0
    )

    sealed class Msg {
        object Increment : Msg()
        object Decrement : Msg()
    }

    data class Props(
        val count: Int,
        val onIncrement: () -> Unit,
        val onDecrement: () -> Unit
    )

    val init: Init<Model, Msg> = {
        Model() to Effect.none()
    }

    val update: Update<Model, Msg> = { msg, model ->
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

}