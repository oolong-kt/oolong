[oolong](../index.md) / [oolong.util](index.md) / [nextUBytes](./next-u-bytes.md)

# nextUBytes

`fun <Msg> <ERROR CLASS>.nextUBytes(array: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-bytes.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-bytes.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextUBytes(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-bytes.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-bytes.md#Msg)`>`

Call [Random.nextUBytes](#) with a mapping of [UByteArray](#) to [Msg](next-u-bytes.md#Msg).

### Parameters

`msg` - map function of [UByteArray](#) to [Msg](next-u-bytes.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-bytes.md#Msg) for the generated [UByteArray](#)

