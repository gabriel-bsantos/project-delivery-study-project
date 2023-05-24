package com.composetest.advicesapp.domain.api

import com.composetest.advicesapp.data.response.AdviceSlipResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET


interface AppApi {

    @GET("advice")
    suspend fun getRandomAdvice(): NetworkResponse<AdviceSlipResponse, String>
}