package ir.ahe.abbas.newstest.Home

import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.call.*
import ir.ahe.abbas.newstest.Models.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class HomeUseCase @Inject constructor(val homeRepository: HomeRepository) {


    suspend fun getNewsList(q: String, from: String, sortBy: String, apiKey: String): Flow<List<News>> {

        val responseModel = homeRepository.getNews(q, from, sortBy, apiKey)
        val list: Flow<List<News>> = flow {
           emit(responseModel.articles)

        }
        return list
    }
}