package com.example.composelearning.features.main

import com.example.composelearning.utils.ApiKeyProvider
import com.example.composelearning.generated.Article
import com.example.composelearning.generated.NewsApiService


interface NewsRepository {
    suspend fun getTopHeadlines(): List<Article>
}

class NewsRepositoryImpl(private val newsApiService: NewsApiService) : NewsRepository {
    override suspend fun getTopHeadlines(): List<Article> {
        val response = newsApiService.getTopHeadlines(apiKey = ApiKeyProvider.API_KEY)
        return if (response.isSuccessful) {
            response.body()?.articles ?: emptyList()
        } else {
            emptyList()
        }
    }
}

