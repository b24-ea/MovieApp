package com.aldanmaz.movieapp.data.api


import com.aldanmaz.movieapp.data.model.MovieResponse
import com.aldanmaz.movieapp.data.modeldetail.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET("/")
    suspend fun getAllMovies(
        @Query("s") s: String,
        @Query("page")page: Int,
        @Query("apiKey")apiKey:String

    ): Response<MovieResponse>

    @GET("/")
    suspend fun getAllDetails(
        @Query("i") imdbId: String,
        @Query("apiKey")apiKey:String

    ): Response<MovieDetails>
}