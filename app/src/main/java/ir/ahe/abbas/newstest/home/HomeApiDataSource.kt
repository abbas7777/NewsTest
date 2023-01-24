package ir.ahe.abbas.newstest.home

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import ir.ahe.abbas.newstest.models.ResponseModel
import javax.inject.Inject

class HomeApiDataSource @Inject constructor(private val api: HttpClient) {

    suspend fun getNews(q: String, from: String, sortBy: String, apiKey: String): ResponseModel {

        var responseModel :ResponseModel

        try {
            responseModel  =api.get("/everything") {
                url {
                    parameter("q", q)
                    parameter("from", from)
                    parameter("sortBy", sortBy)
                    parameter("apiKey", apiKey)
                }
            }.body()
        }catch (e:Throwable){
            responseModel = ResponseModel("500",0,null)
            e.printStackTrace()
        }

        return responseModel

    }

}