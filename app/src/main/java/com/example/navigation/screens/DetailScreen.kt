package com.example.navigation.screens

//import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navigation.Screen

//import java.lang.reflect.Modifier

//@Preview(showBackground = true )
@Composable
fun DetailScreen(navController : NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Detail",
            modifier = Modifier.clickable {
                /** If we continue navigating with this button,
                 * every screen will bi pilled in a stack.
                 * -> HomeScren | DetailScreen | HomeScreen | DetailScreen ..
                 * To avoid this
                 * we could simply pop the Detail screen from the back stack
                 * That way we assure that the detail screen will always come
                 * out as a secondary screen of the HomeScreen
                 * HomeScreen -> back -> exits the application
                 *
                 * NOTE: if we want to pass a paramater from DetailScreen to
                 * Home Screen, we cannot use the popBackStack method.
                 * use navigate() explicit instead
                 *
                 * When we don't want the DetailScreen to pop out when we
                 * close the Home Screen and we also want to pass arguments
                 * from the Detail Screen to the Home Screen, we use popUpTo
                 */

                // Simple navigation
                //navController.navigate(Screen.Home.route)

                //PopBackStack
                //navController.popBackStack()

                //PopUpTo
                navController.navigate(Screen.Home.route){
                    //It will pop from the back of the stack
                    popUpTo(Screen.Home.route){
                        inclusive = true // Accept arguments
                    }
                }
            },
            color= Color.Red,
            fontSize=MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}


/** If we want to preview
 * a composable function even if we receive a nav contoller as
 * a parameter
 *
 * rememberNavController craetes a new nav controller diffent
 * from the one we actually use, but its a workaround when
 * we want to preview the screen
 */

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    DetailScreen(navController = rememberNavController())
}
