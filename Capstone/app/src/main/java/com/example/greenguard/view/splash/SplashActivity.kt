package com.example.greenguard.view.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.greenguard.R
import com.example.greenguard.view.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        },  3000L)
    }

    private fun goToMainActivity(){
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}