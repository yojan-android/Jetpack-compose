package com.yojan.learning.ui.spotifyUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yojan.learning.R


@Composable
fun ArtistList(
    modifier: Modifier,
    artistList : List<ArtisListModel>) {

    LazyRow(modifier
        .fillMaxWidth()) {
        items(artistList.size) {index->
            val artistList = artistList[index]
            Column(modifier = Modifier
                .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(painter = painterResource(id = artistList.imageRes),
                    contentDescription = artistList.name,
                    modifier = Modifier.size(140.dp),
                    contentScale = ContentScale.Crop)
                Text(text = artistList.name,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
data class ArtisListModel(
    val name: String,
    val imageRes: Int
)