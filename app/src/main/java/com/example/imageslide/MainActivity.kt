package com.example.imageslide

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var  currentimage=0
    lateinit var image : ImageView
    val name=arrayOf("SHIVA","PREET","KRISHNA")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pre=findViewById<ImageButton>(R.id.btn2) // btn2 is Rewind (Previous)
        val next=findViewById<ImageButton>(R.id.btn1) // btn1 is Fast Forward (Next)
        val textview=findViewById<TextView>(R.id.text1)
        
        // Set initial state
        textview.text = name[currentimage]

        pre.setOnClickListener {
            var imagestring= "pic${currentimage + 1}"
            val imageint=this.resources.getIdentifier(imagestring,"id",packageName)
            image= findViewById(imageint)
            image.alpha=0f

            currentimage=(3+currentimage-1)%3
            var imagetosow= "pic${currentimage + 1}"
            val imageintger=this.resources.getIdentifier(imagetosow,"id",packageName)
            image= findViewById(imageintger)
            image.alpha=1f
            textview.setText(name[currentimage])
        }
        next.setOnClickListener {
            var imagestring= "pic${currentimage + 1}"
            val imageint=this.resources.getIdentifier(imagestring,"id",packageName)
            image=findViewById(imageint)
            image.alpha=0f

            currentimage=(3+currentimage+1)%3
            var imagetoshow= "pic${currentimage + 1}"
            val imageintger=this.resources.getIdentifier(imagetoshow,"id",packageName)
            image= findViewById(imageintger)
            image.alpha=1f
            textview.setText(name[currentimage])
        }
    }
}