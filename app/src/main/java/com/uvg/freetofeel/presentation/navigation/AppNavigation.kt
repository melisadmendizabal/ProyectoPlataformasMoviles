package com.uvg.freetofeel.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.LoginBaseDestination
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.loginBaseScreen
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.navigateToLoginBase
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput.LoginInputDESTINATION
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput.loginInputScreen
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput.navigateToLoginInput
import com.uvg.freetofeel.presentation.loginProfilePresentation.newAccount.NewAccountDESTINATION
import com.uvg.freetofeel.presentation.loginProfilePresentation.newAccount.navigateToNewAccount
import com.uvg.freetofeel.presentation.loginProfilePresentation.newAccount.newAccountScreen
import com.uvg.freetofeel.presentation.navigation.BotNavigation.ScreenBotNavigationDestination
import com.uvg.freetofeel.presentation.navigation.BotNavigation.navigateToScreenBotNavigation
import com.uvg.freetofeel.presentation.navigation.BotNavigation.screenBotNavigation
import com.uvg.freetofeel.presentation.petPresentation.firstPet.FirstPetDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.firstPet.firstPetScreen
import com.uvg.freetofeel.presentation.petPresentation.firstPet.navigateToFirstPet
import com.uvg.freetofeel.presentation.petPresentation.petHome.PetHomeDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petHome.navigateToPetHome
import com.uvg.freetofeel.presentation.petPresentation.petHome.pethomeScreen

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

            onNewAccClick ={
                navController.navigateToNewAccount(NewAccountDESTINATION)
            }
        )

        loginInputScreen(
            onLoginStartClick = {
                navController.navigateToFirstPet(FirstPetDESTINATION)
            }
        )


        newAccountScreen(
            onCreateAccountClick = {
                navController.navigateToLoginBase(LoginBaseDestination)
            }
        )

        //navega a la pantalla en donde está configurado el BottomBar todavía no borra bien el login
        firstPetScreen(
            onFirstPetOk = {
                navController.navigateToScreenBotNavigation(
                    navOptions = NavOptions.Builder().setPopUpTo<FirstPetDESTINATION>(
                        inclusive = true
                    ).build(),
                    destination = ScreenBotNavigationDestination)
            }
        )

        screenBotNavigation()




    }

}