package com.composetest.advicesapp.core.injection

import com.composetest.advicesapp.data.repository.AdviceRepositoryImpl
import com.composetest.advicesapp.domain.repository.AdviceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsAdviceRepository(adviceRepositoryImpl: AdviceRepositoryImpl): AdviceRepository
}