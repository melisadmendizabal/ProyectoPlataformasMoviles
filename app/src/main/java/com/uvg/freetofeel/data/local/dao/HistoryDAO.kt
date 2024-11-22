package com.uvg.freetofeel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uvg.freetofeel.data.local.entity.HistoryEntity
import com.uvg.freetofeel.data.model.HistoryPets
import kotlinx.coroutines.flow.Flow


@Dao
interface HistoryDAO {
    @Query("SELECT * FROM HistoryEntity")
    fun getAllHistories(): Flow<List<HistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHistory(historyPet: List<HistoryEntity>)

    @Query("SELECT * FROM HistoryEntity WHERE typePet = :typePet")
    suspend fun getHistoryPetsByType(typePet: String): List<HistoryEntity>

    @Query("SELECT * FROM HistoryEntity WHERE idHistory = :idHistory")
    suspend fun getHistoryPetById(idHistory: Int): HistoryEntity
}

fun HistoryPets.mapToEntity(): HistoryEntity {
    return HistoryEntity(
        idHistory = this.idHistory,
        title = this.title,
        description = this.description,
        typePet = this.typePet,
        option1 = this.option1,
        point1 = this.point1,
        option2 = this.option2,
        point2 = this.point2,
        option3 = this.option3,
        point3 = this.point3,
        back = this.back,
        pet = this.pet
    )
}
