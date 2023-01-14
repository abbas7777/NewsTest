package ir.ahe.abbas.newstest.Modules

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class News(
    @ColumnInfo(name = "source")
    var source: String,
    @ColumnInfo(name = "author")
    var author: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "urlToImage")
    var urlToImage: String,
    @ColumnInfo(name = "publishedAt")
    var publishedAt: String,
    @ColumnInfo(name = "content")
    var content: String
)
