package com.uvg.freetofeel.presentation.petPresentation.petSelect

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object PetSelectDESTINATION

fun NavController.navigateToPetSelect(
    destination: PetSelectDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.petSelectScreen(
    onBackFromSelectToHomePet: ()-> Unit,
    onpetselection: (Int) -> Unit

){
    composable<PetSelectDESTINATION>{
        PetSelectROUTE(
            onBackFromSelectToHomePet = onBackFromSelectToHomePet,
            onpetselection = onpetselection
        )
    }
}