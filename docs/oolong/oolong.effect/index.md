[oolong](../index.md) / [oolong.effect](./index.md)

## Package oolong.effect

### Functions

| Name | Summary |
|---|---|
| [batch](batch.md) | `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> batch(vararg effects: `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>`<br>`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> batch(effects: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>`<br>Compose a collection of [Effect](../oolong/-effect.md) into a single [Effect](../oolong/-effect.md). |
| [disposableEffect](disposable-effect.md) | `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> disposableEffect(effect: `[`Effect`](../oolong/-effect.md)`<`[`Msg`](disposable-effect.md#Msg)`>): <ERROR CLASS><`[`Effect`](../oolong/-effect.md)`<`[`Msg`](disposable-effect.md#Msg)`>, `[`Dispose`](../oolong/-dispose.md)`>`<br>Create a [Pair](#) of [Effect](../oolong/-effect.md) and [Dispose](../oolong/-dispose.md). |
| [map](map.md) | `fun <A : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, B : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> map(effect: `[`Effect`](../oolong/-effect.md)`<`[`A`](map.md#A)`>, f: (`[`A`](map.md#A)`) -> `[`B`](map.md#B)`): `[`Effect`](../oolong/-effect.md)`<`[`B`](map.md#B)`>`<br>Map from [Effect](../oolong/-effect.md) of [A](map.md#A) to [Effect](../oolong/-effect.md) of [B](map.md#B) |
| [none](none.md) | `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> none(): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](none.md#Msg)`>`<br>Create an empty [Effect](../oolong/-effect.md). |
