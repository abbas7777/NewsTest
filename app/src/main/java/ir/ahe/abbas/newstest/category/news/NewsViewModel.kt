package ir.ahe.abbas.newstest.category.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ahe.abbas.newstest.models.News
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    private var _news: MutableLiveData<List<News>> = MutableLiveData()
    var news: LiveData<List<News>> = _news

     fun getCatNews(sources: String, apiKey: String) {

        viewModelScope.launch {
            newsRepository.getCatNews(sources, apiKey).collect {
                _news.postValue(it)
            }

        }
    }
}