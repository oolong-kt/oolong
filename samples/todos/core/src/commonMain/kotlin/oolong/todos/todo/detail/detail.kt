package oolong.todos.todo.detail

import oolong.Init
import oolong.Update
import oolong.View
import oolong.effect
import oolong.effect.none
import oolong.todos.todo.GetTodo
import oolong.todos.todo.Todo

sealed class Model {

    object Init : Model()

    data class Data(
        val todo: Todo
    ) : Model()
}

sealed class Msg {

    data class GetTodo(val id: Long) : Msg()

    data class SetTodo(val todo: Todo) : Msg()

}

data class Props(
    val title: String
)

val makeInit: (Long) -> Init<Model, Msg> = { id ->
    { Model.Init to effect { dispatch -> dispatch(Msg.GetTodo(id)) } }
}

val makeUpdate: (GetTodo) -> Update<Model, Msg> = { getTodo ->
    { msg, model ->
        when (msg) {
            is Msg.GetTodo -> {
                model to effect { dispatch -> dispatch(Msg.SetTodo(getTodo(msg.id))) }
            }
            is Msg.SetTodo -> {
                Model.Data(msg.todo) to none()
            }
        }
    }
}

val view: View<Model, Props> = { model ->
    when (model) {
        is Model.Init -> {
            Props("")
        }
        is Model.Data -> {
            Props(model.todo.title)
        }
    }
}
