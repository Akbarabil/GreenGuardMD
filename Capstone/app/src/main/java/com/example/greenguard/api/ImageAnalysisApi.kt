package com.example.greenguard.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ImageAnalysisApi {
    @Multipart
    @POST("analyze-image")
    fun analyzeImage(
        @Part image: MultipartBody.Part
    ): Call<ApiResponse>
}