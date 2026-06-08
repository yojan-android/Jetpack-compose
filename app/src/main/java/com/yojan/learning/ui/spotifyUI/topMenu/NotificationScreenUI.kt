package com.yojan.learning.ui.spotifyUI.topMenu

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotificationScreenUI(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title =
        { Text(text = "Notification") },
        navigationIcon = {
            IconButton(onClick = {   }) {
                Icon(imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back Press")
            }
        }
        )
    }) { innerPadding ->

    }
}