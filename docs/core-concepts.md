# Core Concepts

Let's visit each of the core concepts by examining a simple example.

## Model


```kotlin
data class Model(
    val count: Int = 0
)
```

## Msg

```kotlin
sealed class Msg {
    object Increment : Msg()
    object Decrement : Msg()
}
```

## Init

```kotlin
val init: Init<Model, Msg> = {
    Model() to noEffect()
}
```

## Update

```kotlin
val update: Update<Model, Msg> = { msg, model ->
    when (msg) {
        Msg.Increment -> model.copy(count = model.count + 1)
        Msg.Decrement -> model.copy(count = model.count - 1)
    } to noEffect()
}
```

## Props

```kotlin
data class Props(
    val count: Int,
    val onIncrement: () -> Msg,
    val onDecrement: () -> Msg
)
```

## View

```kotlin
val view: View<Model, Props> = { model ->
    Props(
        model.count,
        { Msg.Increment },
        { Msg.Decrement }
    )
}
```

## Render

