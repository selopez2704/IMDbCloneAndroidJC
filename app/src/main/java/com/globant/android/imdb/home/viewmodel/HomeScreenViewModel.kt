package com.globant.android.imdb.home.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.android.imdb.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeScreenViewModel(val moviesRepository:MoviesRepository) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state:StateFlow<HomeScreenState> = _state.asStateFlow()

    init {
        updateEntireScreenState()
    }


    fun updateEntireScreenState() {
        viewModelScope.launch(Dispatchers.IO) {
            val moviesByPopularity = moviesRepository.listMoviesByPopularity()
            val moviesPopular = moviesRepository.listPopularMovies()
            val moviesTopRated = moviesRepository.listTopRatedMovies()
            withContext(Dispatchers.Main) {
                _state.update {
                    it.copy(
                        featureContent = it.featureContent.copy(
                            player = moviesByPopularity[0].title,
                            poster = moviesByPopularity[0].title,
                            title = moviesByPopularity[0].title,
                            subTitle = moviesByPopularity[0].title,
                        ),
                        bestChoicesCarousel = it.bestChoicesCarousel.copy(
                            cards = moviesPopular.take(10)
                                .map { Card(it.title, it.title, it.title, it.title) }),
                        mayInterest = it.mayInterest.copy(
                            cards = moviesByPopularity.take(10)
                                .map { Card(it.title, it.title, it.title, it.title) }),
                        fanFavoritesCarousel = it.fanFavoritesCarousel.copy(
                            cards = moviesTopRated.take(10)
                                .map { Card(it.title, it.title, it.title, it.title) })
                    )
                }

            }
        }
    }
}


data class HomeScreenState(
    val featureContent:FeatureContent = FeatureContent("Player", "Poster", "Title", "Subtitle"),
    val bestChoicesCarousel:Carousel = Carousel("Las mejores selecciones", defaultCarouselCards),
    val fanFavoritesCarousel:Carousel = Carousel("Favoritos de los aficionados",defaultCarouselCards),
    val mayInterest:Carousel = Carousel("Quizás te interesen", defaultCarouselCards)
)


data class FeatureContent(
    val player:String = "", val poster:String = "", val title:String = "", val subTitle:String = ""
)

data class Carousel(
    val name:String = "",
    var cards:List<Card>
)

data class Card(
    val name:String = "",
    val rating:String = "",
    val moreInfoButton:String = "",
    val image:String = ""
)


val defaultCard = Card("Name", "4.5", "ïnfoLink", "Movie image")

val defaultCarouselCards = listOf<Card>(
    defaultCard,
    defaultCard,
    defaultCard,
    defaultCard,
    defaultCard
)