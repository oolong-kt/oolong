[oolong](../../../index.md) / [oolong](../../index.md) / [Oolong](../index.md) / [MainRuntime](./index.md)

# MainRuntime

`abstract class MainRuntime`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MainRuntime()` |

### Functions

| Name | Summary |
|---|---|
| [runtime](runtime.md) | `fun <Model, Msg, Props> runtime(init: `[`Init`](../../-init.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`>, update: `[`Update`](../../-update.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`>, view: `[`View`](../../-view.md)`<`[`Model`](runtime.md#Model)`, `[`Msg`](runtime.md#Msg)`, `[`Props`](runtime.md#Props)`>, render: `[`Render`](../../-render.md)`<`[`Props`](runtime.md#Props)`>, runtimeScope: <ERROR CLASS> = GlobalScope, effectContext: <ERROR CLASS> = Dispatchers.Default): `[`Dispose`](../../-dispose.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Android](../-android.md) | `object Android : `[`MainRuntime`](./index.md) |
| [JavaFX](../-java-f-x.md) | `object JavaFX : `[`MainRuntime`](./index.md) |
| [Swing](../-swing.md) | `object Swing : `[`MainRuntime`](./index.md) |
