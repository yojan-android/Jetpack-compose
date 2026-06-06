package com.yojan.learning.models

import com.google.gson.annotations.SerializedName

data class DeviceInfoRequest(
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("osVersion") val osVersion: Int,
    @SerializedName("osName") val osName: String,
    @SerializedName("devicePlatform") val devicePlatform: String,
    @SerializedName("appVersion") val appVersion: Int,
    @SerializedName("deviceTimezone") val deviceTimezone: String,
    @SerializedName("deviceCurrentTimestamp") val deviceCurrentTimestamp: String,
    @SerializedName("token") val token: String,
    @SerializedName("modelName") val modelName: String
)