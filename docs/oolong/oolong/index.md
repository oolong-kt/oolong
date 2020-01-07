[oolong](../index.md) / [oolong](./index.md)

## Package oolong

### Types

| Name | Summary |
|---|---|
| (common) [Dispatch](-dispatch.md) | Dispatches a message to the runtime`typealias Dispatch<Msg> = (msg: Msg) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (common) [Dispose](-dispose.md) | Stops the function and cleans up resources`typealias Dispose = () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (common) [Effect](-effect.md) | Runs a side-effect away from the runtime`typealias Effect<Msg> = suspend CoroutineScope.(dispatch: `[`Dispatch`](-dispatch.md)`<Msg>) -> `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?` |
| (common) [Init](-init.md) | Creates an initial state and side-effects`typealias Init<Model, Msg> = () -> `[`Next`](-next.md)`<Model, Msg>` |
| (common) [Next](-next.md) | A pair of the next state and side-effects`typealias Next<Model, Msg> = `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<Model, `[`Effect`](-effect.md)`<Msg>>` |
| (common) [Oolong](-oolong/index.md) | Oolong runtime module.`object Oolong` |
| (common) [Render](-render.md) | Renders the view properties`typealias Render<Msg, Props> = (props: Props, dispatch: `[`Dispatch`](-dispatch.md)`<Msg>) -> `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?` |
| (common) [Update](-update.md) | Creates a next state and side-effects from a message and current state`typealias Update<Model, Msg> = (msg: Msg, model: Model) -> `[`Next`](-next.md)`<Model, Msg>` |
| (common) [View](-view.md) | Creates view properties from the current state`typealias View<Model, Props> = (model: Model) -> Props` |

### Functions

| Name | Summary |
|---|---|
| (common) [effect](effect.md) | [Effect](-effect.md) builder function.`fun <Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> effect(block: `[`Effect`](-effect.md)`<Msg>): `[`Effect`](-effect.md)`<Msg>` |
| (common) [init](init.md) | [Init](-init.md) builder function.`fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> init(block: `[`Init`](-init.md)`<Model, Msg>): `[`Init`](-init.md)`<Model, Msg>` |
| (common) [render](render.md) | [Render](-render.md) builder function.`fun <Props : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> render(block: `[`Render`](-render.md)`<Props, Msg>): `[`Render`](-render.md)`<Props, Msg>` |
| (common) [update](update.md) | [Update](-update.md) builder function.`fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Msg : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> update(block: `[`Update`](-update.md)`<Model, Msg>): `[`Update`](-update.md)`<Model, Msg>` |
| (common) [view](view.md) | [View](-view.md) builder function.`fun <Model : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, Props : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> view(block: `[`View`](-view.md)`<Model, Props>): `[`View`](-view.md)`<Model, Props>` |
