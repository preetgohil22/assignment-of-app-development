package com.example.orderview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class datatransfer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_datatransfer)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve data from Intent
        val name = intent.getStringExtra("name")
        val food = intent.getStringExtra("food")
        val drink = intent.getStringExtra("drink")

        // Display data in TextViews
       val t1=findViewById<TextView>(R.id.t1)
        t1.text="Hello, $name your order is $food and $drink ."

    }
}
