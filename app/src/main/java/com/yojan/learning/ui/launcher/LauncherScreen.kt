package com.yojan.learning.ui.launcher

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    when(val uiState = viewModel.obsDeviceDetails.collectAsStateWithLifecycle().value) {
        UiState.Loading -> LauncherScreenUI()
        is UiState.Error -> ErrorScreenUI(uiState.message)
        is UiState.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(NavigationRoutesModel.RoleTypeScreenNav) {
                    popUpTo(NavigationRoutesModel.LauncherScreenNav) {
                        inclusive = true
                    }
                }
            }
        }

        else -> {
            Unit
        }
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LauncherScreenUI() {
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(snackbarHost = {SnackbarHost(hostState = snackbarHostState)}) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
            Image(painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "launcher screen")
        }
    }
}

