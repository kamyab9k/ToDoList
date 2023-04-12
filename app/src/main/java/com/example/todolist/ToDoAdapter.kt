package com.example.todolist

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
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

            if (todoList[position].isChecked) {
                tvTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                tvTitle.paintFlags = tvTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
//
//            cbDone.setOnCheckedChangeListener { button, isChecked ->
//                onItemClicked()
//            }

            cbDone.setOnCheckedChangeListener { _, isChecked ->
                todoList[position].isChecked = isChecked
                onItemClicked()
                if (isChecked) {
                    tvTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

                } else {
                    tvTitle.paintFlags = tvTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

}
