[oolong](../index.md) / [oolong.effect](./index.md)

## Package oolong.effect

### Functions

| Name | Summary |
|---|---|
| [batchEffects](batch-effects.md) | `fun <Msg> batchEffects(vararg effects: `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>`<br>`fun <Msg> batchEffects(effects: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>>): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](batch-effects.md#Msg)`>`<br>Compose a list of effects into a single effect. |
| [map](map.md) | `fun <A, Msg> map(effect: `[`Effect`](../oolong/-effect.md)`<`[`A`](map.md#A)`>, f: (`[`A`](map.md#A)`) -> `[`Msg`](map.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](map.md#Msg)`>`<br>Map from [Effect](../oolong/-effect.md) of [A](map.md#A) to [Effect](../oolong/-effect.md) of [Msg](map.md#Msg) |
| [noEffect](no-effect.md) | `fun <Msg> noEffect(): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](no-effect.md#Msg)`>`<br>Create an empty effect. |
| [withoutEffects](without-effects.md) | `fun <Model, Msg> withoutEffects(init: () -> `[`Model`](without-effects.md#Model)`): `[`Init`](../oolong/-init.md)`<`[`Model`](without-effects.md#Model)`, `[`Msg`](without-effects.md#Msg)`>`<br>Create an [Init](../oolong/-init.md) function with no effects.`fun <Model, Msg> withoutEffects(init: (msg: `[`Msg`](without-effects.md#Msg)`, model: `[`Model`](without-effects.md#Model)`) -> `[`Model`](without-effects.md#Model)`): `[`Update`](../oolong/-update.md)`<`[`Model`](without-effects.md#Model)`, `[`Msg`](without-effects.md#Msg)`>`<br>Create an [Update](../oolong/-update.md) function with no effects. |
