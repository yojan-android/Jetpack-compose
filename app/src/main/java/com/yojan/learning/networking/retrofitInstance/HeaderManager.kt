package com.example.privateambulance.data.networking.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeaderManager @Inject constructor() {
    var headers: Map<String, String?>? = null
}