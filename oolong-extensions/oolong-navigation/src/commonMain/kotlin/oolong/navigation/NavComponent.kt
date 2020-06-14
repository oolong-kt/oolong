package oolong.navigation

import oolong.Init
import oolong.Next
import oolong.Update
import oolong.View
import oolong.effect.map
import oolong.effect.none
import oolong.next.bimap

abstract class NavComponent<Model : Any, Msg : Any, Props : Any, Route : Any> {

    data class NavModel<Model>(
        val screenModel: Model,
        val screenCache: Map<String, Model>
    )

    sealed class NavMsg<out Msg, out Route> {

        data class SetRoute<Route : Any>(
            val route: Route,
            val lastRouteKey: String,
            val nextRouteKey: String,
            val restore: Boolean
        ) : NavMsg<Nothing, Route>()

        data class Screen<Msg>(
            val screenMsg: Msg
        ) : NavMsg<Msg, Nothing>()

    }

    // Init

    abstract val screenInit: (Route) -> Init<Model, Msg>

    val init: (Route) -> Init<NavModel<Model>, NavMsg<Msg, Route>> =
        { route ->
            {
                val (model, effect) = screenInit(route)()
                NavModel(
                    screenModel = model,
                    screenCache = emptyMap()
                ) to map(effect, { msg -> NavMsg.Screen(msg) })
            }
        }

    // Update

    abstract val screenUpdate: Update<Model, Msg>

    val update: Update<NavModel<Model>, NavMsg<Msg, Route>> =
        { msg, model ->
            when (msg) {
                is NavMsg.SetRoute -> updateSetRoute(msg, model)
                is NavMsg.Screen -> updateDelegate(msg, model)
            }
        }

    private val updateSetRoute: (NavMsg.SetRoute<Route>, NavModel<Model>) -> Next<NavModel<Model>, NavMsg<Msg, Route>> =
        { msg, model ->
            val savedModel: Model? = if (msg.restore) model.screenCache[msg.lastRouteKey] else null
            if (savedModel != null) {
                model.copy(
                    screenModel = savedModel,
                    screenCache = model.screenCache - msg.lastRouteKey
                ) to none()
            } else {
                val (delegate, effect) = screenInit(msg.route)()
                model.copy(
                    screenModel = delegate,
                    screenCache = model.screenCache + (msg.nextRouteKey to model.screenModel)
                ) to map(effect, { screenMsg -> NavMsg.Screen(screenMsg) })
            }
        }

    private val updateDelegate: (NavMsg.Screen<Msg>, NavModel<Model>) -> Next<NavModel<Model>, NavMsg<Msg, Route>> =
        { msg, model ->
            bimap(
                screenUpdate(msg.screenMsg, model.screenModel),
                { screenModel -> model.copy(screenModel = screenModel) },
                { screenMsg -> NavMsg.Screen(screenMsg) }
            )
        }

    // View

    abstract val screenView: View<Model, Props>

    val view: View<NavModel<Model>, Props> =
        { model -> screenView(model.screenModel) }

}
