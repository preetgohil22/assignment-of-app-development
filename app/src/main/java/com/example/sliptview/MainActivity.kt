package com.example.sliptview

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
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
        
        supportActionBar?.hide()

        val amazonLogo = findViewById<ImageView>(R.id.amazonLogo)
        val amazonText = findViewById<TextView>(R.id.amazonText)

        // Animation for Logo: Slide down and Fade in
        amazonLogo.translationY = -100f
        amazonLogo.animate()
            .translationY(0f)
            .alpha(1f)
            .setDuration(1000)
            .start()

        // Animation for Text: Slide up and Fade in
        amazonText.translationY = 100f
        amazonText.animate()
            .translationY(0f)
            .alpha(1f)
            .setDuration(1000)
            .setStartDelay(200)
            .withEndAction {
                // Navigate after animations finish
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, amzon::class.java)
                    startActivity(intent)
                    finish()
                }, 1000)
            }
            .start()
    }
}