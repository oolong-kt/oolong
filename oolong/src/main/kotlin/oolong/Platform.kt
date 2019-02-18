package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import oolong.platform.Effect
import kotlin.coroutines.CoroutineContext

object Platform {

    fun <Model, Msg, Props> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Msg, Props>,
        render: Render<Props>,
        subscriptions: Subscriptions<Model, Msg> = { Effect.none() },
        runtimeScope: CoroutineScope = GlobalScope,
        effectContext: CoroutineContext = Dispatchers.IO,
        renderContext: CoroutineContext = effectContext
    ): Dispose {
        var disposed = false
        val channel = Channel<Next<Model, Msg>>(Channel.CONFLATED)
        val runtimeJob = runtimeScope.launch {
            fun reduce(next: Next<Model, Msg>) {
                if (disposed) return
                val (model, effect) = next
                val dispatch = { msg: Msg ->
                    if (!disposed) channel.offer(update(msg, model))
                }
                launch(effectContext) { effect(dispatch) }
                launch(effectContext) { subscriptions(model)(dispatch) }
                launch(renderContext) { render(view(model, dispatch)) }
            }
            if (!disposed) channel.send(init())
            for (next in channel) reduce(next)
        }
        return {
            if (!disposed) {
                disposed = true
                channel.close()
                runtimeJob.cancel()
            }
        }
    }

    abstract class MainRuntime {

        fun <Model, Msg, Props> runtime(
            init: Init<Model, Msg>,
            update: Update<Model, Msg>,
            view: View<Model, Msg, Props>,
            render: Render<Props>,
            subscriptions: Subscriptions<Model, Msg> = { Effect.none() },
            runtimeScope: CoroutineScope = GlobalScope,
            effectContext: CoroutineContext = Dispatchers.IO
        ) = Platform.runtime(
            init,
            update,
            view,
            render,
            subscriptions,
            runtimeScope,
            effectContext,
            Dispatchers.Main
        )

    }

}