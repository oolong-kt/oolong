# Oolong

Oolong is an [Elm](https://guide.elm-lang.org/architecture) inspired Model-View-Update (MVU) implementation for Kotlin multiplatform. As the name implies, three core concepts comprise the foundation of this architecture: 

* **Model** - a type to represent the program state

* **View** - a function to map the state to view properties

* **Update** - a function to update the state

By applying this simple pattern you can create composable, testable programs that can run on any platform. Oolong enables a common codebase for all platforms by using a `render` function which is implemented by each frontend.

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
    val increment: () -> Unit,
    val decrement: () -> Unit,
)

val init: () -> Pair<Model, Effect<Msg>> = { 
    Model() to none()
}

val update: (Msg, Model) -> Pair<Model, Effect<Msg>> = { msg, model ->
    when (msg) {
        Msg.Increment -> next(model.copy(count = model.count + 1))
        Msg.Decrement -> next(model.copy(count = model.count - 1))
    }
}

val view: (Model, Dispatch<Msg>) -> Props = { model ->
    Props(
        model.count,
        { dispatch(Msg.Increment) },
        { dispatch(Msg.Decrement) },
    )
}
```

<!--
## See it in action

Initialize an Oolong runtime by supplying your `init`, `update`, and `view` functions as well as a `render` function from the host platform. Press the play button below to run the example.

```{.kotlin .playground}
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import oolong.Dispatch
import oolong.Dispose
import oolong.Effect
import oolong.Oolong
import oolong.effect.none
import oolong.next.next

fun <Model : Any, Msg : Any, Props : Any> CoroutineScope.runtime(
    init: () -> Pair<Model, Effect<Msg>>,
    update: (Msg, Model) -> Pair<Model, Effect<Msg>>,
    view: (Model, Dispatch<Msg>) -> Props,
    render: (Props) -> Any?,
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
    val count: Int = 0,
)

sealed class Msg {
    object Increment : Msg()
    object Decrement : Msg()
}

class Props(
    val count: Int,
    val increment: () -> Unit,
    val decrement: () -> Unit,
)

val init: () -> Pair<Model, Effect<Msg>> = { 
    next(Model())
}

val update: (Msg, Model) -> Pair<Model, Effect<Msg>> = { msg, model ->
    when (msg) {
        Msg.Increment -> next(model.copy(count = model.count + 1))
        Msg.Decrement -> next(model.copy(count = model.count - 1))
    }
}

val view: (Model, Dispatch<Msg>) -> Props = { model ->
    Props(
        model.count,
        { dispatch(Msg.Increment) },
        { dispatch(Msg.Decrement) },
    )
}

fun main() {
    runBlocking {
//sampleStart
        val render: (Props) -> Any? = { props ->
            // Print the current count
            println("count: ${props.count}")

            // Dispatch Msg.Increment if less than 3
            if (props.count < 3) {
                props.increment()
            }
        }

        runtime(init, update, view, render)
//sampleEnd
    }
}
```
-->
