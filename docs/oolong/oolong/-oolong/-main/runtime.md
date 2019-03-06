[oolong](../../../index.md) / [oolong](../../index.md) / [Oolong](../index.md) / [Main](index.md) / [runtime](./runtime.md)

# runtime

`fun <Model, Msg, Props> runtime(program: `[`Program`](../../-program/index.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`, `[`Props`](runtime.md#Props)`>, render: `[`Render`](../../-render.md)`<`[`Props`](runtime.md#Props)`>, runtimeScope: <ERROR CLASS> = GlobalScope, effectContext: <ERROR CLASS> = Dispatchers.Default): `[`Dispose`](../../-dispose.md)
`fun <Model, Msg, Props> runtime(init: `[`Init`](../../-init.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`>, update: `[`Update`](../../-update.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`>, view: `[`View`](../../-view.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`, `[`Props`](runtime.md#Props)`>, render: `[`Render`](../../-render.md)`<`[`Props`](runtime.md#Props)`>, runtimeScope: <ERROR CLASS> = GlobalScope, effectContext: <ERROR CLASS> = Dispatchers.Default): `[`Dispose`](../../-dispose.md)

Create a runtime with a render [CoroutineContext](#) of [Dispatchers.Main](#).

