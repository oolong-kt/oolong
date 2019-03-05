[oolong](../index.md) / [oolong.util.effect](index.md) / [withoutEffects](./without-effects.md)

# withoutEffects

`fun <Model, Msg> withoutEffects(init: () -> `[`Model`](without-effects.md#Model)`): `[`Init`](../oolong/-init.md)`<`[`Model`](without-effects.md#Model)`, `[`Msg`](without-effects.md#Msg)`>`

Create an [Init](../oolong/-init.md) function with no effects.

`fun <Model, Msg> withoutEffects(init: (msg: `[`Msg`](without-effects.md#Msg)`, model: `[`Model`](without-effects.md#Model)`) -> `[`Model`](without-effects.md#Model)`): `[`Update`](../oolong/-update.md)`<`[`Model`](without-effects.md#Model)`, `[`Msg`](without-effects.md#Msg)`>`

Create an [Update](../oolong/-update.md) function with no effects.

