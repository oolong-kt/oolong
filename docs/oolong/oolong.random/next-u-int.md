[oolong](../index.md) / [oolong.random](index.md) / [nextUInt](./next-u-int.md)

# nextUInt

`fun <Msg> nextUInt(msg: (<ERROR CLASS>) -> `[`Msg`](next-u-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L196)
`fun <Msg> nextUInt(until: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L206)
`fun <Msg> nextUInt(from: <ERROR CLASS>, until: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L216)

Call [Random.nextUInt](#) with a mapping of [UInt](#) to [Msg](next-u-int.md#Msg).

### Parameters

`msg` - map function of [UInt](#) to [Msg](next-u-int.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-int.md#Msg) for the generated [UInt](#)

