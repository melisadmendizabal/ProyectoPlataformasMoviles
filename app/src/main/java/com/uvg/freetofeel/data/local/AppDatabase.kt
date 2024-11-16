package com.uvg.freetofeel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.entity.FeelingEntity

@Database(
    entities = [
        FeelingEntity::class
    ],
    version = 1
)
abstract class AppDatabase:RoomDatabase(){
    abstract fun feelingDao(): FeelingDAO
}

