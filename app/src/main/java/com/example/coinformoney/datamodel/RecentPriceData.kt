package com.example.coinformoney.datamodel

data class RecentPriceData(
    val transaction_date: String,
    val type: String,
    val units_traded: String,
    val price: String,
    val total: String
)