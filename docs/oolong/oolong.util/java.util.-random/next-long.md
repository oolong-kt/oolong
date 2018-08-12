[oolong](../../index.md) / [oolong.util](../index.md) / [java.util.Random](index.md) / [nextLong](./next-long.md)

# nextLong

`fun <Msg> `[`Random`](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html)`.nextLong(msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](next-long.md#Msg)`): `[`Cmd`](../../oolong.platform/-cmd/index.md)`<`[`Msg`](next-long.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/random.kt#L72)

Call [Random.nextLong](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html#nextLong()) with a mapping of [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Msg](next-long.md#Msg).

### Parameters

`msg` - map function of [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Msg](next-long.md#Msg)

**Return**
[Cmd](../../oolong.platform/-cmd/index.md) of [Msg](next-long.md#Msg) for the generated [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

