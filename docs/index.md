# Oolong

Oolong is an [Elm](https://guide.elm-lang.org/architecture) inspired Model-View-Update (MVU) implementation for Kotiln multiplatform. As the name implies, three core concepts comprise the foundation of this architecture: 

* **Model** - a type to represent the program state

* **View** - a function to map the state to view properties

* **Update** - a function to update the state

By applying this simple pattern you can create composable, testable programs that can run on any platform. Oolong enables a common codebase for all platforms by using a `Render` function which is implemented by each frontend.

## An example

Here is a simple example in which a number can be incremented or decremented.

```kotlin 
data class Model(
    val count: Int = 0
)

sealed class Msg {
    object Increment : Msg()
    object Decrement : Msg()
}

class Props(
    val count: Int,
    val increment: (Dispatch<Msg>) -> Unit,
    val decrement: (Dispatch<Msg>) -> Unit
)

val init: Init<Model, Msg> = { 
    Model() to none()
}

val update: Update<Model, Msg> = { msg, model ->
    when (msg) {
        Msg.Increment -> model.copy(count = model.count + 1)
        Msg.Decrement -> model.copy(count = model.count - 1)
    } to none()
}

val view: View<Model, Props> = { model ->
    Props(
        model.count,
        { dispatch -> dispatch(Msg.Increment) },
        { dispatch -> dispatch(Msg.Decrement) }
    )
}
```

## See it in action

Initialize an Oolong runtime by supplying your `Init`, `Update`, and `View` functions as well as a `Render
` function from the host platform. Press the play button below to run the example.

```{.kotlin .playground}
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import oolong.Dispatch
import oolong.Dispose
import oolong.Init
import oolong.Oolong
import oolong.Render
import oolong.Update
import oolong.View
import oolong.effect.none

fun <Model : Any, Msg : Any, Props : Any> CoroutineScope.runtime(
    init: Init<Model, Msg>,
    update: Update<Model, Msg>,
    view: View<Model, Props>,
    render: Render<Msg, Props>,
): Dispose = Oolong.runtime(
    init, 
    update, 
    view, 
    render, 
    coroutineContext,
    coroutineContext, 
    coroutineContext
)


data class Model(
    val count: Int = 0
)

sealed class Msg {
    object Increment : Msg()
    object Decrement : Msg()
}

class Props(
    val count: Int,
    val increment: (Dispatch<Msg>) -> Unit,
    val decrement: (Dispatch<Msg>) -> Unit
)

val init: Init<Model, Msg> = { 
    Model() to none()
}

val update: Update<Model, Msg> = { msg, model ->
    when (msg) {
        Msg.Increment -> model.copy(count = model.count + 1)
        Msg.Decrement -> model.copy(count = model.count - 1)
    } to none()
}

val view: View<Model, Props> = { model ->
    Props(
        model.count,
        { dispatch -> dispatch(Msg.Increment) },
        { dispatch -> dispatch(Msg.Decrement) }
    )
}

fun main() {
    runBlocking {
//sampleStart
        val render: Render<Msg, Props> = { props, dispatch ->
            // Print the current count
            println("count: ${props.count}")

            // Dispatch Msg.Increment if less than 3
            if (props.count < 3) {
                props.increment(dispatch)
            }
        }

        runtime(init, update, view, render)
//sampleEnd
    }
}
```
