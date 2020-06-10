[oolong](../index.md) / [oolong.random](index.md) / [nextBits](./next-bits.md)

# nextBits

(common) `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextBits(bitCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: suspend CoroutineScope.(`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L18)

Call [Random.nextBits](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/next-bits.html) with a mapping of [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) to [Msg](next-bits.md#Msg).

### Parameters

`msg` - map function of [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) to [Msg](next-bits.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-bits.md#Msg) for the generated [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

