package com.uvg.freetofeel.presentation.loginProfilePresentation.profileHome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.petPresentation.petHome.PetHomeROUTE
import kotlinx.serialization.Serializable

@Serializable
data object ProfileHomeDESTINATION

fun NavGraphBuilder.profilehomeScreen(
    onMyWriteClick: ()-> Unit
){
    composable<ProfileHomeDESTINATION>{
        ProfileHomeROUTE( onMyWriteClick = onMyWriteClick)
    }
}