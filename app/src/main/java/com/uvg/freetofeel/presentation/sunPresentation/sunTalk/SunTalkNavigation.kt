package com.uvg.freetofeel.presentation.sunPresentation.sunTalk

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.SunInputROUTE
import kotlinx.serialization.Serializable


@Serializable
data class SunTalkDESTINATION(
    val emotion:String
)

fun NavController.navigateToSunTalk(
    destination: String,
    navOptions: NavOptions? = null
){
    this.navigate(SunTalkDESTINATION(emotion = destination), navOptions)
}

fun NavGraphBuilder.sunTalkScreen(
    onAccept: () -> Unit

){
    composable<SunTalkDESTINATION>{
        SunTalkROUTE(onAccept = onAccept)
    }
}