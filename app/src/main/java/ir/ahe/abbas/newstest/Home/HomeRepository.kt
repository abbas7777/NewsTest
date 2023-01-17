package ir.ahe.abbas.newstest.Home

import io.ktor.client.call.*
import ir.ahe.abbas.newstest.Models.News
import ir.ahe.abbas.newstest.Models.ResponseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeRepository @Inject constructor( private var homeApiDataSource: HomeApiDataSource) {


    suspend fun getNews(q:String, from:String, sortBy :String, apiKey: String):Flow<List<News>>{

        val response:ResponseModel=homeApiDataSource.getNews(q, from, sortBy, apiKey)

        return flow {
            emit(response.articles )
        }
    }

}