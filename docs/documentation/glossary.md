### Dispatch

`typealias Dispatch<Msg> = (msg: Msg) -> Unit`

A function which dispatches a message to the runtime.

### Effect
`typealias Effect<Msg> = suspend CoroutineScope.(dispatch: Dispatch<Msg>) -> Any?`

A function which runs a side-effect away from the runtime.

### Next
`typealias Next<Model, Msg> = Pair<Model, Effect<Msg>>`

A pair of the next state and side-effects.

### Init

`typealias Init<Model, Msg> = () -> Next<Model, Msg>`

A function which creates an initial state and side-effects.

### Update

`typealias Update<Model, Msg> = (msg: Msg, model: Model) -> Next<Model, Msg>`

A function which creates a next state and side-effects from a message and current state.

### View

`typealias View<Model, Props> = (model: Model) -> Props`

A function which creates view properties from the current state.

### Render

`typealias Render<Msg, Props> = (props: Props, dispatch: Dispatch<Msg>) -> Any?`

A function which renders the view properties.

### Dispose

`typealias Dispose = () -> Unit`

A function which disposes and cleans up resources.
