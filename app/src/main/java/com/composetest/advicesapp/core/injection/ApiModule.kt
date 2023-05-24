package com.composetest.advicesapp.core.injection

import com.composetest.advicesapp.domain.api.AppApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun providesApi(retrofit: Retrofit): AppApi {
        return retrofit.create(AppApi::class.java)
    }
}