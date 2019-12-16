package com.example.youin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
    lateinit var listsRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        //NavigationUI.setupActionBarWithNavController(this,navController)

        NavigationUI.setupWithNavController(binding.navView, navController)

        //1
        listsRecyclerView = findViewById(R.id.lists_recyclerview)
        //2
        listsRecyclerView.layoutManager = LinearLayoutManager(this)
        //3
        listsRecyclerView.adapter = ListSelectionRecyclerViewAdapter()
    }
}
