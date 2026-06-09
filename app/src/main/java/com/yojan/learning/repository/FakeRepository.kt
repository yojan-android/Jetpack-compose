package com.yojan.learning.repository

import com.yojan.learning.R
import com.yojan.learning.models.FakeUsers
import kotlinx.coroutines.delay
import javax.inject.Inject

class FakeRepository @Inject constructor() {
    suspend fun getListOfUsers() : List<FakeUsers> {
        delay(1000)
        return listOf(
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Rahul", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Priya", profile = R.drawable.ic_launcher_foreground),
        )
    }
}