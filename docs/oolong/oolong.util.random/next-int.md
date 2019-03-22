[oolong](../index.md) / [oolong.util.random](index.md) / [nextInt](./next-int.md)

# nextInt

`fun <Msg> <ERROR CLASS>.nextInt(msg: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Msg`](next-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L103)
`fun <Msg> <ERROR CLASS>.nextInt(until: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Msg`](next-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L112)
`fun <Msg> <ERROR CLASS>.nextInt(from: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, until: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Msg`](next-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L121)
`fun <Msg> <ERROR CLASS>.nextInt(range: `[`IntRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)`, msg: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Msg`](next-int.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-int.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L130)

Call [Random.nextInt](#) with a mapping of [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) to [Msg](next-int.md#Msg).

### Parameters

`msg` - map function of [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) to [Msg](next-int.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-int.md#Msg) for the generated [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

