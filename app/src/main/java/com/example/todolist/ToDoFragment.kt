package com.example.todolist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.FragmentRvBinding

class ToDoFragment : Fragment() {
    private var _binding: FragmentRvBinding? = null
    lateinit var viewModel: ToDoViewModel

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

        viewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        observeData()

        _binding?.rvTodos?.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        _binding!!.addFabAndroid.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, AddTaskFragment())
                .commit()
        }
    }

    private fun observeData() {
        viewModel.apply {
            todoListLiveData.observe(viewLifecycleOwner) {
                it?.let { initAdapter(it) }
            }
        }
    }

    private fun initAdapter(todolist: List<ToDo>) {
        val adapter = TodoAdapter(todolist)
        adapter.onItemClicked = {
            viewModel.deleteToDo(it)
        }
        _binding!!.rvTodos.adapter = adapter
        _binding!!.rvTodos.layoutManager = LinearLayoutManager(requireContext())
    }
}




