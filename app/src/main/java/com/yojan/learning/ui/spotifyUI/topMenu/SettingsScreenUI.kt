package com.yojan.learning.ui.spotifyUI.topMenu

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreenUI(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Settings") })
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()) {

        }
    }
}