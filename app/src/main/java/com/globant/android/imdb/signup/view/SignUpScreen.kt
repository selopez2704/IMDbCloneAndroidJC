package com.globant.android.imdb.signup.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.globant.android.imdb.R
import com.globant.android.imdb.navigation.AppScreens
import com.globant.android.imdb.utils.TopBottomBar


@Composable
fun SignUpScreen(navController:NavController) {
    TopBottomBar(
        topEnabled = true,
        bottomEnabled = false,
        topBackRoute = AppScreens.LoginScreen.route,
        navController = navController
    )
    {innerPadding->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(Modifier.padding(12.dp)) {
                    Text(
                        text = "IMDb",
                        color = MaterialTheme.colorScheme.tertiary,
                        fontFamily = FontFamily(Font(R.font.impact)),
                        fontSize = 45.sp,
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(start = 15.dp, end = 15.dp)
                    )
                }
                Text(text = "Crear una cuenta")
            }
        }
    }
}