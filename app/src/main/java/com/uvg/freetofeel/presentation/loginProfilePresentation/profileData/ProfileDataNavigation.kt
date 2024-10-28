package com.uvg.freetofeel.presentation.loginProfilePresentation.profileData

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ProfileDataDESTINATION

fun NavController.navigateToProfileData(
    destination: ProfileDataDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.profileDataScreen(
    onBackProfileData: ()-> Unit

){
    composable<ProfileDataDESTINATION>{
        ProfileDataROUTE(
            onBackProfileData = onBackProfileData
        )
    }
}