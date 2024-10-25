package com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.uvg.freetofeel.LanguageViewModel
import kotlinx.serialization.Serializable

@Serializable
data object LoginBaseDestination


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