package ir.ahe.abbas.newstest.Home

import io.ktor.client.call.*
import io.ktor.client.plugins.resources.*
import ir.ahe.abbas.newstest.Api.ApiClients
import ir.ahe.abbas.newstest.Modules.ResponseModule
import javax.inject.Inject

class HomeApiDataSource @Inject constructor( private val api:ApiClients) {

    suspend fun getNews(q:String, from:String, sortBy :String, apiKey: String):ResponseModule{

        val ss:ResponseModule=api.provideClient().get(getNews(q, from, sortBy, apiKey)).body()

        return ss

    }
}