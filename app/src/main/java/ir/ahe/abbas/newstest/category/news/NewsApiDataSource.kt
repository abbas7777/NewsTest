package ir.ahe.abbas.newstest.category.news

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import ir.ahe.abbas.newstest.models.ResponseModel
import javax.inject.Inject

class NewsApiDataSource @Inject constructor(private val apiclient:HttpClient) {

    suspend fun getCatNews(sources:String, apiKey :String ):ResponseModel{
        var responseModel :ResponseModel
        try {
             responseModel  =apiclient.get("/top-headlines"){
                url {
                    parameter("sources" , sources)
                    parameter("apiKey" , apiKey)
                }
            }.body()
        }catch (e:Throwable){
            responseModel = ResponseModel("500",0,null)
            e.printStackTrace()
        }
        return responseModel

    }

}