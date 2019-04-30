package oolong.todos

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.litho.config.ComponentsConfiguration
import com.facebook.soloader.SoLoader
import max.Navigator
import oolong.Oolong
import oolong.Render
import oolong.next.bimap
import oolong.todos.app.Model
import oolong.todos.app.Msg
import oolong.todos.app.Props
import oolong.todos.app.init
import oolong.todos.app.view
import oolong.todos.oolong.RenderDelegate
import oolong.todos.todo.detail.makeInit
import java.net.URI
import oolong.todos.todo.list.Model as TodoListModel
import oolong.todos.todo.list.Msg as TodoListMsg
import oolong.todos.todo.list.init as todoListInit

class App : Application() {

    private val renderDelegate = RenderDelegate<Msg, Props>()

    private val navigator by lazy {
        val mapDirection = { direction: Navigator.Direction ->
            when (direction) {
                Navigator.Direction.FORWARD -> Model.Direction.FORWARD
                Navigator.Direction.BACKWARD -> Model.Direction.BACKWARD
                Navigator.Direction.REPLACE -> Model.Direction.REPLACE
            }
        }

        Navigator(Routes.todos()) {
            path("/todos") {
                route("") { request ->
                    val next = bimap(
                        todoListInit(),
                        { model -> Model.TodoList(model, mapDirection(request.direction)) },
                        Msg::TodoList
                    )
                    renderDelegate.dispatch(Msg.RouteChanged(next))
                }
                route("/:id") { request ->
                    val itemId = requireNotNull(request.params["id"]).toLong()
                    val next = bimap(
                        makeInit(itemId)(),
                        { model -> Model.TodoDetail(model, mapDirection(request.direction)) },
                        Msg::TodoDetail
                    )
                    renderDelegate.dispatch(Msg.RouteChanged(next))
                }
            }
        }
    }

    init {
        INSTANCE = this
        Oolong.Main.runtime(
            init,
            Dependencies.update,
            view,
            renderDelegate
        )
    }

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            ComponentsConfiguration.isDebugModeEnabled = true
            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            client.start()
        }
    }

    companion object {

        private lateinit var INSTANCE: App

        fun setRender(render: Render<Msg, Props>) {
            INSTANCE.renderDelegate.set(render)
        }

        fun clearRender() {
            INSTANCE.renderDelegate.clear()
        }

        fun pushRoute(route: URI) {
            INSTANCE.navigator.push(route)
        }

        fun popRoute(): Boolean {
            return INSTANCE.navigator.pop()
        }

    }

}
