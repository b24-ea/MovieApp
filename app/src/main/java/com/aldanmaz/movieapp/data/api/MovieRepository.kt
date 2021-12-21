package com.aldanmaz.movieapp.data.api



import com.aldanmaz.movieapp.data.modeldetail.MovieDetails
import com.aldanmaz.movieapp.data.repository.Result
import com.aldanmaz.movieapp.data.repository.Status
import com.aldanmaz.movieapp.util.Constants


class MovieRepository (private val movieInterface: MovieInterface) {


    suspend fun getMovieDetails(imdbId: String): Result<MovieDetails> {


        return try {
            val response= movieInterface.getAllDetails(imdbId,Constants.API_KEY)
            if(response.isSuccessful){

                Result(Status.SUCCESS,response.body(),null)
            }else{
                Result(Status.ERROR,null,null)
            }

        } catch (e: Exception) {
            Result(Status.ERROR,null,null)
        }

    }
}

