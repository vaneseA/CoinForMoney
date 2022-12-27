package com.example.coinformoney.background

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import timber.log.Timber

class GetCoinPriceRecentContractedWorkManager(val context : Context, workerParameters: WorkerParameters)
    : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {


        return Result.success()

    }
}