package com.example.borutoapp.domain.use_cases

import com.example.borutoapp.domain.use_cases.save_onboarding.readOnBoardingCase
import com.example.borutoapp.domain.use_cases.save_onboarding.saveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: saveOnBoardingUseCase,
    val readOnBoardingCase: readOnBoardingCase
)
