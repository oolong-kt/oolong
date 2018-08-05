[oolong](../../index.md) / [oolong.platform](../index.md) / [Sub](./index.md)

# Sub

`class Sub<Msg>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/platform/Sub.kt#L5)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Sub(block: (`[`Dispatch`](../../oolong/-dispatch.md)`<`[`Msg`](index.md#Msg)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | `operator fun invoke(dispatch: `[`Dispatch`](../../oolong/-dispatch.md)`<`[`Msg`](index.md#Msg)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [batch](batch.md) | `fun <Msg> batch(vararg subs: `[`Sub`](./index.md)`<`[`Msg`](batch.md#Msg)`>): `[`Sub`](./index.md)`<`[`Msg`](batch.md#Msg)`>`<br>`fun <Msg> batch(effs: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Sub`](./index.md)`<`[`Msg`](batch.md#Msg)`>>): `[`Sub`](./index.md)`<`[`Msg`](batch.md#Msg)`>` |
| [none](none.md) | `fun <Msg> none(): `[`Sub`](./index.md)`<`[`Msg`](none.md#Msg)`>` |
