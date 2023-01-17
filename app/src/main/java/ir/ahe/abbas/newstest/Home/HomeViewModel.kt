package ir.ahe.abbas.newstest.Home

import android.annotation.SuppressLint
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ahe.abbas.newstest.Models.News
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val homeRepository: HomeRepository) : ViewModel() {


    private var _news: MutableLiveData<List<News>> =MutableLiveData()
    var news: LiveData<List<News>> = _news

    fun getNews(q:String, from:String, sortBy :String, apiKey: String){
        viewModelScope.launch{
            homeRepository.getNews(q, from, sortBy, apiKey).collect() {
                _news.postValue(it)
            }

        }
    }


}