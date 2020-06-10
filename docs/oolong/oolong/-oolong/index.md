[oolong](../../index.md) / [oolong](../index.md) / [Oolong](./index.md)

# Oolong

(common) `object Oolong` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/Oolong.kt#L16)

Oolong runtime module.

### Functions

| Name | Summary |
|---|---|
| (common) [runtime](runtime.md) | Create a runtime.`fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Props : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> runtime(init: `[`Init`](../-init.md)`<Model, Msg>, update: `[`Update`](../-update.md)`<Model, Msg>, view: `[`View`](../-view.md)`<Model, Props>, render: `[`Render`](../-render.md)`<Msg, Props>, runtimeDispatcher: CoroutineDispatcher = Dispatchers.Default, renderDispatcher: CoroutineDispatcher = Dispatchers.Main, effectDispatcher: CoroutineDispatcher = Dispatchers.Default): `[`Dispose`](../-dispose.md) |
