package com.example.todolist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

//private val myTodoList = mutableListOf<ToDo>()

//@Dao
//interface ToDoDao {
//
//    @Query("SELECT * FROM user")
//    fun getToDoList(): MutableList<ToDo> {
//        return myTodoList
//    }
//
//    @Upsert
//    fun upsertToDoO(myTodo: ToDo) {
//        myTodoList.add(myTodo)
//    }
//
//    @Delete
//    fun delete(todo: ToDo) {
//        myTodoList.remove(todo)
//    }
//}