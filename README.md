Oolong 🍵 
=========

[![Build Status](https://img.shields.io/travis/pardom/oolong/master.svg)](https://travis-ci.org/pardom/oolong/)
[![Maven Central](https://img.shields.io/maven-central/v/com.michaelpardo/oolong.svg)](#download)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.michaelpardo/oolong.svg)](#download)
[![License](https://img.shields.io/github/license/pardom/oolong.svg)](LICENSE.md)

Oolong is an [Elm](https://guide.elm-lang.org/architecture) inspired Model-View-Update (MVU) implementation for Kotiln multiplatform. As the name implies, three core concepts comprise the foundation of this architecture: 

* **Model** - a type to represent the program state

* **Update** - a function to update the state

* **View** - a function to map the state to view properties

By applying this simple pattern you can create composable, testable programs that can run on any platform. Oolong enables a common codebase for all platforms by using a `Render` function which is implemented by each frontend.

Get started with Oolong by reading the [official guide](docs/guide/index.md).

Example
-------

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

    data class Props(
        val count: Int,
        val onIncrement: () -> Unit,
        val onDecrement: () -> Unit
    )

    val init: Init<Model, Msg> = { 
        Model() to noEffect()
    }

    val update: Update<Model, Msg> = { msg, model ->
        when (msg) {
            Msg.Increment -> model.copy(count = model.count + 1)
            Msg.Decrement -> model.copy(count = model.count - 1)
        } to noEffect()
    }

    val view: View<Model, Msg, Props> = { model, dispatch ->
        Props(
            model.count,
            { dispatch(Msg.Increment) },
            { dispatch(Msg.Decrement) }
        )
    }

}
```

More examples can be found in the [samples directory](samples).

Documentation
-------------

Further reading can be found in the [official guide](docs/guide/index.md) and [documentation](docs/oolong/index.md).

Download
--------

```kotlin
dependencies {
    implementation("com.michaelpardo:oolong:2.0.0-SNAPSHOT")
}
```
