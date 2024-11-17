package com.uvg.freetofeel.presentation.challengePresenation.dailyReco

import com.uvg.freetofeel.data.model.DailyRecoModel

data class DailyRecoState(
    val data: DailyRecoModel? = null,
    val isLoading: Boolean = true
)