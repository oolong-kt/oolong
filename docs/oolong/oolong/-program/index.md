[oolong](../../index.md) / [oolong](../index.md) / [Program](./index.md)

# Program

`interface Program<Model, Msg, Props> : `[`Component`](../-component/index.md)`<`[`Model`](index.md#Model)`, `[`Msg`](index.md#Msg)`, `[`Props`](index.md#Props)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/Program.kt#L6)

An interface to encapsulate the requirements of an Oolong runtime.

### Functions

| Name | Summary |
|---|---|
| [init](init.md) | `abstract fun init(): <ERROR CLASS><`[`Model`](../-next.md#Model)`, `[`Effect`](../-effect.md)`<`[`Msg`](../-next.md#Msg)`>>`<br>Creates an initial state and side-effects |

### Inherited Functions

| Name | Summary |
|---|---|
| [update](../-component/update.md) | `abstract fun update(msg: `[`Msg`](../-component/index.md#Msg)`, model: `[`Model`](../-component/index.md#Model)`): <ERROR CLASS><`[`Model`](../-next.md#Model)`, `[`Effect`](../-effect.md)`<`[`Msg`](../-next.md#Msg)`>>`<br>Creates a next state and side-effects from a message and current state |
| [view](../-component/view.md) | `abstract fun view(model: `[`Model`](../-component/index.md#Model)`): `[`Props`](../-component/index.md#Props)<br>Creates view properties from the current state |
