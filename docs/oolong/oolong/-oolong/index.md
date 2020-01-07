[oolong](../../index.md) / [oolong](../index.md) / [Oolong](./index.md)

# Oolong

(common) `object Oolong` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/Oolong.kt#L13)

Oolong runtime module.

### Functions

| Name | Summary |
|---|---|
| (common) [runtime](runtime.md) | Create a runtime.`fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Props : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> runtime(init: `[`Init`](../-init.md)`<Model, Msg>, update: `[`Update`](../-update.md)`<Model, Msg>, view: `[`View`](../-view.md)`<Model, Props>, render: `[`Render`](../-render.md)`<Msg, Props>, runtimeScope: CoroutineScope = GlobalScope, effectContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)` = Dispatchers.Default, renderContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)` = Dispatchers.Main): `[`Dispose`](../-dispose.md) |
