package com.example.coinformoney.network.model

import com.example.coinformoney.datamodel.RecentPriceData

data class RecentCoinPriceList (

    val status : String,
    val data : List<RecentPriceData>

)