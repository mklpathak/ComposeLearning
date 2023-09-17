package com.example.composelearning.generated

sealed class ResultWrapper<out T> {
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Error(val errorMessage: String) : ResultWrapper<Nothing>()
}
