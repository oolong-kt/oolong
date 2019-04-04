package time

import oolong.Init
import oolong.Next
import oolong.Update
import oolong.View
import oolong.delay.interval
import oolong.effect.withoutEffects

object Time {

    data class Model(
        val time: Long
    )

    sealed class Msg {
        data class Tick(val time: Long) : Msg()
    }

    data class Props(
        val time: Long
    )

    val init: Init<Model, Msg> = {
        // TODO: multiplatform function to get current time
        val state = Model(0)
        val subscriptions = interval<Msg>(1000L) { Msg.Tick(0) }
        (state to subscriptions.first) as Next<Model, Msg>
    }

    val update: Update<Model, Msg> = withoutEffects { msg, _ ->
        when (msg) {
            is Msg.Tick -> Model(msg.time)
        }
    }

    val view: View<Model, Props> = { model ->
        Props(model.time)
    }

}
