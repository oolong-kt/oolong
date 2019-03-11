package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.js.JsName

object Oolong {

    /**
     * Create a runtime.
     */
    @JsName("program")
    fun <Model, Msg, Props> program(
        program: Program<Model, Msg, Props>,
        render: Render<Msg, Props>,
        runtimeScope: CoroutineScope = GlobalScope,
        effectContext: CoroutineContext = Dispatchers.Default,
        renderContext: CoroutineContext = effectContext
    ) = runtime(
        program::init,
        program::update,
        program::view,
        render,
        runtimeScope,
        effectContext,
        renderContext
    )

    /**
     * Create a runtime.
     */
    @JsName("runtime")
    fun <Model, Msg, Props> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Msg, Props>,
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

    object Main {

        /**
         * Create a runtime with a render [CoroutineContext] of [Dispatchers.Main].
         */
        @JsName("program")
        fun <Model, Msg, Props> program(
            program: Program<Model, Msg, Props>,
            render: Render<Msg, Props>,
            runtimeScope: CoroutineScope = GlobalScope,
            effectContext: CoroutineContext = Dispatchers.Default
        ) = runtime(
            program::init,
            program::update,
            program::view,
            render,
            runtimeScope,
            effectContext
        )

        /**
         * Create a runtime with a render [CoroutineContext] of [Dispatchers.Main].
         */
        @JsName("runtime")
        fun <Model, Msg, Props> runtime(
            init: Init<Model, Msg>,
            update: Update<Model, Msg>,
            view: View<Model, Props>,
            render: Render<Msg, Props>,
            runtimeScope: CoroutineScope = GlobalScope,
            effectContext: CoroutineContext = Dispatchers.Default
        ) = runtime(
            init,
            update,
            view,
            render,
            runtimeScope,
            effectContext,
            Dispatchers.Main
        )

    }

    private class Runtime<Model, Msg, Props>(
        init: Init<Model, Msg>,
        private val update: Update<Model, Msg>,
        private val view: View<Model, Props>,
        private val render: Render<Msg, Props>,
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
            launch(renderContext) { render(view(state), ::dispatch) }
        }

        fun dispose() {
            running = false
        }
    }

}
