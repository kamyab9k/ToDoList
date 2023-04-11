package com.example.todolist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
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
        _binding?.submitButton?.setOnClickListener {
            if (_binding!!.newTask.text.isNotEmpty()) {
                viewModel1.addToDo(ToDo(_binding!!.newTask.text.toString(), false))
                val intent = Intent(requireContext(), MainActivity::class.java)
                intent.putExtra("key", true)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "please enter your ToDo", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}

