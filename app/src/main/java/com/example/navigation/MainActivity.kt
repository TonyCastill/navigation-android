package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navigation.nav_graph.SetupNavGraph
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    /**lateinit is used to declare
     * a non-nullable variable that will
     * be initialized later after the object is created.
     * It allows you to delay the initialization of a variable
     * without having to make it nullable, and it can only be
     * used with var (mutable variables).
     *
     * Usually variables that depend on dependency injections
     */
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()
            /** rememberNavController()
             * A predefined composable function that allows us to
             * immediately create a nav host controller
             * which will handle the navigation in our app
             */

            //NavGraph.kt
            SetupNavGraph(navController = navController)
            
            /*NavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationTheme {
        Greeting("Android")
    }
}