package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.test.fail

expect fun <T> runBlocking(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> T
)

fun test(
    timeout: Long = 1000,
    step: Long = 10,
    block: (resolve: () -> Unit) -> Any?
) {
    runBlocking {
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