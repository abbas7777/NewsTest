package ir.ahe.abbas.newstest.Home

import io.ktor.client.call.*
import ir.ahe.abbas.newstest.Models.ResponseModel
import javax.inject.Inject

class HomeRepository @Inject constructor( var homeApiDataSource: HomeApiDataSource) {


    suspend fun getNews(q:String, from:String, sortBy :String, apiKey: String):ResponseModel{

        return homeApiDataSource.getNews(q, from, sortBy, apiKey).body()
    }

}