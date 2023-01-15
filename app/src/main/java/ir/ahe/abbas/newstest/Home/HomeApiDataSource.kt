package ir.ahe.abbas.newstest.Home

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import ir.ahe.abbas.newstest.Models.ResponseModel
import javax.inject.Inject

class HomeApiDataSource @Inject constructor( private val api:HttpClient) {

    suspend fun getNews(q:String, from:String, sortBy :String, apiKey: String):ResponseModel{
       val res= api.get("/everything") {
            url {
                parameter("q",q)
                parameter("from",from)
                parameter("sortBy",sortBy)
                parameter("apiKey",apiKey)
            }
        }

        val s=res.body<String>()

        Log.e("ACE", "getNews: "+s )
        return res.body()
    }

}