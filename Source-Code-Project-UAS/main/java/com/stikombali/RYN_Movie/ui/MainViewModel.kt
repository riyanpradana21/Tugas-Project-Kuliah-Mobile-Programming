package com.stikombali.RYN_Movie.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stikombali.RYN_Movie.models.Movie
import com.stikombali.RYN_Movie.network.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> get() = _movies

    private val _filteredMovies = MutableStateFlow<List<Movie>>(emptyList())
    val filteredMovies: StateFlow<List<Movie>> get() = _filteredMovies

    fun fetchMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getPopularMovies(apiKey)
                _movies.value = response.results
                _filteredMovies.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun filterMovies(query: String) {
        _filteredMovies.value = if (query.isEmpty()) {
            _movies.value
        } else {
            _movies.value.filter { it.title.contains(query, ignoreCase = true) }
        }
    }

    fun getMovieById(id: Int): Movie? {
        return _movies.value.find { it.id == id }
    }
}