package com.example.coinformoney.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coinformoney.db.entity.SelectedCoinPriceEntity

@Dao
interface SelectedCoinPriceDAO {

    // getAllData
    @Query("SELECT * FROM selected_coin_price_table")
    fun getAllData() : List<SelectedCoinPriceEntity>

    // insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(selectedCoinPriceEntity: SelectedCoinPriceEntity)

    // 하나의 코인에 대해서 저장된 정보를 가져오는 역할
    // BTC 15분전 30분전 45분전 -> List<BTC> -> 현재가격 15분전 30분전 45분전 어떻게 변화했는지 DB에 저장된 값과 비교하는 용도
    @Query("SELECT * FROM selected_coin_price_table WHERE coinName = :coinName")
    fun getOneCoinData(coinName : String) : List<SelectedCoinPriceEntity>

//
}