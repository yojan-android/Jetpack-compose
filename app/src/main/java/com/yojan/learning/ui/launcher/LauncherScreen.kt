package com.yojan.learning.ui.launcher

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.yojan.learning.R
import com.yojan.learning.navigation.NavigationRoutesModel
import com.yojan.learning.networking.networkModel.UiState
import com.yojan.learning.ui.uiState.ErrorScreenUI

@Composable
fun LauncherScreen(navController: NavHostController) {
    val viewModel : LauncherViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.sendDeviceInfo()
    }
    val uiState = viewModel.obsDeviceDetails.collectAsStateWithLifecycle().value

    when(uiState) {
        UiState.Loading -> LauncherScreenUI()
        is UiState.Error -> ErrorScreenUI(uiState.message)
        is UiState.Success -> { navController.navigate(NavigationRoutesModel.RoleTypeScreenNav) }
    }

}

@Composable
fun LauncherScreenUI() {
    Box(modifier = Modifier
        .fillMaxSize()) {
        Image(painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "launcher screen")
    }

}

