package com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.LoginBaseDestination
import kotlinx.serialization.Serializable

@Serializable
data object LoginInputDESTINATION

fun NavController.navigateToLoginInput(
    destination: LoginInputDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.loginInputScreen(       //Por el momento, es provisional. Revisar al momento de hacer la nav
    onLoginStartClick: () -> Unit
) {
    composable<LoginInputDESTINATION> {
        LoginInputROUTE(onLoginStartClick = onLoginStartClick)
    }
}