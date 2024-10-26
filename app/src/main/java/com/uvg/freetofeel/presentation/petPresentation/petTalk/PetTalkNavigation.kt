package com.uvg.freetofeel.presentation.petPresentation.petTalk

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.challengePresenation.dailyReco.DailyRecoROUTE
import kotlinx.serialization.Serializable


@Serializable
data object PetTalkDESTINATION

fun NavController.navigateToPetTalk(
    destination: PetTalkDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.petTalkScreen(
    onElection: () -> Unit

){
    composable<PetTalkDESTINATION>{
        PetTalkROUTE(onElection = onElection)
    }
}