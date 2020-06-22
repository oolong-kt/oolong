# Side Effects

A side effect is an operation that modifies some state outside of the local environment. HTTP requests, disk I/O, user input, and dispalying pixels on a screen are examples of side effects. As you can imagine, a program without side effects is not very useful at all.

Functional programming loves [pure functions](https://en.wikipedia.org/wiki/Pure_function) and abhors side effects, so how can we perform effectful operations while keeping our code pure? MVU uses the concept of **managed effects**. Instead of performing effects in your purely functional core, you describe the effect and pass it off to the runtime where it can be safely executed.

In Oolong, for each call to `update` we return a `Next` value. This value is a `Pair` comprised of the new state and an `Effect`. After getting the next value, the effect is launched in a new coroutine away from the runtime. Looking at the type of `Effect` you'll notice it takes a single argument of type `Dispatch`.

`typealias Effect<Msg> = suspend CoroutineScope.(dispatch: Dispatch<Msg>) -> Any?`

This is how you call back in to your purely functional code: by calling `dispatch` with an effect response message. Here's a simple example which dispatches a message after a short delay.

```kotlin
val continueAfterDelayEffect = effect<Msg> { dispatch ->
    delay(500)
    dispatch(Msg.Continue)
}
```

In this example, they delay is a stand-in for any time consuming operation that you might do, for example an HTTP request. An actual network effect might look like this:

```kotlin
val getNetworkItemsEffect = effect<Msg> { dispatch ->
    val response = itemNetworkRepository.getItems()
    val msg = when (response) {
        is Either.Left -> {
            Msg.GetNetworkItemsFailure(response.value)
        }
        is Either.Right -> {
            Msg.GetNetworkItemsSuccess(response.value)
        }
    }
    dispatch(msg)
}
```

For most updates, you may not want to perform any side effects. In this case you can just return an effect with an empty body or just use the provided [`none()`](/oolong/oolong.effect/none) function. At other times, you may want to return multiple effects. You can compose multiple effects using the [`batch()`](/oolong/oolong.effect/batch) function.

Oolong provides a few utility functions for common effects, which can be found in [oolong.delay](/oolong/oolong.delay/index) and [oolong.random](/oolong/oolong.random/index).
