package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

object Oolong {

    fun <Model, Msg, Props> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Msg, Props>,
        render: Render<Props>,
        runtimeScope: CoroutineScope = GlobalScope,
        effectContext: CoroutineContext = Dispatchers.IO,
        renderContext: CoroutineContext = effectContext
    ): Dispose {
        val channel = Channel<Next<out Model, out Msg>>(Channel.CONFLATED)
        val runtimeJob = runtimeScope.launch {
            channel.send(init())
            for (next in channel) {
                val (model, effect) = next
                val dispatch = { msg: Msg ->
                    if (!channel.offer(update(msg, model))) {
                        throw IllegalStateException("Channel failed to accept next state.")
                    }
                }
                launch(effectContext) { effect(dispatch) }
                launch(renderContext) { render(view(model, dispatch)) }
            }
        }
        return {
            if (runtimeJob.isActive) {
                runtimeJob.cancel()
                channel.close()
            }
        }
    }

    abstract class MainRuntime {

        fun <Model, Msg, Props> runtime(
            init: Init<Model, Msg>,
            update: Update<Model, Msg>,
            view: View<Model, Msg, Props>,
            render: Render<Props>,
            runtimeScope: CoroutineScope = GlobalScope,
            effectContext: CoroutineContext = Dispatchers.IO
        ) = Oolong.runtime(
            init,
            update,
            view,
            render,
            runtimeScope,
            effectContext,
            Dispatchers.Main
        )

    }

}