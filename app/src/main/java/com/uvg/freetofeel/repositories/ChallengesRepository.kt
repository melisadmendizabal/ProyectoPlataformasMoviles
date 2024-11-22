package com.uvg.freetofeel.repositories

import com.uvg.freetofeel.data.model.Challenge

interface ChallengesRepository {
    suspend fun getChallenges():List<Challenge>
    suspend fun getChallengesByFilter(filter: String):List<Challenge>
    suspend fun getSingleChallengeByTitle(title: String):Challenge
}