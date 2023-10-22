package com.globant.android.imdb.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.globant.android.imdb.utils.TopBottomBar
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun HomeScreen(navController:NavController) {
    TopBottomBar(
        topEnabled = false,
        bottomEnabled = true,
        topBackRoute = "home-screen",
        navController
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.Transparent),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                FeatureContent()
            }
            item {
                Carousel(
                    title = "Las mejores selecciones",
                    movies = listOf("Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5")
                )
            }
            item {
                Carousel(
                    title = "Quizas te interese",
                    movies = listOf("Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5")
                )
            }
            item {
                Carousel(
                    title = "Post-Apocalypse opciones",
                    movies = listOf("Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5")
                )
            }
            item {
                Carousel(
                    title = "Recomendaciones",
                    movies = listOf("Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5")
                )
            }

        }
    }
}

@Preview
@Composable
fun FeatureContent() {
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
            Text(text = "Player")
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
                Text(text = "Movie Title")
                Text(text = "trailer oficial")
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
            Text(text = "Poster")
        }
    }
}


@Preview
@Composable
fun Carousel(title:String = "Not defined", movies:List<String> = listOf<String>("undefined")) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(start = 24.dp, top = 24.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Row(modifier = Modifier.height(32.dp)) {
            Divider(
                color = Color.Transparent,
                modifier = Modifier
                    .fillMaxHeight()  //fill the max height
                    .width(4.dp)
                    .border(
                        shape = RoundedCornerShape(12.dp),
                        width = 12.dp,
                        color = MaterialTheme.colorScheme.surface
                    )
            )
            Text(text = title)
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            items(movies) { movie -> Card(movie) }
        }
    }
}

@Preview
@Composable
fun Card(name:String = "Not defined") {

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
        )
        {
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
                        text = "Image",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .constrainAs(cardText) {
                            top.linkTo(cardImage.bottom)
                        }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start=12.dp,top=12.dp)
                    ) {
                        Text(text = "Rating", fontSize = 11.sp)
                        Text(text = "Name", fontSize = 15.sp)
                    }
                }
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(color = Color.Black.copy(alpha=0.6f))
                        .constrainAs(cardPlusButton) {
                            top.linkTo(parent.top)
                            start.linkTo(startGuide)
                        }
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add to list",
                            tint = Color.White
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .constrainAs(cardInfoButton) {
                            top.linkTo(cardText.bottom)
                            end.linkTo(parent.end, margin=6.dp)
                            bottom.linkTo(parent.bottom)
                        }
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Get info",
                            tint=Color.Gray
                        )
                    }
                }
            }
        }
    }
}