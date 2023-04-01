package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.databinding.FragmentAddTaskBinding


class AddTaskFragment : Fragment() {

    private var _binding: FragmentAddTaskBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val viewModel1 = ViewModelProvider(this)[ToDoViewModel::class.java]
        _binding?.submitButton?.setOnClickListener{
            viewModel1.addToDo(ToDo(_binding!!.newTask.text.toString(),false))
        }
    }

}

