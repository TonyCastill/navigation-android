package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navigation.BottomBarScreen
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




            navController = rememberNavController() //Global

            /** rememberNavController()
             * A predefined composable function that allows us to
             * immediately create a nav host controller
             * which will handle the navigation in our app
             */

            Scaffold(
                bottomBar={ BottomBar(navController = navController) }
            ){ innerPadding->
                Column(modifier =Modifier.padding(innerPadding)){
                    SetupNavGraph(navController = navController)
                }
            }
            //NavGraph.kt


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
fun BottomBar(navController:NavHostController){
    val screens = listOf( //Sealed Classes
        BottomBarScreen.HomeBB,
        BottomBarScreen.SettingsBB,
        BottomBarScreen.ProfileBB
    )

    //Whenever its value is changed, we will be notified about that
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestionation = navBackStackEntry?.destination // Nullable type // current location


    //Predefined composable function to add items to the nav bar
    NavigationBar(){
        screens.forEach{screen ->
            AddItem(screen = screen, currentDestination = currentDestionation, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(// Extends from RowScope
    screen:BottomBarScreen, //Sealed class
    currentDestination: NavDestination?, //Nullable type // The current location
    navController: NavHostController // To navigate to other destinations
){
    /*BottomNavigationItem(
        onClick = { /*TODO*/ },
        icon = { /*TODO*/ },
        label = {Text(text = screen.title)}
    )*/
    NavigationBarItem(
        onClick = {
            navController.navigate(screen.route){
                //Avoid back stack problem
                // PopUp the new screen instead of creating a new intace every time
                popUpTo(navController.graph.findStartDestination().id)
                //popUpTo(navController.navigate(BottomBarScreen.HomeBB.route))
                launchSingleTop=true
                /**
                 * This allows us to avoid multiple copies of of the same destination
                 * when reselecting the same item
                 */

            }

                  },
        icon = { Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")},
        label = {Text(text = screen.title)}, //Text
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route // Checks if is selected
        } == true
    )

}

/*@Composable
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
}*/