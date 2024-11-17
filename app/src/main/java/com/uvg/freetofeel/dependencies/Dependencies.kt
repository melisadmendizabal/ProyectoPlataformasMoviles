package com.uvg.freetofeel.dependencies

import android.content.Context
import androidx.room.Room
import com.uvg.freetofeel.data.local.AppDatabase
import com.uvg.freetofeel.data.local.dao.DailyRecoDAO
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.repositories.DailyRecoRepository
import com.uvg.freetofeel.repositories.DailyRecoRepositoryImpl
import com.uvg.freetofeel.repositories.FeelingRepositoryImpl
import com.uvg.freetofeel.repositories.FeelingsRepository

object Dependencies {
    @Volatile
    private var database: AppDatabase? = null

    private fun buildDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "full.db"
        ).build()
    }

    fun provideDatabase(context: Context): AppDatabase {
        return database ?: synchronized(this) {
            database ?: buildDatabase(context).also { database = it }
        }
    }

    fun provideFeelingDao(context: Context):FeelingDAO{
        return provideDatabase(context).feelingDao()
    }

    fun provideFeelingRepository(context: Context):FeelingsRepository{
        val feelingDao = provideFeelingDao(context)
        return FeelingRepositoryImpl(feelingDao)
    }

    fun provideDailyRecoDao(context: Context):DailyRecoDAO{
        return provideDatabase(context).dailyRecoDao()
    }

    fun provideDailyRecoRepository(context: Context):DailyRecoRepository{
        val dailyRecoDAO = provideDailyRecoDao(context)
        return DailyRecoRepositoryImpl(dailyRecoDAO)
    }

    //otros providers
    //unos llevan Impl





}