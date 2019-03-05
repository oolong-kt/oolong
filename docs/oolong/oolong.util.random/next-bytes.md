[oolong](../index.md) / [oolong.util.random](index.md) / [nextBytes](./next-bytes.md)

# nextBytes

`fun <Msg> <ERROR CLASS>.nextBytes(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, fromIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, toIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: (`[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`Msg`](next-bytes.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-bytes.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextBytes(array: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, msg: (`[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`Msg`](next-bytes.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-bytes.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextBytes(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: (`[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`Msg`](next-bytes.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-bytes.md#Msg)`>`

Call [Random.nextBytes](#) with a mapping of [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) to [Msg](next-bytes.md#Msg).

### Parameters

`msg` - map function of [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) to [Msg](next-bytes.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-bytes.md#Msg) for the generated [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

