package ir.ahe.abbas.newstest.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
class SourceModel(
    @SerialName("id")
    var id: String? = "ggg",

    @SerialName("name")
    var name :String?
) : Parcelable