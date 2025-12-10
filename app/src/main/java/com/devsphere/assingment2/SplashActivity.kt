package com.devsphere.assingment2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.devsphere.assingment2.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        // Delay 2 seconds → then open MainActivity
        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }, 2000) // 2000ms = 2 seconds
    }
}
