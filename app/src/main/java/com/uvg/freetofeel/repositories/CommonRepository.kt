package com.uvg.freetofeel.repositories

import com.uvg.freetofeel.data.source.FeelingsDb
import com.uvg.freetofeel.data.local.dao.DailyRecoDAO
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.dao.mapToEntity
import com.uvg.freetofeel.data.local.entity.mapToModel
import com.uvg.freetofeel.data.model.DailyRecoModel
import com.uvg.freetofeel.data.model.Feeling
import com.uvg.freetofeel.data.source.DailyRecoDB
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

    override suspend fun getSingleRandomFeelingByEmotion(emotion: String): Feeling {
        val randomFeelingEntity = feelingDAO.getSingleRandomFeelingByEmotion(emotion)
        return randomFeelingEntity.mapToModel()

    }

    suspend fun insertAllFeelings(feelings:List<Feeling>){
        val entities = feelings.map { it.mapToEntity() }
        feelingDAO.insertAllFeelings(entities)
    }
}

class DailyRecoRepositoryImpl(
    private val dailyRecoDAO: DailyRecoDAO
):DailyRecoRepository{

    override suspend fun getDailyRecos(): List<DailyRecoModel> {
        val dailyRecoDB = DailyRecoDB()
        val remoteDailyrecos = dailyRecoDB.getAllDailyRecos()
        val localDailyRecos = remoteDailyrecos.map { dailyRecoModel -> dailyRecoModel.mapToEntity()}
        dailyRecoDAO.insertAllDailyRecos(localDailyRecos)

        return dailyRecoDAO.getAllDailyRecos().first().map { entity-> entity.mapToModel() }
    }

    override suspend fun getDailyRecosByCompleted(completed: String): List<DailyRecoModel> {
        val localDailyRecos = dailyRecoDAO.getAllDailyRecosByCompleted(completed)
        return localDailyRecos.map { entity -> entity.mapToModel()}

    }

    override suspend fun getSingleRandomRecoByCompleted(completed: String): DailyRecoModel {
        val randomDailyEntity = dailyRecoDAO.getSigleRandomDailyRecoByCompeted(completed)
        return randomDailyEntity.mapToModel()
    }


}