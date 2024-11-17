package com.uvg.freetofeel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uvg.freetofeel.data.local.entity.DailyRecoEntity
import com.uvg.freetofeel.data.model.DailyRecoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyRecoDAO {
    @Query("SELECT * FROM DailyRecoEntity")
    fun getAllDailyRecos(): Flow<List<DailyRecoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDailyRecos(dailyRecos: List<DailyRecoEntity>)

    @Query("SELECT * FROM DailyRecoEntity WHERE completed = :completed")
    suspend fun getAllDailyRecosByCompleted(completed: String): List<DailyRecoEntity>

    @Query("SELECT * FROM DailyRecoEntity WHERE completed = :completed ORDER BY RANDOM() LIMIT 1")
    suspend fun getSigleRandomDailyRecoByCompeted(completed: String): DailyRecoEntity

}

fun DailyRecoModel.mapToEntity(): DailyRecoEntity{
    return DailyRecoEntity(
        title = this.title,
        body = this.body,
        completed = this.completed,
        points = this.points
    )
}