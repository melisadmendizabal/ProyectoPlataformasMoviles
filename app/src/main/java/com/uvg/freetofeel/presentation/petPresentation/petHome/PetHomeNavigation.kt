package com.uvg.freetofeel.presentation.petPresentation.petHome

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.petPresentation.firstPet.FirstPetDESTINATION
import kotlinx.serialization.Serializable

@Serializable
data object PetHomeDESTINATION

fun NavController.navigateToPetHome(
    destination: PetHomeDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.pethomeScreen(
    onAllPetsClick: () -> Unit,
    onTipDayPetScreenClick: ()-> Unit,
    onHistoryScreenPetHome: ()-> Unit

){
    composable<PetHomeDESTINATION>{
        PetHomeROUTE(
            onAllPetsClick = onAllPetsClick,
            onTipDayPetScreenClick = onTipDayPetScreenClick,
            onHistoryScreenPetHome = onHistoryScreenPetHome)
    }

}