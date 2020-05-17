package oolong

import kotlinx.coroutines.CoroutineDispatcher
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
        runtimeDispatcher: CoroutineDispatcher = Dispatchers.Default,
        renderDispatcher: CoroutineDispatcher = Dispatchers.Main,
        effectDispatcher: CoroutineDispatcher = Dispatchers.Default
    ): Dispose {
        val runtime = RuntimeImpl(
            init, update, view, render,
            runtimeDispatcher, renderDispatcher, effectDispatcher
        )
        return { runtime.dispose() }
    }

    private class RuntimeImpl<Model : Any, Msg : Any, Props : Any>(
        init: Init<Model, Msg>,
        private val update: Update<Model, Msg>,
        private val view: View<Model, Props>,
        private val render: Render<Msg, Props>,
        private val runtimeDispatcher: CoroutineDispatcher,
        private val renderDispatcher: CoroutineDispatcher,
        private val effectDispatcher: CoroutineDispatcher
    ) : CoroutineScope {

        private lateinit var currentState: Model

        override val coroutineContext: CoroutineContext
            get() = runtimeDispatcher + SupervisorJob()

        init {
            launch(runtimeDispatcher) { step(init()) }
        }

        private fun dispatch(msg: Msg) {
            if (isActive) {
                launch(runtimeDispatcher) { step(update(msg, currentState)) }
            }
        }

        private fun step(next: Next<Model, Msg>) {
            val (state, effect) = next
            val props = view(state)
            currentState = state
            launch(renderDispatcher) { render(props, ::dispatch) }
            launch(effectDispatcher) { effect(::dispatch) }
        }

        fun dispose() {
            if (isActive) {
                cancel()
            }
        }

    }

}
