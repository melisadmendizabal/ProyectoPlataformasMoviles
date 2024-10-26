package com.uvg.freetofeel.presentation.sunPresentation.sunInput

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.petPresentation.petTalk.PetTalkROUTE
import kotlinx.serialization.Serializable


@Serializable
data object SunInputDESTINATION

fun NavController.navigateToSunInput(
    destination: SunInputDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.sunInputScreen(
    onOption: () -> Unit

){
    composable<SunInputDESTINATION>{
        SunInputROUTE(onOption = onOption)
    }
}