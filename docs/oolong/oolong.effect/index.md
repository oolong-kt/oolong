[oolong](../index.md) / [oolong.effect](./index.md)

## Package oolong.effect

### Functions

| Name | Summary |
|---|---|
| (common) [batch](batch.md) | Compose a collection of [Effect](../oolong/-effect.md) into a single [Effect](../oolong/-effect.md).`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> batch(vararg effects: `[`Effect`](../oolong/-effect.md)`<Msg>): `[`Effect`](../oolong/-effect.md)`<Msg>`<br>`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> batch(effects: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Effect`](../oolong/-effect.md)`<Msg>>): `[`Effect`](../oolong/-effect.md)`<Msg>` |
| (common) [disposableEffect](disposable-effect.md) | Create a [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html) of [Effect](../oolong/-effect.md) and [Dispose](../oolong/-dispose.md).`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> disposableEffect(effect: `[`Effect`](../oolong/-effect.md)`<Msg>): `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Effect`](../oolong/-effect.md)`<Msg>, `[`Dispose`](../oolong/-dispose.md)`>` |
| (common) [map](map.md) | Map from [Effect](../oolong/-effect.md) of [A](map.md#A) to [Effect](../oolong/-effect.md) of [B](map.md#B)`fun <A : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, B : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> map(effect: `[`Effect`](../oolong/-effect.md)`<A>, f: (A) -> B): `[`Effect`](../oolong/-effect.md)`<B>` |
| (common) [none](none.md) | Create an empty [Effect](../oolong/-effect.md).`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> none(): `[`Effect`](../oolong/-effect.md)`<Msg>` |
