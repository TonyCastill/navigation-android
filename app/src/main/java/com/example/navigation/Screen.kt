package com.example.navigation


/**
 * We create the sealed class to define routes to our screens
 *
 * Inside the Screen constructor, we pass one variable of a
 * type of a string
 */
sealed class Screen(val route : String) {
    //This class contains the screens
    object Home: Screen(route = "home_screen") //Will inherit from the Screen sealed class
    object Detail: Screen(route = "detail_screen")
}