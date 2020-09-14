package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmOverloads

/**
 * Create a runtime.
 */
@JvmOverloads
fun <Model, Msg> runtime(
    init: () -> Pair<Model, Effect<Msg>>,
    update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
    view: (Model, Dispatch<Msg>) -> Any?,
    runtimeContext: CoroutineContext = Dispatchers.Default,
    renderContext: CoroutineContext = Dispatchers.Main,
    effectContext: CoroutineContext = Dispatchers.Default
): Job = runtime(init, update, { it }, view, runtimeContext, renderContext, effectContext)

/**
 * Create a runtime.
 */
@JvmOverloads
fun <Model, Msg, Props> runtime(
    init: () -> Pair<Model, Effect<Msg>>,
    update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
    view: (Model) -> Props,
    render: (Props, Dispatch<Msg>) -> Any?,
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
@Deprecated("To be removed in the next minor release")
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
    fun <Model, Msg, Props> runtime(
        init: () -> Pair<Model, Effect<Msg>>,
        update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
        view: (Model) -> Props,
        render: (Props, Dispatch<Msg>) -> Any?,
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

private class RuntimeImpl<Model, Msg, Props>(
    init: () -> Pair<Model, Effect<Msg>>,
    private val update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
    private val view: (Model) -> Props,
    private val render: (Props, Dispatch<Msg>) -> Any?,
    private val runtimeContext: CoroutineContext,
    private val renderContext: CoroutineContext,
    private val effectContext: CoroutineContext
) : CoroutineScope {

    val job: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = runtimeContext + job

    private var currentState: Model

    init {
        val initNext = init()
        currentState = initNext.first
        launch(runtimeContext) { step(initNext) }
    }

    private fun dispatch(msg: Msg) {
        if (isActive) {
            launch(runtimeContext) { step(update(msg, currentState)) }
        }
    }

    private fun step(next: Pair<Model, Effect<Msg>>) {
        val (state, effect) = next
        val props = view(state)
        currentState = state
        launch(renderContext) { render(props, ::dispatch) }
        launch(effectContext) { effect(::dispatch) }
    }

}
