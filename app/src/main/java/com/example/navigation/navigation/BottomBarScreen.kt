package com.example.navigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route : String,
    val title: String,
    val icon: ImageVector
){
    object HomeBB : BottomBarScreen(
        route="home_bb",
        title = "Home",
        icon = Icons.Filled.Home
    )
    object ProfileBB : BottomBarScreen(
        route="profile",
        title = "Profile",
        icon = Icons.Filled.AccountCircle
    )
    object SettingsBB : BottomBarScreen(
        route="settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}