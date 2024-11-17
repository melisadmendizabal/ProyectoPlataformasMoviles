package com.uvg.freetofeel.repositories

import com.uvg.freetofeel.data.model.DailyRecoModel

interface DailyRecoRepository {
    suspend fun getDailyRecos(): List<DailyRecoModel>
    suspend fun getDailyRecosByCompleted(completed: String): List<DailyRecoModel>
    suspend fun getSingleRandomRecoByCompleted(completed: String): DailyRecoModel
}