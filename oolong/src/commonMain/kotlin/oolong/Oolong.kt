package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Oolong runtime module.
 */
object Oolong {

    /**
     * Create a runtime.
     */
    fun <Model : Any, Msg : Any, Props : Any> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Msg, Props>,
        mainDispatcher: MainCoroutineDispatcher = Dispatchers.Main
    ): Dispose {
        val runtime = RuntimeImpl(init, update, view, render, mainDispatcher)
        return { runtime.dispose() }
    }

    private class RuntimeImpl<Model : Any, Msg : Any, Props : Any>(
        init: Init<Model, Msg>,
        private val update: Update<Model, Msg>,
        private val view: View<Model, Props>,
        private val render: Render<Msg, Props>,
        private val mainDispatcher: MainCoroutineDispatcher
    ) : CoroutineScope {

        private lateinit var currentState: Model

        override val coroutineContext: CoroutineContext
            get() = mainDispatcher + SupervisorJob()

        init {
            launch { step(init()) }
        }

        private fun dispatch(msg: Msg) {
            if (isActive) {
                launch { step(update(msg, currentState)) }
            }
        }

        private fun step(next: Next<Model, Msg>) {
            val (state, effect) = next
            val props = view(state)
            currentState = state
            launch { render(props, ::dispatch) }
            launch(Dispatchers.Default) { effect(::dispatch) }
        }

        fun dispose() {
            if (isActive) {
                cancel()
            }
        }

    }

}
