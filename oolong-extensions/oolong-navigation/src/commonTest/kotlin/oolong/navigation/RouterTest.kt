package oolong.navigation

import oolong.Init
import oolong.Update
import oolong.effect.none
import kotlin.test.Test
import kotlin.test.assertEquals

class RouterTest {

    private sealed class Model {
        data class Main(val ids: List<Int>) : Model()
        data class Detail(val id: Int) : Model()
    }

    private sealed class Msg {
        object Main : Msg()
        object Detail : Msg()
    }

    private sealed class Route {
        object Main : Route()
        data class Detail(val id: Int) : Route()
    }

    private val itemIds = listOf(1, 2, 3)
    private val detailId = itemIds.first()

    private val init: (Route) -> Init<Model, Msg> =
        { route ->
            {
                when (route) {
                    is Route.Main -> Model.Main(itemIds)
                    is Route.Detail -> Model.Detail(route.id)
                } to none()
            }
        }

    private val update: Update<Model, Msg> =
        { msg, model ->
            model to none()
        }

    @Test
    fun `router should handle initial route`() {
        val (routerInit, _) = Router.create(init, update)
        val (mainModel, _) = routerInit(Route.Main)()
        assertEquals(routerModel(Model.Main(itemIds)), mainModel)
        val (detailModel, _) = routerInit(Route.Detail(detailId))()
        assertEquals(routerModel(Model.Detail(detailId)), detailModel)
    }

    @Test
    fun `router should handle route change`() {
        val (routerInit, routerUpdate) = Router.create(init, update)
        val (initModel, _) = routerInit(Route.Main)()
        assertEquals(routerModel(Model.Main(itemIds)), initModel)
        val (detailModel, _) = routerUpdate(routerMsg(Msg.Detail), initModel)
        assertEquals(routerModel(Model.Detail(detailId), mapOf("Main" to initModel.screen)), detailModel)
        val (restoredModel, _) = routerUpdate(routerMsg(Msg.Main), detailModel)
        assertEquals(initModel, restoredModel)
    }

    private fun routerMsg(msg: Msg) =
        when (msg) {
            Msg.Main -> Router.Msg.SetRoute(
                Route.Main,
                "Detail",
                "Main",
                Router.Direction.BACKWARD
            )
            Msg.Detail -> Router.Msg.SetRoute(
                Route.Detail(detailId),
                "Main",
                "Detail",
                Router.Direction.FORWARD
            )
        }

    private fun routerModel(
        model: Model,
        cache: Map<String, Model> = emptyMap()
    ) = Router.Model(model, cache)

}