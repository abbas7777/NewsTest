package ir.ahe.abbas.newstest.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.ahe.abbas.newstest.App
import javax.inject.Singleton

@InstallIn(App::class)
@Module
object DatabaseModule {

    @Provides
    fun provideNewsDao(database: Database): NewsDao {
        return database.newsDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context = context,
            Database::class.java,
            "Database"
        ).build()
    }
}