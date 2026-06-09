package com.yojan.learning.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yojan.learning.PostViewModel
import com.yojan.learning.networking.networkModel.PostModel
import com.yojan.learning.networking.networkModel.UiState


@Composable
fun PostUI(post : List<PostModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(post) {post ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = post.title,
                        color = Color.Red,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                    HorizontalDivider(modifier = Modifier.padding(vertical = 6.dp))
                    Text(text = post.body,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun LoadingUI() {
    Box(modifier = Modifier
        .fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorUI(message : String) {
    Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center) {
        Text(text = message, color = Color.Red)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostScreen(modifier: Modifier = Modifier) {
    val viewModel: PostViewModel = hiltViewModel()
    val items = listOf(
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.Favorite,
        Icons.Default.Person
    )
    Scaffold(modifier.fillMaxSize(),
        topBar = { TopAppBar(
            title = {
                Text(text = "Post Details")
            })
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    items.forEach { icon ->
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(modifier.fillMaxSize()
            .padding(innerPadding)) {
            PostScreenContent(uiState = viewModel.obsPostList.collectAsStateWithLifecycle().value)
        }
    }
}

@Composable
fun PostScreenContent(uiState: UiState<List<PostModel>>) {
    when (uiState) {
        is UiState.Loading -> LoadingUI()
        is UiState.Success -> PostUI(post = uiState.response)
        is UiState.Error   -> ErrorUI(message = uiState.message)
    }
}