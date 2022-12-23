package com.example.coinformoney.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinformoney.repository.NetWorkRepository
import kotlinx.coroutines.launch

class SelectViewModel : ViewModel() {

    private val netWorkRepository = NetWorkRepository()

    fun getCurrentCoinList() = viewModelScope.launch {
        val result = netWorkRepository.getCurrentCoinList()

    }
}