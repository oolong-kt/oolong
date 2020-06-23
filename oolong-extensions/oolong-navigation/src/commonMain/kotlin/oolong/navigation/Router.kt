package oolong.navigation

import oolong.Init
import oolong.Next
import oolong.Update
import oolong.effect.map
import oolong.effect.none
import oolong.next.bimap

object Router {

    data class Model<Model_ : Any>(
        val screen: Model_,
        internal val cache: Map<String, Model_>
    )

    sealed class Msg<out Msg_ : Any, out Route : Any> {

        data class SetRoute<Route : Any>(
            val nextRoute: Route,
            val prevRouteKey: String,
            val nextRouteKey: String,
            val direction: Direction
        ) : Msg<Nothing, Route>()

        data class Route<Msg_ : Any>(
            val routeMsg: Msg_
        ) : Msg<Msg_, Nothing>()

    }

    enum class Direction {
        FORWARD, BACKWARD, REPLACE
    }

    fun <Model_ : Any, Msg_ : Any, Route : Any> create(
        init_: RouteInit<Model_, Msg_, Route>,
        update_: Update<Model_, Msg_>
    ): RouterPair<Model_, Msg_, Route> {

        val init: (Route) -> Init<Model<Model_>, Msg<Msg_, Route>> =
            { route ->
                {
                    val (routeModel, routeEffect) = init_(route)()
                    Model(
                        screen = routeModel,
                        cache = emptyMap()
                    ) to map(routeEffect, { routeMsg -> Msg.Route(routeMsg) })
                }
            }

        val updateSetRoute: (Msg.SetRoute<Route>, Model<Model_>) -> Next<Model<Model_>, Msg<Msg_, Route>> =
            { msg, model ->
                val savedModel: Model_? = model.cache[msg.nextRouteKey]
                if (msg.direction == Direction.BACKWARD && savedModel != null) {
                    model.copy(
                        screen = savedModel,
                        cache = model.cache - msg.nextRouteKey
                    ) to none()
                } else {
                    val (routeModel, routeEffect) = init_(msg.nextRoute)()
                    val cache = if (msg.direction == Direction.REPLACE) emptyMap()
                    else model.cache + (msg.prevRouteKey to model.screen)
                    model.copy(
                        screen = routeModel,
                        cache = cache
                    ) to map(routeEffect, { routeMsg -> Msg.Route(routeMsg) })
                }
            }

        val updateRoute: (Msg.Route<Msg_>, Model<Model_>) -> Next<Model<Model_>, Msg<Msg_, Route>> =
            { msg, model ->
                bimap(
                    update_(msg.routeMsg, model.screen),
                    { routeModel -> model.copy(screen = routeModel) },
                    { routerMsg -> Msg.Route(routerMsg) }
                )
            }

        val update: Update<Model<Model_>, Msg<Msg_, Route>> =
            { msg, model ->
                when (msg) {
                    is Msg.SetRoute -> updateSetRoute(msg, model)
                    is Msg.Route -> updateRoute(msg, model)
                }
            }

        return init to update
    }

}
