[oolong](../index.md) / [oolong.util.random](index.md) / [nextFloat](./next-float.md)

# nextFloat

`fun <Msg> <ERROR CLASS>.nextFloat(msg: (`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`) -> `[`Msg`](next-float.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-float.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/util/random/util.kt#L94)

Call [Random.nextFloat](#) with a mapping of [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) to [Msg](next-float.md#Msg).

### Parameters

`msg` - map function of [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) to [Msg](next-float.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-float.md#Msg) for the generated [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)

