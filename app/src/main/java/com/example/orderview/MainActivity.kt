package com.example.orderview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            val name = findViewById<EditText>(R.id.txt1).text.toString()
            val food = findViewById<EditText>(R.id.txt2).text.toString()
            val drink = findViewById<EditText>(R.id.txt3).text.toString()
            
            val intent = Intent(this, datatransfer::class.java)
            intent.putExtra("name", name)
            intent.putExtra("food", food)
            intent.putExtra("drink", drink)
            startActivity(intent)
        }
    }
}
