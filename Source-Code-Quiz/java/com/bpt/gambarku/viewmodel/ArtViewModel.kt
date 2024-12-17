package com.bpt.gambarku.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bpt.gambarku.api.RetrofitInstance
import com.bpt.gambarku.models.ArtData


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArtViewModel : ViewModel() {
    private val _artworks = MutableStateFlow<List<ArtData>>(emptyList())
    val artworks: StateFlow<List<ArtData>> = _artworks

    init {
        fetchArtworks()
    }

    private fun fetchArtworks() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getArtworks()
                _artworks.value = response.data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}