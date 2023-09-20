package com.globant.android.imdb.signup.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.globant.android.imdb.R
import com.globant.android.imdb.navigation.AppScreens
import com.globant.android.imdb.utils.TopBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController:NavController) {
    var showPassword by remember { mutableStateOf(value = false) }
    TopBottomBar(
        topEnabled = true,
        bottomEnabled = false,
        topBackRoute = AppScreens.LoginScreen.route,
        navController = navController
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 48.dp, end = 48.dp, bottom=240.dp)
                    .fillMaxSize(),
//                verticalArrangement = Arrangement.SpaceBetween
                verticalArrangement = Arrangement.SpaceEvenly
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
                Text(text = "Crear una cuenta", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp),
                    onValueChange = { "name" },
                    label = { Text(text = "Nombre") },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary
                    )
                )
                OutlinedTextField(
                    value = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp),
                    onValueChange = { "email" },
                    label = { Text(text = "Correo electrónico") },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary
                    )
                )
                OutlinedTextField(
                    value = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp),
                    onValueChange = { "password" },
                    label = { Text(text = "Contraseña") },
                    shape = RoundedCornerShape(12.dp),
                    trailingIcon = {
                        if (showPassword) {
                            IconButton(onClick = { showPassword = false }) {
                                Icon(
                                    painter = painterResource(R.drawable.visibility_icon),
                                    contentDescription = "hide_password"
                                )
                            }
                        } else {
                            IconButton(
                                onClick = { showPassword = true }) {
                                Icon(
                                    painter = painterResource(R.drawable.visibility_off_icon),
                                    contentDescription = "hide_password"
                                )
                            }
                        }
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary
                    )
                )
                Text(text = "la contraseña debe contener 8 caracteres")

                Button(
                    onClick = { "SignUp" },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                ) {
                    Text(text = "Aceptar", fontSize = (18.sp))
                }
            }
        }
    }
}