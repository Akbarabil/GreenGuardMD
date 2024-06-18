package com.example.greenguard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Navigate to Home
                    true
                }
                R.id.navigation_scanner -> {
                    true
                }
                R.id.navigation_forum -> {
                    // Navigate to Forum
                    true
                }
                R.id.navigation_news -> {
                    // Navigate to News
                    true
                }
                R.id.navigation_profile -> {
                    // Navigate to News
                    true
                }
                else -> false
            }
        }
    }
}