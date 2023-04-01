package com.example.todolist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.FragmentRvBinding

class ToDoFragment : Fragment() {
    private var _binding: FragmentRvBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRvBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        viewModel.addToDo(ToDo("test", true))
        val adapter = TodoAdapter(viewModel.getToDoList())
        adapter.onItemClicked = {
           viewModel.deleteToDo(ToDo("khar",false))
        }

        _binding!!.rvTodos.adapter = adapter
        _binding!!.rvTodos.layoutManager = LinearLayoutManager(requireContext())

        _binding!!.addFabAndroid.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, AddTaskFragment())
                .commit()
        }


//
//            val title = _binding!!.etTODO.text.toString()
//            val todo = ToDo(title, false)
//            todoList.add(todo)
//            adapter.notifyItemInserted(
//                todoList.size
//                        - 1
//            )
//        }


    }
}





