package com.example.composelearning.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.composelearning.features.main.NewsViewModel
import com.example.composelearning.utils.State
import com.example.composelearning.generated.Article
import com.example.composelearning.screens.components.NewsCard

@Composable
fun NewsApp(navController: NavController,viewModel: NewsViewModel = hiltViewModel()) {
    val state : State<List<Article>> by viewModel.newsList.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = "Article" ){
        viewModel.getNewsList()
    }
    when (state) {
        is State.Success -> {
            val list = (state as State.Success<List<Article>>).data
            LazyColumn {
                items(list.size){
                    NewsCard(article = list[it]) { article ->
                        navController.navigate(Routes.News.name)
                    }
                }
            }
        }
        else -> {
            Text(text = "No data")
        }
    }

}
