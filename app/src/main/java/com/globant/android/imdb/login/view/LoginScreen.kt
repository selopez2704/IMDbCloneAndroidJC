package com.globant.android.imdb.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.globant.android.imdb.R
import com.globant.android.imdb.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController:NavController?, modifier:Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.surface) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "IMDb",
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = FontFamily(Font(R.font.impact)),
                fontSize = 45.sp,
                modifier = Modifier.padding(top = 204.dp)
            )

            Box(modifier = modifier) {
                Column {
                    TextField(
                        value = "",
                        modifier = Modifier.padding(12.dp),
                        onValueChange = { "user" },
                        label = { Text(text = "usuario") },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )

                    )
                    TextField(
                        value = "",
                        onValueChange = { "password" },
                        modifier = Modifier.padding(12.dp),
                        label = { Text(text = "Contraseña") },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )

                    )
                }
            }
            Text(text = "¿Olvidaste tu contraseña?")

            Button(
                onClick = { navController?.navigate(AppScreens.HomeScreen.route) },
                contentPadding = PaddingValues(20.dp),
                modifier = Modifier.width(280.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Login", fontSize = 20.sp)
            }
            Text(text = "O puedes ingresar con")
            IconButton(
                onClick = { "a" },
                Modifier.background(color = Color.White, shape = CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.googlelogo),
                    contentDescription = "Google logo"
                )
            }

            Row(modifier = Modifier) {
                Text(text = "¿No tienes cuenta?")
                Text(
                    text = " Registrate",
                    modifier = Modifier.clickable(
                        enabled = true,
                        onClick = { navController?.navigate(AppScreens.SignUpScreen.route) }
                    ),
                    fontWeight = FontWeight.Bold
                )
            }
            Text(text = "Continuar como invitado")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen(navController = null)
}