package com.example.login_page

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login_page.R.id.signup
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {

    lateinit var database : DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signup1=findViewById<TextView>(signup)
        val email=findViewById<TextInputEditText>(R.id.email)
        val phone=findViewById<TextInputEditText>(R.id.phone)
        val username=findViewById<TextInputEditText>(R.id.username)
        val password=findViewById<TextInputEditText>(R.id.password)
        val login=findViewById<Button>(R.id.bnt1)
        login.setOnClickListener {
            val eml=email.text.toString()
            val pho=phone.text.toString()
            val usern=username.text.toString()
            val pass=password.text.toString()
            val data= Database(eml,pho,usern,pass)
            database= FirebaseDatabase.getInstance().getReference("user")
            database.child(usern).setValue(data).addOnSuccessListener {
                Toast.makeText(this, "Succesfull Registered", Toast.LENGTH_SHORT).show()
            }
        }
        signup1.setOnClickListener {
            val intent= Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}