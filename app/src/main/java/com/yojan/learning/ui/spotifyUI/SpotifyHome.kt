package com.yojan.learning.ui.spotifyUI

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.NotificationImportant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SyncLock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yojan.learning.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpotifyHome() {
    val artist = listOf(
    ArtisListModel("1 (Remastered)", R.drawable.remastered),
    ArtisListModel("Lana Del Rey", R.drawable.lana),
    ArtisListModel("Marvin Gaye", R.drawable.marvin) ,
    ArtisListModel("1 (Remastered)", R.drawable.remastered),
    ArtisListModel("Lana Del Rey", R.drawable.lana),
    ArtisListModel("Marvin Gaye", R.drawable.marvin)
    )

    val topForYou = listOf(
        ArtisListModel("Your Top Songs 2021",R.drawable.top_songs),
        ArtisListModel("Your Artists Revealed",R.drawable.your_artist)
    )

    val editorPick = listOf(
        ArtisListModel("Ed Sheeran, Big Sean \n Juice WRLD, Post Malone",R.drawable.editor_pick_first),
        ArtisListModel("Your Artists Revealed",R.drawable.editor_pick_second),
        ArtisListModel("Ed Sheeran, Big Sean \n Juice WRLD, Post Malone",R.drawable.editor_pick_first),
        ArtisListModel("Your Artists Revealed",R.drawable.editor_pick_second),
        ArtisListModel("Ed Sheeran, Big Sean \n Juice WRLD, Post Malone",R.drawable.editor_pick_first),
        ArtisListModel("Your Artists Revealed",R.drawable.editor_pick_second)
    )

    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = "Recently Played",
                fontWeight = FontWeight.Bold)
            },
            actions = { IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.NotificationImportant,
                        contentDescription = "Notification")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.SyncLock,
                        contentDescription = "Recent")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Settings,
                        contentDescription = "Settings")
                }

            })
        },
        bottomBar = { NavigationBar {
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = { Icon(Icons.Default.Home, "Home") },
                label = { Text("Home") }
            )

            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = { Icon(Icons.Default.Search, "Search") },
                label = { Text("Search") }
            )

            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = { Icon(Icons.Default.LibraryMusic, "Library") },
                label = { Text("Library") }
            )
        } }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier
            .padding(innerPadding)) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    ArtistList(
                        modifier = Modifier, artistList = artist
                    )
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(90.dp),
                            painter = painterResource(R.drawable.review),
                            contentDescription = "review"
                        )

                        Column(
                            modifier = Modifier
                                .padding(10.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "#SPOTIFYWRAPPED",
                                fontFamily = FontFamily.Serif
                            )
                            Text(
                                text = "Your 2021 in review",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    ArtistList(modifier = Modifier, artistList = topForYou)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .padding(10.dp), text = "Editor'S Picks",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    ArtistList(
                        modifier = Modifier,
                        artistList = editorPick
                    )
                }
            }
        }
    }
}