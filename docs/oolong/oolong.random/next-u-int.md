[oolong](../index.md) / [oolong.random](index.md) / [nextUInt](./next-u-int.md)

# nextUInt

(common) `@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUInt(msg: suspend CoroutineScope.(`[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L196)
`@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUInt(until: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`, msg: suspend CoroutineScope.(`[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L206)
`@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUInt(from: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`, until: `[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`, msg: suspend CoroutineScope.(`[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L216)
`@ExperimentalUnsignedTypes fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextUInt(range: `[`UIntRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-u-int-range/index.html)`, msg: suspend CoroutineScope.(`[`UInt`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L226)

Call [Random.nextUInt](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/next-u-int.html) with a mapping of [UInt](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html) to [Msg](next-u-int.md#Msg).

### Parameters

`msg` - map function of [UInt](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html) to [Msg](next-u-int.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-int.md#Msg) for the generated [UInt](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-int/index.html)

