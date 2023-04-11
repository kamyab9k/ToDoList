package com.example.todolist

import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {


    fun getToDoList(): MutableList<ToDo> {
        return ToDoRepository.getToDoList()
    }

    fun deleteToDo(myDelete: ToDo) {
        println("delete is called")
//        myTodoList.remove(myDelete)
    }

    fun addToDo(myTodo: ToDo) {
        ToDoRepository.addToDo(myTodo)
    }

}