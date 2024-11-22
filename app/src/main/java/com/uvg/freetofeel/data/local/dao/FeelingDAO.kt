package com.uvg.freetofeel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uvg.freetofeel.data.local.entity.FeelingEntity
import com.uvg.freetofeel.data.model.Feeling
import kotlinx.coroutines.flow.Flow


@Dao
interface FeelingDAO {
    @Query("SELECT * FROM FeelingEntity")
    fun getAllFeelings(): Flow<List<FeelingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFeelings(feelings: List<FeelingEntity>)

    @Query("SELECT * FROM FeelingEntity WHERE emotion = :emotion")
    suspend fun getAllFeelingsByEmotion(emotion: String): List<FeelingEntity>

    @Query("SELECT * FROM FeelingEntity WHERE emotion = :emotion ORDER BY RANDOM() LIMIT 1")
    suspend fun getSingleRandomFeelingByEmotion(emotion: String): FeelingEntity
}


fun Feeling.mapToEntity():FeelingEntity{
    return FeelingEntity(
        title = this.title,
        body = this.body,
        emotion = this.emotion
    )
}

