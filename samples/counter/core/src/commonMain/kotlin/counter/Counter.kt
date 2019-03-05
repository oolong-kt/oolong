package counter

import oolong.Init
import oolong.Update
import oolong.View
import oolong.util.effect.withoutEffects

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

    val init: Init<Model, Msg> = withoutEffects { ->
        Model()
    }

    val update: Update<Model, Msg> = withoutEffects { msg, model ->
        when (msg) {
            Msg.Increment -> model.copy(count = model.count + 1)
            Msg.Decrement -> model.copy(count = model.count - 1)
        }
    }

    val view: View<Model, Msg, Props> = { model, dispatch ->
        Props(
            model.count,
            { dispatch(Msg.Increment) },
            { dispatch(Msg.Decrement) }
        )
    }

}