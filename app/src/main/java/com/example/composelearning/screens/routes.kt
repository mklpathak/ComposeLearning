package com.example.composelearning.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Routes (val name:String ) {
    object Home : Routes("Home")
    object NewsList : Routes("NewsList")
    object News : Routes("News")
}

@Composable
fun Route(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.NewsList.name) {
        composable(Routes.NewsList.name) { NewsApp(navController = navController) }
        composable(Routes.News.name) { News()}
    }
}