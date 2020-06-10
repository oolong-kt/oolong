[oolong](../index.md) / [oolong.random](index.md) / [nextBoolean](./next-boolean.md)

# nextBoolean

(common) `fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> nextBoolean(msg: suspend CoroutineScope.(`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> Msg): `[`Effect`](../oolong/-effect.md)`<Msg>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/random/util.kt#L27)

Call [Random.nextBoolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/next-boolean.html) with a mapping of [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) to [Msg](next-boolean.md#Msg).

### Parameters

`msg` - map function of [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) to [Msg](next-boolean.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-boolean.md#Msg) for the generated [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

