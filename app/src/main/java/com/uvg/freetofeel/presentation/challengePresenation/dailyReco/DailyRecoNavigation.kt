package com.uvg.freetofeel.presentation.challengePresenation.dailyReco

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.petPresentation.petSelect.PetSelectROUTE
import kotlinx.serialization.Serializable

@Serializable
data class DailyRecoDESTINATION(
    val completed:String
)

fun NavController.navigateToDailyReco(
    destination: String,
    navOptions: NavOptions? = null
){
    this.navigate(DailyRecoDESTINATION(completed = destination), navOptions)
}

fun NavGraphBuilder.dailyRecoScreen(
    onAcceptDailyReco: () -> Unit

){
    composable<DailyRecoDESTINATION>{
        DailyRecoROUTE(onAcceptDailyReco = onAcceptDailyReco)
    }
}