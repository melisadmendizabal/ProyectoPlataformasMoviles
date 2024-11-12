package com.uvg.freetofeel.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.SupabaseAuthViewModel
import com.uvg.freetofeel.data.model.UserLoginState
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
    languageViewModel: LanguageViewModel,
    authViewModel: SupabaseAuthViewModel = viewModel()
){
    val userState by authViewModel.userState
    var currentUserState by remember { mutableStateOf<UserLoginState>(UserLoginState.Loading) }

    LaunchedEffect(Unit) {
        authViewModel.isUserLoggedIn(context)
    }
    LaunchedEffect(userState) {
        currentUserState = userState
    }

    val startDestination = when (currentUserState) {
        is UserLoginState.Success -> FirstPetDESTINATION
        else -> LoginBaseDestination
    }
    NavHost(
        navController = navController,
        startDestination = startDestination
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

        loginInputScreen(authViewModel = authViewModel,
            context = context,
            onLoginStartClick = {
                when(userState){
                    is UserLoginState.Success -> {
                        navController.navigateToFirstPet(FirstPetDESTINATION)
                    }

                    is UserLoginState.Error -> currentUserState = (userState as UserLoginState.Error)
                    UserLoginState.Loading -> TODO() //no debería pasar?
                }
            }
        )


        newAccountScreen(authViewModel = authViewModel,
            context = context,
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

        screenBotNavigation(authViewModel = authViewModel, context = context, onLogOutClick = {navController.navigateToLoginBase(navOptions = NavOptions.Builder().setPopUpTo<LoginBaseDestination>(
            inclusive = true
        ).build(),
            destination = LoginBaseDestination)})

    }

}