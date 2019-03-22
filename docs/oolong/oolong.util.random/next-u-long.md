[oolong](../index.md) / [oolong.util.random](index.md) / [nextULong](./next-u-long.md)

# nextULong

`fun <Msg> <ERROR CLASS>.nextULong(msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L236)
`fun <Msg> <ERROR CLASS>.nextULong(until: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L246)
`fun <Msg> <ERROR CLASS>.nextULong(from: <ERROR CLASS>, until: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L256)

Call [Random.nextULong](#) with a mapping of [ULong](#) to [Msg](next-u-long.md#Msg).

### Parameters

`msg` - map function of [ULong](#) to [Msg](next-u-long.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-long.md#Msg) for the generated [ULong](#)

