package oolong.navigation

import oolong.Init
import oolong.Next
import oolong.Update
import oolong.View
import oolong.effect.map
import oolong.effect.none
import oolong.next.bimap

abstract class Router<Model_ : Any, Msg_ : Any, Props : Any, Route : Any> {

    data class Model<Model_>(
        val routeModel: Model_,
        val routeCache: Map<String, Model_>
    )

    sealed class Msg<out Msg_, out Route> {

        data class SetRoute<Route : Any>(
            val route: Route,
            val lastRouteKey: String,
            val nextRouteKey: String,
            val restore: Boolean
        ) : Msg<Nothing, Route>()

        data class Route<Msg_>(
            val screenMsg: Msg_
        ) : Msg<Msg_, Nothing>()

    }

    // Init

    abstract val initRoute: (Route) -> Init<Model_, Msg_>

    val init: (Route) -> Init<Model<Model_>, Msg<Msg_, Route>> =
        { route ->
            {
                val (model, effect) = initRoute(route)()
                Model(
                    routeModel = model,
                    routeCache = emptyMap()
                ) to map(effect, { msg -> Msg.Route(msg) })
            }
        }

    // Update

    abstract val updateRoute: Update<Model_, Msg_>

    val update: Update<Model<Model_>, Msg<Msg_, Route>> =
        { msg, model ->
            when (msg) {
                is Msg.SetRoute -> updateSetRoute(msg, model)
                is Msg.Route -> updateDelegate(msg, model)
            }
        }

    private val updateSetRoute: (Msg.SetRoute<Route>, Model<Model_>) -> Next<Model<Model_>, Msg<Msg_, Route>> =
        { msg, model ->
            val savedModel: Model_? = if (msg.restore) model.routeCache[msg.lastRouteKey] else null
            if (savedModel != null) {
                model.copy(
                    routeModel = savedModel,
                    routeCache = model.routeCache - msg.lastRouteKey
                ) to none()
            } else {
                val (delegate, effect) = initRoute(msg.route)()
                model.copy(
                    routeModel = delegate,
                    routeCache = model.routeCache + (msg.nextRouteKey to model.routeModel)
                ) to map(effect, { screenMsg -> Msg.Route(screenMsg) })
            }
        }

    private val updateDelegate: (Msg.Route<Msg_>, Model<Model_>) -> Next<Model<Model_>, Msg<Msg_, Route>> =
        { msg, model ->
            bimap(
                updateRoute(msg.screenMsg, model.routeModel),
                { routeModel -> model.copy(routeModel = routeModel) },
                { screenMsg -> Msg.Route(screenMsg) }
            )
        }

    // View

    abstract val viewRoute: View<Model_, Props>

    val view: View<Model<Model_>, Props> =
        { model -> viewRoute(model.routeModel) }

}
