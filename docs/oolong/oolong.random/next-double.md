[oolong](../index.md) / [oolong.random](index.md) / [nextDouble](./next-double.md)

# nextDouble

(common) `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextDouble(msg: suspend CoroutineScope.(`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L67)
`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextDouble(until: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, msg: suspend CoroutineScope.(`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L76)
`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextDouble(from: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, until: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, msg: suspend CoroutineScope.(`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L85)

Call [Random.nextDouble](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/next-double.html) with a mapping of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-double.md#Msg).

### Parameters

`msg` - map function of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-double.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-double.md#Msg) for the generated [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

