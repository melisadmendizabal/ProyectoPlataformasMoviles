package com.uvg.freetofeel.presentation.petPresentation.petHome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object PetHomeDESTINATION

fun NavGraphBuilder.pethomeScreen(

){
    composable<PetHomeDESTINATION>{
        PetHomeROUTE()
    }
}