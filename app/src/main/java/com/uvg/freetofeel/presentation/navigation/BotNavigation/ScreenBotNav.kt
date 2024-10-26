package com.uvg.freetofeel.presentation.navigation.BotNavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uvg.freetofeel.presentation.challengePresenation.challengeHome.challengehomeScreen
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.LoginBaseDestination
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.navigateToLoginBase
import com.uvg.freetofeel.presentation.loginProfilePresentation.profileHome.profilehomeScreen
import com.uvg.freetofeel.presentation.petPresentation.firstPet.FirstPetDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petHome.PetHomeDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petHome.pethomeScreen
import com.uvg.freetofeel.presentation.petPresentation.petSelect.PetSelectDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petSelect.navigateToPetSelect
import com.uvg.freetofeel.presentation.petPresentation.petSelect.petSelectScreen
import com.uvg.freetofeel.presentation.sunPresentation.sunHome.sunhomeScren

@Composable
fun ScreenBotNav(
    navController: NavHostController = rememberNavController()
){
    var bottomBarVisible by rememberSaveable {
        mutableStateOf(false)
    }

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    bottomBarVisible = if (currentDestination != null){
        LevelsDestinationBotNav.any {destination ->
            currentDestination.hasRoute(destination)
        }

    } else {
        false
    }

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = bottomBarVisible,
                enter = slideInVertically(initialOffsetY = {it}),
                exit = slideOutVertically(targetOffsetY = {it})
            ) {
                NavigationBar(
                    checkItemSelected = { destination ->
                        currentDestination?.hierarchy?.any { it.hasRoute(destination::class)  } ?: false
                    },
                    onNavItemClick = { destination ->
                        navController.navigate(destination){
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }

    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PetHomeDESTINATION,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){


            pethomeScreen(
                onAllPetsClick = {
                    navController.navigateToPetSelect(PetSelectDESTINATION)
                },
                onTipDayPetScreenClick = {},
                onHistoryScreenPetHome = {}
            )

            sunhomeScren()
            challengehomeScreen()
            profilehomeScreen()


            petSelectScreen(
                onBackFromSelectToHomePet = {
                    //debe regresar uno xd
                }
            )
        }
    }
}