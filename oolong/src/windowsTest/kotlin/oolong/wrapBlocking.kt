package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual fun wrapBlocking(block: suspend CoroutineScope.() -> Unit) {
    runBlocking { block() }
}

