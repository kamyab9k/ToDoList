package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todoTable")
    fun getToDoListDao(): LiveData<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo : ToDo)

    @Delete
    suspend fun delete(todo: ToDo)

    @Update
    suspend fun update(todo: ToDo)

}