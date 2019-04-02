package random

import oolong.Effect
import oolong.Init
import oolong.Update
import oolong.View
import oolong.util.effect.noEffect
import oolong.util.random.nextInt
import kotlin.random.Random

object Random {

    data class Model(
        val face: Int = 0
    )

    sealed class Msg {
        object Roll : Msg()
        data class NewFace(val face: Int) : Msg()
    }

    data class Props(
        val dieFace: Int,
        val onRoll: () -> Msg
    )

    val init: Init<Model, Msg> = {
        Model() to rollDie()
    }

    val update: Update<Model, Msg> = { msg, model ->
        when (msg) {
            Msg.Roll -> model to rollDie()
            is Msg.NewFace -> Model(msg.face) to noEffect()
        }
    }

    val view: View<Model, Props> = { model ->
        Props(
            model.face,
            { Msg.Roll }
        )
    }

    private val rollDie: () -> Effect<Msg> = {
        Random.nextInt(1..6) { Msg.NewFace(it) } as Effect<Msg>
    }

}
