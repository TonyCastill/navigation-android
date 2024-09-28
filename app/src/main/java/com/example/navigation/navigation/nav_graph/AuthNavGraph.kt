package com.example.navigation.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.navigation.navigation.AUTHENTICATION_ROUTE
import com.example.navigation.navigation.Screen
import com.example.navigation.screens.LoginScreen
import com.example.navigation.screens.SignUpScreen

fun NavGraphBuilder.authNavGrap(navController: NavController){// Extension function on a NavGraphBuilder()
    navigation( // Extension function on a NavGraphBuilder()
        startDestination = Screen.Login.route, // The first route of the nested navigation graph
        route = AUTHENTICATION_ROUTE
    ) {
        composable(route = Screen.SignUp.route) { SignUpScreen(navController) }
        composable(route = Screen.Login.route) { LoginScreen(navController) }
    }
}