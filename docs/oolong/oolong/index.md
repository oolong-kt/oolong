[oolong](../index.md) / [oolong](./index.md)

## Package oolong

The Oolong runtime and types.

### Types

| Name | Summary |
|---|---|
| [Oolong](-oolong/index.md) | `object Oolong` |
| [Program](-program/index.md) | `interface Program<Model, Msg, Props>`<br>An interface to encapsulate the requirements of an Oolong runtime. |

### Type Aliases

| Name | Summary |
|---|---|
| [Dispatch](-dispatch.md) | `typealias Dispatch<Msg> = (msg: `[`Msg`](-dispatch.md#Msg)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispatches a message to the runtime |
| [Dispose](-dispose.md) | `typealias Dispose = () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Stops the function and cleans up resources |
| [Effect](-effect.md) | `typealias Effect<Msg> = (dispatch: `[`Dispatch`](-dispatch.md)`<`[`Msg`](-effect.md#Msg)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Runs a side-effect away from the runtime |
| [Init](-init.md) | `typealias Init<Model, Msg> = () -> `[`Next`](-next.md)`<`[`Model`](-init.md#Model)`, `[`Msg`](-init.md#Msg)`>`<br>Creates an initial state and side-effects |
| [Next](-next.md) | `typealias Next<Model, Msg> = <ERROR CLASS><`[`Model`](-next.md#Model)`, `[`Effect`](-effect.md)`<`[`Msg`](-next.md#Msg)`>>`<br>A pair of the next state and side-effects |
| [Render](-render.md) | `typealias Render<Msg, Props> = (props: `[`Props`](-render.md#Props)`, dispatch: `[`Dispatch`](-dispatch.md)`<`[`Msg`](-render.md#Msg)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Renders the view properties |
| [Update](-update.md) | `typealias Update<Model, Msg> = (msg: `[`Msg`](-update.md#Msg)`, model: `[`Model`](-update.md#Model)`) -> `[`Next`](-next.md)`<`[`Model`](-update.md#Model)`, `[`Msg`](-update.md#Msg)`>`<br>Creates a next state and side-effects from a message and current state |
| [View](-view.md) | `typealias View<Model, Props> = (model: `[`Model`](-view.md#Model)`) -> `[`Props`](-view.md#Props)<br>Creates view properties from the current state |
