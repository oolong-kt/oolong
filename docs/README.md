# Oolong 🍵

[![Build Status](https://img.shields.io/travis/oolong-kt/oolong/master.svg)](https://travis-ci.org/oolong-kt/oolong/)
[![Maven Central](https://img.shields.io/maven-central/v/org.oolong-kt/oolong.svg)](#download)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.oolong-kt/oolong.svg)](#download)
[![License](https://img.shields.io/github/license/oolong-kt/oolong.svg)](LICENSE.md)
[![Github](https://img.shields.io/github/stars/oolong-kt/oolong.svg?style=social)](https://github.com/oolong-kt/oolong)

Oolong is an Elm inspired Model-View-Update (MVU) implementation for Kotiln multiplatform. As the name implies, three core concepts comprise the foundation of this architecture:

* **Model** - a type to represent the program state

* **View** - a function to map the state to view properties

* **Update** - a function to update the state

By applying this simple pattern you can create composable, testable programs that can run on any platform. Oolong enables a common codebase for all platforms by using a Render function which is implemented by each frontend.

### Example

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
        val increment: () -> Msg,
        val decrement: () -> Msg
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

    val view: View<Model, Props> = { model ->
        Props(
            model.count,
            { Msg.Increment },
            { Msg.Decrement }
        )
    }

}
```

### Download

```kotlin
dependencies {
    implementation("org.oolong-kt:oolong:2.0.0-SNAPSHOT")
}
```
