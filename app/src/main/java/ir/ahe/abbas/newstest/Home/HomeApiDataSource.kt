package ir.ahe.abbas.newstest.Home

import io.ktor.client.plugins.resources.*
import io.ktor.client.statement.*
import ir.ahe.abbas.newstest.Api.ApiClient
import ir.ahe.abbas.newstest.Models.ResponseModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeApiDataSource () {

    suspend fun getNews(q:String, from:String, sortBy :String, apiKey: String):HttpResponse{

        return ApiClient.client.get(getNews(q, from, sortBy, apiKey))

    }
}