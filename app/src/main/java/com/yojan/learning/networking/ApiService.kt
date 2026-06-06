package com.yojan.learning.networking

import com.yojan.learning.models.DeviceInfo
import com.yojan.learning.models.DeviceInfoRequest
import com.yojan.learning.networking.networkModel.PostModel
import com.yojan.learning.networking.networkModel.UiState
import kotlinx.serialization.json.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

const val API = "api"
interface ApiService {
    @GET("posts")
    suspend fun getPost() : List<PostModel>

    @POST("$API/device")
    suspend fun deviceDetails(@Body jsonObject: DeviceInfoRequest) : Response<DeviceInfo>
}