package com.composetest.advicesapp.domain.repository

import com.haroldadmin.cnradapter.NetworkResponse

interface AdviceRepository {
    suspend fun getRandomAdvice(): NetworkResponse<String, String>
}