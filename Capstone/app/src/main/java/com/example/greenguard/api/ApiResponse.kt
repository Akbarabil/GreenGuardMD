package com.example.greenguard.api

import com.google.gson.annotations.SerializedName

data class ApiResponse(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Result(

	@field:SerializedName("disease")
	val disease: String? = null,

	@field:SerializedName("handling")
	val handling: String? = null,

	@field:SerializedName("plant_type")
	val plantType: String? = null
)
