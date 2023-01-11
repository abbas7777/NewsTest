package ir.ahe.abbas.newstest.Api

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.resources.*
import io.ktor.http.*

class ApiClient {

    companion object{
        val client= HttpClient(CIO){
            install(Resources)
            defaultRequest {
                host = "newsapi.org/v2"
                url { protocol = URLProtocol.HTTPS }
            }
        }
    }

}