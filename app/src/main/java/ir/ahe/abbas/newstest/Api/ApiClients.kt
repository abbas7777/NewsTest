package ir.ahe.abbas.newstest.Api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object ApiClients {


    @Provides
    @Singleton
    fun provideClient()= HttpClient(OkHttp){

        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            host = "newsapi.org/v2"
            url { protocol = URLProtocol.HTTPS }
        }



    }
}