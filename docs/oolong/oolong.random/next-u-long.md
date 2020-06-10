[oolong](../index.md) / [oolong.random](index.md) / [nextULong](./next-u-long.md)

# nextULong

(common) `@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextULong(msg: suspend CoroutineScope.(`[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L236)
`@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextULong(until: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`, msg: suspend CoroutineScope.(`[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L246)
`@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextULong(from: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`, until: `[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`, msg: suspend CoroutineScope.(`[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L256)
`@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextULong(range: `[`ULongRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-u-long-range/index.html)`, msg: suspend CoroutineScope.(`[`ULong`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L266)

Call [Random.nextULong](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/next-u-long.html) with a mapping of [ULong](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html) to [Msg](next-u-long.md#Msg).

### Parameters

`msg` - map function of [ULong](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html) to [Msg](next-u-long.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-long.md#Msg) for the generated [ULong](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-long/index.html)

