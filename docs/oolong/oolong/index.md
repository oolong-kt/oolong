[oolong](../index.md) / [oolong](./index.md)

## Package oolong

The Oolong runtime.

### Type Aliases

| Name | Summary |
|---|---|
| [Dispatch](-dispatch.md) | `typealias Dispatch<Msg> = (`[`Msg`](-dispatch.md#Msg)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [runtime](runtime.md) | `fun <Model, Msg> runtime(init: () -> `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Model`](runtime.md#Model)`, `[`Cmd`](../oolong.platform/-cmd/index.md)`<`[`Msg`](runtime.md#Msg)`>>, update: (`[`Msg`](runtime.md#Msg)`, `[`Model`](runtime.md#Model)`) -> `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Model`](runtime.md#Model)`, `[`Cmd`](../oolong.platform/-cmd/index.md)`<`[`Msg`](runtime.md#Msg)`>>, view: (`[`Model`](runtime.md#Model)`, `[`Dispatch`](-dispatch.md)`<`[`Msg`](runtime.md#Msg)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, subscriptions: (`[`Model`](runtime.md#Model)`) -> `[`Sub`](../oolong.platform/-sub/index.md)`<`[`Msg`](runtime.md#Msg)`> = { Sub.none() }): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
