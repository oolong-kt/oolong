[oolong](../index.md) / [oolong.random](index.md) / [nextDouble](./next-double.md)

# nextDouble

`fun <Msg> nextDouble(msg: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Msg`](next-double.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-double.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L67)
`fun <Msg> nextDouble(until: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, msg: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Msg`](next-double.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-double.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L76)
`fun <Msg> nextDouble(from: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, until: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, msg: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Msg`](next-double.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-double.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L85)

Call [Random.nextDouble](#) with a mapping of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-double.md#Msg).

### Parameters

`msg` - map function of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-double.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-double.md#Msg) for the generated [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

