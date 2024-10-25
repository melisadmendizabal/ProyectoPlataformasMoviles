package com.uvg.freetofeel.presentation.challengePresenation.challengeHome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ChallengeHomeDESTINATION


fun NavGraphBuilder.challengehomeScreen(

){
    composable<ChallengeHomeDESTINATION>{
        ChallengeHomeROUTE(

        )
    }
}