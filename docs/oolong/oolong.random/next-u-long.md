[oolong](../index.md) / [oolong.random](index.md) / [nextULong](./next-u-long.md)

# nextULong

`fun <Msg> nextULong(msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L236)
`fun <Msg> nextULong(until: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L246)
`fun <Msg> nextULong(from: <ERROR CLASS>, until: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L256)

Call [Random.nextULong](#) with a mapping of [ULong](#) to [Msg](next-u-long.md#Msg).

### Parameters

`msg` - map function of [ULong](#) to [Msg](next-u-long.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-long.md#Msg) for the generated [ULong](#)

