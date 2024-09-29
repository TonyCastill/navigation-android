package com.example.navigation.screens

//import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navigation.AUTHENTICATION_ROUTE
import com.example.navigation.navigation.Screen

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
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ){
        Text("HOME",
            modifier = Modifier
                /*.clickable {
                /**
                 * Whenever we modify the route from the Screen sealed class,
                 * we have to change it here
                 */
                navController.navigate( //Remember to change NavGraph.kt and Screen.kt
                    //No arguments
                    //route=Screen.Detail.route

                    //Required Single argument in plain text
                    //"detail_screen/"+1

                    //Required Single Argument using Screen function
                    //route=Screen.Detail.passId(10)

                    //Required Muliple Arguments using Screen function
                    //route = Screen.Detail.passNameAndId(id=10, name = "Tony")

                    //Optional Single Argument using Screen function
                    //route = Screen.Detail.passId()

                    //Optional Multiple Argument using Scree function
                    route = Screen.Detail.passIdAndName()

                )

                //.navigate() allows us to navigate to a destination
            }*/,
            color=MaterialTheme.colorScheme.primary,
            fontSize=MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        /*TextButton(modifier = Modifier.padding(top = 150.dp),
            onClick = { navController.navigate(AUTHENTICATION_ROUTE) }) {
            Text(
                "Login/Sing up"
            )
        }*/
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}
