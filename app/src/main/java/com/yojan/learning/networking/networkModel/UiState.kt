package com.yojan.learning.networking.networkModel

sealed class UiState<out T> {
    object Idle : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<T>(val response : T) : UiState<T>()
    data class Error(val message : String) : UiState<Nothing>()
}
