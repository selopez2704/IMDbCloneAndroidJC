package com.globant.android.imdb.repository

import com.globant.android.imdb.utils.api.RetrofitServiceFactory
import com.globant.android.imdb.utils.api.model.Movie

class MoviesRepository {
//    TODO: dependency injection
    private val service = RetrofitServiceFactory.makeRetrofitService()

    suspend fun listPopularMovies():List<Movie> {
        val movies = service.listPopularMovies("3c4793bc02b5eccc9ddac89eeb42c642","US")
        return movies.movies
    }
    suspend fun listMoviesByPopularity():List<Movie> {
        val movies = service.listMoviesByPopularity("3c4793bc02b5eccc9ddac89eeb42c642","US")
        return movies.movies
    }
    suspend fun listTopRatedMovies():List<Movie> {
        val movies = service.listTopRatedMovies("3c4793bc02b5eccc9ddac89eeb42c642","US")
        return movies.movies
    }
}