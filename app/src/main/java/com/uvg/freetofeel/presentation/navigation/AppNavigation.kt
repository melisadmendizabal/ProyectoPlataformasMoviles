package com.uvg.freetofeel.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.LoginBaseDestination
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.loginBaseScreen
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput.LoginInputDESTINATION
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput.loginInputScreen
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput.navigateToLoginInput

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    context: Context,
    languageViewModel: LanguageViewModel
){

    NavHost(
        navController = navController,
        startDestination = LoginBaseDestination
    ){

        loginBaseScreen(
            context,
            languageViewModel,
            onLoginClick = {
                navController.navigateToLoginInput(LoginInputDESTINATION)

            },

            onNewAccClick ={}
        )

        loginInputScreen()


    }

}