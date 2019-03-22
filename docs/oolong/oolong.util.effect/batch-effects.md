[oolong](../index.md) / [oolong.util.effect](index.md) / [batchEffects](./batch-effects.md)

# batchEffects

`fun <Msg> batchEffects(vararg effects: `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/effect/util.kt#L18)
`fun <Msg> batchEffects(effects: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/effect/util.kt#L26)

Compose a list of effects into a single effect.

### Parameters

`effects` - a list of effects