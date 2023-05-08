package com.example.todolist

import androidx.lifecycle.LiveData


class ToDoRepository(private val dao:ToDoDao) {

    val allToDo:  LiveData<List<ToDo>> = dao.getToDoListDao()

//    fun getToDoList(): MutableList<ToDo> {
//       return dao.getToDoListDao()
//    }

    fun addToDo(myTodo: ToDo) {
        dao.upsertToDoO(myTodo)
    }

    fun delete(todo: ToDo) {
        dao.delete(todo)
    }
}