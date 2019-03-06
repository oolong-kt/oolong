[oolong](../index.md) / [oolong.util.delay](./index.md)

## Package oolong.util.delay

Utility functions for creating delay effects.

### Functions

| Name | Summary |
|---|---|
| [interval](interval.md) | `fun <Msg> interval(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, scope: <ERROR CLASS> = GlobalScope, msg: () -> `[`Msg`](interval.md#Msg)`): <ERROR CLASS><`[`Effect`](../oolong/-effect.md)`<`[`Msg`](interval.md#Msg)`>, `[`Dispose`](../oolong/-dispose.md)`>`<br>Generate [Msg](interval.md#Msg)s at a specified delay. |
| [timeout](timeout.md) | `fun <Msg> timeout(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, scope: <ERROR CLASS> = GlobalScope, msg: () -> `[`Msg`](timeout.md#Msg)`): <ERROR CLASS><`[`Effect`](../oolong/-effect.md)`<`[`Msg`](timeout.md#Msg)`>, `[`Dispose`](../oolong/-dispose.md)`>`<br>Generate a [Msg](timeout.md#Msg) after a specified delay. |
