package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    /** NavHost()
     * A predefined composable function where
     * We define the nav controller, our start destination and a nav graph builder
     * Inside Nav Graph builder we define all our destinations
     */
    NavHost(navController = navController,
        //startDestination = "home_screen"
        startDestination = Screen.Home.route){
        //Inside this body or nav graph builder, we declare all our destinations and composable screens

        //Here we define our routes
        composable(route = Screen.Home.route){ HomeScreen(navController) }
        //We send navController as argument to navigate from there
        composable(route = Screen.Detail.route){ DetailScreen(navController) }
    }
}