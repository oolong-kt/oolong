package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

object Oolong {

    fun <Model, Msg, Props> runtime(
            init: Init<Model, Msg>,
            update: Update<Model, Msg>,
            view: View<Model, Msg, Props>,
            render: Render<Props>,
            runtimeScope: CoroutineScope = GlobalScope,
            effectContext: CoroutineContext = Dispatchers.Default,
            renderContext: CoroutineContext = effectContext
    ): Dispose {
        val runtime = Runtime(
                init,
                update,
                view,
                render,
                runtimeScope,
                effectContext,
                renderContext
        )
        return { runtime.dispose() }
    }

    private class Runtime<Model, Msg, Props>(
            init: Init<Model, Msg>,
            private val update: Update<Model, Msg>,
            private val view: View<Model, Msg, Props>,
            private val render: Render<Props>,
            runtimeScope: CoroutineScope = GlobalScope,
            private val effectContext: CoroutineContext = Dispatchers.Default,
            private val renderContext: CoroutineContext = effectContext
    ) : CoroutineScope by runtimeScope {

        private var running = true
        private var currentState: Model

        init {
            with(init()) {
                currentState = first
                change(this)
            }
        }

        private fun dispatch(msg: Msg) {
            if (running) {
                change(update(msg, currentState))
            }
        }

        private fun change(next: Next<Model, Msg>) {
            val (state, effect) = next
            currentState = state
            launch(effectContext) { effect(::dispatch) }
            launch(renderContext) { render(view(currentState, ::dispatch)) }
        }

        fun dispose() {
            running = false
        }
    }

    abstract class MainRuntime {

        fun <Model, Msg, Props> runtime(
                init: Init<Model, Msg>,
                update: Update<Model, Msg>,
                view: View<Model, Msg, Props>,
                render: Render<Props>,
                runtimeScope: CoroutineScope = GlobalScope,
                effectContext: CoroutineContext = Dispatchers.Default
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