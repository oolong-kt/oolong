package oolong

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

actual fun wrapBlocking(block: suspend CoroutineScope.() -> Unit) {
    GlobalScope.promise { block() }
}
