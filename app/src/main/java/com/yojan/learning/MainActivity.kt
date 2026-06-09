package com.yojan.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yojan.learning.navigation.NavGraph
import com.yojan.learning.ui.fake.GetAllUsers
import com.yojan.learning.ui.spotifyUI.bottomMenu.SpotifyHome
import com.yojan.learning.ui.theme.LearningTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningTheme {
                NavGraph()
//                GetAllUsers()
            }
        }
    }
}