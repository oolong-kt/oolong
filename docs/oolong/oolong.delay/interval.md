[oolong](../index.md) / [oolong.delay](index.md) / [interval](./interval.md)

# interval

(common) `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> interval(timeMillis: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: suspend CoroutineScope.() -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/delay/util.kt#L29)

Generate [Msg](interval.md#Msg)s at a specified timeMillis.

### Parameters

`timeMillis` - time in milliseconds.

`msg` - generator function of [Msg](interval.md#Msg)

**Return**
a delayed effect

