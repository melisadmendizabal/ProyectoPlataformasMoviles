package com.uvg.freetofeel.presentation.sunPresentation.sunFeeling

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.SunInputDESTINATION
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.SunInputROUTE
import kotlinx.serialization.Serializable


@Serializable
data object SunFeelingDESTINATION

fun NavController.navigateToSunFeeling(
    destination: SunFeelingDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.sunFeelingScreen(
    onEmotionClick: () -> Unit,
    userName:String

){
    composable<SunFeelingDESTINATION>{
        SunFeelingROUTE(onEmotionClick = onEmotionClick, username = userName)
    }
}