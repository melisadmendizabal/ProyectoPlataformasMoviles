package com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput.LoginInputDESTINATION
import kotlinx.serialization.Serializable

@Serializable
data object LoginBaseDestination

fun NavController.navigateToLoginBase(
    destination: LoginBaseDestination,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.loginBaseScreen(       //Por el momento, es provisional. Revisar al momento de hacer la nav
    context: Context,
    languageViewModel: LanguageViewModel,
    onLoginClick: () -> Unit,
    onNewAccClick: () -> Unit,
) {
    composable<LoginBaseDestination> {
        LoginRoute(
            modifier = Modifier.fillMaxWidth(),
            languageViewModel = languageViewModel,
            onLoginClick = onLoginClick,
            onNewAccClick = onNewAccClick

        )
    }
}