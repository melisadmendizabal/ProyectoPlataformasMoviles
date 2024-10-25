package com.uvg.freetofeel.presentation.sunPresentation.sunHome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Serializable
data object SunHomeDESTINATION


fun NavGraphBuilder.sunhomeScren(

){
    composable<SunHomeDESTINATION>{
        SunHomeScreenROUTE()
    }
}