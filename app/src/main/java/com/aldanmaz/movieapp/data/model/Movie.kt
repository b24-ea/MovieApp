package com.aldanmaz.movieapp.data.model

import com.google.gson.annotations.SerializedName


data class Movie(
    @SerializedName("poster")
    val Poster: String,
    @SerializedName("")
    val Title: String,
    @SerializedName("poster")
    val Type: String,
    @SerializedName("title")
    val Year: String,
    @SerializedName("year")
    val imdbID: String

)