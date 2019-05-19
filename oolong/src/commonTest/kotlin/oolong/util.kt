package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlin.test.fail

fun <Model : Any, Msg : Any, Props : Any> runtime(
    init: Init<Model, Msg>,
    update: Update<Model, Msg>,
    view: View<Model, Props>,
    render: Render<Msg, Props>
) = Oolong.runtime(init, update, view, render, GlobalScope, Dispatchers.Default, Dispatchers.Default)

fun runTest(timeout: Long = 1000, step: Long = 10, block: suspend CoroutineScope.(resolve: () -> Unit) -> Unit) {
    wrapBlocking {
        var elapsed = 0L
        var resolved = false
        block { resolved = true }
        while (!resolved) {
            delay(step)
            elapsed += step
            if (elapsed >= timeout) {
                fail("Test exceeded max execution time of $timeout ms.")
            }
        }
    }
}

expect fun wrapBlocking(block: suspend CoroutineScope.() -> Unit)
