package ir.ahe.abbas.newstest.database

import androidx.room.RoomDatabase
import androidx.room.Database

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}