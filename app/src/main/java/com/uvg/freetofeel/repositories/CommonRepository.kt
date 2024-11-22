package com.uvg.freetofeel.repositories

import com.uvg.freetofeel.data.local.dao.ChallengeDAO
import com.uvg.freetofeel.data.source.FeelingsDb
import com.uvg.freetofeel.data.source.HistoryPetsDb
import com.uvg.freetofeel.data.local.dao.DailyRecoDAO
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.dao.HistoryDAO
import com.uvg.freetofeel.data.local.dao.mapToEntity
import com.uvg.freetofeel.data.local.entity.mapToModel
import com.uvg.freetofeel.data.model.Challenge
import com.uvg.freetofeel.data.model.DailyRecoModel
import com.uvg.freetofeel.data.model.Feeling
import com.uvg.freetofeel.data.model.HistoryPets
import com.uvg.freetofeel.data.source.ChallengeDB
import com.uvg.freetofeel.data.source.DailyRecoDB
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

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

class HistoryPetsRepositoryImpl(
    private val historyDAO: HistoryDAO
):HistoryRepository {


    override suspend fun getHistories(): List<HistoryPets> {
        val historyPetsDb = HistoryPetsDb()
        val remoteHistoryPets = historyPetsDb.getAllHistories()
        val localHistoryPets = remoteHistoryPets.map { historyPets -> historyPets.mapToEntity()}
        historyDAO.insertAllHistory(localHistoryPets)

        return historyDAO.getAllHistories().first().map { entity -> entity.mapToModel() }
    }

    override suspend fun getHistoriesByTipe(typePet: String): List<HistoryPets> {
        val localHistoryPets = historyDAO.getHistoryPetsByType(typePet)
        return localHistoryPets.map { entity -> entity.mapToModel() }
    }

    override suspend fun getSigleHistorybyOrder(idHistory: Int): HistoryPets {
        val singleHistoryEntity = historyDAO.getHistoryPetById(idHistory)
        return singleHistoryEntity.mapToModel()
    }


}


class ChallengeRepositoryImpl(
    private val challengeDAO: ChallengeDAO
): ChallengesRepository{
    override suspend fun getChallenges(): List<Challenge> {
        val challengesDb = ChallengeDB()
        val remoteChallenges = challengesDb.getAllChallenges()
        val localChallenges = remoteChallenges.map { challenge -> challenge.mapToEntity() }
        challengeDAO.insertAllChallenges(localChallenges)
        return challengeDAO.getAllChallenges().first().map { entity -> entity.mapToModel()}
    }

    override suspend fun getChallengesByFilter(filter: String): List<Challenge> {
        val localChallenges = challengeDAO.getAllChallengsByFilter(filter)
        return localChallenges.map { entity -> entity.mapToModel() }
    }

    override suspend fun getSingleChallengeByTitle(title: String): Challenge {
        val singleChallengeEntity = challengeDAO.getSingleChallengeByTitle(title)
        return singleChallengeEntity.mapToModel()
    }

}
