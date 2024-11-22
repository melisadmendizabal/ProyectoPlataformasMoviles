package com.uvg.freetofeel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uvg.freetofeel.data.local.dao.DailyRecoDAO
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.dao.HistoryDAO
import com.uvg.freetofeel.data.local.entity.DailyRecoEntity
import com.uvg.freetofeel.data.local.entity.FeelingEntity
import com.uvg.freetofeel.data.local.entity.HistoryEntity

@Database(
    entities = [
        FeelingEntity::class,
        DailyRecoEntity::class,
        HistoryEntity::class
    ],
    version = 1
)
abstract class AppDatabase:RoomDatabase(){
    abstract fun feelingDao(): FeelingDAO
    abstract fun dailyRecoDao(): DailyRecoDAO
    abstract fun historyPetsDao(): HistoryDAO
}


