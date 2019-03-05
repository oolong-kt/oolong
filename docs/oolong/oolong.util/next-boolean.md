[oolong](../index.md) / [oolong.util](index.md) / [nextBoolean](./next-boolean.md)

# nextBoolean

`fun <Msg> <ERROR CLASS>.nextBoolean(msg: (`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> `[`Msg`](next-boolean.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-boolean.md#Msg)`>`

Call [Random.nextBoolean](#) with a mapping of [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) to [Msg](next-boolean.md#Msg).

### Parameters

`msg` - map function of [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) to [Msg](next-boolean.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-boolean.md#Msg) for the generated [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

