package com.globant.android.imdb.utils.api.model

import com.google.gson.annotations.SerializedName

data class MoviesResult(
    val page: Int,
    @SerializedName(value="results")
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)