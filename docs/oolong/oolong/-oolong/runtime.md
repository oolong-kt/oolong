[oolong](../../index.md) / [oolong](../index.md) / [Oolong](index.md) / [runtime](./runtime.md)

# runtime

`fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Props : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> runtime(init: `[`Init`](../-init.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`>, update: `[`Update`](../-update.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`>, view: `[`View`](../-view.md)`<`[`Model`](runtime.md#Model)`, `[`Props`](runtime.md#Props)`>, render: `[`Render`](../-render.md)`<`[`Msg`](runtime.md#Msg)`, `[`Props`](runtime.md#Props)`>, runtimeScope: <ERROR CLASS> = GlobalScope, effectContext: <ERROR CLASS> = Dispatchers.Default, renderContext: <ERROR CLASS> = Dispatchers.Main): `[`Dispose`](../-dispose.md) [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/Oolong.kt#L19)

Create a runtime.

