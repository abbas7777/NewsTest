package ir.ahe.abbas.newstest.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SourceModel(
    @SerialName("id")
    var id: String? = "ggg",

    @SerialName("name")
    var name :String?
)