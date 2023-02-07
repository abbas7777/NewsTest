package ir.ahe.abbas.newstest.database

import androidx.room.RoomDatabase
import androidx.room.Database

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao: NewsDao
}