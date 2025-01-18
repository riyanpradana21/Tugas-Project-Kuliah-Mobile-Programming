package com.stikombali.RYN_Movie.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stikombali.RYN_Movie.models.Movie
import com.stikombali.RYN_Movie.ui.MainViewModel

@Composable
fun AppNavigation(viewModel: MainViewModel, apiKey: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(viewModel, apiKey) { movieId ->
                navController.navigate("details/$movieId")
            }
        }
        composable("details/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull()
            if (movieId != null) {
                MovieDetailScreen(movieId = movieId, viewModel = viewModel)
            } else {
                Text("Invalid movie ID", color = Color.Red, modifier = Modifier.fillMaxSize())
            }
        }
    }
}