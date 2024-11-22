package com.uvg.freetofeel.repositories

import com.uvg.freetofeel.data.model.HistoryPets

interface HistoryRepository{
    suspend fun getHistories(): List<HistoryPets>
    suspend fun getHistoriesByTipe(typePet: String): List<HistoryPets>
    suspend fun getSigleHistorybyOrder(idHistory: Int): HistoryPets
}