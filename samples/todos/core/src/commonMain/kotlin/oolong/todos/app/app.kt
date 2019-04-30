package oolong.todos.app

import oolong.Init
import oolong.Next
import oolong.Update
import oolong.View
import oolong.effect.none
import oolong.next.bimap
import oolong.todos.todo.AddTodo
import oolong.todos.todo.GetTodo
import oolong.todos.todo.GetTodos
import oolong.todos.todo.detail.makeUpdate
import oolong.todos.todo.detail.view
import oolong.todos.todo.list.init
import oolong.todos.todo.list.makeUpdate
import oolong.todos.todo.list.view
import oolong.todos.todo.detail.Model as TodoDetailModel
import oolong.todos.todo.detail.Msg as TodoDetailMsg
import oolong.todos.todo.detail.Props as TodoDetailProps
import oolong.todos.todo.list.Model as TodoListModel
import oolong.todos.todo.list.Msg as TodoListMsg
import oolong.todos.todo.list.Props as TodoListProps

sealed class Model {

    enum class Direction {
        FORWARD, BACKWARD, REPLACE
    }

    data class TodoList(
        val model: TodoListModel,
        val direction: Direction
    ) : Model()

    data class TodoDetail(
        val model: TodoDetailModel,
        val direction: Direction
    ) : Model()
}

sealed class Msg {
    data class RouteChanged(val next: Next<Model, Msg>) : Msg()
    data class TodoList(val msg: TodoListMsg) : Msg()
    data class TodoDetail(val msg: TodoDetailMsg) : Msg()
}

sealed class Props {

    abstract val direction: Model.Direction

    data class TodoList(
        val props: TodoListProps,
        override val direction: Model.Direction
    ) : Props()

    data class TodoDetail(
        val props: TodoDetailProps,
        override val direction: Model.Direction
    ) : Props()

}

val init: Init<Model, Msg> = {
    bimap(
        init(),
        { model -> Model.TodoList(model, Model.Direction.REPLACE) },
        Msg::TodoList
    )
}

val makeUpdate: (GetTodos, GetTodo, AddTodo) -> Update<Model, Msg> = { getTodos, getTodo, addTodo ->
    { msg, model ->
        when (msg) {
            is Msg.RouteChanged -> {
                msg.next
            }
            is Msg.TodoList -> {
                when (model) {
                    is Model.TodoList -> {
                        bimap(
                            makeUpdate(getTodos, addTodo)(msg.msg, model.model),
                            { model.copy(model = it) },
                            Msg::TodoList
                        )
                    }
                    else -> {
                        model to none()
                    }
                }
            }
            is Msg.TodoDetail -> {
                when (model) {
                    is Model.TodoDetail -> {
                        bimap(
                            makeUpdate(getTodo)(msg.msg, model.model),
                            { model.copy(model = it) },
                            Msg::TodoDetail
                        )
                    }
                    else -> {
                        model to none()
                    }
                }
            }
        }
    }
}

val view: View<Model, Props> = { model ->
    when (model) {
        is Model.TodoList -> Props.TodoList(view(model.model), model.direction)
        is Model.TodoDetail -> Props.TodoDetail(view(model.model), model.direction)
    }
}
