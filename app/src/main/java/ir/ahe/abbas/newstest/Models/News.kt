package ir.ahe.abbas.newstest.Models

import kotlinx.serialization.Serializable

@Serializable
data class News(
    var source: SourceModel,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String
)
