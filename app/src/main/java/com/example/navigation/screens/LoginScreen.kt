package com.example.navigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navigation.HOME_ROUTE
import com.example.navigation.navigation.Screen

@Composable
fun LoginScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Login",
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.SignUp.route)
            },
            color= Color.Magenta,
            fontSize= MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text( // Go Back
            "Go Detail Screen",
            modifier = Modifier
                .clickable {
                    /*TODO("navigate back")*/
                    /*navController.navigate(HOME_ROUTE){
                        // To exit the application after Home screen
                        popUpTo(HOME_ROUTE)
                    }*/
                    // When we want to navigate to other location of another Nav Graph
                    // We can directly navigate and pop this screen from the back stack
                    navController.popBackStack()
                    navController.navigate(Screen.Detail.passIdAndName())
                }
                .padding(top=150.dp),
            color= Color.Black,
            fontSize= MaterialTheme.typography.bodySmall.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}