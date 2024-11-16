package com.uvg.freetofeel.data.model

import androidx.annotation.StringRes

//Para la pantalla de SunFeeling

data class  Feeling(
    @StringRes val title:Int,
    @StringRes val body:Int,
    val emotion:String
)

