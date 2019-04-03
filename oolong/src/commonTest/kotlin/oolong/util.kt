package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay

fun runTest(block: suspend (resolve: () -> Unit) -> Unit) {
    wrapBlocking {
        var resolved = false
        block { resolved = true }
        while (!resolved) {
            delay(10)
        }
    }
}

expect fun wrapBlocking(block: suspend CoroutineScope.() -> Unit)
