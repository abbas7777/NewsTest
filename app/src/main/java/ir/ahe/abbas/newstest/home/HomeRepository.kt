package ir.ahe.abbas.newstest.home

import ir.ahe.abbas.newstest.models.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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