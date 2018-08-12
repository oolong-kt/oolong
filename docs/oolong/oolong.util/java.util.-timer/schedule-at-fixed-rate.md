[oolong](../../index.md) / [oolong.util](../index.md) / [java.util.Timer](index.md) / [scheduleAtFixedRate](./schedule-at-fixed-rate.md)

# scheduleAtFixedRate

`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.scheduleAtFixedRate(firstTime: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule-at-fixed-rate.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule-at-fixed-rate.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L55)
`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.scheduleAtFixedRate(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule-at-fixed-rate.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule-at-fixed-rate.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L66)

Call [Timer.scheduleAtFixedRate](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html#scheduleAtFixedRate(java.util.TimerTask, long, long)) with a mapping of [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Msg](schedule-at-fixed-rate.md#Msg).

### Parameters

`msg` - map function of [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Msg](schedule-at-fixed-rate.md#Msg)

**Return**
[Sub](../../oolong.platform/-sub/index.md) of [Msg](schedule-at-fixed-rate.md#Msg) for the generated [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

