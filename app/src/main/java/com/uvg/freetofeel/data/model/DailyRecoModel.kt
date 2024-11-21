package com.uvg.freetofeel.data.model

import androidx.annotation.StringRes

data class DailyRecoModel(
    @StringRes val title: Int,
    @StringRes val body: Int,
    val completed: String,
    val points: Int
)