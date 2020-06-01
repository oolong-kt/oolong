package oolong

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

actual fun <T> runBlocking(
    context: CoroutineContext,
    block: suspend CoroutineScope.() -> T
) {
    GlobalScope.async { block(this) }
}
