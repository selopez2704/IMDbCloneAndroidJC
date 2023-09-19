package com.globant.android.imdb.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.globant.android.imdb.utils.TopBottomBar

@Composable
fun HomeScreen(navController:NavController) {
    TopBottomBar(
        topEnabled = false,
        bottomEnabled = true,
        topBackRoute = "home-screen",
        navController
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
            item {
                Text(text = "Home screen", fontSize = 64.sp)
            }
        }
    }
}