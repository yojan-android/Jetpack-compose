package com.yojan.learning.ui.fake


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yojan.learning.models.FakeUsers

@Composable
fun LazyRowExample(user : List<FakeUsers>,modifier: Modifier) {
    LazyRow(modifier = Modifier.padding(10.dp)) {
        items(user) { users ->
            Text(text = users.name?: "Unknown")
        }
    }
}

@Composable
fun LazyColumnExample(userList : List<FakeUsers>,modifier: Modifier) {
    LazyColumn(modifier = Modifier.padding(10.dp)) {
        items(userList) {usersList ->
            Text(text = usersList.name?: "")
        }
    }
}
