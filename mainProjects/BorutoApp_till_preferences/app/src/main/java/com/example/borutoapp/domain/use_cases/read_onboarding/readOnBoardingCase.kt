package com.example.borutoapp.domain.use_cases.save_onboarding

import com.example.borutoapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class readOnBoardingCase (
    private val repository: Repository
){
    suspend operator fun invoke():Flow<Boolean>{
       return repository.readOnBoardingState()
    }
}