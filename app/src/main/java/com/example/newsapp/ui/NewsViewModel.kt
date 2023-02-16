package com.example.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.R
import com.example.newsapp.domain.Repository
import com.example.newsapp.domain.models.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _newsLiveData = MutableLiveData<List<News>>()
    val newsLiveData: LiveData<List<News>> get() = _newsLiveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    private val handler = CoroutineExceptionHandler { _, throwable: Throwable ->
        when (throwable) {
            is SocketTimeoutException -> _errorLiveData.value = R.string.SocketTimeoutException
            else -> _errorLiveData.value = R.string.OtherExceptions
        }
    }

    fun getNewsList() {
        viewModelScope.launch(handler) {
            _loadingLiveData.value = false
            _newsLiveData.value = repository.getNewsList()
        }
    }
}