package com.example.coinformoney.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.coinformoney.R
import timber.log.Timber

class SelectActivity : AppCompatActivity() {

    private val viewModel: SelectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        viewModel.getCurrentCoinList()
        viewModel.currentPriceResult.observe(this, Observer {
            Timber.d(it.toString())
        })
    }
}