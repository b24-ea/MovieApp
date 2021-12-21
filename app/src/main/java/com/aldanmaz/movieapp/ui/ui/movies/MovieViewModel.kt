package com.aldanmaz.movieapp.ui.ui.movies

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.aldanmaz.movieapp.data.api.MovieInterface
import com.aldanmaz.movieapp.data.modeldetail.MovieDetails
import com.aldanmaz.movieapp.data.repository.Result
import com.aldanmaz.movieapp.data.repository.Status
import com.aldanmaz.movieapp.data.api.MovieRepository
import com.aldanmaz.movieapp.util.Events


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieInterface: MovieInterface,private val repository: MovieRepository): ViewModel(){

       private val query= MutableLiveData<String>("")

    val list= query.switchMap { query ->
        Pager(PagingConfig(pageSize = 10)) {
            MoviePaging(query, movieInterface)
        }.liveData.cachedIn(viewModelScope)
    }

    fun setQuery(s:String) {
        query.postValue(s)
    }

        private val _movieDetails= MutableLiveData<Events<Result<MovieDetails>>>()
        val movieDetails:LiveData<Events<Result<MovieDetails>>> = _movieDetails


    fun getMovieDetails(imdbId: String) = viewModelScope.launch {
        _movieDetails.postValue(Events(Result(Status.RUNNING,null,null)))
        _movieDetails.postValue(Events(repository.getMovieDetails(imdbId)))


    }



    }

