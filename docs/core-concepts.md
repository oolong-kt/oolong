# Core Concepts

Let's visit each of the core concepts by examining a simple example. We'll create a simple "counter" program that can increment and decrement an `Int` state. In MVU architecture, state is changed by dispatching and handling messages. We'll look at this more in a moment. First let's take a look at the model.

## Model

The model is a representation of the state of your application. In this case, the model contains just one property which is an `Int` named `count` with a default value of `0`. By convention, we define the model as a `data` class so it can be mutated easily. While your application is running, the model will be changing from one state to the next every time a message is dispatched.

```kotlin
data class Model(
    val count: Int = 0
)
```

## Update

#### Messages

Before looking at the update function, let's talk about messages. Messages describe the way we want the application state to change. In the case of our counter app, we have two messages that can be dispatched and handled: `Increment` and `Decrement`. `Increment` adds `1` to the current value of `count` and `Decrement` subtracts `1` from `count`. We'll look at how messages are handled next. By convention, messages are defined as part of a `sealed` class. This allows us to use an exhaustive list of types when interpreting messages.

```kotlin
sealed class Msg {
    object Increment : Msg()
    object Decrement : Msg()
}
```

#### Update function

So far we have looked at the model and messages. The update function uses these two concepts to take a previous state and transform it to the next state. When a message is dispatched, update is called with the dispatched message and the current state as arguments. The function must determine what state to return given these arguments.

So far we have mentioned two conventions: models are `data` classes, and messages are `sealed` classes. You can see in the function below how those modifiers come into play. The message is type is able to be determined in an exhaustive `when` block. The new state is created by mutating the old state with the `copy` function. You may notice that the return type is a `Pair` of `Model` and some type returned by `noEffect`. We'll discuss this in detail in a later chapter.

```kotlin
val update: Update<Model, Msg> = { msg, model ->
    when (msg) {
        Msg.Increment -> model.copy(count = model.count + 1)
        Msg.Decrement -> model.copy(count = model.count - 1)
    } to noEffect()
}
```

## View

The job of the view function is to transform the current state into something that can be rendered in a UI. This could be an HTML string, a tree of widgets, or in most practical cases it will be a deeply nested data structure. The term we'll use for this is view properties or `Props`.

#### View properties

There are two types of data you may want to store in your view properties. First is information that you want rendered to the UI, and in this case we want to show the current count. The second category of data is message generators. Your rendering code will know how to display properties and dispatch messages created from generators. If you are only targetting one platform, then you may decide to return components specific to that platform, but since Oolong is a multiplatform library it is convention to use a simple data structure.

```kotlin
class Props(
    val count: Int,
    val onIncrement: () -> Msg,
    val onDecrement: () -> Msg
)
```

#### View function

The view function, as mentioned above, takes the current state its argument and returns view properties. Here we populate the view properties with:

* `count` - the current count.
* `onIncrement` - a function which returns the `Increment` message.
* `onDecrement` - a function which returns the `Decrement` message.

```kotlin
val view: View<Model, Props> = { model ->
    Props(
        model.count,
        { Msg.Increment },
        { Msg.Decrement }
    )
}
```

## Puting it all together

Now that we've built the core components of our application, we need a few more things to complete the it.

#### Initialization function

To get the runtime loop going, we first need to know what the initial state is. We do this by definiting an initialization function. This function is similar to the `update` function, however it takes no arguments. By convention, it is often desireable to define defaults in the model class and simply return a new instance from the init function.

```kotlin
val init: Init<Model, Msg> = {
    Model() to noEffect()
}
```

#### Render function

We also need to know how to render the view properties returned by the view function. Each target platform does this by implementing a render function which takes the view properties and a dispatch function as arguments. The dispatch function can be invoked to send messages to the update function.

```kotlin
val render: Render<Msg, Props> = { props, dispatch ->
    // Platform specific rendering
    countLabel.text = "${props.count}"
    incrementButton.setOnClickListener { dispatch(props.onIncrement()) }
    decrementButton.setOnClickListener { dispatch(props.onDecrement()) }
}
```

#### Runtime

Now that we have all the requirements of an Oolong runtime defined, we can start it by calling `Oolong.runtime`.

```kotlin
Oolong.runtime(
    init,
    update,
    view,
    render
)
```

Next, let's learn about [Effects](effects/README.md).