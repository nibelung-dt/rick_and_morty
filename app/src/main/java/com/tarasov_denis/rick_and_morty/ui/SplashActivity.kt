package com.tarasov_denis.rick_and_morty.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.tarasov_denis.rick_and_morty.MainActivity
import com.tarasov_denis.rick_and_morty.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this, MainActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed({  startActivity(intent) }, 3000)
      //  startActivity(intent)
    }
}