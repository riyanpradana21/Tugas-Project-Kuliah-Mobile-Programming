package com.stikombali.RYN_Movie.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stikombali.RYN_Movie.ui.MovieItem

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel(), apiKey: String, onMovieClick: (Int) -> Unit) {
    val movies = viewModel.filteredMovies.collectAsState().value
    var searchQuery by remember { mutableStateOf("") }

    Column {
        // Search Bar
        TextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                viewModel.filterMovies(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            placeholder = { Text("Search Movie:") }
        )

        // Movie List
        LazyColumn {
            items(movies) { movie ->
                MovieItem(movie = movie, onClick = { onMovieClick(it) })
            }
        }
    }

    // Fetch movies
    LaunchedEffect(Unit) {
        viewModel.fetchMovies(apiKey)
    }
}
