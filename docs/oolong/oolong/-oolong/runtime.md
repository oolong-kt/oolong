[oolong](../../index.md) / [oolong](../index.md) / [Oolong](index.md) / [runtime](./runtime.md)

# runtime

(common) `fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Props : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> ~~runtime~~(init: `[`Init`](../-init.md)`<Model, Msg>, update: `[`Update`](../-update.md)`<Model, Msg>, view: `[`View`](../-view.md)`<Model, Props>, render: `[`Render`](../-render.md)`<Msg, Props>, runtimeScope: CoroutineScope = GlobalScope, effectContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)` = Dispatchers.Default, renderContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)` = Dispatchers.Main): `[`Dispose`](../-dispose.md) [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/Oolong.kt#L24)
**Deprecated:** \n        User defined coroutine scope and context have been deprecated and are ignored. Execution context can be changed \n        using withContext in an Effect block. \n

(common) `fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Props : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> runtime(init: `[`Init`](../-init.md)`<Model, Msg>, update: `[`Update`](../-update.md)`<Model, Msg>, view: `[`View`](../-view.md)`<Model, Props>, render: `[`Render`](../-render.md)`<Msg, Props>): `[`Dispose`](../-dispose.md) [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/Oolong.kt#L37)

Create a runtime.

