package com.composetest.advicesapp.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SlipResponse(
    @Json(name="advice")
    val advice: String? = null,
    @Json(name="id")
    val id: Int? = null
)