[oolong](../index.md) / [oolong.util.random](index.md) / [nextBits](./next-bits.md)

# nextBits

`fun <Msg> <ERROR CLASS>.nextBits(bitCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, msg: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Msg`](next-bits.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-bits.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L17)

Call [Random.nextBits](#) with a mapping of [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) to [Msg](next-bits.md#Msg).

### Parameters

`msg` - map function of [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) to [Msg](next-bits.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-bits.md#Msg) for the generated [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

