[oolong](../index.md) / [oolong.util.effect](./index.md)

## Package oolong.util.effect

Utility functions for creating effects.

### Functions

| Name | Summary |
|---|---|
| [batchEffects](batch-effects.md) | `fun <Msg> batchEffects(vararg effects: `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>`<br>`fun <Msg> batchEffects(effects: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>`<br>Compose a list of effects into a single effect. |
| [noEffect](no-effect.md) | `fun <Msg> noEffect(): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](no-effect.md#Msg)`>`<br>Create an empty effect. |
| [withoutEffects](without-effects.md) | `fun <Model, Msg> withoutEffects(init: () -> `[`Model`](without-effects.md#Model)`): `[`Init`](../oolong/-init.md)`<`[`Model`](without-effects.md#Model)`, `[`Msg`](without-effects.md#Msg)`>`<br>Create an [Init](../oolong/-init.md) function with no effects.`fun <Model, Msg> withoutEffects(init: (msg: `[`Msg`](without-effects.md#Msg)`, model: `[`Model`](without-effects.md#Model)`) -> `[`Model`](without-effects.md#Model)`): `[`Update`](../oolong/-update.md)`<`[`Model`](without-effects.md#Model)`, `[`Msg`](without-effects.md#Msg)`>`<br>Create an [Update](../oolong/-update.md) function with no effects. |
