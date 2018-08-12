[oolong](../../index.md) / [oolong.util](../index.md) / [java.util.Timer](index.md) / [schedule](./schedule.md)

# schedule

`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.schedule(time: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L15)
`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.schedule(firstTime: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L25)
`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.schedule(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L35)
`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.schedule(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L45)

Call [Timer.schedule](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html#schedule(java.util.TimerTask, long)) with a mapping of [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Msg](schedule.md#Msg).

### Parameters

`msg` - map function of [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Msg](schedule.md#Msg)

**Return**
[Sub](../../oolong.platform/-sub/index.md) of [Msg](schedule.md#Msg) for the generated [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

