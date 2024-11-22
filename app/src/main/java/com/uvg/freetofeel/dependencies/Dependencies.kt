package com.uvg.freetofeel.dependencies

import android.content.Context
import androidx.room.Room
import com.uvg.freetofeel.data.local.AppDatabase
import com.uvg.freetofeel.data.local.dao.ChallengeDAO
import com.uvg.freetofeel.data.local.dao.DailyRecoDAO
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.dao.HistoryDAO
import com.uvg.freetofeel.repositories.ChallengeRepositoryImpl
import com.uvg.freetofeel.repositories.ChallengesRepository
import com.uvg.freetofeel.repositories.DailyRecoRepository
import com.uvg.freetofeel.repositories.DailyRecoRepositoryImpl
import com.uvg.freetofeel.repositories.FeelingRepositoryImpl
import com.uvg.freetofeel.repositories.FeelingsRepository
import com.uvg.freetofeel.repositories.HistoryPetsRepositoryImpl
import com.uvg.freetofeel.repositories.HistoryRepository

object Dependencies {
    @Volatile
    private var database: AppDatabase? = null

    private fun buildDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "FreeToFeel.db"
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

    fun provideHistoryPetsDao(context: Context):HistoryDAO{
        return provideDatabase(context).historyPetsDao()
    }

    fun provideHistoryPetsRepository(context: Context): HistoryRepository{
        val historyDAO = provideHistoryPetsDao(context)
        return HistoryPetsRepositoryImpl(historyDAO)
    }

    fun provideChallengeDao(context: Context):ChallengeDAO{
        return provideDatabase(context).challengeDao()
    }

    fun provideChallengeRepository(context: Context):ChallengesRepository{
        val challengeDao = provideChallengeDao(context)
        return ChallengeRepositoryImpl(challengeDao)
    }

    //otros providers
    //unos llevan Impl

}