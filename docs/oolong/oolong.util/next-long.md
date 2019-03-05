[oolong](../index.md) / [oolong.util](index.md) / [nextLong](./next-long.md)

# nextLong

`fun <Msg> <ERROR CLASS>.nextLong(msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](next-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-long.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextLong(until: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](next-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-long.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextLong(from: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, until: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](next-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-long.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextLong(range: `[`LongRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-long-range/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](next-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-long.md#Msg)`>`

Call [Random.nextLong](#) with a mapping of [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Msg](next-long.md#Msg).

### Parameters

`msg` - map function of [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Msg](next-long.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-long.md#Msg) for the generated [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

