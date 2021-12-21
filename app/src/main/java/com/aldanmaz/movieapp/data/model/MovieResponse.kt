package com.aldanmaz.movieapp.data.model


import com.google.gson.annotations.SerializedName


data class MovieResponse(
   val Response: String,
   val Search: List<Movie>,
   val totalResults: String
)