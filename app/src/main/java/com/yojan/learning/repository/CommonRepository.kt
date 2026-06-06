package com.yojan.learning.repository

import com.yojan.learning.models.DeviceInfo
import com.yojan.learning.models.DeviceInfoRequest
import com.yojan.learning.networking.ApiService
import com.yojan.learning.networking.networkModel.PostModel
import com.yojan.learning.networking.networkModel.UiState
import javax.inject.Inject

class CommonRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPostList() : List<PostModel> {
        return apiService.getPost()
    }
    suspend fun deviceDetails(jsonObject : DeviceInfoRequest) : UiState<DeviceInfo> {
        return try {
            val response = apiService.deviceDetails(jsonObject)
            if(response.isSuccessful) {
                response.body()?.let {
                    UiState.Success(it)
                } ?: UiState.Error("Empty Response Body...")
            } else {
                UiState.Error(response.errorBody()?.string() ?: "Unknown error")
            }
        } catch (exception : Exception) {
            UiState.Error(exception.message ?: "Something went wrong")
        }
    }
}