package com.yojan.learning.ui.spotifyUI.topMenu

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecentlyPlayedScreenUI(navController: NavController) {
    Scaffold(topBar = { TopAppBar(
        title = { Text(text = "Recent Played Songs") }
    ) }) {  innerPadding ->

    }
}