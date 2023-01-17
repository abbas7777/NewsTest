package ir.ahe.abbas.newstest.Home

import android.util.Log
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import ir.ahe.abbas.newstest.Models.ResponseModel
import kotlinx.serialization.json.Json
import javax.inject.Inject

class HomeApiDataSource @Inject constructor(private val api: HttpClient) {

    suspend fun getNews(q: String, from: String, sortBy: String, apiKey: String): ResponseModel {
        return api.get("/everything") {
            url {
                parameter("q", q)
                parameter("from", from)
                parameter("sortBy", sortBy)
                parameter("apiKey", apiKey)
            }
        }.body()

    }

}