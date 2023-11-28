package com.globant.android.imdb.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.globant.android.imdb.utils.TopBottomBar
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.globant.android.imdb.R
import com.globant.android.imdb.home.viewmodel.Card
import com.globant.android.imdb.home.viewmodel.FeatureContent
import com.globant.android.imdb.home.viewmodel.HomeScreenViewModel
import com.globant.android.imdb.home.viewmodel.HomeScreenViewModelFactory
import com.globant.android.imdb.repository.MoviesRepository


@Composable
fun HomeScreen(navController:NavController, repository:MoviesRepository) {
    val homeScreenViewModel:HomeScreenViewModel =
        viewModel(factory = HomeScreenViewModelFactory(repository))
    val featureContentState = homeScreenViewModel.state.collectAsState().value.featureContent
    val bestChoicesCarouselState =
        homeScreenViewModel.state.collectAsState().value.bestChoicesCarousel
    val fanFavoritesCarouselState =
        homeScreenViewModel.state.collectAsState().value.fanFavoritesCarousel
    val mayInterestState = homeScreenViewModel.state.collectAsState().value.mayInterest

    TopBottomBar(
        topEnabled = false, bottomEnabled = true, topBackRoute = "home-screen", navController
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.Transparent),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                FeatureContent(featureContentState)
            }
            item {
                Button(modifier = Modifier
                    .height(64.dp)
                    .padding(start = 64.dp, end = 64.dp)
                    .fillMaxWidth(),
                       shape = RoundedCornerShape(16.dp),
                       onClick = { homeScreenViewModel.updateEntireScreenState() }) {
                    Text(text = "Actualizar estado")
                }
            }
            item {
                Carousel(
                    title = bestChoicesCarouselState.name, movies = bestChoicesCarouselState.cards
                )
            }
            item {
                Carousel(
                    title = mayInterestState.name, movies = mayInterestState.cards
                )
            }
            item {
                Carousel(
                    title = fanFavoritesCarouselState.name, movies = fanFavoritesCarouselState.cards
                )
            }

        }
    }
}

@Composable
fun FeatureContent(featureContentState:FeatureContent) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        val (player, poster, title) = createRefs()
        val startGuide = createGuidelineFromStart(0.07f)
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .background(color = Color.Red)
            .constrainAs(player) {
                top.linkTo(parent.top)
            }) {
            Text(text = featureContentState.player)
        }
        Box(modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(color = Color.Green)
            .constrainAs(title) {
                top.linkTo(player.bottom, 16.dp)
                start.linkTo(poster.end, 20.dp)
            }) {
            Column() {
                Text(text = featureContentState.title)
                Text(text = featureContentState.subTitle)
            }
        }
        Box(modifier = Modifier
            .height(200.dp)
            .width(140.dp)
            .background(color = Color.Cyan)
            .constrainAs(poster) {
                top.linkTo(player.top, margin = 120.dp)
                start.linkTo(startGuide)
            }) {
            Text(text = featureContentState.poster)
        }
    }
}

@Preview
@Composable
fun Carousel(
    title:String = "Not defined", movies:List<Card> = listOf<Card>(
        Card(
            "undefined", "undefined", "undefined", "undefined"
        )
    )
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(start = 24.dp, top = 24.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Row(modifier = Modifier.height(32.dp), verticalAlignment = Alignment.CenterVertically) {
            Divider(
                color = Color.Transparent, modifier = Modifier
                    .height(24.dp)  //fill the max height
                    .width(4.dp)
                    .border(
                        shape = RoundedCornerShape(12.dp), width = 12.dp, color = Color.Red
//                        color = MaterialTheme.colorScheme.surface
                    )
            )
            Text(text = title, modifier = Modifier.padding(start = 12.dp))
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            items(movies) { movie -> CardUI(movie) }
        }
    }
}

@Composable
fun CardUI(
    card:Card = Card(
        "undefined", "undefined", "undefined", "undefined"
    )
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(130.dp)
            .height(225.dp)
            .shadow(
                elevation = 3.dp,
//                clip = true,
                shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp))
        ) {
            ConstraintLayout(
                Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                val (cardImage, cardPlusButton, cardInfoButton, cardText) = createRefs()
                val startGuide = createGuidelineFromStart(4.dp)

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(color = Color.Red)
                    .constrainAs(cardImage) {
                        top.linkTo(parent.top)
                    }) {
                    Text(
                        text = card.image,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .constrainAs(cardText) {
                        top.linkTo(cardImage.bottom)
                    }) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 12.dp, top = 12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(R.drawable.rating_icon),
                                contentDescription = "Rating Icon",
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = card.rating,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                        Row() {
                            Text(text = card.name, fontSize = 15.sp)
                        }
                    }
                }
                Box(modifier = Modifier
                    .size(24.dp)
                    .background(color = Color.Black.copy(alpha = 0.6f))
                    .constrainAs(cardPlusButton) {
                        top.linkTo(parent.top)
                        start.linkTo(startGuide)
                    }) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add to list",
                            tint = Color.White
                        )
                    }
                }
                Box(modifier = Modifier
                    .size(24.dp)
                    .constrainAs(cardInfoButton) {
                        end.linkTo(parent.end, margin = 6.dp)
                        bottom.linkTo(parent.bottom, margin = 6.dp)
                    }) {
                    IconButton(onClick = { card.moreInfoButton }) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Get info",
                            tint = Color.Gray
                        )
                    }
                }
            }
        }
    }
}