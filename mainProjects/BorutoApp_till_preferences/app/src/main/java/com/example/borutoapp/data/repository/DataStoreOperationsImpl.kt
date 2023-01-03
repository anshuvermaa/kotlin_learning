package com.example.borutoapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.borutoapp.domain.repository.DataStoreOperations
import com.example.borutoapp.util.Constants.PREFERENCES_KEY
import com.example.borutoapp.util.Constants.PREFERENCES_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl(context: Context): DataStoreOperations {
    private object PreferencesKey{
        val onBoardingKey= booleanPreferencesKey(name = PREFERENCES_KEY)
    }


    private val dataStore=context.dataStore

    override suspend fun saveOnBoadingState(completed: Boolean) {
      dataStore.edit {
          preferences->
          preferences[PreferencesKey.onBoardingKey]=completed
      }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
       return dataStore.data
           .catch {exception->
               if(exception is IOException){
                   emit(emptyPreferences())
               }else{
                   throw exception
               }
           }
           .map { Preferences ->
               val onBoardingState =Preferences[PreferencesKey.onBoardingKey] ?: false
               onBoardingState

           }
    }
}