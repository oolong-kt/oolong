[oolong](../index.md) / [oolong.delay](./index.md)

## Package oolong.delay

### Functions

| Name | Summary |
|---|---|
| (common) [delay](delay.md) | Generate a [Msg](delay.md#Msg) after a specified timeMillis.`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> delay(timeMillis: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: suspend CoroutineScope.() -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` |
| (common) [interval](interval.md) | Generate [Msg](interval.md#Msg)s at a specified timeMillis.`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> interval(timeMillis: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: suspend CoroutineScope.() -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` |
