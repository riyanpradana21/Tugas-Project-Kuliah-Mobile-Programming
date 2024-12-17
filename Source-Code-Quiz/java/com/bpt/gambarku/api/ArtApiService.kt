package com.bpt.gambarku.api

import com.bpt.gambarku.models.ArtResponse
import retrofit2.http.GET

interface ArtApiService {
    @GET("artworks")
    suspend fun getArtworks(): ArtResponse
}