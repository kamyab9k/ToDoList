package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding


class TodoAdapter(
    var todoList: List<ToDo>,

    ) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    lateinit var onItemClicked: (() -> Unit)

    inner class TodoViewHolder(val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = todoList[position].title
            cbDone.isChecked = todoList[position].isChecked
//
//            cbDone.setOnCheckedChangeListener { button, isChecked ->
//                onItemClicked()
//            }

            cbDone.setOnCheckedChangeListener { _, isChecked ->
                todoList[position].isChecked=isChecked
                if (!isChecked) {
                    onItemClicked()
                }


            }
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

}