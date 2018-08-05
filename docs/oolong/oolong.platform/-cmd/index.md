[oolong](../../index.md) / [oolong.platform](../index.md) / [Cmd](./index.md)

# Cmd

`class Cmd<Msg>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/platform/Cmd.kt#L5)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Cmd(block: (`[`Dispatch`](../../oolong/-dispatch.md)`<`[`Msg`](index.md#Msg)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | `operator fun invoke(dispatch: `[`Dispatch`](../../oolong/-dispatch.md)`<`[`Msg`](index.md#Msg)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [batch](batch.md) | `fun <Msg> batch(vararg cmds: `[`Cmd`](./index.md)`<`[`Msg`](batch.md#Msg)`>): `[`Cmd`](./index.md)`<`[`Msg`](batch.md#Msg)`>`<br>`fun <Msg> batch(cmds: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Cmd`](./index.md)`<`[`Msg`](batch.md#Msg)`>>): `[`Cmd`](./index.md)`<`[`Msg`](batch.md#Msg)`>` |
| [none](none.md) | `fun <Msg> none(): `[`Cmd`](./index.md)`<`[`Msg`](none.md#Msg)`>` |
