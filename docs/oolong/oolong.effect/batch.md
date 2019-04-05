[oolong](../index.md) / [oolong.effect](index.md) / [batch](./batch.md)

# batch

`fun <Msg> batch(vararg effects: `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/effect/util.kt#L18)
`fun <Msg> batch(effects: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/effect/util.kt#L26)

Compose a list of effects into a single effect.

### Parameters

`effects` - a list of effects