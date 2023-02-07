package ir.ahe.abbas.newstest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsEntity")
    fun getAllNews(): Flow<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(news: NewsEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(news: List<NewsEntity>)
}