package ir.ahe.abbas.newstest.category.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ahe.abbas.newstest.models.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    var news = MutableStateFlow<List<News>>(emptyList())

     fun getCatNews(sources: String, apiKey: String) {

        viewModelScope.launch {
            newsRepository.getCatNews(sources, apiKey).collect {
                news.emit(it)
            }

        }
    }
}