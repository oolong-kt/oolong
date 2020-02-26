package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Oolong runtime module.
 */
object Oolong {

    @Deprecated(
        """
        User defined coroutine scope and context have been deprecated and are ignored. Execution context can be changed 
        using withContext in an Effect block. 
        """,
        ReplaceWith("runtime(init, update, view, render)", "oolong.Oolong.runtime")
    )
    fun <Model : Any, Msg : Any, Props : Any> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Msg, Props>,
        runtimeScope: CoroutineScope = GlobalScope,
        effectContext: CoroutineContext = Dispatchers.Default,
        renderContext: CoroutineContext = Dispatchers.Main
    ) = runtime(init, update, view, render)

    /**
     * Create a runtime.
     */
    fun <Model : Any, Msg : Any, Props : Any> runtime(
        init: Init<Model, Msg>,
        update: Update<Model, Msg>,
        view: View<Model, Props>,
        render: Render<Msg, Props>
    ): Dispose {
        val runtime = Runtime(init, update, view, render)
        return { runtime.dispose() }
    }

    private class Runtime<Model : Any, Msg : Any, Props : Any>(
        init: Init<Model, Msg>,
        private val update: Update<Model, Msg>,
        private val view: View<Model, Props>,
        private val render: Render<Msg, Props>
    ) : CoroutineScope {

        private lateinit var currentState: Model

        override val coroutineContext: CoroutineContext
            get() = Dispatchers.Main + SupervisorJob()

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
