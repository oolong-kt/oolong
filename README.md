# Oolong

[![Build Status](https://img.shields.io/github/workflow/status/oolong-kt/oolong/CD)](https://github.com/oolong-kt/oolong/actions?query=workflow%3ACD)
[![Maven Central](https://img.shields.io/maven-central/v/org.oolong-kt/oolong.svg)](#download)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.oolong-kt/oolong.svg)](#download)
[![License](https://img.shields.io/github/license/oolong-kt/oolong.svg)](LICENSE.md)
[![Slack chat](https://img.shields.io/badge/slack-kotlinlang/oolong-brightgreen.svg)](https://kotlinlang.slack.com/archives/CGK4R59KP)

Oolong is an [Elm](https://guide.elm-lang.org/architecture) inspired Model-View-Update (MVU) implementation for Kotlin multiplatform. As the name implies, three core concepts comprise the foundation of this architecture: 

* **Model** - a type to represent the program state

* **View** - a function to map the state to view properties

* **Update** - a function to update the state

By applying this simple pattern you can create composable, testable programs that can run on any platform. Oolong enables a common codebase for all platforms by using a `render` function which is implemented by each frontend.

## Documentation

Get started with Oolong by reading the [official guide](https://oolong-kt.org).

## Download

```kotlin
dependencies {
    implementation("org.oolong-kt:oolong:2.1.1")
}
```
