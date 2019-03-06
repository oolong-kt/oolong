[oolong](../../index.md) / [oolong](../index.md) / [Program](./index.md)

# Program

`interface Program<Model, Msg, Props>`

An interface to encapsulate the requirements of an Oolong runtime.

### Functions

| Name | Summary |
|---|---|
| [init](init.md) | `abstract fun init(): <ERROR CLASS><`[`Model`](../-next.md#Model)`, `[`Effect`](../-effect.md)`<`[`Msg`](../-next.md#Msg)`>>`<br>Creates an initial state and side-effects |
| [update](update.md) | `abstract fun update(msg: `[`Msg`](index.md#Msg)`, model: `[`Model`](index.md#Model)`): <ERROR CLASS><`[`Model`](../-next.md#Model)`, `[`Effect`](../-effect.md)`<`[`Msg`](../-next.md#Msg)`>>`<br>Creates a next state and side-effects from a message and current state |
| [view](view.md) | `abstract fun view(model: `[`Model`](index.md#Model)`, dispatch: `[`Dispatch`](../-dispatch.md)`<`[`Msg`](index.md#Msg)`>): `[`Props`](index.md#Props)<br>Creates view properties from the current state |
