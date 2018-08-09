[oolong](../../index.md) / [oolong.util](../index.md) / [java.util.Timer](index.md) / [schedule](./schedule.md)

# schedule

`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.schedule(time: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L9)
`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.schedule(firstTime: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L13)
`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.schedule(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L17)
`fun <Msg> `[`Timer`](http://docs.oracle.com/javase/6/docs/api/java/util/Timer.html)`.schedule(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, msg: (`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Msg`](schedule.md#Msg)`): `[`Sub`](../../oolong.platform/-sub/index.md)`<`[`Msg`](schedule.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/timer.kt#L21)