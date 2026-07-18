package com.example.login_page

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val username = findViewById<TextInputEditText>(R.id.username)
        val password = findViewById<TextInputEditText>(R.id.password)
        val login = findViewById<Button>(R.id.btn1)
        val signup1 = findViewById<TextView>(R.id.signup)
        login.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            if (username.isNotEmpty() and password.isNotEmpty()) {
                readdata(username)
            } else {
                Toast.makeText(this, "please enter the username", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        signup1.setOnClickListener {
            val i = Intent(applicationContext, Signup::class.java)
            startActivity(i)
        }
    }

    fun readdata(username: String) {
        database = FirebaseDatabase.getInstance().getReference("user")
        database.child(username).get().addOnSuccessListener {
            if (it.exists()) {
                val usenm = it.child("username").value
                val pass = it.child("password").value
                val email=it.child("email").value
                val username = findViewById<TextInputEditText>(R.id.username)
                val password = findViewById<TextInputEditText>(R.id.password)
                val usn = username.text.toString()
                val pasw = password.text.toString()
                if (usenm == usn && pass == pasw)
                {
                    val intent= Intent(applicationContext, home::class.java)
                    intent.putExtra("username",usenm.toString())
                    intent.putExtra("email",email.toString())
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, "enter the valid username and password", Toast.LENGTH_SHORT).show()
                }
                }
        }
    }
}