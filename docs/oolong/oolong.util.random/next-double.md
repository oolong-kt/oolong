[oolong](../index.md) / [oolong.util.random](index.md) / [nextDouble](./next-double.md)

# nextDouble

`fun <Msg> <ERROR CLASS>.nextDouble(msg: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Msg`](next-double.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-double.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextDouble(until: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, msg: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Msg`](next-double.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-double.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextDouble(from: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, until: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, msg: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Msg`](next-double.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-double.md#Msg)`>`

Call [Random.nextDouble](#) with a mapping of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-double.md#Msg).

### Parameters

`msg` - map function of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-double.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-double.md#Msg) for the generated [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

