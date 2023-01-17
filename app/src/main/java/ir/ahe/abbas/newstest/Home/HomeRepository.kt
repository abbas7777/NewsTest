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

        var list:List<News> =ArrayList<News>()
        try {
            val response=homeApiDataSource.getNews(q, from, sortBy, apiKey)
            list=response.articles
        }catch (e:Throwable){
            e.printStackTrace()
        }
        return flow {
            emit(list)
        }
    }

}