Oolong
=========

[![Build Status](https://img.shields.io/github/workflow/status/oolong-kt/oolong/CD)](https://github.com/oolong-kt/oolong/actions?query=workflow%3ACD)
[![Maven Central](https://img.shields.io/maven-central/v/org.oolong-kt/oolong.svg)](#download)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.oolong-kt/oolong.svg)](#download)
[![License](https://img.shields.io/github/license/oolong-kt/oolong.svg)](LICENSE.md)
[![Gitter chat](https://img.shields.io/gitter/room/oolong-kt/community.svg)](https://gitter.im/oolong-kt/community)

Oolong is an [Elm](https://guide.elm-lang.org/architecture) inspired Model-View-Update (MVU) implementation for Kotlin multiplatform. As the name implies, three core concepts comprise the foundation of this architecture: 

* **Model** - a type to represent the program state

* **View** - a function to map the state to view properties

* **Update** - a function to update the state

By applying this simple pattern you can create composable, testable programs that can run on any platform. Oolong enables a common codebase for all platforms by using a `Render` function which is implemented by each frontend.

Get started with Oolong by reading the [official guide](https://oolong-kt.org).

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

Samples
-------------

* [Official samples](https://github.com/oolong-kt/samples)
* [Lambda News](http://lambda.news)
* [Dice](https://github.com/pardom/dice)

Documentation
-------------

Further reading can be found in the [official guide](https://oolong-kt.org) and [documentation](https://oolong-kt.org/#/oolong/index).

Download
--------

```kotlin
dependencies {
    implementation("org.oolong-kt:oolong:2.0.5")
}
```
