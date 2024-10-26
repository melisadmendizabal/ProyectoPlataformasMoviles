package com.uvg.freetofeel.presentation.navigation.BotNavigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
data object ScreenBotNavigationDestination

fun NavController.navigateToScreenBotNavigation(
    destination: ScreenBotNavigationDestination,
    navOptions: NavOptions? = null){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.screenBotNavigation(

){
    composable<ScreenBotNavigationDestination>{
        val nestedNavController = rememberNavController()
        ScreenBotNav()
    }
}