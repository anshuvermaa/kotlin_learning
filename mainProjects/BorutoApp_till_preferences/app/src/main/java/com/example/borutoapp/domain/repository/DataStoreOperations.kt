package com.example.borutoapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveOnBoadingState(completed: Boolean)
    // we are not creating suspend second function because
    // return type if this is
    // Flow and Flow is by default syncronous data type
    fun readOnBoardingState():Flow<Boolean>
}


