[oolong](../index.md) / [oolong.delay](./index.md)

## Package oolong.delay

### Functions

| Name | Summary |
|---|---|
| [delay](delay.md) | `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> delay(timeMillis: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: suspend <ERROR CLASS>.() -> `[`Msg`](delay.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](delay.md#Msg)`>`<br>Generate a [Msg](delay.md#Msg) after a specified timeMillis. |
| [interval](interval.md) | `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> interval(timeMillis: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: suspend <ERROR CLASS>.() -> `[`Msg`](interval.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](interval.md#Msg)`>`<br>Generate [Msg](interval.md#Msg)s at a specified timeMillis. |
