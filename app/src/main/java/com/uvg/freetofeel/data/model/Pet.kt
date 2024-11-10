package com.uvg.freetofeel.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Pet(
    val id: Int,
    val name: String,
    @StringRes val issue: Int,
    val points: Int,
    @DrawableRes val iconPet: Int,
    @DrawableRes val backPet: Int,
    @DrawableRes val imagePet: Int,

)
