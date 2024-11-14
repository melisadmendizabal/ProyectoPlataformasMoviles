package com.uvg.freetofeel.data.repositories

import com.uvg.freetofeel.data.local.FeelingsDb
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.dao.mapToEntity
import com.uvg.freetofeel.data.local.entity.mapToModel
import com.uvg.freetofeel.data.model.Feeling
import kotlinx.coroutines.flow.first

class LocalFeelingRepository(
    private val feelingDao:FeelingDAO,
    private val feelingDb:FeelingsDb
){
    suspend fun getFeelings():List<Feeling>{
        val localFeelings = feelingDao.getAllFeelings().first()

        return localFeelings.map { localFeeling ->localFeeling.mapToModel() }
    }

    init {
        suspend fun populateFeelingsDatabase(){
            val remoteFeelings = feelingDb.getAllFeelings()
            val localFeelings = remoteFeelings.map { remoteFeeling ->remoteFeeling.mapToEntity() }
            feelingDao.insertAllFeelings(localFeelings)

        }
    }


}