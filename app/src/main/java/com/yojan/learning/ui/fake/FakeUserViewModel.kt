package com.yojan.learning.ui.fake

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yojan.learning.models.FakeUsers
import com.yojan.learning.networking.networkModel.UiState
import com.yojan.learning.repository.FakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FakeUserViewModel @Inject constructor(
    val repository: FakeRepository
) : ViewModel() {
    private var internalObsGetUserList : MutableStateFlow<UiState<List<FakeUsers>>> = MutableStateFlow(UiState.Loading)
    val publicObsGetUserList : StateFlow<UiState<List<FakeUsers>>> = internalObsGetUserList.asStateFlow()

    fun getUserList() {
        viewModelScope.launch {
            internalObsGetUserList.value = UiState.Loading
            try {
                val users = repository.getListOfUsers()
                internalObsGetUserList.value = UiState.Success(users)
            } catch (exception : Exception) {
                internalObsGetUserList.value = UiState.Error("$exception")
            }

        }
    }
}