package com.composetest.advicesapp.data.repository

import com.composetest.advicesapp.core.extensions.convert
import com.composetest.advicesapp.domain.api.AppApi
import com.composetest.advicesapp.domain.repository.AdviceRepository
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject


class AdviceRepositoryImpl @Inject constructor(
    private val appApi: AppApi
) : AdviceRepository {

    override suspend fun getRandomAdvice(): NetworkResponse<String, String> {
        return appApi.getRandomAdvice().convert { response ->
            response.slip?.advice.orEmpty()
        }
    }
}