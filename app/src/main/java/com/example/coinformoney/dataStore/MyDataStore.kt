package com.example.coinformoney.dataStore

import android.content.Context
import  androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.coinformoney.App


class MyDataStore {

    private val context = App.context()

    companion object {
        private val Context.datastore: DataStore<Preferences> by preferencesDataStore("user_pref")
    }

    private val mDataStore: DataStore<Preferences> = context.datastore

    private val FIRST_FLAG = booleanPreferencesKey("FIRST_FLAG")

    // 메인액티비티로 갈 때 True로 변경

    // 처음 접속하는 유저->false
    // 처음이 아닌 유저 ->true


    suspend fun setupFirstData() {
        mDataStore.edit { preferences ->
            preferences[FIRST_FLAG] = true
        }
    }

    suspend fun getFirstData(): Boolean {
        var currentValue = false

        mDataStore.edit { preferences ->
            currentValue = preferences[FIRST_FLAG] ?: false
        }

        return currentValue
    }
}