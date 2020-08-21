package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmOverloads

/**
 * Oolong runtime module.
 */
object Oolong {

    /**
     * Create a runtime.
     */
    @JvmOverloads
    fun <Model : Any, Msg : Any, Props : Any> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Msg, Props>,
        runtimeContext: CoroutineContext = Dispatchers.Default,
        renderContext: CoroutineContext = Dispatchers.Main,
        effectContext: CoroutineContext = Dispatchers.Default
    ): Dispose {
        val runtime = RuntimeImpl(
            init, update, view, render,
            runtimeContext, renderContext, effectContext
        )
        return { runtime.dispose() }
    }

    private class RuntimeImpl<Model : Any, Msg : Any, Props : Any>(
        init: Init<Model, Msg>,
        private val update: Update<Model, Msg>,
        private val view: View<Model, Props>,
        private val render: Render<Msg, Props>,
        private val runtimeContext: CoroutineContext,
        private val renderContext: CoroutineContext,
        private val effectContext: CoroutineContext
    ) : CoroutineScope {

        private lateinit var currentState: Model

        override val coroutineContext: CoroutineContext
            get() = runtimeContext + SupervisorJob()

        init {
            launch(runtimeContext) { step(init()) }
        }

        private fun dispatch(msg: Msg) {
            if (isActive) {
                launch(runtimeContext) { step(update(msg, currentState)) }
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
            if (isActive) {
                cancel()
            }
        }

    }

}
