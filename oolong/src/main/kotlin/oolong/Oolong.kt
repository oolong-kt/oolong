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
        val runtimeThread = Thread.currentThread()
        var running = true
        fun reduce(next: Next<Model, Msg>) {
            if (!running) return
            if (Thread.currentThread() != runtimeThread) {
                throw IllegalThreadStateException(
                    "Dispatch function must be invoked from $runtimeThread but was invoked from ${Thread.currentThread()}."
                )
            }
            val (model, effect) = next
            val dispatch = { msg: Msg -> reduce(update(msg, model)) }
            effect(dispatch)
            subscriptions(model)(dispatch)
            render(view(model, dispatch))
        }
        reduce(init())
        return { running = false }
    }

}