package oolong

import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmOverloads
import kotlinx.coroutines.*

internal const val DEPRECATION_MESSAGE_DISPATCH_RELOCATED =
    "The dispatch function should now be accessed via the view function. It will be removed from the render function in a future release."

/** Create a runtime. */
@JvmOverloads
@Deprecated(DEPRECATION_MESSAGE_DISPATCH_RELOCATED)
fun <Model, Msg> runtime(
    init: () -> Pair<Model, Effect<Msg>>,
    update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
    view: (Model, Dispatch<Msg>) -> Any?,
    runtimeContext: CoroutineContext = Dispatchers.Default,
    renderContext: CoroutineContext = Dispatchers.Main,
    effectContext: CoroutineContext = Dispatchers.Default,
): Job {
    val runtime =
        RuntimeImpl(
            init,
            update,
            view,
            { _, _ -> },
            runtimeContext,
            renderContext,
            effectContext,
        )
    return runtime.job
}

/** Create a runtime. */
@JvmOverloads
@Deprecated(DEPRECATION_MESSAGE_DISPATCH_RELOCATED)
fun <Model, Msg, Props> runtime(
    init: () -> Pair<Model, Effect<Msg>>,
    update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
    view: (Model) -> Props,
    render: (Props, Dispatch<Msg>) -> Any?,
    runtimeContext: CoroutineContext = Dispatchers.Default,
    renderContext: CoroutineContext = Dispatchers.Main,
    effectContext: CoroutineContext = Dispatchers.Default,
): Job {
    val runtime =
        RuntimeImpl(
            init,
            update,
            { model, _ -> view(model) },
            render,
            runtimeContext,
            renderContext,
            effectContext,
        )
    return runtime.job
}

/** Create a runtime. */
@JvmOverloads
fun <Model, Msg, Props> runtime(
    init: () -> Pair<Model, Effect<Msg>>,
    update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
    view: (Model, Dispatch<Msg>) -> Props,
    render: (Props) -> Any?,
    runtimeContext: CoroutineContext = Dispatchers.Default,
    renderContext: CoroutineContext = Dispatchers.Main,
    effectContext: CoroutineContext = Dispatchers.Default,
): Job {
    val runtime =
        RuntimeImpl(
            init,
            update,
            view,
            { model, _ -> render(model) },
            runtimeContext,
            renderContext,
            effectContext,
        )
    return runtime.job
}

private class RuntimeImpl<Model, Msg, Props>(
    init: () -> Pair<Model, Effect<Msg>>,
    private val update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
    private val view: (Model, Dispatch<Msg>) -> Props,
    private val render: (Props, Dispatch<Msg>) -> Any?,
    private val runtimeContext: CoroutineContext,
    private val renderContext: CoroutineContext,
    private val effectContext: CoroutineContext,
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
        val props = view(state, ::dispatch)
        currentState = state
        launch(renderContext) { render(props, ::dispatch) }
        launch(effectContext) { effect(::dispatch) }
    }
}
