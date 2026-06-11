package com.yojan.learning.repository

import com.yojan.learning.R
import com.yojan.learning.models.FakeUsers
import kotlinx.coroutines.delay
import javax.inject.Inject

class FakeRepository @Inject constructor() {
    suspend fun getListOfUsers() : List<FakeUsers> {
        delay(3000)
        return listOf(
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
        )
    }

    suspend fun getUsers() : List<FakeUsers> {
        delay(10000)
        return listOf(
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 1, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 2, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
            FakeUsers(id = 3, name = "Yojan", profile = R.drawable.ic_launcher_foreground),
        )
    }
}