package com.example.borutoapp.di

import android.content.Context
import com.example.borutoapp.data.repository.DataStoreOperationsImpl
import com.example.borutoapp.data.repository.Repository
import com.example.borutoapp.domain.repository.DataStoreOperations
import com.example.borutoapp.domain.use_cases.UseCases
import com.example.borutoapp.domain.use_cases.save_onboarding.readOnBoardingCase
import com.example.borutoapp.domain.use_cases.save_onboarding.saveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModel {
    @Provides
    @Singleton
    fun provodeDataStoreOperations(
        @ApplicationContext context:Context
    ):DataStoreOperations{
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository):UseCases{
        return UseCases(
            saveOnBoardingUseCase= saveOnBoardingUseCase(repository),
            readOnBoardingCase=readOnBoardingCase(repository)
        )
    }
}