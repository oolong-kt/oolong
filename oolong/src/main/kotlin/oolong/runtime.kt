package oolong

import oolong.platform.Cmd
import oolong.platform.Sub

typealias Dispatch<Msg> = (Msg) -> Unit

fun <Model, Msg> runtime(
    init: () -> Pair<Model, Cmd<Msg>>,
    update: (Msg, Model) -> Pair<Model, Cmd<Msg>>,
    view: (Model, Dispatch<Msg>) -> Unit,
    subscriptions: (Model) -> Sub<Msg> = { Sub.none() }
): () -> Unit {
    val runtimeThread = Thread.currentThread()
    var running = true
    fun reduce(update: Pair<Model, Cmd<Msg>>) {
        if (!running) return
        if (Thread.currentThread() != runtimeThread) {
            throw IllegalThreadStateException(
                "Dispatch function must be invoked from $runtimeThread but was invoked from ${Thread.currentThread()}."
            )
        }
        val (model, eff) = update
        val dispatch = { msg: Msg -> reduce(update(msg, model)) }
        eff(dispatch)
        subscriptions(model)(dispatch)
        view(model, dispatch)
    }
    reduce(init())
    return { running = false }
}
