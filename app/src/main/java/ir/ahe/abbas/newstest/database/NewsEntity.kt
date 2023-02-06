package ir.ahe.abbas.newstest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.ahe.abbas.newstest.models.SourceModel

@Entity
class NewsEntity (

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @ColumnInfo(name = "source")
    var source: SourceModel,

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