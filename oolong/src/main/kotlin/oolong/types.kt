package oolong

import oolong.platform.Effect

typealias Dispatch<Msg> = (Msg) -> Unit

typealias Next<Model, Msg> = Pair<Model, Effect<Msg>>

typealias Init<Model, Msg> = () -> Next<Model, Msg>

typealias Update<Model, Msg> = (Msg, Model) -> Next<Model, Msg>

typealias View<Model, Msg, Props> = (Model, Dispatch<Msg>) -> Props

typealias Render<Props> = (Props) -> Unit

typealias Subscriptions<Model, Msg> = (Model) -> Effect<Msg>

typealias Dispose = () -> Unit

