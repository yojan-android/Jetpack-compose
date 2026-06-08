package com.yojan.learning.ui.spotifyUI.topArtist

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopArtistScreenUI(navController: NavController,artistName : String?) {
    Scaffold(topBar = {
        TopAppBar(
        title = { Text(text = artistName?:"unknow artist") }
    )
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()) {
            Text(text = artistName?:"Unknow Artist..",
                modifier = Modifier,
                textAlign = TextAlign.Center)
        }
    }
}