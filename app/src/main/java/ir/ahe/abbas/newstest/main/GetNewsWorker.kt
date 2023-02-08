package ir.ahe.abbas.newstest.main

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import ir.ahe.abbas.newstest.home.HomeRepository

@HiltWorker
class GetNewsWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val homeRepository: HomeRepository
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {

        homeRepository.getNews(
            "Apple",
            "2023-01-12",
            "popularity",
            "79819d81c81c4b5aa23c25e99ce15029"
        ).collect {
            homeRepository.addNews(it)
            Log.i("ace", "doWork: ${it[0].content}")

        }
        return Result.retry()
    }
}