package com.uvg.freetofeel.presentation.loginProfilePresentation.profileHome

import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.uvg.freetofeel.SupabaseAuthViewModel
import com.uvg.freetofeel.presentation.petPresentation.petHome.PetHomeROUTE
import kotlinx.serialization.Serializable

@Serializable
data object ProfileHomeDESTINATION

fun NavGraphBuilder.profilehomeScreen(
    onMyWriteClick: ()-> Unit,
    authViewModel:SupabaseAuthViewModel,
    context: Context,
    onLogOutClick:()->Unit
){
    composable<ProfileHomeDESTINATION>{
        ProfileHomeROUTE( onMyWriteClick = onMyWriteClick, authViewModel = authViewModel, context = context, onLogOutClick = onLogOutClick)
    }
}