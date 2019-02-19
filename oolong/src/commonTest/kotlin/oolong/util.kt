package oolong

import kotlinx.coroutines.CoroutineScope

fun <Model, Msg, Props> CoroutineScope.testRuntime(
    init: Init<Model, Msg>,
    update: Update<Model, Msg>,
    view: View<Model, Msg, Props>,
    render: Render<Props>
) = Oolong.runtime(init, update, view, render, this, coroutineContext)
