package com.yojan.learning.ui.fake.fakePerson.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yojan.learning.networking.networkModel.UiState
import com.yojan.learning.ui.fake.fakePerson.model.FakePersonDetails
import com.yojan.learning.ui.fake.fakePerson.repo.FakePersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FakePersonViewModel @Inject constructor(
    val repository: FakePersonRepository
) : ViewModel() {
    private var _obsSubmitPersonDetails : MutableStateFlow<UiState<FakePersonDetails>> = MutableStateFlow(UiState.Idle)
    val obsSubmitPersonDetails : StateFlow<UiState<FakePersonDetails>> = _obsSubmitPersonDetails.asStateFlow()

    var firstName by mutableStateOf("")
    var midName by mutableStateOf("")
    var lastName by mutableStateOf("")

    fun sendPersonDetails() {
        viewModelScope.launch {
            _obsSubmitPersonDetails.value = UiState.Loading
            try {
                val result = repository.submitPersonDetails(FakePersonDetails(firstName,midName,lastName))
                _obsSubmitPersonDetails.value = UiState.Success(result)
            } catch (exception : Exception) {
                _obsSubmitPersonDetails.value = UiState.Error("$exception")
            }
        }
    }
    fun resetUi() {
        _obsSubmitPersonDetails.value = UiState.Idle
    }

}