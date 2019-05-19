[oolong](../index.md) / [oolong.random](index.md) / [nextUInt](./next-u-int.md)

# nextUInt

`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUInt(msg: suspend <ERROR CLASS>.(<ERROR CLASS>) -> `[`Msg`](next-u-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L196)
`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUInt(until: <ERROR CLASS>, msg: suspend <ERROR CLASS>.(<ERROR CLASS>) -> `[`Msg`](next-u-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L206)
`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUInt(from: <ERROR CLASS>, until: <ERROR CLASS>, msg: suspend <ERROR CLASS>.(<ERROR CLASS>) -> `[`Msg`](next-u-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/random/util.kt#L216)

Call [Random.nextUInt](#) with a mapping of [UInt](#) to [Msg](next-u-int.md#Msg).

### Parameters

`msg` - map function of [UInt](#) to [Msg](next-u-int.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-int.md#Msg) for the generated [UInt](#)

