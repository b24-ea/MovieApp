package com.aldanmaz.movieapp.hilt

import com.aldanmaz.movieapp.data.api.MovieInterface
import com.aldanmaz.movieapp.data.api.MovieRepository
import com.aldanmaz.movieapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object AppModules {

    @Provides
    fun provideRetrofitInterface(): MovieInterface {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(MovieInterface::class.java)

    }

    @Provides
    fun provideRepository(movieInterface: MovieInterface) : MovieRepository {
        return MovieRepository(movieInterface)
    }

}