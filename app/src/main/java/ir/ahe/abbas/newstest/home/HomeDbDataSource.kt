package ir.ahe.abbas.newstest.home

import ir.ahe.abbas.newstest.database.NewsDao
import ir.ahe.abbas.newstest.database.NewsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeDbDataSource @Inject constructor(private val newsDao: NewsDao) {

    fun getNewsFromLocal(): Flow<List<NewsEntity>> {
        return newsDao.getAllNews()
    }

    suspend fun addNews(listNewsEntity: List<NewsEntity>) {
        newsDao.insertAll(listNewsEntity)
    }
}