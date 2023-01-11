package ir.ahe.abbas.newstest.Api

import io.ktor.resources.*


@Resource("/everything")
class getNews(val q: String? = "q",val from:String ="from",val sortBy:String="sortBy",val apiKey :String="apiKey")

