package com.yojan.learning.ui.fake

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.modifier.modifierLocalConsumer
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
        viewModel.userList()
    }
    val userList = viewModel.publicObsGetUserList.collectAsStateWithLifecycle().value
    val getUserList = viewModel.PubObsGetUserList.collectAsStateWithLifecycle().value

    Scaffold(
        topBar = {TopAppBar(title = {Text(text = "UserList")}
        )}
    ) { innerPadding ->
        val isLoading = userList is UiState.Loading || getUserList is UiState.Loading

        if (isLoading) {
            LoadingScreenUI()
            return@Scaffold
        }
        Column(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()) {

        when(userList) {
            is UiState.Error -> ErrorScreenUI(userList.message)
            is UiState.Success -> LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(userList.response) { users ->
                    UserCard(users.name?: "unknown user")
                }
            }

            else -> {
                Unit
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
            when(getUserList) {
                is UiState.Error -> ErrorScreenUI(getUserList.message)
                is UiState.Success -> LazyColumn(contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(getUserList.response) { users ->
                        UserCard(users.name?: "Unknown users")
                    }
                }

                else -> {
                    Unit
                }
            }
        }
    }
}
