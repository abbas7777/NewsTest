package ir.ahe.abbas.newstest.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class News(
    @SerialName("source")
    var source: SourceModel?,

    @SerialName("author")
    var author: String?,

    @SerialName("title")
    var title: String?,

    @SerialName("description")
    var description: String?,

    @SerialName("url")
    var url: String?,

    @SerialName("urlToImage")
    var urlToImage: String?,

    @SerialName("publishedAt")
    var publishedAt: String?,

    @SerialName("content")
    var content: String?
) : Parcelable
