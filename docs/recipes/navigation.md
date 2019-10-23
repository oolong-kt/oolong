# Navigation

Since MVU architecture is fractal and composable, navigation is simply an excercise in composition and delegation. Let's look at a simple example with two screens: `List` and `Detail`.

## Data Structures

The navigation component needs to have an awareness of the logical screens in order to delegate to them, so we must create `Model`, `Msg`, and `Props` wrappers for each screen.

A navigation component's model is comprised of wrapper instances for each screen:

```kotlin
sealed class Model {
    // Delegates
    data class List(model: List.Model) : Model()
    data class Detail(model: Detail.Model) : Model()
}
```

Similarly, delegated components also need wrappers for their message types. Additionally, we have defined a navigation message to set a new screen.

```kotlin
sealed class Msg {
    // Delegates
    data class List(msg: List.Msg) : Msg()
    data class Detail(msg: Detail.Msg) : Msg()
    // Navigation
    data class SetScreen(next: Next<Model, Msg>): Msg()
}
```

Finally, we create delegation wrappers for each screen's props.

```kotlin
sealed class Props {
    // Delegates
    data class List(props: List.Props) : Props()
    data class Detail(props: Detail.Props) : Props()
}
```

## Functions

Now that the appropriate types have been defined, we can define program functions which delegate to each screen. Let's look each function in order starting with `init`.

Oolong provides a few utility functions for common use-cases and one of these is [`bimap`](/oolong/oolong.next/bimap). The bimap function transforms an instance of `Next<A, B>` to an instance of `Next<C, D>`. We're goint to use `List` as our initial screen, so in this case we're bimapping from an instance of `Next<List.Model, List.Msg>` to an instance of `Next<Model, Msg>`.

In other words, we're taking the `List.Model` and `List.Msg` returned from `List.init` and wrapping them in the delegated types of `Model.List` and `Msg.List`.

```kotlin
val init: Init<Model, Msg> = {
    bimap(List.init(), Model::List, Msg::List)
}
```

The same `bimap` function is used to delegate to screens in the `update` function. If the `msg` is an instance of a screen message wrapper, then we delegate to that screen using `bimap`. However, we receive a `SetScreen` message, we simply return the next value provided.

```kotlin
val update: Update<Model, Msg> = { msg, model ->
    when (msg) {
        is Msg.List -> {
            bimap(
                List.update(msg.msg, (model as Model.List).model), 
                Model::List, 
                Msg::List
            )
        }
        is Msg.Detail -> {
            bimap(
                Detail.update(msg.msg, (model as Model.Detail).model), 
                Model::Detail, 
                Msg::Detail
            )
        }
        is Msg.SetScreen -> {
            msg.next
        }
    }
}
```

The `view` function is quite simple, as we only need to wrap the screen's props with it's respected instance in the navigation props.

```kotlin
val view: View<Model, Props> = { model ->
    when (model) {
        is Model.List -> {
            Props.List(List.view(model.model))
        }
        is Model.Detail -> {
            Props.Detail(Detail.view(model.model))
        }
    }
}
```

Finally, in the `view` function we unwrap the props and delegate to each screen's render function. There is one additional consideration we need to take in this function, however, which is mapping the `dispatch` function from the screen's `Msg` type to the parent's. For this, we can use the provided [`contramap`](/oolong/oolong.dispatch/contramap) fuction.

```kotlin
val render: Render<Msg, Props> = { props, dispatch ->
    when (props) {
        is Props.List -> {
            List.render(props.props, contramap(dispatch, Msg::List))
        }
        is Props.Detail -> {
            Detail.render(props.props, contramap(dispatch, Msg::Detail))
        }
    }
}
```

## Navigating

With our types and functions setup for the navigation component, changing screens is done by simply dispatching a `SetScreen` message with the initial state for that screen. How navigation is performed and dispatched is an excercise for the user on each platform. Typically, you will create an adapter for your backstack which dispatches `SetScreen` using the latest instance of `dispatch`.


```kotlin
val navigateToItemDetail = { id: Long, dispatch: Dispatch<Msg> ->
    val init = Detail.makeInit(id)
    val next = bimap(init(), Model::Detail, Msg::Detail)
    dispatch(Msg.SetScreen(next))
}
```
