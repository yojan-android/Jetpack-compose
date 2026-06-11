package com.yojan.learning.ui.fake

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Users") }) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyRowExample(user = emptyList(), modifier = Modifier)
            LazyColumnExample(userList = emptyList(), modifier = Modifier.padding())
        }

    }
}