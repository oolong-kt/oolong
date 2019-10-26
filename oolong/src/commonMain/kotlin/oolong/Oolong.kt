package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.js.JsName

/**
 * Oolong runtime module.
 */
object Oolong {

    /**
     * Create a runtime.
     */
    @JsName("runtime")
    fun <Model : Any, Msg : Any, Props : Any> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Msg, Props>,
        runtimeScope: CoroutineScope = GlobalScope,
        effectContext: CoroutineContext = Dispatchers.Default,
        renderContext: CoroutineContext = Dispatchers.Main
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

    private class Runtime<Model : Any, Msg : Any, Props : Any>(
        init: Init<Model, Msg>,
        private val update: Update<Model, Msg>,
        private val view: View<Model, Props>,
        private val render: Render<Msg, Props>,
        runtimeScope: CoroutineScope,
        private val effectContext: CoroutineContext,
        private val renderContext: CoroutineContext
    ) : CoroutineScope by runtimeScope {

        private var running = true
        private var currentState: Model

        init {
            with(init()) {
                currentState = first
                step(this)
            }
        }

        private fun dispatch(msg: Msg) {
            if (running) {
                step(update(msg, currentState))
            }
        }

        private fun step(next: Next<Model, Msg>) {
            val (state, effect) = next
            val props = view(state)
            currentState = state
            launch(renderContext) { render(props, ::dispatch) }
            launch(effectContext) { effect(::dispatch) }
        }

        fun dispose() {
            running = false
        }

    }

}
