package com.uvg.freetofeel.presentation.challengePresenation.dailyReco

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.petPresentation.petSelect.PetSelectROUTE
import kotlinx.serialization.Serializable

@Serializable
data object DailyRecoDESTINATION

fun NavController.navigateToDailyReco(
    destination: DailyRecoDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.dailyRecoScreen(
    onAcceptDailyReco: () -> Unit

){
    composable<DailyRecoDESTINATION>{
        DailyRecoROUTE(onAcceptDailyReco = onAcceptDailyReco)
    }
}