package random

import oolong.Init
import oolong.Update
import oolong.View
import oolong.platform.Effect
import oolong.util.nextInt

object Random {

    data class Model(
        val face: Int = 0
    )

    sealed class Msg {
        object Roll : Msg()
        data class NewFace(val face: Int) : Msg()
    }

    data class RenderModel(
        val dieFace: Int,
        val onRoll: () -> Unit
    )

    val init: Init<Model, Msg> = {
        Model() to Effect.none()
    }

    val update: Update<Model, Msg> = { msg, model ->
        val random = java.util.Random()
        when (msg) {
            Msg.Roll -> model to random.nextInt<Msg>(5) { Msg.NewFace(it + 1) }
            is Msg.NewFace -> Model(msg.face) to Effect.none()
        }
    }

    val view: View<Model, Msg, RenderModel> = { model, dispatch ->
        RenderModel(
            model.face,
            { dispatch(Msg.Roll) }
        )
    }

}