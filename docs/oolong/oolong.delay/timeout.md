[oolong](../index.md) / [oolong.delay](index.md) / [timeout](./timeout.md)

# timeout

`fun <Msg> timeout(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, scope: <ERROR CLASS> = GlobalScope, msg: () -> `[`Msg`](timeout.md#Msg)`): <ERROR CLASS><`[`Effect`](../oolong/-effect.md)`<`[`Msg`](timeout.md#Msg)`>, `[`Dispose`](../oolong/-dispose.md)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/delay/util.kt#L23)

Generate a [Msg](timeout.md#Msg) after a specified delay.

### Parameters

`delay` - the delay length before the effect is invoked

`scope` - the [CoroutineScope](#) in which to run the effect

`msg` - generator function of [Msg](timeout.md#Msg)

**Return**
A pair of effect and dispose

