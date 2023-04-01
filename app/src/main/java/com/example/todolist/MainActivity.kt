package com.example.todolist

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, ToDoFragment(), "ToDoList")
            .commit()

        supportActionBar?.title = "Your ToDo List"

        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {

        supportFragmentManager.popBackStack();
        super.onBackPressed()
    }

}


//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            android.R.id.home -> {
//                finish()
//                return true
//            }
//        }
//        return super.onContextItemSelected(item)
//    }


//        supportActionBar?.apply {
//            setDisplayHomeAsUpEnabled(true)
//           setDisplayShowHomeEnabled(true)
//        }


