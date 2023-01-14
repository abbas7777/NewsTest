package ir.ahe.abbas.newstest.Api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.resources.*
import io.ktor.http.*
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object ApiClients {


    @Provides
    @Singleton
    fun provideClient()= HttpClient(CIO){

        install(Resources)
        defaultRequest {
            host = "newsapi.org/v2"
            url { protocol = URLProtocol.HTTPS }
        }

    }
}