package com.uvg.freetofeel.repositories

import com.uvg.freetofeel.data.model.Feeling

interface FeelingsRepository{
    suspend fun getFeelings():List<Feeling>
    suspend fun getFeelingsByEmotion(emotion:String):List<Feeling>
    suspend fun getSingleRandomFeelingByEmotion(feelingList:List<Feeling>):Feeling
}