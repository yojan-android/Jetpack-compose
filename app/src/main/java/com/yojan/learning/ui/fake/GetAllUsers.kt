package com.yojan.learning.ui.fake

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yojan.learning.networking.networkModel.UiState
import com.yojan.learning.ui.uiState.ErrorScreenUI
import com.yojan.learning.ui.uiState.LoadingScreenUI

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GetAllUsers(
    viewModel: FakeUserViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getUserList()
    }
    val userList = viewModel.publicObsGetUserList.collectAsStateWithLifecycle().value

    when(userList) {
        is UiState.Loading -> LoadingScreenUI()
        is UiState.Error -> ErrorScreenUI(message = userList.message)
        is UiState.Success -> {
            Scaffold(topBar = {
                TopAppBar(title = {
                    Text(text = "Users Details")
                })
            }) { innerPadding ->
                LazyColumn(modifier = Modifier.padding(innerPadding)) {
                    items(userList.response) { user ->
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)) {
                            Text(text = user.name?: "unknow user")
                        }
                    }
                }
            }
        }
    }
}