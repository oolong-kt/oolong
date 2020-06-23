package oolong.navigation

import oolong.Init
import oolong.Update

typealias RouteInit<Model, Msg, Route> = (Route) -> Init<Model, Msg>

typealias RouterInit<Model_, Msg_, Route> = RouteInit<Router.Model<Model_>, Router.Msg<Msg_, Route>, Route>

typealias RouterUpdate<Model_, Msg_, Route> = Update<Router.Model<Model_>, Router.Msg<Msg_, Route>>

typealias RouterPair<Model_, Msg_, Route> =
        Pair<RouterInit<Model_, Msg_, Route>, RouterUpdate<Model_, Msg_, Route>>