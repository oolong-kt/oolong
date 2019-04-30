package oolong.todos.todo

typealias GetTodos = () -> List<Todo>

typealias GetTodo = (Long) -> Todo

typealias AddTodo = (String) -> List<Todo>
