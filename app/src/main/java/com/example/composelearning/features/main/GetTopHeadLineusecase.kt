package com.example.composelearning.features.main

import com.example.composelearning.features.main.NewsRepository
import com.example.composelearning.generated.Article

class GetTopHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(): List<Article> {
        return newsRepository.getTopHeadlines()
    }
}
