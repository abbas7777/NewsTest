package ir.ahe.abbas.newstest.Home

import ir.ahe.abbas.newstest.Modules.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor( private var homeApiDataSource: HomeApiDataSource) {


    suspend fun getNews(q:String, from:String, sortBy :String, apiKey: String):Flow<List<News>>{

        val list:Flow<List<News>> = flow {
            emit(homeApiDataSource.getNews(q, from, sortBy, apiKey).articles )
        }

        return list
    }

}