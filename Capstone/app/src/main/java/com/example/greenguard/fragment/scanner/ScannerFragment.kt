package com.dicoding.greenguard.fragment.scanner

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.example.greenguard.api.ApiConfig
import com.example.greenguard.api.ApiResponse
import com.example.greenguard.databinding.FragmentScannerBinding
import com.example.greenguard.view.result.ResultActivity
import com.yalantis.ucrop.UCrop
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class ScannerFragment : Fragment() {

    private var currentImageUri: Uri? = null
    private lateinit var binding: FragmentScannerBinding

    private val uCropContract = object : ActivityResultContract<Pair<Uri, Uri>, Uri?>() {
        override fun createIntent(context: Context, input: Pair<Uri, Uri>): Intent {
            val (inputUri, outputUri) = input
            return UCrop.of(inputUri, outputUri)
                .withAspectRatio(1f, 1f)
                .withMaxResultSize(512, 512)
                .getIntent(context)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
            return intent?.let { UCrop.getOutput(it) }
        }
    }

    private val uCropLauncher = registerForActivityResult(uCropContract) { uri ->
        uri?.let {
            currentImageUri = it
            showImage(it)
        } ?: showToast("Image cropping failed")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imagebuttonUploadPhoto.setOnClickListener { startGallery() }
        binding.buttonAnalyze.setOnClickListener { analyzeImage() }
    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        uri?.let {
            val outputUri = File(requireContext().filesDir, "cropped_${System.currentTimeMillis()}.jpg").toUri()
            uCropLauncher.launch(Pair(it, outputUri))
        } ?: Log.d("Photo Picker", "No media selected")
    }

    private fun showImage(uri: Uri) {
        Log.d("Image URI", "showImage: $uri")
        binding.previewImageView.setImageURI(null)
        binding.previewImageView.setImageURI(uri)
    }

    private fun analyzeImage() {
        currentImageUri?.let { uri ->
            val filePath = getFilePathFromUri(uri)
            if (filePath != null) {
                val file = File(filePath)
                val requestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
                val multipartBody = MultipartBody.Part.createFormData("image", file.name, requestBody)

                ApiConfig.api.analyzeImage(multipartBody).enqueue(object : Callback<ApiResponse> {
                    override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                        if (response.isSuccessful) {
                            response.body()?.result?.let {
                                moveToResult(uri.toString(), it.toString())
                            } ?: showToast("Image analysis returned no result")
                        } else {
                            showToast("Image analysis failed: ${response.message()}")
                            Log.e("Analyze Image", "Error: ${response.errorBody()?.string()}")
                        }
                    }

                    override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                        showToast("Failed to analyze image: ${t.message}")
                        Log.e("Analyze Image", "Failure: ${t.message}", t)
                    }
                })
            } else {
                showToast("Failed to get file path from URI")
            }
        } ?: showToast("Please select an image first")
    }
    private fun getFilePathFromUri(uri: Uri): String? {
        // Implement method to get the file path from URI
        // This may involve querying the MediaStore or using a File API
        // Returning uri.path for simplicity, update as needed
        return uri.path
    }

    private fun moveToResult(imageUri: String, displayResult: String) {
        val intent = Intent(requireContext(), ResultActivity::class.java).apply {
            putExtra("IMAGE_URI", imageUri)
            putExtra("ANALYSIS_RESULT", displayResult)
        }
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
