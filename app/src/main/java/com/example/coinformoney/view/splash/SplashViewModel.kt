package com.example.coinformoney.view.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinformoney.dataStore.MyDataStore
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _first = MutableLiveData<Boolean>()
    val first: LiveData<Boolean>
        get() = _first

    fun checkFirstFlag() = viewModelScope.launch {
        val getData = MyDataStore().getFirstData()

        _first.value = getData
    }


}