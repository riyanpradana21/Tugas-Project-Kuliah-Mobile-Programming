package com.stikombali.RYN_Movie.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.stikombali.RYN_Movie.models.Movie
import com.stikombali.RYN_Movie.ui.MainViewModel

@Composable
fun MovieDetailScreen(movieId: Int, viewModel: MainViewModel) {
    val movie = viewModel.getMovieById(movieId)
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (movie != null) {
            Text(
                text = movie.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500${movie.poster_path}"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "Rating: ${movie.vote_average}/10",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(text = movie.overview, fontSize = 16.sp)
        } else {
            Text("Movie not found", modifier = Modifier.fillMaxSize(), color = Color.Red)
        }
    }
}

