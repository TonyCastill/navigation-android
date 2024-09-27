package com.example.navigation

//import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

//import java.lang.reflect.Modifier


/**
 * Here we create the screens we are going to use
 * to navigate. When we're done, we create the sealed
 * class Screen to define routes reachable from
 * anywhere
 *
 * Alternatively, we could create a constant within the
 * route name of the screens, but a sealed class is one of
 * the most popular ways of defining screens in the app
 *
 * A sealed class in kotlin:
 * Sealed classes and interfaces provide
 * controlled inheritance of your class hierarchies.
 * All direct subclasses of a sealed class are known at
 * compile time. No other subclasses may appear outside the
 * module and package within which the sealed class is defined.
 * The same logic applies to sealed interfaces and their
 * implementations: once a module with a sealed interface is
 * compiled, no new implementations can be created.
 *
 *
 */
//@Preview(showBackground = true)
@Composable
fun HomeScreen(
    /**To navigate
     * to other destinations, we need to import
     * the nav controller
     */
    navController : NavController
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Home",
            modifier = Modifier.clickable {
                navController.navigate(route=Screen.Detail.route)
                //.navigate() allows us to navigate to a destination
            },
            color=MaterialTheme.colorScheme.primary,
            fontSize=MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}