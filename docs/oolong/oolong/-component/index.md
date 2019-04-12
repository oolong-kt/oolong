[oolong](../../index.md) / [oolong](../index.md) / [Component](./index.md)

# Component

`interface Component<Model, Msg, Props>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/Component.kt#L6)

An interface to encapsulate the requirements of a compositional child in a [Program](../-program/index.md).

### Functions

| Name | Summary |
|---|---|
| [update](update.md) | `abstract fun update(msg: `[`Msg`](index.md#Msg)`, model: `[`Model`](index.md#Model)`): <ERROR CLASS><`[`Model`](../-next.md#Model)`, `[`Effect`](../-effect.md)`<`[`Msg`](../-next.md#Msg)`>>`<br>Creates a next state and side-effects from a message and current state |
| [view](view.md) | `abstract fun view(model: `[`Model`](index.md#Model)`): `[`Props`](index.md#Props)<br>Creates view properties from the current state |

### Inheritors

| Name | Summary |
|---|---|
| [Program](../-program/index.md) | `interface Program<Model, Msg, Props> : `[`Component`](./index.md)`<`[`Model`](../-program/index.md#Model)`, `[`Msg`](../-program/index.md#Msg)`, `[`Props`](../-program/index.md#Props)`>`<br>An interface to encapsulate the requirements of an Oolong runtime. |
