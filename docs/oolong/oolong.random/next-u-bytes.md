[oolong](../index.md) / [oolong.random](index.md) / [nextUBytes](./next-u-bytes.md)

# nextUBytes

`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUBytes(array: <ERROR CLASS>, msg: suspend <ERROR CLASS>.(<ERROR CLASS>) -> `[`Msg`](next-u-bytes.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-bytes.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L176)
`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUBytes(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: suspend <ERROR CLASS>.(<ERROR CLASS>) -> `[`Msg`](next-u-bytes.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-bytes.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L186)

Call [Random.nextUBytes](#) with a mapping of [UByteArray](#) to [Msg](next-u-bytes.md#Msg).

### Parameters

`msg` - map function of [UByteArray](#) to [Msg](next-u-bytes.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-bytes.md#Msg) for the generated [UByteArray](#)

