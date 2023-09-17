package com.example.composelearning.utils

sealed  class  State <T>{
    data class Success<T>(val data:T): State<T>()
    data class Error<T>(val t:Throwable): State<T>()
    class Loading<T> : State<T>()
    class NoState<T>: State<T>()
}
