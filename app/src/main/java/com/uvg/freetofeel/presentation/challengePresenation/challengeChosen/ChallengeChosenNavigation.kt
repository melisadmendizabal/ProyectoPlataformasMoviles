package com.uvg.freetofeel.presentation.challengePresenation.challengeChosen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.challengePresenation.challengeHome.ChallengeHomeROUTE
import com.uvg.freetofeel.presentation.sunPresentation.sunFeeling.SunFeelingDESTINATION
import kotlinx.serialization.Serializable


@Serializable
data object ChallengeChosenDESTINATION


fun NavGraphBuilder.challengeChosenScreen(
onButton:()->Unit
){
    composable<ChallengeChosenDESTINATION>{
        ChallengeChosenROUTE(
            onButton = onButton

        )
    }
}

fun NavController.navigateToChallengeChosen(
    destination: ChallengeChosenDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}