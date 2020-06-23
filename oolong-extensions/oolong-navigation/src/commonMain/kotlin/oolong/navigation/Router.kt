package oolong.navigation

import oolong.Init
import oolong.Next
import oolong.Update
import oolong.View
import oolong.effect.map
import oolong.effect.none
import oolong.next.bimap

object Router {

    data class Model<Model_>(
        val routeModel: Model_,
        val routeCache: Map<String, Model_>
    )

    sealed class Msg<out Msg_, out Route> {

        data class SetRoute<Route : Any>(
            val nextRoute: Route,
            val prevRouteKey: String,
            val nextRouteKey: String,
            val direction: Direction
        ) : Msg<Nothing, Route>()

        data class Route<Msg_>(
            val routerMsg: Msg_
        ) : Msg<Msg_, Nothing>()

    }

    enum class Direction {
        FORWARD, BACKWARD, REPLACE
    }

    fun <Model_ : Any, Msg_ : Any, Route : Any> create(
        init: (Route) -> Init<Model_, Msg_>,
        update: Update<Model_, Msg_>
    ): Pair<(Route) -> Init<Model<Model_>, Msg<Msg_, Route>>, Update<Model<Model_>, Msg<Msg_, Route>>> {

        val routerInit: (Route) -> Init<Model<Model_>, Msg<Msg_, Route>> =
            { route ->
                {
                    val (model, effect) = init(route)()
                    Model(
                        routeModel = model,
                        routeCache = emptyMap()
                    ) to map(effect, { msg -> Msg.Route(msg) })
                }
            }

        val updateSetRoute: (Msg.SetRoute<Route>, Model<Model_>) -> Next<Model<Model_>, Msg<Msg_, Route>> =
            { msg, model ->
                val savedModel: Model_? = model.routeCache[msg.nextRouteKey]
                if (msg.direction == Direction.BACKWARD && savedModel != null) {
                    model.copy(
                        routeModel = savedModel,
                        routeCache = model.routeCache - msg.nextRouteKey
                    ) to none()
                } else {
                    val (delegate, effect) = init(msg.nextRoute)()
                    val routeCache = if (msg.direction == Direction.REPLACE) emptyMap()
                    else model.routeCache + (msg.prevRouteKey to model.routeModel)
                    model.copy(
                        routeModel = delegate,
                        routeCache = routeCache
                    ) to map(effect, { routerMsg -> Msg.Route(routerMsg) })
                }
            }

        val updateDelegate: (Msg.Route<Msg_>, Model<Model_>) -> Next<Model<Model_>, Msg<Msg_, Route>> =
            { msg, model ->
                bimap(
                    update(msg.routerMsg, model.routeModel),
                    { routeModel -> model.copy(routeModel = routeModel) },
                    { routerMsg -> Msg.Route(routerMsg) }
                )
            }

        val routerUpdate: Update<Model<Model_>, Msg<Msg_, Route>> =
            { msg, model ->
                when (msg) {
                    is Msg.SetRoute -> updateSetRoute(msg, model)
                    is Msg.Route -> updateDelegate(msg, model)
                }
            }

        return routerInit to routerUpdate
    }

}
