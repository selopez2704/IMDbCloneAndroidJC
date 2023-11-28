package com.globant.android.imdb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.globant.android.imdb.login.view.LoginScreen
import com.globant.android.imdb.home.view.HomeScreen
import com.globant.android.imdb.repository.MoviesRepository
import com.globant.android.imdb.search.view.SearchScreen
import com.globant.android.imdb.signup.view.SignUpScreen

@Composable
fun AppNavigation(){
    val moviesRepository = MoviesRepository()

    val navController = rememberNavController()
    NavHost(navController=navController,startDestination=AppScreens.LoginScreen.route){
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController,moviesRepository)
        }
        composable(route = AppScreens.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route = AppScreens.SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(route = AppScreens.SearchScreen.route){
            SearchScreen(navController)
        }
    }
}