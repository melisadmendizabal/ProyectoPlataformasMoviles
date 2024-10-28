package com.uvg.freetofeel.presentation.challengePresenation.challengeHome

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ChallengeHomeDESTINATION


fun NavGraphBuilder.challengehomeScreen(
    onSelect: (Any)->Unit

){
    composable<ChallengeHomeDESTINATION>{
        ChallengeHomeROUTE(
            onSelect = onSelect

        )
    }
}