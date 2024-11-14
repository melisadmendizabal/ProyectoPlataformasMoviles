package com.uvg.freetofeel.repositories

import com.uvg.freetofeel.data.local.FeelingsDb
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.dao.mapToEntity
import com.uvg.freetofeel.data.local.entity.mapToModel
import com.uvg.freetofeel.data.model.Feeling
import kotlinx.coroutines.flow.first

class FeelingRepositoryImpl(
    private val feelingDAO: FeelingDAO
):FeelingsRepository{

    override suspend fun getFeelings(): List<Feeling> {
        val feelingsDb = FeelingsDb()
        val remoteFeelings = feelingsDb.getAllFeelings()
        val localFeelings = remoteFeelings.map { feeling -> feeling.mapToEntity() }
        feelingDAO.insertAllFeelings(localFeelings)

        return feelingDAO.getAllFeelings().first().map { entity ->entity.mapToModel() }
    }

    override suspend fun getFeelingsByEmotion(emotion: String): List<Feeling> {
        val localFeelings = feelingDAO.getAllFeelingsByEmotion(emotion)
        return localFeelings.map { entity -> entity.mapToModel() }

    }

    override suspend fun getSingleRandomFeelingByEmotion(feelingList: List<Feeling>): Feeling {
        val randomFeelingEntity = feelingDAO.getSingleRandomFeelingByEmotion(feelingList.random().emotion)
        return randomFeelingEntity.mapToModel()

    }

    suspend fun insertAllFeelings(feelings:List<Feeling>){
        val entities = feelings.map { it.mapToEntity() }
        feelingDAO.insertAllFeelings(entities)
    }
}