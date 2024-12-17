package com.bpt.gambarku.models

data class ArtResponse(
    val data: List<ArtData>
)

data class ArtData(
    val id: String,
    val title: String,
    val artist_title: String?,
    val image_id: String
)