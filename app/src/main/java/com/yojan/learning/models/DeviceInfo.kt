package com.yojan.learning.models


import com.google.gson.annotations.SerializedName

data class DeviceInfo(
    @SerializedName("deviceId")
    val deviceId: Int = 0,
    @SerializedName("versionInfo")
    val versionInfo: VersionInfo = VersionInfo()
)

data class VersionInfo(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("devicePlatform")
    val devicePlatform: String = "",
    @SerializedName("locationPath")
    val locationPath: String = "",
    @SerializedName("currentVersion")
    val currentVersion: Int = 0,
    @SerializedName("lastCompulsoryVersion")
    val lastCompulsoryVersion: Int = 0
)