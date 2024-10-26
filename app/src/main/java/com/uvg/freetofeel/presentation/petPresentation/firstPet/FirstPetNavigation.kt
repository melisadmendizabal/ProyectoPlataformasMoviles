package com.uvg.freetofeel.presentation.petPresentation.firstPet

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object FirstPetDESTINATION

fun NavController.navigateToFirstPet(
    destination: FirstPetDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.firstPetScreen(       //Por el momento, es provisional. Revisar al momento de hacer la nav
    onFirstPetOk: () -> Unit
) {
    composable<FirstPetDESTINATION> {
        FirstPetScreen(onFirstPetOk = onFirstPetOk)
    }
}