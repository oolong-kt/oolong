# Quick Start

Oolong is an [Elm](https://guide.elm-lang.org/architecture) inspired Model-View-Update (MVU) implementation for Kotiln multiplatform. As the name implies, three core concepts comprise the foundation of this architecture: 

* **Model** - a type to represent the program state

* **View** - a function to map the state to view properties

* **Update** - a function to update the state

By applying this simple pattern you can create composable, testable programs that can run on any platform. Oolong enables a common codebase for all platforms by using a `Render` function which is implemented by each frontend.

## Download

Add Oolong to your project with Gradle.

```kotlin
dependencies {
    implementation("org.oolong-kt:oolong:2.0.3")
}
```

## Setup

Define your program functions and initialize an Oolong runtime.

```kotlin
val init:   Int<Model, Msg>    = { ... }
val update: Update<Model, Msg> = { msg, model -> ... }
val view:   View<Model, Props> = { model -> ... }
val render: Render<Msg, Props> = { props, dispatch -> ... }

val dispose = Oolong.runtime(
    init,
    update,
    view,
    render
)
```

## Example

The following is a simple counter example in which the count can be incremented or decremented.

```kotlin
object Counter {

    data class Model(
        val count: Int = 0
    )

    sealed class Msg {
        object Increment : Msg()
        object Decrement : Msg()
    }

    class Props(
        val count: Int,
        val increment: () -> Msg,
        val decrement: () -> Msg
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
            { Msg.Increment },
            { Msg.Decrement }
        )
    }

}
```
