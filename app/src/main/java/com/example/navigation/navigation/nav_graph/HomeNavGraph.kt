package com.example.navigation.navigation.nav_graph

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.navigation.navigation.DETAIL_ARGUMENT_KEY
import com.example.navigation.navigation.DETAIL_ARGUMENT_KEY2
import com.example.navigation.navigation.HOME_ROUTE
import com.example.navigation.navigation.Screen
import com.example.navigation.screens.DetailScreen
import com.example.navigation.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(navController: NavController) {// Extension function on a NavGraphBuilder()
    navigation( // Extension function on a NavGraphBuilder()
        startDestination = Screen.Home.route, // The first route of the nested navigation graph
        route = HOME_ROUTE
    ) {
        composable(route = Screen.Home.route){ HomeScreen(navController) }
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