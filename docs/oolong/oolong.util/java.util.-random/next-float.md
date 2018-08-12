[oolong](../../index.md) / [oolong.util](../index.md) / [java.util.Random](index.md) / [nextFloat](./next-float.md)

# nextFloat

`fun <Msg> `[`Random`](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html)`.nextFloat(msg: (`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`) -> `[`Msg`](next-float.md#Msg)`): `[`Cmd`](../../oolong.platform/-cmd/index.md)`<`[`Msg`](next-float.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/random.kt#L32)

Call [Random.nextFloat](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html#nextFloat()) with a mapping of [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) to [Msg](next-float.md#Msg).

### Parameters

`msg` - map function of [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) to [Msg](next-float.md#Msg)

**Return**
[Cmd](../../oolong.platform/-cmd/index.md) of [Msg](next-float.md#Msg) for the generated [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)

