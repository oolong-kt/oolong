[oolong](../index.md) / [oolong.effect](./index.md)

## Package oolong.effect

### Functions

| Name | Summary |
|---|---|
| [batch](batch.md) | `fun <Msg> batch(vararg effects: `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>`<br>`fun <Msg> batch(effects: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>`<br>Compose a list of effects into a single effect. |
| [map](map.md) | `fun <A, Msg> map(effect: `[`Effect`](../oolong/-effect.md)`<`[`A`](map.md#A)`>, f: (`[`A`](map.md#A)`) -> `[`Msg`](map.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](map.md#Msg)`>`<br>Map from [Effect](../oolong/-effect.md) of [A](map.md#A) to [Effect](../oolong/-effect.md) of [Msg](map.md#Msg) |
| [none](none.md) | `fun <Msg> none(): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](none.md#Msg)`>`<br>Create an empty effect. |
