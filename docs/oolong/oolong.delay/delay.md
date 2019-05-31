[oolong](../index.md) / [oolong.delay](index.md) / [delay](./delay.md)

# delay

`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> delay(timeMillis: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: suspend <ERROR CLASS>.() -> `[`Msg`](delay.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](delay.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/delay/util.kt#L16)

Generate a [Msg](delay.md#Msg) after a specified timeMillis.

### Parameters

`timeMillis` - time in milliseconds.

`msg` - generator function of [Msg](delay.md#Msg)

**Return**
a delayed effect
