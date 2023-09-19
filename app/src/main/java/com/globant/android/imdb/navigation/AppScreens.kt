package com.globant.android.imdb.navigation

sealed class AppScreens (val route:String){
    object HomeScreen:AppScreens("home-screen")
    object LoginScreen:AppScreens("login-screen")
    object SignUpScreen:AppScreens("signup-screen")
}
