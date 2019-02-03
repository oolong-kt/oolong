package oolong

import oolong.platform.Effect

typealias Dispatch<Msg> = (Msg) -> Unit

typealias Next<Model, Msg> = Pair<Model, Effect<Msg>>

typealias Init<Model, Msg> = () -> Next<Model, Msg>

typealias Update<Model, Msg> = (Msg, Model) -> Next<Model, Msg>

typealias View<Model, Msg, RenderModel> = (Model, Dispatch<Msg>) -> RenderModel

typealias Render<RenderModel> = (RenderModel) -> Unit

typealias Subscriptions<Model, Msg> = (Model) -> Effect<Msg>

typealias Dispose = () -> Unit

