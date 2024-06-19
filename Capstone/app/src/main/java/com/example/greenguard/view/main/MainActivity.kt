package com.example.greenguard.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.greenguard.R
import com.example.greenguard.databinding.ActivityMainBinding
import com.example.greenguard.view.login.LoginActivity
import com.example.greenguard.view.register.RegisterActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
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
                    // Navigate to Profile
                    true
                }
                else -> false
            }
        }

        binding.login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}
