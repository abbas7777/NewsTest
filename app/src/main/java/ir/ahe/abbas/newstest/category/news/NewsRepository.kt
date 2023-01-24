package ir.ahe.abbas.newstest.category.news

import ir.ahe.abbas.newstest.models.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApiDataSource: NewsApiDataSource) {


    suspend fun getCatNews(sources:String, apiKey :String ):Flow<List<News>> {
        return flow {
            newsApiDataSource.getCatNews(sources, apiKey).articles?.let { emit(it) }
        }

    }
}