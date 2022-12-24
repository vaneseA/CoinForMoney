package com.example.coinformoney.view.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinformoney.dataStore.MyDataStore
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    fun checkFirstFlag() = viewModelScope.launch {
        val getData = MyDataStore().getFirstData()
    }


}