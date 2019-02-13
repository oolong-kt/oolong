package oolong

import oolong.platform.Effect

object Oolong {

    fun <Model, Msg, Props> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Msg, Props>,
        render: Render<Props>,
        subscriptions: Subscriptions<Model, Msg> = { Effect.none() }
    ): Dispose {
        var running = true
        fun reduce(next: Next<Model, Msg>) {
            if (!running) return
            val (model, effect) = next
            val dispatch = { msg: Msg -> reduce(update(msg, model)) }
            render(view(model, dispatch))
            effect(dispatch)
            subscriptions(model)(dispatch)
        }
        reduce(init())
        return { running = false }
    }

}