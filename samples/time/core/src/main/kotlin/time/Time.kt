package time

import oolong.Init
import oolong.Subscriptions
import oolong.Update
import oolong.View
import oolong.platform.Effect
import oolong.util.schedule
import java.time.LocalDateTime
import java.util.Timer

object Time {

    data class Model(
        val time: LocalDateTime
    )

    sealed class Msg {
        data class Tick(val time: LocalDateTime) : Msg()
    }

    data class Props(
        val hour: Int,
        val minute: Int,
        val second: Int
    )

    val init: Init<Model, Msg> = {
        Model(LocalDateTime.now()) to Effect.none()
    }

    val update: Update<Model, Msg> = { msg, model ->
        when (msg) {
            is Msg.Tick -> Model(msg.time)
        } to Effect.none()
    }

    val view: View<Model, Msg, Props> = { model, dispatch ->
        Props(
            model.time.hour,
            model.time.minute,
            model.time.second
        )
    }

    val subscriptions: Subscriptions<Model, Msg> = { model ->
        val timer = Timer()
        timer.schedule(1000) { Msg.Tick(LocalDateTime.now()) }
    }

}