package time

import oolong.Init
import oolong.Update
import oolong.View
import oolong.util.fixedRateTimer
import oolong.util.noEffect
import java.time.LocalDateTime

object Time {

    data class Model(
        val time: LocalDateTime
    )

    sealed class Msg {
        data class Tick(val time: LocalDateTime) : Msg()
    }

    data class Props(
        val time: LocalDateTime
    )

    val init: Init<Model, Msg> = {
        val state = Model(LocalDateTime.now())
        val subscriptions = fixedRateTimer(period = 1000L) { Msg.Tick(LocalDateTime.now()) }
        state to subscriptions
    }

    val update: Update<Model, Msg> = { msg, model ->
        when (msg) {
            is Msg.Tick -> Model(msg.time)
        } to noEffect()
    }

    val view: View<Model, Msg, Props> = { model, dispatch ->
        Props(model.time)
    }

}