package ir.ahe.abbas.newstest.Home

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ahe.abbas.newstest.Models.News
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @AssistedInject constructor( val homeUseCase: HomeUseCase) : ViewModel() {


    @SuppressLint("SuspiciousIndentation")
    suspend fun getNewsLiveData(q:String, from:String, sortBy :String, apiKey: String):LiveData<List<News>>{

      val list: Flow<List<News>> =homeUseCase.getNewsList(q, from, sortBy, apiKey)

        return list.asLiveData()
    }


}