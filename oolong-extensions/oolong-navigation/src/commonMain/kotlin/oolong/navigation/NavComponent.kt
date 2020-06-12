package oolong.navigation

import oolong.Init
import oolong.Next
import oolong.Update
import oolong.View
import oolong.effect.map
import oolong.effect.none
import oolong.next.bimap

abstract class NavComponent<Route : Any, Model : Any, Msg : Any, Props : Any> {

    data class NavModel<Model, Route>(
        val savedStates: Map<String, Model>,
        val route: Route,
        val delegate: Model
    )

    sealed class NavMsg<out Msg, out Route> {

        data class SetRoute<Route : Any>(
            val route: Route,
            val lastRouteKey: String,
            val nextRouteKey: String,
            val restore: Boolean
        ) : NavMsg<Nothing, Route>()

        data class Delegate<Msg>(
            val delegate: Msg
        ) : NavMsg<Msg, Nothing>()

    }

    // Init

    abstract val screenInit: (Route) -> Init<Model, Msg>

    val init: (Route) -> Init<NavModel<Model, Route>, NavMsg<Msg, Route>> =
        { route ->
            {
                val (model, effect) = screenInit(route)()
                NavModel(
                    savedStates = emptyMap(),
                    route = route,
                    delegate = model
                ) to map(effect, { msg -> NavMsg.Delegate(msg) })
            }
        }

    // Update

    abstract val screenUpdate: Update<Model, Msg>

    val update: Update<NavModel<Model, Route>, NavMsg<Msg, Route>> =
        { msg, model ->
            when (msg) {
                is NavMsg.SetRoute -> updateSetRoute(msg, model)
                is NavMsg.Delegate -> updateDelegate(msg, model)
            }
        }

    private val updateSetRoute: (NavMsg.SetRoute<Route>, NavModel<Model, Route>) -> Next<NavModel<Model, Route>, NavMsg<Msg, Route>> =
        { msg, model ->
            val savedModel: Model? = if (msg.restore) {
                model.savedStates[msg.lastRouteKey]
            } else null
            if (savedModel != null) {
                model.copy(
                    savedStates = model.savedStates - msg.lastRouteKey,
                    route = msg.route,
                    delegate = savedModel
                ) to none()
            } else {
                val (delegate, effect) = screenInit(msg.route)()
                model.copy(
                    savedStates = model.savedStates + (msg.nextRouteKey to model.delegate),
                    route = msg.route,
                    delegate = delegate
                ) to map(effect, { NavMsg.Delegate(it) })
            }
        }

    private val updateDelegate: (NavMsg.Delegate<Msg>, NavModel<Model, Route>) -> Next<NavModel<Model, Route>, NavMsg<Msg, Route>> =
        { msg, model ->
            bimap(
                screenUpdate(msg.delegate, model.delegate),
                { delegate -> model.copy(delegate = delegate) },
                { delegate -> NavMsg.Delegate(delegate) }
            )
        }

    // View

    abstract val screenView: View<Model, Props>

    val view: View<NavModel<Model, Route>, Props> =
        { model -> screenView(model.delegate) }

}
