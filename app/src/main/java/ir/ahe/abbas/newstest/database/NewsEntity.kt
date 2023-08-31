package ir.ahe.abbas.newstest.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.ahe.abbas.newstest.models.SourceModel

@Entity
class NewsEntity (

    @PrimaryKey(autoGenerate = true)
    val ide:Int?,

    @Embedded
    var source: SourceModel,

    @ColumnInfo(name = "author", defaultValue = "author")
    var author: String,

    @ColumnInfo(name = "title", defaultValue = "title")
    var title: String,

    @ColumnInfo(name = "description", defaultValue = "description")
    var description: String,

    @ColumnInfo(name = "url", defaultValue = "url")
    var url: String,

    @ColumnInfo(name = "urlToImage", defaultValue = "urlToImage")
    var urlToImage: String,

    @ColumnInfo(name = "publishedAt", defaultValue = "publishedAt")
    var publishedAt: String,

    @ColumnInfo(name = "content", defaultValue = "content")
    var content: String
)