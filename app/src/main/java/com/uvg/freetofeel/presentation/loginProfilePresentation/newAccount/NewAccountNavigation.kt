package com.uvg.freetofeel.presentation.loginProfilePresentation.newAccount

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object NewAccountDESTINATION

fun NavController.navigateToNewAccount(
    destination: NewAccountDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.newAccountScreen(
    onCreateAccountClick:() -> Unit

) {
    composable<NewAccountDESTINATION> {
        NewAccountROUTE(onCreateAccountClick = onCreateAccountClick)
    }
}