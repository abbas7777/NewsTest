package ir.ahe.abbas.newstest.LocalDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Provides
import ir.ahe.abbas.newstest.Models.News
import javax.inject.Singleton

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class LocalDatabase :RoomDatabase(){


    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null


        fun getDatabase(c: Context): LocalDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    c.applicationContext,
                    LocalDatabase::class.java,
                    "database",
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}