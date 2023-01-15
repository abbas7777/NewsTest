package ir.ahe.abbas.newstest.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel(

    @SerialName("status")
    var status: String,

    @SerialName("totalResults")
    var totalResults: Int,

    @SerialName("articles")
    var articles: List<News>

    )
