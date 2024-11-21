package com.uvg.freetofeel.data.model

import androidx.annotation.StringRes

data class Challenge(
    //val id: Int,
    @StringRes val title: Int,
    @StringRes val category: Int,
    @StringRes val body: Int,
    val filter: String,
    val image: String
)