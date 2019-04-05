[oolong](../index.md) / [oolong.delay](index.md) / [interval](./interval.md)

# interval

`fun <Msg> interval(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, scope: <ERROR CLASS> = GlobalScope, msg: () -> `[`Msg`](interval.md#Msg)`): <ERROR CLASS><`[`Effect`](../oolong/-effect.md)`<`[`Msg`](interval.md#Msg)`>, `[`Dispose`](../oolong/-dispose.md)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/delay/util.kt#L38)

Generate [Msg](interval.md#Msg)s at a specified delay.

### Parameters

`delay` - the delay length before the effect is invoked

`scope` - the [CoroutineScope](#) in which to run the effect

`msg` - generator function of [Msg](interval.md#Msg)

**Return**
A pair of effect and dispose

