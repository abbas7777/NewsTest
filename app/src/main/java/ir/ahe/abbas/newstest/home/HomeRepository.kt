package ir.ahe.abbas.newstest.home

import ir.ahe.abbas.newstest.models.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private var homeApiDataSource: HomeApiDataSource,
    private var homeDbDataSource: HomeDbDataSource,
) {

    suspend fun getNews(q: String, from: String, sortBy: String, apiKey: String): Flow<List<News>> {

        return flow {
            homeApiDataSource.getNews(q, from, sortBy, apiKey).articles?.let { emit(it) }
        }
    }

    fun getNewsLocal(): Flow<List<News>> {
        return homeDbDataSource.getNewsFromLocal().map {
            it.map { news ->
                News(
                    news.source,
                    news.author,
                    news.title,
                    news.description,
                    news.url,
                    news.urlToImage,
                    news.publishedAt,
                    news.content
                )
            }
        }
    }

}