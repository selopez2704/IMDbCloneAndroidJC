package com.globant.android.imdb.home.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel : ViewModel() {
    private val _featureContentUIState = MutableStateFlow(FeatureContent("Player","Poster","Title", "Subtitle"))
    val featureContentUIState:StateFlow<FeatureContent> = _featureContentUIState.asStateFlow()

    private val _bestChoicesCarouselUIState =
        MutableStateFlow(Carousel("Las mejores selecciones", defaultCarouselCards))
    val bestChoicesCarouselUIState:StateFlow<Carousel> = _bestChoicesCarouselUIState.asStateFlow()

    private val _fanFavoritesCarouselUIState =
        MutableStateFlow(Carousel("Favoritos de los aficionados", defaultCarouselCards))
    val fanFavoritesCarouselUIState:StateFlow<Carousel> = _fanFavoritesCarouselUIState.asStateFlow()

    private val _mayInterestUIState =
        MutableStateFlow(Carousel("Quizás te interesen", defaultCarouselCards))
    val mayInterestUIState:StateFlow<Carousel> = _mayInterestUIState.asStateFlow()
}

data class FeatureContent(
    val player:String = "",
    val poster:String = "",
    val title:String = "",
    val subTitle:String = ""
)

data class Carousel(
    val name:String = "",
    val cards:List<Card>
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
    defaultCard,
    defaultCard,
    defaultCard,
)