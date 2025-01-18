package com.stikombali.RYN_Movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stikombali.RYN_Movie.ui.AppNavigation
import com.stikombali.RYN_Movie.ui.MainScreen
import com.stikombali.RYN_Movie.ui.MainViewModel
import com.stikombali.RYN_Movie.ui.MovieDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation(
                viewModel = viewModel(),
                apiKey = "173d8eb66138c2fae7f799307ce7db8f"
            )
        }
    }
}
