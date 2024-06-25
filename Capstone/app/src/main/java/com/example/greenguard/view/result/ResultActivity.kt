package com.example.greenguard.view.result

import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.greenguard.R
import com.example.greenguard.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUri = intent.getStringExtra("IMAGE_URI")?.toUri()
        val disease = intent.getStringExtra("DISEASE")
        val handling = intent.getStringExtra("HANDLING")
        val plantType = intent.getStringExtra("PLANT_TYPE")

        imageUri?.let {
            binding.resultImage.setImageURI(it)
        }

        binding.resultText.text = getString(R.string.result_text, disease, plantType, handling)
    }
}
