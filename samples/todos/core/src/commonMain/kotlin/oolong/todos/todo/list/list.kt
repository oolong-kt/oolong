package oolong.todos.todo.list

import oolong.Init
import oolong.Next
import oolong.Update
import oolong.View
import oolong.effect
import oolong.effect.none
import oolong.todos.todo.AddTodo
import oolong.todos.todo.GetTodos
import oolong.todos.todo.Todo
import oolong.todos.todo.list.Props.Body
import oolong.todos.todo.list.Props.Body.Row
import oolong.todos.todo.list.Props.Header

data class Model(
    val todos: List<Todo>,
    val field: String
)

sealed class Msg {
    object GetTodos : Msg()
    object AddTodo : Msg()
    data class SetTodos(val todos: List<Todo>) : Msg()
    data class UpdateField(val field: String) : Msg()
}

data class Props(
    val header: Header,
    val body: Body
) {

    data class Header(
        val field: String
    )

    data class Body(
        val rows: List<Row>
    ) {

        data class Row(
            val id: Long,
            val title: String
        )
    }
}

val init: Init<Model, Msg> = {
    Next(
        Model(emptyList(), ""),
        effect { dispatch -> dispatch(Msg.GetTodos) }
    )
}

val makeUpdate: (GetTodos, AddTodo) -> Update<Model, Msg> = { getTodos, addTodo ->
    { msg, model ->
        when (msg) {
            Msg.GetTodos -> {
                model to effect { dispatch ->
                    dispatch(Msg.SetTodos(getTodos()))
                }
            }
            is Msg.SetTodos -> {
                model.copy(todos = msg.todos) to none()
            }
            is Msg.AddTodo -> {
                model.copy(field = "") to effect { dispatch ->
                    dispatch(Msg.SetTodos(addTodo(model.field)))
                }
            }
            is Msg.UpdateField -> {
                model.copy(field = msg.field) to none()
            }
        }
    }
}

val view: View<Model, Props> = { model ->
    Props(
        Header(model.field),
        Body(
            model.todos.map { todo ->
                Row(todo.id, todo.title)
            }
        )
    )
}
