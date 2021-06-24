package com.raywenderlich.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.models.ArticlesItem
import com.raywenderlich.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArticlesViewModel :ViewModel() {

    private var _data = MutableLiveData<List<ArticlesItem>>()

    val data: LiveData<List<ArticlesItem>> get() = _data


  private  var _isLoader  = MutableLiveData<Boolean>()
    val isLoader: LiveData<Boolean> get() = _isLoader


    fun loader(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val loadData = ApiService.apiService.getArticles()
                _data.postValue(loadData.body())
                _isLoader.postValue(false)
            }

        }
    }



}