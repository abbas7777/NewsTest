package ir.ahe.abbas.newstest.home

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ahe.abbas.newstest.models.News
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val homeRepository: HomeRepository) : ViewModel() {

    init {
        getNews()
        getNewsFromLocal()
    }

    var news = MutableStateFlow<List<News>>(emptyList())

    private fun getNews(){
        viewModelScope.launch{
            homeRepository.getNews(
                "Apple",
                "2023-01-12",
                "popularity",
                "79819d81c81c4b5aa23c25e99ce15029"

            ).collect {
                news.emit(it)
            }

        }
    }

   private fun getNewsFromLocal(){
       viewModelScope.launch {
           homeRepository.getNewsLocal().collect{
               news.emit(it)
           }
       }
   }
}