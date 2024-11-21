package com.uvg.freetofeel.data.source

import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.Challenge

class ChallengeDB {
    private val challenges: List<Challenge> = listOf(

    )

    fun getAllChallenges(): List<Challenge>{
        return challenges
    }
}