package com.example.greenguard.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.greenguard.fragment.forum.ForumFragment
import com.dicoding.greenguard.fragment.home.HomeFragment
import com.dicoding.greenguard.fragment.news.NewsFragment
import com.dicoding.greenguard.fragment.profile.ProfileFragment
import com.dicoding.greenguard.fragment.scanner.ScannerFragment
import com.example.greenguard.R
import com.example.greenguard.databinding.ActivityMainBinding
import com.example.greenguard.view.login.LoginActivity
import com.example.greenguard.view.register.RegisterActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the initial fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, HomeFragment())
                .commit()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Navigate to Home
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, HomeFragment())
                        .commit()
                    true
                }
                R.id.navigation_scanner -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, ScannerFragment())
                        .commit()
                    true
                }
                R.id.navigation_forum -> {
                    // Navigate to Forum
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, ForumFragment())
                        .commit()
                    true
                }
                R.id.navigation_news -> {
                    // Navigate to News
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, NewsFragment())
                        .commit()
                    true
                }
                R.id.navigation_profile -> {
                    // Navigate to Profile
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, ProfileFragment())
                        .commit()
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
