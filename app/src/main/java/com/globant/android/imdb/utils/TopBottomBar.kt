package com.globant.android.imdb.utils

import android.provider.CalendarContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.globant.android.imdb.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBottomBar(
    topEnabled:Boolean = true,
    bottomEnabled:Boolean = true,
    topBackRoute:String = "home-screen",
    navController:NavController,
    content:@Composable (PaddingValues)-> Unit
) {
    Scaffold(
        topBar = { TopBar(topEnabled, topBackRoute, navController) },
        bottomBar = { BottonBar(bottomEnabled, navController) },
        content = {innerPadding-> content(innerPadding) }
    )
}

@Composable
fun TopBar(enabled:Boolean = true, route:String = "home-screen", navController:NavController) {
    if (enabled) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .background(color = Color.Red)
            ) {
                IconButton(onClick = { navController.navigate(route) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Volver")
                }
            }
        }
    }
}


@Composable
fun BottonBar(enabled:Boolean = true, navController:NavController) {
    if (enabled) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)
                )
                .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { navController.navigate(AppScreens.HomeScreen.route) }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        modifier = Modifier.size(24.dp),
                        contentDescription = "home"
                    )
                }
                Text(text = "Inicio")
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { "a" }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        modifier = Modifier.size(24.dp),
                        contentDescription = "search"
                    )
                }
                Text(text = "Buscar")
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { "a" }) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        modifier = Modifier.size(24.dp),
                        contentDescription = "play"
                    )
                }
                Text(text = "Play")
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { "a" }) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        modifier = Modifier.size(24.dp),
                        contentDescription = "account"
                    )
                }
                Text(text = "User")
            }
        }
    }
}
