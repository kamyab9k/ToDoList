package com.example.todolist

object ToDoRepository {

    private val myTodoList = mutableListOf<ToDo>()

    fun getToDoList(): MutableList<ToDo> {
        return myTodoList
    }

    fun addToDo(myTodo: ToDo) {
        myTodoList.add(myTodo)
    }

    fun delete(todo: ToDo) {
        myTodoList.remove(todo)
    }
}