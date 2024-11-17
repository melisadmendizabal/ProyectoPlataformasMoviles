package com.uvg.freetofeel.data.local.dao



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uvg.freetofeel.data.local.entity.ChallengeEntity
import com.uvg.freetofeel.data.model.Challenge
import kotlinx.coroutines.flow.Flow

@Dao
interface ChallengeDAO {
    @Query("SELECT * FROM ChallengeEntity")
    fun getAllChallenges(): Flow<List<ChallengeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllChallenges(challenges: List<ChallengeEntity>)

    @Query("SELECT * FROM ChallengeEntity WHERE filter = :filter")
    suspend fun getAllChallengsByFilter(filter: String): List<ChallengeEntity>
}

fun Challenge.mapToEntity():ChallengeEntity{
    return ChallengeEntity(
        title = this.title,
        category = this.category,
        body = this.body,
        filter = this.filter,
        image = this.image

    )
}