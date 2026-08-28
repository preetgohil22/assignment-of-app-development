package com.example.listview

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       val listview=findViewById<ListView>(R.id.listview1)
        val list=arrayListOf<String>()
        list.add("Login")
        list.add("Home")
        list.add("Task")
        list.add("Total task")
        list.add("Exit")
        val Arrayadapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listview.adapter=Arrayadapter


        listview.setOnItemClickListener { parent, view, position, id ->
            val item = list[position]
            Toast.makeText(this, "Clicked: $item", Toast.LENGTH_SHORT).show()
        }
    }
}