package com.example.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel (application: Application) : AndroidViewModel(application) {

    val todoListLiveData: LiveData<List<ToDo>>
    private val repository : ToDoRepository

    init {
        val dao = ToDoDatabase.getDatabase(application).getTodosDao()
        repository = ToDoRepository(dao)
        todoListLiveData = repository.getToDoList()
    }

    fun deleteToDo(myTodo: ToDo) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.delete(myTodo)
        }
    }

    fun addToDo(myTodo: ToDo) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.addToDo(myTodo)
        }
    }
}