[oolong](../index.md) / [oolong.random](index.md) / [nextFloat](./next-float.md)

# nextFloat

(common) `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextFloat(msg: suspend CoroutineScope.(`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L94)

Call [Random.nextFloat](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/next-float.html) with a mapping of [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) to [Msg](next-float.md#Msg).

### Parameters

`msg` - map function of [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) to [Msg](next-float.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-float.md#Msg) for the generated [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)

