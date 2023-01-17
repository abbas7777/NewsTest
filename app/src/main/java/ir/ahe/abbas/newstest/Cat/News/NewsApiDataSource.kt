package ir.ahe.abbas.newstest.Cat.News

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import javax.inject.Inject

class NewsApiDataSource @Inject constructor(private val apiclient:HttpClient) {

    suspend fun getCatNews(sources:String, apiKey :String ):HttpResponse{
        return apiclient.get("/top-headlines"){
            url {
                parameter("sources" , sources)
                parameter("apiKey" , apiKey)
            }
        }

    }

}