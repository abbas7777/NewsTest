package ir.ahe.abbas.newstest.LocalDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.ahe.abbas.newstest.Modules.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM News  ")
    fun getAllNews():Flow<List<News>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(news: News)
}