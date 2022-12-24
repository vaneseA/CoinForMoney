package com.example.coinformoney.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coinformoney.db.dao.InterestCoinDAO
import com.example.coinformoney.db.entity.InterestCoinEntity


@Database(entities = [InterestCoinEntity::class], version = 1)
abstract class CoinPriceDatabase : RoomDatabase() {
    abstract fun interestCoinDAO(): InterestCoinDAO

    companion object {

        @Volatile
        private var INSTANCE: CoinPriceDatabase? = null

        fun getDatabase(
            context: Context
        ): CoinPriceDatabase {
            return INSTANCE ?: synchronized(this) {
                val intance = Room.databaseBuilder(
                    context.applicationContext,
                    CoinPriceDatabase::class.java,
                    "coin_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = intance
                intance
            }
        }
    }
}