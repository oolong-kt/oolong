package oolong.todos

import oolong.Update
import oolong.todos.app.Model
import oolong.todos.app.Msg
import oolong.todos.app.makeUpdate
import oolong.todos.todo.AddTodo
import oolong.todos.todo.GetTodo
import oolong.todos.todo.GetTodos
import oolong.todos.todo.Todo

object Dependencies {

    private val todos = mutableMapOf<Long, Todo>()

    private val getTodos: GetTodos = {
        todos.values.toList()
    }

    private val getTodo: GetTodo = { id ->
        requireNotNull(todos[id]) { "Todo not found for id: $id" }
    }

    private val addTodo: AddTodo = { title ->
        val todo = Todo(todos.size + 1L, title)
        todos[todo.id] = todo
        getTodos()
    }

    val update: Update<Model, Msg> =
        makeUpdate(getTodos, getTodo, addTodo)

}
