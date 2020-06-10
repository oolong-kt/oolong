[oolong](../index.md) / [oolong.random](index.md) / [nextUBytes](./next-u-bytes.md)

# nextUBytes

(common) `@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUBytes(array: `[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`, msg: suspend CoroutineScope.(`[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L176)
`@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUBytes(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: suspend CoroutineScope.(`[`UByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L186)

Call [Random.nextUBytes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/next-u-bytes.html) with a mapping of [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) to [Msg](next-u-bytes.md#Msg).

### Parameters

`msg` - map function of [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) to [Msg](next-u-bytes.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-bytes.md#Msg) for the generated [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)

