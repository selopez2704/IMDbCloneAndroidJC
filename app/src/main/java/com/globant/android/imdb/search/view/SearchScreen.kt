package com.globant.android.imdb.search.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.globant.android.imdb.utils.TopBottomBar


@Composable
fun SearchScreen(navController:NavController) {
    TopBottomBar(
        topEnabled = false,
        bottomEnabled = true,
        topBackRoute = "home-screen",
        navController
    ) { innerPadding ->
        Column(Modifier.fillMaxSize()) {
            SearchTextField()
            LazyColumn(Modifier.padding(start = 24.dp, end = 24.dp, top = 16.dp)) {
                item {
                    ResultCard(name = "Result 1")
                }
                item {
                    ResultCard(name = "Result 2")
                }
                item {
                    ResultCard(name = "Result 3")
                }
                item {
                    ResultCard(name = "Result 4")
                }
                item {
                    ResultCard(name = "Result 5")
                }
                item {
                    ResultCard(name = "Result 6")
                }
                item {
                    Spacer(modifier = Modifier.size(100.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchTextField() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = "search",
            onValueChange = {/*TODO*/ },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
//                    disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
        )
    }
}

@Preview
@Composable
fun ResultCard(name:String = "Not defined") {
    Row(
        Modifier
            .height(200.dp)
            .fillMaxWidth()
            .drawBehind {
                val borderSize = 1.dp.toPx()
                drawLine(
                    color = Color(0xFF9D9C9C),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = borderSize
                )
            }
            .padding(top = 12.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier) {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(160.dp)
                    .background(color = Color.Cyan)
            ) {
                Text(text = "Poster")
            }
        }
        Column(Modifier.padding(24.dp)) {
            Row {
                Text(text = name)
            }
            Row {
                Text(text = "2023")
            }
            Row(Modifier.padding(top=24.dp)){
                Text(text = "Actor 1, Actor 2")
            }

        }
    }
}