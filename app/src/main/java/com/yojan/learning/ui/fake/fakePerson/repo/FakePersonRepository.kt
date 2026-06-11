package com.yojan.learning.ui.fake.fakePerson.repo

import com.yojan.learning.ui.fake.fakePerson.model.FakePersonDetails
import kotlinx.coroutines.delay
import javax.inject.Inject

class FakePersonRepository @Inject constructor() {

    suspend fun submitPersonDetails(person : FakePersonDetails) : FakePersonDetails {
        delay(3000)
        return person
    }
}