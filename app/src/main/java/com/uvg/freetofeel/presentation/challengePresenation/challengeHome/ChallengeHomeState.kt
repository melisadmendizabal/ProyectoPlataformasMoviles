package com.uvg.freetofeel.presentation.challengePresenation.challengeHome

import com.uvg.freetofeel.data.model.Challenge

data class ChallengeHomeState (
    val isLoading:Boolean = true,
    val challenges:List<Challenge> = emptyList(),
    val isError:Boolean=false
)