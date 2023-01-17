package ir.ahe.abbas.newstest.Cat.News

import io.ktor.client.call.*
import ir.ahe.abbas.newstest.Models.News
import ir.ahe.abbas.newstest.Models.ResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApiDataSource: NewsApiDataSource) {


    suspend fun getCatNews(sources:String, apiKey :String ):Flow<List<News>> {
        val responseModel :ResponseModel=newsApiDataSource.getCatNews(sources, apiKey).body()

        return flow {
            emit(responseModel.articles)
        }

    }
}