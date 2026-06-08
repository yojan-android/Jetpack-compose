package com.yojan.learning.ui.spotifyUI.bottomMenu

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LibraryScreenUI(navController: NavController) {
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(Unit) {
        snackbarHostState.showSnackbar("Library Screen")
    }
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Library") }) },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { innerPadding ->
    }
}