package com.example.todolist

import androidx.lifecycle.LiveData

class ToDoRepository(private val dao: ToDoDao) {

    fun getToDoList(): LiveData<List<ToDo>> {
      return dao.getToDoListDao()
    }

    suspend fun addToDo(myTodo: ToDo) {
        dao.insert(myTodo)
    }

    suspend fun delete(todo: ToDo) {
        dao.delete(todo)
    }
    suspend fun update(todo: ToDo) {
        dao.update(todo)
    }
}