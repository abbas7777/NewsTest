package ir.ahe.abbas.newstest.Home

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ahe.abbas.newstest.Models.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( val homeRepository: HomeRepository) : ViewModel() {


    @SuppressLint("SuspiciousIndentation")
    suspend fun getNewsLiveData(q:String, from:String, sortBy :String, apiKey: String):LiveData<List<News>>{


        val list: Flow<List<News>> =homeRepository.getNews(q, from, sortBy, apiKey)

        return list.asLiveData()

    }


}