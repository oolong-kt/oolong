[oolong](../../../index.md) / [oolong](../../index.md) / [Oolong](../index.md) / [Main](./index.md)

# Main

`object Main` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/Oolong.kt#L57)

### Functions

| Name | Summary |
|---|---|
| [program](program.md) | `fun <Model, Msg, Props> program(program: `[`Program`](../../-program/index.md)`<`[`Model`](program.md#Model)`, `[`Msg`](program.md#Msg)`, `[`Props`](program.md#Props)`>, render: `[`Render`](../../-render.md)`<`[`Msg`](program.md#Msg)`, `[`Props`](program.md#Props)`>, runtimeScope: <ERROR CLASS> = GlobalScope, effectContext: <ERROR CLASS> = Dispatchers.Default): `[`Dispose`](../../-dispose.md)<br>Create a runtime with a render [CoroutineContext](#) of [Dispatchers.Main](#). |
| [runtime](runtime.md) | `fun <Model, Msg, Props> runtime(init: `[`Init`](../../-init.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`>, update: `[`Update`](../../-update.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`>, view: `[`View`](../../-view.md)`<`[`Model`](runtime.md#Model)`, `[`Props`](runtime.md#Props)`>, render: `[`Render`](../../-render.md)`<`[`Msg`](runtime.md#Msg)`, `[`Props`](runtime.md#Props)`>, runtimeScope: <ERROR CLASS> = GlobalScope, effectContext: <ERROR CLASS> = Dispatchers.Default): `[`Dispose`](../../-dispose.md)<br>Create a runtime with a render [CoroutineContext](#) of [Dispatchers.Main](#). |
