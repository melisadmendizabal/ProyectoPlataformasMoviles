package com.uvg.freetofeel.data.model

import androidx.annotation.StringRes

data class HistoryPets(
    val idHistory: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val option1: Int,
    val point1: Int,
    @StringRes val option2: Int,
    val point2: Int,
    @StringRes val option3: Int,
    val point3: Int,

)
