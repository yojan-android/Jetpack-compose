package com.yojan.learning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yojan.learning.networking.networkModel.PostModel
import com.yojan.learning.networking.networkModel.UiState
import com.yojan.learning.repository.CommonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: CommonRepository)
    : ViewModel() {
    private var internalObsPostList : MutableStateFlow<UiState<List<PostModel>>> = MutableStateFlow(UiState.Loading)
        val obsPostList = internalObsPostList

    init {
        getPostList()
    }
    private fun getPostList() {
        viewModelScope.launch {
            internalObsPostList.value = UiState.Loading
            try {
                val posts = repository.getPostList()
                internalObsPostList.value = UiState.Success(posts)
            } catch (exception : Exception) {
                internalObsPostList.value = UiState.Error("Something went wrong $exception")
            }
        }
    }
}