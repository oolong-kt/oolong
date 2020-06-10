[oolong](../index.md) / [oolong.next](index.md) / [bimap](./bimap.md)

# bimap

(common) `fun <A : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, B : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, C : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> bimap(next: `[`Next`](../oolong/-next.md)`<A, B>, fa: (A) -> C, fb: (B) -> D): `[`Next`](../oolong/-next.md)`<C, D>` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/next/util.kt#L50)

Map from [Next](../oolong/-next.md) of [A](bimap.md#A) and [B](bimap.md#B) to [Next](../oolong/-next.md) of [C](bimap.md#C) and [D](bimap.md#D)

`bimap` can be used to map an init or update function from a child `Next` to a parent `Next`. A typical use for
`bimap` is compositional screen management.

Example:

``` kotlin
sealed class Model {
    data class Home(val model: HomeModel): Model()
    data class Settings(val model: SettingsModel): Model()
}

sealed class Msg {
    data class Home(val msg: HomeMsg) : Msg()
    data class Settings(val msg: SettingsMsg) : Msg()
}

val update: Update<Model, Msg> = { msg: Msg, model: Model ->
    when (msg) {
        is Msg.Home -> {
            when (model) {
                is Model.Home -> bimap(
                    homeUpdate(msg.msg, model.model),
                    Model::Home,
                    Msg::Home
                )
                else -> model to none()
            }
        }
        is Msg.Settings -> {
            when (model) {
                is Model.Settings -> bimap(
                    settingsUpdate(msg.msg, model.model),
                    Model::Settings,
                    Msg::Settings
                )
                else -> model to none()
            }
        }
    }
}
```

