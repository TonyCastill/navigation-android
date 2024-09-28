package com.example.navigation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigation.navigation.HOME_ROUTE
import com.example.navigation.navigation.ROOT_ROUTE
import com.example.navigation.navigation.Screen

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
        //startDestination = Screen.Home.route,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE
    ){
        //Inside this body or nav graph builder, we declare all our destinations and composable screens

        //Here we define our routes
        //composable(route = Screen.Home.route){ HomeScreen(navController) }
        //We send navController as argument to navigate from there
        // We can also add arguments
        /*composable(
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
        }*/

        // Nested Navigation Graph
        // Authentication Navigation graph

        // This is if we wanted to have everything in a single file, but we can add
        // other file
//        navigation( // Extension function on a NavGraphBuilder()
//            startDestination = Screen.Login.route, // The first route of the nested navigation graph
//            route = AUTHENTICATION_ROUTE
//        ) {
//            composable(route = Screen.SignUp.route) { SignUpScreen(navController) }
//            composable(route = Screen.Login.route) { LoginScreen(navController) }
//        }

        //Insted, we use other file
        homeNavGraph(navController=navController)
        authNavGrap(navController=navController) //Extension function on a NavGraphBuilder()

    }
}