package com.example.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

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
        // We can also add arguments
        composable(
            route = Screen.Detail.route,
            arguments = listOf( //List of arguments
                // id
                navArgument(DETAIL_ARGUMENT_KEY){
                    type = NavType.IntType // We define the type of the argument id
                    //In case is an optional argument, we define a defaultValue
                    defaultValue = 0
                    // As an alternative, we can set a null value whenever nothing is received
                    // nullable = true
                },
                //Another argument, name
                navArgument(DETAIL_ARGUMENT_KEY2){
                    type = NavType.StringType
                    defaultValue = "nobody"
                }
            )
        ){
            //Here we receive the arguments
            // ? is used to avoid null exception
            Log.d("Args",it.arguments?.getInt("id").toString())
            Log.d("Args",it.arguments?.getString("name").toString())
            //The destination
            DetailScreen(navController)
        }
    }
}