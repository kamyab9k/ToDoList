package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {

    private val _todoListLiveData = MutableLiveData<MutableList<ToDo>>()
    val todoListLiveData: LiveData<MutableList<ToDo>> = _todoListLiveData

    fun getToDoList() {
        _todoListLiveData.postValue(ToDoRepository.getToDoList())
    }


    fun deleteToDo(myDelete: ToDo) {
        println("delete is called")
//        myTodoList.remove(myDelete)
    }

    fun addToDo(myTodo: ToDo) {
        ToDoRepository.addToDo(myTodo)
    }

}