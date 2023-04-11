package com.example.todolist

object ToDoRepository {

    private val myTodoList = mutableListOf<ToDo>()

    fun getToDoList(): MutableList<ToDo> {
        return myTodoList
    }

    fun addToDo(myTodo: ToDo) {
        myTodoList.add(myTodo)
//        myTodoList.add(ToDo("wash dishes", false))
//        myTodoList.add(ToDo("drink tea", true))
//        myTodoList.add(ToDo("study for exams", true))
//        myTodoList.add(ToDo("play football", false))
//        myTodoList.add(ToDo("wash hands", true))
//        myTodoList.add(ToDo("complete my CV", false))
//        myTodoList.add(ToDo("read 10 pages of a book", true))
//        myTodoList.add(ToDo("feed dog", false))
//        myTodoList.add(ToDo("call sis", true))
//        myTodoList.add(ToDo("Go swimming", true))
//        myTodoList.add(ToDo("take out the trash", false))
//        myTodoList.add(ToDo("get ready for uni conference", true))
//        myTodoList.add(ToDo("study MVVM", false))
//        myTodoList.add(ToDo("sleep 7 hours", true))
    }

}