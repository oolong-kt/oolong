[oolong](../index.md) / [oolong.effect](index.md) / [withoutEffects](./without-effects.md)

# withoutEffects

`fun <Model, Msg> withoutEffects(init: () -> `[`Model`](without-effects.md#Model)`): `[`Init`](../oolong/-init.md)`<`[`Model`](without-effects.md#Model)`, `[`Msg`](without-effects.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/effect/util.kt#L32)

Create an [Init](../oolong/-init.md) function with no effects.

`fun <Model, Msg> withoutEffects(init: (msg: `[`Msg`](without-effects.md#Msg)`, model: `[`Model`](without-effects.md#Model)`) -> `[`Model`](without-effects.md#Model)`): `[`Update`](../oolong/-update.md)`<`[`Model`](without-effects.md#Model)`, `[`Msg`](without-effects.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/effect/util.kt#L38)

Create an [Update](../oolong/-update.md) function with no effects.

