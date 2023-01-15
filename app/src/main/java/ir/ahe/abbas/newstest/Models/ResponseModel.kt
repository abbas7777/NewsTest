package ir.ahe.abbas.newstest.Models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel(var status: String, var totalResult: Int, var articles: List<News>)
