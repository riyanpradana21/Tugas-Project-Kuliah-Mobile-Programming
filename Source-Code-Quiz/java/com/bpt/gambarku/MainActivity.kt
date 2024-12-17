package com.bpt.gambarku
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.bpt.gambarku.models.ArtData
import com.bpt.gambarku.ui.theme.GambarkuTheme
import com.bpt.gambarku.viewmodel.ArtViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GambarkuTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ArtListScreen()
                }
            }
        }
    }
}

@Composable
fun ArtListScreen(viewModel: ArtViewModel = viewModel()) {
    val artworks by viewModel.artworks.collectAsState()

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(artworks) { artwork ->
            ArtItem(artwork)
        }
    }
}

@Composable
fun ArtItem(artwork: ArtData) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(
                model = "https://www.artic.edu/iiif/2/${artwork.image_id}/full/843,/0/default.jpg"
            ),
            contentDescription = artwork.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(text = artwork.title, style = MaterialTheme.typography.titleMedium)
        Text(text = "Artist: ${artwork.artist_title ?: "Unknown"}", style = MaterialTheme.typography.bodyMedium)
    }
}