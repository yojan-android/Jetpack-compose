package com.yojan.learning.ui.launcher

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yojan.learning.BuildConfig
import com.yojan.learning.models.DeviceInfo
import com.yojan.learning.models.DeviceInfoRequest
import com.yojan.learning.networking.networkModel.UiState
import com.yojan.learning.repository.CommonRepository
import com.yojan.learning.util.getCurrentTimeStamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import java.util.TimeZone
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(
    private val repository: CommonRepository
) : ViewModel() {
    private var internalDeviceObs : MutableStateFlow<UiState<DeviceInfo>> = MutableStateFlow(UiState.Loading)
    val obsDeviceDetails = internalDeviceObs

    fun sendDeviceInfo() {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        val modelName = if (model.startsWith(manufacturer)) model else "$manufacturer $model"

        val request = DeviceInfoRequest(
            deviceId = "0",
            osVersion = Build.VERSION.SDK_INT,
            osName = "Android",
            devicePlatform = "Android",
            appVersion = BuildConfig.VERSION_CODE,
            deviceTimezone = TimeZone.getDefault().id,
            deviceCurrentTimestamp = Date().getCurrentTimeStamp(),
            token = "",
            modelName = modelName
        )
        viewModelScope.launch {
            internalDeviceObs.value = UiState.Loading
            val result = repository.deviceDetails(request)
            internalDeviceObs.value = result
        }
    }
}