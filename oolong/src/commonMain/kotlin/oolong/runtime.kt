package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import oolong.dispatch.Dispatch
import oolong.next.Next
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmOverloads

// Types

/**
 * Creates an initial state and side-effects
 */
typealias Init<Model, Msg> = () -> Next<Model, Msg>

/**
 * Creates a next state and side-effects from a message and current state
 */
typealias Update<Model, Msg> = (Msg, Model) -> Next<Model, Msg>

/**
 * Creates view properties from the current state
 */
typealias View<Model, Props> = (Model) -> Props

/**
 * Renders the view properties
 */
typealias Render<Msg, Props> = (Props, Dispatch<Msg>) -> Any?

// Builders

/**
 * [Init] builder function.
 */
fun <Model : Any, Msg : Any> init(block: Init<Model, Msg>): Init<Model, Msg> = block

/**
 * [Update] builder function.
 */
fun <Model : Any, Msg : Any> update(block: Update<Model, Msg>): Update<Model, Msg> = block

/**
 * [View] builder function.
 */
fun <Model : Any, Props : Any> view(block: View<Model, Props>): View<Model, Props> = block

/**
 * [Render] builder function.
 */
fun <Props : Any, Msg : Any> render(block: Render<Props, Msg>): Render<Props, Msg> = block

// Runtime

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
): Job {
    val runtime = RuntimeImpl(
        init, update, view, render,
        runtimeContext, renderContext, effectContext
    )
    return runtime.job
}

/**
 * Oolong runtime module.
 */
object Oolong {
    /**
     * Create a runtime.
     */
    @JvmOverloads
    @Deprecated(
        "Use oolong.runtime(init, update, view, render, runtimeContext, renderContext, effectContext) instead",
        ReplaceWith(
            "oolong.runtime(init, update, view, render, runtimeContext, renderContext, effectContext)",
            "oolong"
        )
    )
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
        return { runtime.job.cancel() }
    }

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

    val job: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = runtimeContext + job

    private lateinit var currentState: Model

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

}
