[oolong](../index.md) / [oolong.util.random](index.md) / [nextULong](./next-u-long.md)

# nextULong

`fun <Msg> <ERROR CLASS>.nextULong(msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextULong(until: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>`
`fun <Msg> <ERROR CLASS>.nextULong(from: <ERROR CLASS>, until: <ERROR CLASS>, msg: (<ERROR CLASS>) -> `[`Msg`](next-u-long.md#Msg)`): `[`Effect`](../oolong/-effect.md)`<`[`Msg`](next-u-long.md#Msg)`>`

Call [Random.nextULong](#) with a mapping of [ULong](#) to [Msg](next-u-long.md#Msg).

### Parameters

`msg` - map function of [ULong](#) to [Msg](next-u-long.md#Msg)

**Return**
[Effect](../oolong/-effect.md) of [Msg](next-u-long.md#Msg) for the generated [ULong](#)

