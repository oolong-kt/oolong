[oolong](../index.md) / [oolong.effect](index.md) / [batch](./batch.md)

# batch

(common) `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> batch(vararg effects: `[`Effect`](../oolong/-effect.md)`<Msg>): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/effect/util.kt#L20)
`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> batch(effects: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Effect`](../oolong/-effect.md)`<Msg>>): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/effect/util.kt#L28)

Compose a collection of [Effect](../oolong/-effect.md) into a single [Effect](../oolong/-effect.md).

### Parameters

`effects` - a list of effects