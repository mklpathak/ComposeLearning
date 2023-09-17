package com.example.composelearning.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelearning.utils.State
import com.example.composelearning.generated.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.NullPointerException
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase) :
    ViewModel() {
    private val _newsList = MutableStateFlow<State<List<Article>>>(State.Loading())
    val newsList: StateFlow<State<List<Article>>> = _newsList

    private val _news = MutableStateFlow<State<Article>>(State.Loading())
    val news: StateFlow<State<Article>> = _news

    private val newsListA = ArrayList<Article>()


    fun getNewsList () {
        viewModelScope.launch {
            try {
                newsListA.addAll(getTopHeadlinesUseCase())
                _newsList.value = State.Success(newsListA)
            }catch (e:Exception) {
                _newsList.value = State.Error(e)
            }

        }
    }


    fun getNewsArticle (id:String) {
        viewModelScope.launch {
            try {
                _news.value = newsListA.find { it.title == id }?.let {
                    State.Success(it)
                } ?: State.Error(Exception())
            }catch (e:Exception) {
                _newsList.value = State.Error(e)
            }

        }
    }
}
