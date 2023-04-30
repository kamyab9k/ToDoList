package com.example.todolist

import android.gesture.GestureStroke
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    var title: String,
    var isChecked: Boolean,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
)
