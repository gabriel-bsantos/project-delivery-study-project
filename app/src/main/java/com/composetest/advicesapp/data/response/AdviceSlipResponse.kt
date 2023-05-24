package com.composetest.advicesapp.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdviceSlipResponse(
	@Json(name="slip")
	val slip: SlipResponse? = null
)


