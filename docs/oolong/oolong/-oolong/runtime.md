[oolong](../../index.md) / [oolong](../index.md) / [Oolong](index.md) / [runtime](./runtime.md)

# runtime

(common) `@JvmOverloads fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Props : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> runtime(init: `[`Init`](../-init.md)`<Model, Msg>, update: `[`Update`](../-update.md)`<Model, Msg>, view: `[`View`](../-view.md)`<Model, Props>, render: `[`Render`](../-render.md)`<Msg, Props>, runtimeDispatcher: CoroutineDispatcher = Dispatchers.Default, renderDispatcher: CoroutineDispatcher = Dispatchers.Main, effectDispatcher: CoroutineDispatcher = Dispatchers.Default): `[`Dispose`](../-dispose.md) [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/Oolong.kt#L22)

Create a runtime.

