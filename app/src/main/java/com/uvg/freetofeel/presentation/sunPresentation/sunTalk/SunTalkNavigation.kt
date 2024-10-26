package com.uvg.freetofeel.presentation.sunPresentation.sunTalk

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.SunInputROUTE
import kotlinx.serialization.Serializable


@Serializable
data object SunTalkDESTINATION

fun NavController.navigateToSunTalk(
    destination: SunTalkDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.sunTalkScreen(
    onAccept: () -> Unit

){
    composable<SunTalkDESTINATION>{
        SunTalkROUTE(onAccept = onAccept)
    }
}