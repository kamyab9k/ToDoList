package com.example.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel (application: Application) : AndroidViewModel(application) {
    private val _todoListLiveData = MutableLiveData<List<ToDo>>()
    var todoListLiveData: LiveData<MutableList<ToDo>> = _todoListLiveData
    val repository : ToDoRepository
init {
    val dao=ToDoDatabase.getDatabase(application).ToDoDao
    repository = ToDoRepository(dao)
    var allToDos = repository.allToDo
}
    fun getToDoList() {
        _todoListLiveData.postValue(repository.allToDo)
    }

    fun deleteToDo(myTodo: ToDo) {
        println("delete is called")
        repository.delete(myTodo)
    }

    fun addToDo(myTodo: ToDo) {
        repository.addToDo(myTodo)
    }
}